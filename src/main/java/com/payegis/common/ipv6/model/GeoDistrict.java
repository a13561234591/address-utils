package com.payegis.common.ipv6.model;

import java.util.List;

public class GeoDistrict extends Geo {
    private List<Areas> multiAreas;
    private String district;
    private String province;
    private String city;
    private String lng;
    private String lat;
    private String adcode;

    public GeoDistrict(Geo geoBase) {
        super.setAccuracy(geoBase.getAccuracy());
        super.setAreacode(geoBase.getAreacode());
        super.setContinent(geoBase.getContinent());
        super.setCountry(geoBase.getCountry());
        super.setOwner(geoBase.getOwner());
        super.setSource(geoBase.getSource());
        super.setTimezone(geoBase.getTimezone());
        super.setZipcode(geoBase.getZipcode());
        super.setIsp(geoBase.getIsp());
        super.setAsnumber(geoBase.getAsnumber());
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public List<Areas> getMultiAreas() {
        return multiAreas;
    }

    public void setMultiAreas(List<Areas> multiAreas) {
        this.multiAreas = multiAreas;
    }
}
