package com.payegis.constant;

import java.io.Serializable;

/**
 * 地域标签解析（定制）
 * Created by qian.wang 2021/09/09
 */
public class AddressParseLabelConstant implements Serializable {

    // 地域标签 返回字段
    public static final String PROVINCE = "Province";
    public static final String PROVINCE_CODE = "ProvinceCode";
    public static final String CITY = "City";
    public static final String CITY_CODE = "CityCode";
    public static final String DISTRICT = "District";
    public static final String DISTRICT_CODE = "DistrictCode";
    public static final String ADDRESS = "Address";
    public static final String OPERATOR = "Operator";
    public static final String ADDRESS_DETAIL = "AddressDetail";
    public static final String FIELD_CODE = "FieldCode";
    public static final String LABEL_TYPE = "LabelType";
    public static final String LABEL_VALUE = "LabelValue";

    // 地域标签判断字段
    public static final String CODE_LOWER = "code";
    public static final String PROVINCE_LOWER = "province";
    public static final String CITY_LOWER = "city";
    public static final String AREA_LOWER = "area";
    public static final String NULL_LOWER = "null";

    /**
     * 原 IpKnowledge
     */
    public static final String IP_VALID_SUFFIX = "_v";
    public static final String IP_COUNTRY = "_cr";
    public static final String IP_PROVINCE = "_rg";
    public static final String IP_CITY = "_ct";
    public static final String IP_ADDRESS = "_add";
    public static final String IP_ISP = "_isp";
    public static final String IP_IP3 = "_ip3";
    public static final String IP_DISTRICT = "_county";

    /**
     * 原 MobileKnowledge
     */
    // 格式是否正确
    public static final String MOBILE_FORMAT_CHECK_SUFFIX = "_c";
    // 手机号码前三位
    public static final String MOBILE_MOBILE3_SUFFIX = "_m3";
    // 手机号码前七位
    public static final String MOBILE_MOBILE7_SUFFIX = "_m7";
    // 运营商
    public static final String MOBILE_OPERATOR_SUFFIX = "_o";
    // 归属地
    public static final String MOBILE_BELONG_SUFFIX = "_b";
    // 归属地省份
    public static final String MOBILE_REGISTER_PROVINCE_SUFFIX = "_p";
    // 归属地城市
    public static final String MOBILE_REGISTER_CITY_SUFFIX = "_ct";

    /**
     * 原 AddressKnowledge
     */
    // 国家/地区 地址类
    public static final String ADDRESS_COUNTRY_SUFFIX = "_c";
    // 省份
    public static final String ADDRESS_PROVINCE_SUFFIX = "_p";
    // 城市
    public static final String ADDRESS_CITY_SUFFIX = "_ci";
    // 区
    public static final String ADDRESS_CITY_AREA_SUFFIX = "_a";
    // 标准地址
    public static final String ADDRESS_STANDARD_SUFFIX = "_s";
    //详细地址
    public static final String ADDRESS_DISTRICT_SUFFIX = "_d";
    //gps
    public static final String ADDRESS_GPS_SUFFIX = "_g";

    /**
     * 银行卡相关
     */
    public static final String BANKCARD_VALID_SUFFIX = "_v";
    public static final String BANKCARD_BIN = "_bin";
    // 类型:借记卡、贷记卡
    public static final String BANKCARD_TYPE_SUFFIX = "_t";
    // 卡名:
    public static final String BANKCARD_NAME_SUFFIX = "_n";
    // 银行名称
    public static final String BANKCARD_BANK_SUFFIX = "_b";
    // 省份
    public static final String BANKCARD_PROVINCE_SUFFIX = "_p";
    // 城市
    public static final String BANKCARD_CITY_SUFFIX = "_ci";

    /**
     * 原身份解析
     */
    // 是否合法
    public static final String IDCARD_VALID_SUFFIX = "_v";
    // ID6
    public static final String IDCARD_ID6_SUFFIX = "_i6";
    // 年龄
    public static final String IDCARD_AGE_SUFFIX = "_age";
    // 性别
    public static final String IDCARD_GENDER_SUFFIX = "_g";
    // 出生日期
    public static final String IDCARD_BIRTHDAY_SUFFIX = "_b";
    // 出生省份
    public static final String IDCARD_LOC_REGION_SUFFIX = "_p";
    // 出生城市
    public static final String IDCARD_LOC_CITY_SUFFIX = "_c";
    // 出生地
    public static final String IDCARD_ADDRESS_SUFFIX = "_a";
    // 区县
    public static final String IDCARD_ADDRESS_REGION_SUFFIX = "_s";

    public static final String ADDRESS_STR_L = "address";
    public static final String MOBILE_STR_L = "mobile";
    public static final String IDCARD_STR_L = "idcard";
    public static final String BANKCARD_STR_L = "bankcard";
    public static final String IP_STR_L = "ip";
    public static final String PLATE_NUMBER_STR_L = "plateNumber";
    public static final String GPS_STR_L = "gps";
}