package com.payegis.enums;

import com.payegis.constant.AddressParseLabelConstant;

public enum DimensionEnum {

    T01_VehNumber("T01_VehNumber", "车牌号", 13, AddressParseLabelConstant.PLATE_NUMBER_STR_L),
    T01_LicenseLocal("T01_LicenseLocal", "车辆上牌地", 14, AddressParseLabelConstant.ADDRESS_STR_L),
    T01_Mobile("T01_Mobile", "手机号码", 1, AddressParseLabelConstant.MOBILE_STR_L),
    T01_BankMobile("T01_BankMobile", "银行预留手机号码", 9, AddressParseLabelConstant.MOBILE_STR_L),
    T01_CertID("T01_CertID", "身份证号", 2, AddressParseLabelConstant.IDCARD_STR_L),
    T01_OcrAddress("T01_OcrAddress", "身份证OCR识别地址", 12, AddressParseLabelConstant.ADDRESS_STR_L),
    T01_BankNo("T01_BankNo", "银行卡号", 11, AddressParseLabelConstant.BANKCARD_STR_L),
    T05_DeviceIp("T05_DeviceIp", "IP地址", 4, AddressParseLabelConstant.IP_STR_L),
    T05_GpsLongitude("T05_GpsLongitude", "GPS经度", 3, AddressParseLabelConstant.GPS_STR_L),
    T05_GpsLatitude("T05_GpsLatitude", "GPS纬度", 3, AddressParseLabelConstant.GPS_STR_L),
    T01_HomeAddress("T01_HomeAddress", "现居住地-详细", 5, AddressParseLabelConstant.ADDRESS_STR_L),
    T01_ContactAddress("T01_ContactAddress", "联系地址", 6, AddressParseLabelConstant.ADDRESS_STR_L),
    T01_PermanentAddress("T01_PermanentAddress", "户籍地址", 7, AddressParseLabelConstant.ADDRESS_STR_L),
    T01_CompanyAddress("T01_CompanyAddress", "单位地址-详细", 8, AddressParseLabelConstant.ADDRESS_STR_L);

    private String code;
    // 维度（具体数值在地域标签需求内）
    private Integer dimensionNum;
    // 维度
    private String dimensionCode;
    //    private String prefix;
    private String describe;

    DimensionEnum(String code, String describe, Integer dimensionNum, String dimensionCode) {
        this.code = code;
        this.describe = describe;
        this.dimensionNum = dimensionNum;
        this.dimensionCode = dimensionCode;
    }

    DimensionEnum() {
    }

    public static Integer getDimensionNumByCode(String code) {
        DimensionEnum[] dimensionEnum = values();
        for (DimensionEnum pEnum : dimensionEnum) {
            if (pEnum.getCode().equals(code)) {
                return pEnum.getDimensionNum();
            }
        }
        return null;
    }

    public static String getDescribeByCode(String code) {
        DimensionEnum[] dimensionEnum = values();
        for (DimensionEnum pEnum : dimensionEnum) {
            if (pEnum.getCode().equals(code)) {
                return pEnum.getDescribe();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDimensionNum() {
        return dimensionNum;
    }

    public void setDimensionNum(Integer dimensionNum) {
        this.dimensionNum = dimensionNum;
    }

    public String getDimensionCode() {
        return dimensionCode;
    }

    public void setDimensionCode(String dimensionCode) {
        this.dimensionCode = dimensionCode;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public static void main(String[] args) {
//        for (DimensionEnum airlineTypeEnum : DimensionEnum.values()) {
//            System.out.println(airlineTypeEnum.getCode());
//        }
    }
}
