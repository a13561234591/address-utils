package com.payegis.common.ipv6.model;


import com.alibaba.fastjson2.annotation.JSONField;

public class Areas {
    private String lat;
    private String lng;
    private String radius;
    private String prov;
    private String city;
    private String district;

    public String getLat() {
        return lat;
    }

    @JSONField(name = "w")
    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    @JSONField(name = "j")
    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getRadius() {
        return radius;
    }

    @JSONField(name = "r")
    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getProv() {
        return prov;
    }

    @JSONField(name = "p")
    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    @JSONField(name = "c")
    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    @JSONField(name = "d")
    public void setDistrict(String district) {
        this.district = district;
    }
}
