package com.payegis.excelListener;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson2.JSONObject;
import com.payegis.common.AreaCode;
import com.payegis.common.MobileAttribute;
import com.payegis.config.CommonCache;
import com.payegis.entity.ElasticBaseEntity;
import com.payegis.entity.ElasticUpdateInfo;
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
public class UpdateElasticListener implements ReadListener<AddressInfo> {

    /**
     * 读取配置文件的配置
     */
    AddressReadConfigModel addressReadConfigModel;
    /**
     * 执行es查询
     */
    ElasticService elasticService;

    public UpdateElasticListener(String originalFilename) {
        this.addressReadConfigModel = SpringContextHolder.getBean(AddressReadConfigModel.class);
        BATCH_COUNT = addressReadConfigModel.getBatchCount();

        this.elasticService = SpringContextHolder.getBean(ElasticService.class);

        this.originFile = new File(addressReadConfigModel.getTempFileLocation().concat(originalFilename));
        this.file = new File(addressReadConfigModel.getTempFileLocation().concat("updated-").concat(originalFilename));
    }

    /**
     * 全局变量，同一个sheet中的数据只能用其去写，负否则会导致数据覆盖
     */
    private WriteSheet writeNormalSheet;

    /**
     * 全局变量，同一个excel中的数据只能用其去写，否则会导致数据覆盖
     */
    private ExcelWriter excelWriter;

    /**
     * 每隔xxx条统一处理
     */
    private int BATCH_COUNT;

    private boolean readEs;
    File originFile;

    File file;

    /**
     * 读取文件的名字
     */
    private String originalFilename;

    /**
     * 已处理的数据批次
     */
    private int processBatchNum = 0;

    /**
     * 文件是否已被读取(每个文件只需被读取一次)
     */
    private boolean fileRead;

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

        if (data.getProductNo().startsWith("PN00000021")) {
            data.setSpecialTreatment(Boolean.TRUE);
            data.setEsApplyId(data.getUserId());
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
        excelWriter.finish();
        originFile.delete();
    }

    /**
     * 数据读取出来后，直接汇总+更新ES
     */
    private void processData() {
        if (cachedDataList.size() <= 0) {
            return;
        }
        processBatchNum++;
        int errorNum = 0;
        //异常地址数据--待写入数据
        List<AddressInfo> inputErrorList = new ArrayList<>();

        log.info("第{}批次,共{}条数据，开始统一处理！", processBatchNum, cachedDataList.size());
        //es唯一索引为key
        Map<String, List<AddressInfo>> addressInfoMap = cachedDataList.stream().collect(Collectors.groupingBy(AddressInfo::getEsApplyId));

        //调用es查询对应的index与id ，响应key为applyId
        Map<String, List<ElasticBaseEntity>> elasticBaseEntityMap = elasticService.select(cachedDataList);

        //更新 ES时使用的List参数
        List<ElasticBaseEntity> updateESParam = new ArrayList<>();

        //拼接ES更新参数
        for (Map.Entry<String, List<AddressInfo>> entry : addressInfoMap.entrySet()) {
            String esApplyId = entry.getKey();
            List<AddressInfo> addressInfoList = entry.getValue();
            List<ElasticBaseEntity> elasticBaseEntityList = elasticBaseEntityMap.get(esApplyId);
            if (CollectionUtils.isEmpty(elasticBaseEntityList)) {
                log.error("根据applyId：{}在ES中未查到数据，所有地址信息列入异常列表", esApplyId);
                errorNum += addressInfoList.size();
                inputErrorList.addAll(addressInfoList);
                continue;
            }
            for (ElasticBaseEntity elasticBaseEntity : elasticBaseEntityList) {
                this.summaryAddress(elasticBaseEntity, addressInfoList);
                updateESParam.add(elasticBaseEntity);
            }
        }
        if (updateESParam.size() == 0) {
            log.error("本次更新数据为空:");
            return;
        }

        elasticService.updateBatch(updateESParam);


        if (!fileRead) {
            //新建excel--将原有的数据复制到新的excel中，并追加一个sheet
            // .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()的作用时列宽自适应
            //excelWriter = EasyExcel.write(fileLocation, AddressInfo.class).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();
            excelWriter = EasyExcel.write(file, AddressInfo.class).withTemplate(originFile).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();

            //同一个sheet只能创建一次
            writeNormalSheet = EasyExcel.writerSheet("ES异常数据").build();

            this.fileRead = true;
        }
        //写入数据
        if (CollectionUtils.isNotEmpty(inputErrorList)) {
            excelWriter.write(inputErrorList, writeNormalSheet);
        }

        log.info("第{}批次,单次处理完成！,异常数量:{}", processBatchNum, errorNum);
    }

    /**
     * @param elasticBaseEntity es key对应的elasticBaseEntity
     * @param
     * @param
     * @return
     */
    private void summaryAddress(ElasticBaseEntity elasticBaseEntity, List<AddressInfo> addressInfoList) {
        List<ElasticUpdateInfo> updateInfoList = new ArrayList<>();
        //因为ES要同时更新多字段，所以对于同一个applyId的多条数据，要做汇总处理
        //每个地址可以解析出两个字段，分别是原地址和 根据原地址解析出的省地址
        for (AddressInfo addressInfo : addressInfoList) {
            List<ElasticUpdateInfo> updateInfoByAddressList = AddressType.getUpdateInfoByAddress(addressInfo);
            updateInfoList.addAll(updateInfoByAddressList);
        }

        elasticBaseEntity.setUpdateInfoList(updateInfoList);
    }

}

