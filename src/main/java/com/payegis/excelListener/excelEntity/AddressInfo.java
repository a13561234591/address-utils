package com.payegis.excelListener.excelEntity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class AddressInfo {

    @ExcelProperty(value = "交易报文流水号", index = 0)
    private String requestSerialNo;

    @ExcelProperty(index = 1, value = "行方申请编号")
    private String applyId;

    @ExcelProperty(index = 2, value = "原申请类型")
    private String requestType;

    @ExcelProperty(index = 3, value = "合作方编号")
    private String merchantId;

    @ExcelProperty(index = 4, value = "产品编号")
    private String productId;

    @ExcelProperty(index = 5, value = "产品NO")
    private String productNo;

    @ExcelProperty(index = 6, value = "用户编号")
    private String userId;

    @ExcelProperty(index = 7, value = "省份")
    private String customerAreaName;

    @ExcelProperty(index = 8, value = "省份编号")
    private String customerAreaResult;

    @ExcelProperty(index = 9, value = "市")
    private String customerAreaCityResultName;

    @ExcelProperty(index = 10, value = "市编号")
    private String customerAreaCityResult;

    @ExcelProperty(index = 11, value = "判断维度")
    private String customerAreaType;

    @ExcelProperty(index = 12, value = "原始数据")
    private String customerAreaValue;
    @ExcelProperty(index = 13, value = "数据生产日期")
    private String date;

    /**
     * 最后加
     */
    @ExcelIgnore
    @ExcelProperty("解析异常原因")
    private String errorReason;

    /**
     * es唯一索引
     */
    @ExcelIgnore
    private String esApplyId;

    /**
     * 是否在ES查询时特殊处理
     */
    @ExcelIgnore
    private boolean specialTreatment = false;


}
