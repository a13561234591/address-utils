package com.payegis.common;


import com.alibaba.fastjson2.JSONObject;
import com.payegis.common.ipv6.AwReader;
import com.payegis.common.ipv6.model.GeoCityV6;
import com.payegis.common.ipv6.model.GeoDistrict;
import com.payegis.config.LocalCache;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.net.util.IPAddressUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Song
 */
public class GeoIpManager {

    private static final Logger logger = LogManager.getLogger(GeoIpManager.class);

    private static AwReader awReaderV4;
    private static AwReader awReaderV6;
    private static final Map<String, String> lngLatMap = new HashMap<>();
    private static final Map<String, String> lngLatMapV2 = new HashMap<>();

    static {
        String geoIpFilePath = LocalCache.serviceProperties.getIpDataFile();
        String geoIpv6FilePath = LocalCache.serviceProperties.getIpv6DataFile();
        logger.info("读取ipv4的离线库路径为：{}", geoIpFilePath);
        logger.info("读取ipv6的离线库路径为：{}", geoIpv6FilePath);
        try {
            awReaderV4 = new AwReader(new File(geoIpFilePath));
            awReaderV6 = new AwReader(new File(geoIpv6FilePath));
            BufferedReader br = null;
            FileInputStream lngLatFile = null;
            String line;
            String[] lngLatArry;
            try {
                lngLatFile = new FileInputStream(LocalCache.serviceProperties.getGeoipLngLatFilePath());
                br = new BufferedReader(new InputStreamReader(lngLatFile, "UTF-8"));
                while ((line = br.readLine()) != null && !line.equals("")) {
                    lngLatArry = line.trim().split("\t");
                    switch (lngLatArry.length) {
                        case 3:
                            lngLatMap.put(lngLatArry[0], lngLatArry[1] + "|" + lngLatArry[2]);
                            break;
                        case 4:
                            lngLatMap.put(lngLatArry[0] + "|" + lngLatArry[1], lngLatArry[2] + "|" + lngLatArry[3]);
                            break;
                        default:
                            break;
                    }
                }
            } catch (IOException e) {
                logger.error("error !", e);
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                    if (lngLatFile != null) {
                        lngLatFile.close();
                    }
                } catch (IOException o) {
                    o.printStackTrace();
                }
            }
            try {
                lngLatFile = new FileInputStream(LocalCache.serviceProperties.getGeoipLngLatFilePathV2());
                br = new BufferedReader(new InputStreamReader(lngLatFile, "UTF-8"));
                while ((line = br.readLine()) != null && !line.equals("")) {
                    lngLatArry = line.trim().split("\t");
                    lngLatMapV2.put(lngLatArry[0] + "|" + lngLatArry[1], lngLatArry[2] + "|" + lngLatArry[3]);
                }
            } catch (IOException e) {
                logger.error("error!", e);
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                    if (lngLatFile != null) {
                        lngLatFile.close();
                    }
                } catch (IOException o) {
                    o.printStackTrace();
                }
            }
            logger.info("[init] lngLatMap size:" + lngLatMap.size() + "\nlngLatMapV2 size:" + lngLatMapV2.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用geoip服务，解析IP所在的国家，省份，城市，经纬度
     *
     * @param ip
     * @return Map, 字段和AppTypeConstant中ip相关字段一致
     */
    public static JSONObject getIpInfo(String ip) {
        String empty = StringUtils.EMPTY;
        // GeoIp start
        JSONObject geoIpResultJson = null;

        try {
            boolean iPv6LiteralAddress = IPAddressUtil.isIPv6LiteralAddress(ip);
            if (iPv6LiteralAddress) {
                //追加ipv6信息
                GeoCityV6 geoV6 = (GeoCityV6) awReaderV6.findIp(ip);
                geoIpResultJson = JSONObject.parseObject(JSONObject.toJSONString(geoV6));

            } else {
                //追加geoIp信息
                GeoDistrict geoV4 = (GeoDistrict) awReaderV4.findIp(ip);
                geoIpResultJson = JSONObject.parseObject(JSONObject.toJSONString(geoV4));
            }

            String country =
                    geoIpResultJson.getOrDefault("country", empty).toString();
            String province =
                    geoIpResultJson.getOrDefault("province", empty).toString();
            String city =
                    geoIpResultJson.getOrDefault("city", empty).toString();
            String district =
                    geoIpResultJson.getOrDefault("district", empty).toString();
            String isp =
                    geoIpResultJson.getOrDefault("isp", empty).toString();
            String lat =
                    geoIpResultJson.getOrDefault("lat", Float.valueOf(0)).toString();
            String lng =
                    geoIpResultJson.getOrDefault("lng", Float.valueOf(0)).toString();

            if (StringUtils.isNotBlank(isp)) {
                switch (isp) {
                    case "China Telecom Backbone":
                        isp = "中国电信";
                        break;
                    case "China Telecom":
                        isp = "中国电信";
                        break;
                    case "China Unicom Backbone":
                        isp = "中国联通";
                        break;
                    case "China Unicom":
                        isp = "中国联通";
                        break;
                    case "China Netcom Backbone":
                        isp = "中国网通";
                        break;
                    case "China Netcom":
                        isp = "中国网通";
                        break;
                    case "China Mobile Backbone":
                        isp = "中国移动";
                        break;
                    case "China Mobile":
                        isp = "中国移动";
                        break;
                    default:
                        isp = "未知";
                        break;

                }
            }

            geoIpResultJson.put("country", country);
            geoIpResultJson.put("province", province);
            geoIpResultJson.put("city", city);
            geoIpResultJson.put("district", district);
            geoIpResultJson.put("isp", isp);

            try {
                geoIpResultJson.putAll(query(country, province, city));
            } catch (Exception e) {
                logger.error("ip解析经纬度出错：{}", e);
            }
//            geoIpResultJson.put("lat", lat);
//            geoIpResultJson.put("lng", lng);

            //logger.info("[GeoIp] ip :{} and result is [{}] ", ip, geoIpResultJson);
        } catch (Exception e) {
            logger.error(empty, e);
        }
        return geoIpResultJson;
    }

    private static JSONObject query(String country, String province, String city) {
        JSONObject jsonObj = new JSONObject();

        //排除国外IP
        if (!country.equals("中国")) {
            if (province.equals("中国香港")) {
                jsonObj.put("lng", "114.08");
                jsonObj.put("lat", "22.2");
            } else if (province.equals("中国澳门")) {
                jsonObj.put("lng", "113.33");
                jsonObj.put("lat", "22.13");
            } else if (province.equals("中国台湾")) {
                jsonObj.put("lng", "121.5");
                jsonObj.put("lat", "25.03");
            } else {
                String key = province + "|" + city;//省市
                JSONObject latAndLonInfo = getLatAndLonInfo(key, "V1");
                if (latAndLonInfo != null) {
                    jsonObj.put("lng", latAndLonInfo.getString("lng"));
                    jsonObj.put("lat", latAndLonInfo.getString("lat"));
                }
            }
        } else {
            if (lngLatMap.containsKey(country)) {
                JSONObject latAndLonInfo = getLatAndLonInfo(country, "V1");
                if (latAndLonInfo != null) {
                    jsonObj.put("lng", latAndLonInfo.getString("lng"));
                    jsonObj.put("lat", latAndLonInfo.getString("lat"));
                }
            }

            //国外IP，查询maxmind数据
            String key = province + "|" + city;//省市

            JSONObject latAndLonInfo = getLatAndLonInfo(key, "V2");
            if (latAndLonInfo != null) {
                jsonObj.put("lng", latAndLonInfo.getString("lng"));
                jsonObj.put("lat", latAndLonInfo.getString("lat"));
            }
        }
        return jsonObj;
    }

    /**
     * 根据键值获取经纬度
     *
     * @param key
     * @param version V1(github版本)或V2(maxmind版本)
     * @return
     */
    private static JSONObject getLatAndLonInfo(String key, String version) {

        //logger.info("[getLatAndLon] key :" + key + ",version:" + version);
        JSONObject result = null;

        if ("V1".equals(version)) {
            if (lngLatMap.containsKey(key)) {
                String lngAndLatValue = lngLatMap.get(key);
                //logger.info("[getLatAndLon] value :" + lngAndLatValue);
                String[] lngAndLat = lngAndLatValue.split("\\|");
                result = new JSONObject();
                result.put("lng", lngAndLat[0]);
                result.put("lat", lngAndLat[1]);
            }
            if (result == null || key.indexOf("\\|") >= 0) {//省
                String lngAndLatValue = lngLatMap.get(key.split("\\|")[0]);
                //logger.info("[getLatAndLon] value :" + lngAndLatValue);
                if (lngAndLatValue != null) {
                    String[] lngAndLat = lngAndLatValue.split("\\|");
                    result = new JSONObject();
                    result.put("lng", lngAndLat[0]);
                    result.put("lat", lngAndLat[1]);
                }
            }
        } else {
            if (lngLatMapV2.containsKey(key)) {
                String lngAndLatValue = lngLatMapV2.get(key);
                //logger.info("[getLatAndLon] value :" + lngAndLatValue);
                String[] lngAndLat = lngAndLatValue.split("\\|");
                result = new JSONObject();
                result.put("lng", lngAndLat[0]);
                result.put("lat", lngAndLat[1]);
            }
        }
        return result;
    }

}
