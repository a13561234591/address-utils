package com.payegis.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payegis.constant.TypeConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class StringType extends Type {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringType.class);
    private static final long serialVersionUID = 1851663643812621890L;

    private String type = "string";
    @JsonProperty("hbaseHead")
    private String hbaseHead = "s_";
    @JsonProperty("originalValue")
    private String val = null;

    public StringType() {

    }

    public StringType(String value) {
        String obj = null;
        if (value != null) {
            obj = value.trim();
        } else {
            LOGGER.debug("value is null");
        }
        val = obj;
    }

    @Override
    public Object getOriginalValue() {
        return val;
    }

    @Override
    public String getHBaseHead() {
        return hbaseHead;
    }

    @Override
    public String toString() {
        if (val != null) {
            return String.valueOf(val).trim();
        } else {
            return TypeConstant.NULL_VALUE;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        StringType t = (StringType) obj;
        return this.val.equals(t.val);
    }

    @Override
    public int hashCode() {
        return this.val.hashCode();
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Object getIndexValue() {
        if (this.val == null) {
            return null;
        } else {
            return this.val.trim().trim();
        }
    }

    public StringType(String country, String province, String city, String district, String street, String other) {
        String nan = "NA";
        List<String> addressList = new ArrayList<>();
        if (StringUtils.isNotBlank(country) && !nan.equalsIgnoreCase(country)) {
            addressList.add(country.trim());
        } else {
            addressList.add("");
        }
        if (StringUtils.isNotBlank(province) && !nan.equalsIgnoreCase(province)) {
            addressList.add(province.trim());
        } else {
            addressList.add("");
        }
        if (StringUtils.isNotBlank(city) && !nan.equalsIgnoreCase(city)) {
            if (city.equals("北京市") || city.equals("上海市") || city.equals("天津市") || city.equals("重庆市")) {
                city = "";
            }
            addressList.add(city.trim());
        } else {
            addressList.add("");
        }
        if (StringUtils.isNotBlank(district) && !nan.equalsIgnoreCase(district)) {
            addressList.add(district.trim());
        } else {
            addressList.add("");
        }
        if (StringUtils.isNotBlank(street) && !nan.equalsIgnoreCase(street)) {
            addressList.add(street.trim());
        } else {
            addressList.add("");
        }
        if (StringUtils.isNotBlank(other) && !nan.equalsIgnoreCase(other)) {
            addressList.add(other.trim());
        } else {
            addressList.add("");
        }
        val = StringUtils.join(addressList, "");
    }

    public StringType(String lng, String lat) {
        String obj = null;
        if (StringUtils.isNotBlank(lng) && StringUtils.isNotBlank(lat)) {
            try {
                if (Math.abs(Double.valueOf(lng)) <= 180 && Math.abs(Double.valueOf(lat)) <= 90) {
                    obj = lng + TypeConstant.GEOGRAPHY_DELIMITER + lat;
                } else {
                    LOGGER.info("经纬度错误 : lng :" + lng + ", lat :" + lat);
                }
            } catch (Exception e) {
                LOGGER.info("经纬度错误 : lng :" + lng + ", lat :" + lat);
            }
        }
        val = obj;
    }

}
