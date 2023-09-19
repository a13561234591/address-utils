package com.payegis.enums;


import com.payegis.entity.ElasticUpdateInfo;
import com.payegis.excelListener.excelEntity.AddressInfo;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */

public enum AddressType {
    HOUSEHOLD("7", "户籍地址","s_T01_PermanentAddress_extra","s_T01_PermanentProvince_extra"),
    ID_CARD_OCR("12", "身份证OCR地址","s_T01_OcrAddress_extra","s_T01_OcrAddressProvince_extra"),
    RESIDENTIAL("5", "居住地址","s_T01_HomeAddress_extra","s_T01_HomeProvince_extra"),
    WORKPLACE("8", "单位地址","s_T01_CompanyAddress_extra","s_T01_CompanyProvince_extra"),
    MOBILE("1", "手机号","s_T01_Mobile_extra","s_T01_MobileProvince_extra"),
    BANK_MOBILE("9", "银行预留手机号","s_T01_BankMobile_extra","s_T01_BankMobileProvince_extra"),
    IP("4", "IP地址","s_T05_DeviceIp_extra","s_T05_IpProvince_extra");

    /**
     * excel中 customerAreaType的值
     */
    private String code;
    private String desc;

    /**
     * 地址字段
     */
    private String esField;

    /**
     * 省份字段
     */
    private String esProvinceField;

    AddressType(String code, String desc, String esField, String esProvinceField) {
        this.code = code;
        this.desc = desc;
        this.esField =esField;
        this.esProvinceField = esProvinceField;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getEsField() {
        return esField;
    }

    public String getEsProvinceField() {
        return esProvinceField;
    }

    public static List<ElasticUpdateInfo> getUpdateInfoByAddress(AddressInfo addressInfo) {
        List<ElasticUpdateInfo> result = new ArrayList<>();
        for(AddressType addressType : AddressType.values()){
            if(addressType.getCode().equals(addressInfo.getCustomerAreaType())){
                //原地址
                ElasticUpdateInfo elasticUpdateInfo = new ElasticUpdateInfo();
                elasticUpdateInfo.setFieldName(addressType.getEsField());
                elasticUpdateInfo.setFieldValue(addressInfo.getCustomerAreaValue());

                //省地址
                String provinceArea = ObjectUtils.isEmpty(addressInfo.getCustomerAreaName()) ? "-" : addressInfo.getCustomerAreaName();
                ElasticUpdateInfo provinceInfo = new ElasticUpdateInfo();
                provinceInfo.setFieldName(addressType.getEsProvinceField());
                provinceInfo.setFieldValue(provinceArea);
                result.add(elasticUpdateInfo);
                result.add(provinceInfo);
                break;
            }
        }
        return result;
    }
}
