package com.payegis.excelListener;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import com.alibaba.fastjson2.JSONObject;
import com.payegis.common.AreaCode;
import com.payegis.common.MobileAttribute;
import com.payegis.config.CommonCache;
import com.payegis.entity.ElasticBaseEntity;
import com.payegis.enums.AddressType;
import com.payegis.excelListener.excelEntity.AddressInfo;
import com.payegis.knowledge.AddressKnowledge;
import com.payegis.knowledge.IpKnowledge;
import com.payegis.knowledge.MobileKnowledge;
import com.payegis.model.AddressReadConfigModel;
import com.payegis.service.ElasticService;
import com.payegis.utils.SpringContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
@Slf4j
@Data
public class AddressListener implements ReadListener<AddressInfo> {

    /**
     * 读取配置文件的配置
     */
    AddressReadConfigModel addressReadConfigModel;
    /**
     * 执行es查询
     */
    ElasticService elasticService;

    public AddressListener(String originalFilename) {
        this.originalFilename = originalFilename;
        this.addressReadConfigModel = SpringContextHolder.getBean(AddressReadConfigModel.class);
        BATCH_COUNT = addressReadConfigModel.getBatchCount();
        this.elasticService = SpringContextHolder.getBean(ElasticService.class);
        String xlsxFileLocation = originalFilename.concat(RandomUtil.randomString(3)).concat(".").concat("xlsx");
        fileLocation = addressReadConfigModel.getTempFileLocation().concat(xlsxFileLocation);


        areaCodeInfoList = AreaCode.getInstance().readCode(CommonCache.getCommonProperties().getCountryArea());

    }

    /**
     * 地址解析文件中得到的全量地址信息
     */
    private List<Map<String, String>> areaCodeInfoList;

    /**
     * 全局变量，同一个sheet中的数据只能用其去写，负否则会导致数据覆盖
     */
    private WriteSheet writeNormalSheet;

    private WriteSheet writeErrorSheet;
    /**
     * 全局变量，同一个excel中的数据只能用其去写，否则会导致数据覆盖
     */
    private ExcelWriter excelWriter;

    /**
     * 每隔xxx条统一处理
     */
    private int BATCH_COUNT;

    private boolean readEs;
    /**
     * 输出文件的具体位置
     */
    private String fileLocation;

    /**
     * 读取文件的名字
     */
    private String originalFilename;

    /**
     * 已处理的数据批次
     */
    private int processBatchNum = 0;

    /**
     * 单次处理的数据缓存起来
     */
    private List<AddressInfo> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    private Map<String, ElasticBaseEntity> cachedDataMap = new HashMap<>();


    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(AddressInfo data, AnalysisContext context) {
        //判断是否是消金2
        if (data.getProductNo().startsWith("PN")) {
            data.setEsApplyId(data.getRequestSerialNo());
        } else {
            data.setEsApplyId(data.getApplyId());
        }

        cachedDataList.add(data);
        // 达到BATCH_COUNT了，需要去处理一次，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            this.processData();
            // 处理完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        processData();
        log.info("所有数据解析完成！");
        excelWriter.close();
    }

    /**
     * 加上存储数据库
     */
    private void processData() {
        if (cachedDataList.size() <= 0) {
            return;
        }
        processBatchNum++;
        int errorNum = 0;
        //地域标签解析--待写入数据
        List<AddressInfo> inputList = new ArrayList<>();
        //异常地址数据--待写入数据
        List<AddressInfo> inputErrorList = new ArrayList<>();
        log.info("第{}批次,共{}条数据，开始统一处理！", processBatchNum, cachedDataList.size());
        //es唯一索引为key
        Map<String, List<AddressInfo>> addressInfoMap = cachedDataList.stream().collect(Collectors.groupingBy(AddressInfo::getEsApplyId));

        //地址解析
        for (Map.Entry<String, List<AddressInfo>> entry : addressInfoMap.entrySet()) {
            List<AddressInfo> addressInfoList = entry.getValue();
            for (int i = 0; i < addressInfoList.size(); i++) {
                AddressInfo addressInfo = addressInfoList.get(i);
                boolean analysisResult = this.addressAnalysis(addressInfo);
                if (analysisResult) {
                    //添加到sheet1
                    inputList.add(addressInfo);
                } else {
                    inputErrorList.add(addressInfo);
                    errorNum++;
                }
            }
        }


        File file = new File(fileLocation);
        if (!file.exists()) {
            //新建excel   .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()的作用时列宽自适应
            excelWriter = EasyExcel.write(fileLocation, AddressInfo.class).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();
            //同一个sheet只能创建一次
            writeNormalSheet = EasyExcel.writerSheet("地域标签解析").build();
            writeErrorSheet = EasyExcel.writerSheet("异常地址数据").registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();
        }
        //写入数据
        if (CollectionUtils.isNotEmpty(inputList)) {
            excelWriter.write(inputList, writeNormalSheet);
        }
        if (CollectionUtils.isNotEmpty(inputErrorList)) {
            excelWriter.write(inputErrorList, writeErrorSheet);
        }

        log.info("第{}批次,单次处理完成！,异常数量:{}", processBatchNum, errorNum);
    }

