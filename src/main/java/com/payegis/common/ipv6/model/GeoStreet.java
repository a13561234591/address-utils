package com.payegis.common.ipv6.model;

import java.util.List;

public class GeoStreet extends Geo {
    private int correctness;
    private int consistency;
    private List<Areas> multiAreas;

    public GeoStreet(Geo geoBase) {
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

    public int getCorrectness() {
        return correctness;
    }

    public void setCorrectness(int correctness) {
        this.correctness = correctness;
    }

    public int getConsistency() {
        return consistency;
    }

    public void setConsistency(int consistency) {
        this.consistency = consistency;
    }

    public List<Areas> getMultiAreas() {
        return multiAreas;
    }

    public void setMultiAreas(List<Areas> multiAreas) {
        this.multiAreas = multiAreas;
    }
}
