package com.payegis.common.ipv6;

import com.fasterxml.jackson.databind.JsonNode;
import com.payegis.common.ipv6.model.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class AwReader extends Reader {

    private static final Logger logger = LogManager.getLogger(AwReader.class);

    public AwReader(File database) throws IOException {
        super(database);
    }

    public AwReader(File database, NodeCache cache) throws IOException {
        super(database, cache);
    }

    public AwReader(InputStream source) throws IOException {
        super(source);
    }

    public AwReader(InputStream source, NodeCache cache) throws IOException {
        super(source, cache);
    }

    public AwReader(File database, FileMode fileMode) throws IOException {
        super(database, fileMode);
    }

    public AwReader(File database, FileMode fileMode, NodeCache cache) throws IOException {
        super(database, fileMode, cache);
    }

    public Geo findIp(String ip) throws Exception {
        InetAddress address = InetAddress.getByName(ip);
        JsonNode record = super.get(address);

        Geo geoBase = new Geo();
        geoBase.setAccuracy(record.get("accuracy").asText());
        geoBase.setAreacode(record.get("areacode").asText());
        geoBase.setContinent(record.get("continent").asText());
        geoBase.setCountry(record.get("country").asText());
        geoBase.setOwner(record.get("owner").asText());
        geoBase.setSource(record.get("source").asText());
        geoBase.setTimezone(record.get("timezone").asText());
        geoBase.setZipcode(record.get("zipcode").asText());
        geoBase.setIsp(record.get("isp").asText());
        geoBase.setAsnumber(record.get("asnumber").asText());

        Metadata metadata = super.getMetadata();
        int ipVersion = metadata.getIpVersion();
        String databaseType = metadata.getDatabaseType();
        //logger.info("databaseType is [{}], ipVersion is [{}]", databaseType, ipVersion);
        if (ipVersion == 4) {
            if (databaseType.contains("city")) {
                GeoCity geo = new GeoCity(geoBase);
                List<Areas> listAreas = new ArrayList<>();
                for (JsonNode temp : record.get("multiAreas")) {
                    Areas areas = new Areas();
                    areas.setProv(temp.get("prov").asText());
                    areas.setCity(temp.get("city").asText());
                    areas.setRadius(temp.get("radius").asText());
                    areas.setLat(temp.get("lat").asText());
                    areas.setLng(temp.get("lng").asText());
                    listAreas.add(areas);
                }
                geo.setMultiAreas(listAreas);
                return geo;
            } else if (databaseType.contains("district")) {
                GeoDistrict geo = new GeoDistrict(geoBase);
                List<Areas> listAreas = new ArrayList<>();
                for (JsonNode temp : record.get("multiAreas")) {
                    Areas areas = new Areas();
                    areas.setProv(temp.get("prov").asText());
                    areas.setCity(temp.get("city").asText());
                    areas.setCity(temp.get("district").asText());
                    areas.setRadius(temp.get("radius").asText());
                    areas.setLat(temp.get("lat").asText());
                    areas.setLng(temp.get("lng").asText());
                    listAreas.add(areas);
                }
                geo.setMultiAreas(listAreas);
                return geo;
            } else if (databaseType.contains("street")) {
                GeoStreet geo = new GeoStreet(geoBase);
                List<Areas> listAreas = new ArrayList<>();
                for (JsonNode temp : record.get("multiAreas")) {
                    Areas areas = new Areas();
                    areas.setProv(temp.get("prov").asText());
                    areas.setCity(temp.get("city").asText());
                    areas.setCity(temp.get("district").asText());
                    areas.setRadius(temp.get("radius").asText());
                    areas.setLat(temp.get("lat").asText());
                    areas.setLng(temp.get("lng").asText());
                    listAreas.add(areas);
                }
                geo.setMultiAreas(listAreas);
                return geo;
            } else if ("IP_basic_single_WGS84_awdb.awdb".equals(databaseType)) {
                GeoDistrict geo = new GeoDistrict(geoBase);
                geo.setCountry(record.get("country") == null ? "NA" : StringUtils.defaultIfBlank(record.get("country").asText(), "NA"));
                geo.setProvince(record.get("province") == null ? "NA" : StringUtils.defaultIfBlank(record.get("province").asText(), "NA"));
                geo.setCity(record.get("city") == null ? "NA" : StringUtils.defaultIfBlank(record.get("city").asText(), "NA"));
                geo.setDistrict(record.get("district") == null ? "NA" : StringUtils.defaultIfBlank(record.get("district").asText(), "NA"));
                geo.setLat(record.get("latwgs") == null ? "" : record.get("latwgs").asText());
                geo.setLng(record.get("lngwgs") == null ? "" : record.get("lngwgs").asText());
                geo.setAdcode(record.get("adcode") == null ? "NA" : StringUtils.defaultIfBlank(record.get("adcode").asText(), "NA"));
                return geo;
            } else {
                throw new Exception("not support this database type!");
            }

        } else if (ipVersion == 6) {
            GeoCityV6 geo = new GeoCityV6(geoBase);
            geo.setProvince(record.get("province") == null ? "NA" : StringUtils.defaultIfBlank(record.get("province").asText(), "NA"));
            geo.setCity(record.get("city") == null ? "NA" : StringUtils.defaultIfBlank(record.get("city").asText(), "NA"));
            geo.setLat(record.get("lat") == null ? "" : record.get("lat").asText());
            geo.setLng(record.get("lng") == null ? "" : record.get("lng").asText());
            return geo;
        } else {
            throw new Exception("only support ipv4 or ipv6!");
        }

    }

}