    private final String emptyString = "null";

    /**
     * 地址解析
     *
     * @param addressInfo
     * @return
     */
    private boolean addressAnalysis(AddressInfo addressInfo) {
        String provinceName = "";
        String cityName = "";
        try {
            if (AddressType.HOUSEHOLD.getCode().equals(addressInfo.getCustomerAreaType())
                    || AddressType.ID_CARD_OCR.getCode().equals(addressInfo.getCustomerAreaType())
                    || AddressType.RESIDENTIAL.getCode().equals(addressInfo.getCustomerAreaType())
                    || AddressType.WORKPLACE.getCode().equals(addressInfo.getCustomerAreaType())
            ) {
                //地址处理
                AddressKnowledge addressKnowledge = new AddressKnowledge();
                Map<String, String> dataMap = addressKnowledge.learn(addressInfo.getCustomerAreaValue());
                provinceName = dataMap.get("province");
                cityName = dataMap.get("city");
            } else if (
                    AddressType.MOBILE.getCode().equals(addressInfo.getCustomerAreaType())
                            || AddressType.BANK_MOBILE.getCode().equals(addressInfo.getCustomerAreaType())
            ) {
                //手机号处理
                MobileKnowledge mobileKnowledge = new MobileKnowledge();
                MobileAttribute mobileAttribute = mobileKnowledge.learn(addressInfo.getCustomerAreaValue());
                provinceName = mobileAttribute.getProvince();
                cityName = mobileAttribute.getCity();

            } else if (AddressType.IP.getCode().equals(addressInfo.getCustomerAreaType())) {
                //IP处理
                IpKnowledge ipKnowledge = new IpKnowledge();
                JSONObject jsonResult = ipKnowledge.learn(addressInfo.getCustomerAreaValue());
                provinceName = (String) jsonResult.get("province");
                cityName = (String) jsonResult.get("city");

            } else {
                log.error("类型错误:{}", addressInfo.getCustomerAreaType());
                return false;
            }
        }catch (Exception e){
            log.error("地址解析异常,applyId：{},addressInfo:{}", addressInfo.getApplyId(), addressInfo.getCustomerAreaValue(),e);
            return false;
        }
        if (StringUtils.isBlank(provinceName) && StringUtils.isBlank(cityName)) {
            log.error("地址解析异常，applyId：{},addressInfo:{}", addressInfo.getApplyId(), addressInfo.getCustomerAreaValue());
            return false;
        }

        String cityCode = "";
        String provinceCode = "";
        //解析市区code和省份code
        /**
         * areaCodeInfoList示例结构：
         * {area=null, code=110000, province=北京市, city=null}
         * {area=朝阳区, code=110105, province=北京市, city=市辖区}
         */
        for (Map<String, String> areaMap : areaCodeInfoList) {
            //如果市区code和省份code都已解析出来，循环结束
            if (ObjectUtils.isNotEmpty(cityCode) && ObjectUtils.isNotEmpty(provinceCode)) {
                break;
            }
            String provinceAreaName = areaMap.get("province");
            String cityAreaName = areaMap.get("city");
            String areaName = areaMap.get("area");
            String areaCode = areaMap.get("code");
            if (StringUtils.isNotBlank(provinceName) && provinceName.equals(provinceAreaName)
                    && (StringUtils.isBlank(cityAreaName) || emptyString.equals(cityAreaName))) {
                provinceCode = areaCode;
            }
            if (StringUtils.isNotBlank(cityName) && cityName.equals(cityAreaName)
                    && (StringUtils.isBlank(areaName) || emptyString.equals(areaName))) {
                cityCode = areaCode;
            }
        }

        //填充
        addressInfo.setCustomerAreaName(provinceName);
        addressInfo.setCustomerAreaResult(provinceCode);
        addressInfo.setCustomerAreaCityResultName(cityName);
        addressInfo.setCustomerAreaCityResult(cityCode);
        return true;
    }


}

