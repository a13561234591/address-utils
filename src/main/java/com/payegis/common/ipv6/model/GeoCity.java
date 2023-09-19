package com.payegis.common.ipv6.model;

import java.util.List;

public class GeoCity extends Geo {

    private List<Areas> multiAreas;

    public GeoCity(Geo geoBase) {
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

    public List<Areas> getMultiAreas() {
        return multiAreas;
    }

    public void setMultiAreas(List<Areas> multiAreas) {
        this.multiAreas = multiAreas;
    }
}
