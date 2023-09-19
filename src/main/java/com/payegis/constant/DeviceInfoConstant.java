package com.payegis.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 行尾注释的，还有注释写在代码下方的兄弟。 我 谢 谢 你 ！！！
 *
 * @author qian.wang
 */
public final class DeviceInfoConstant {

    public static final String DEVICE_SESSION = "s";
    public static final String DEVICE_ID_SUFFIX = "_device";
    // 浏览器ID
    public static final String DEVICE_BROWSER_ID_SUFFIX = "_browser";
    // 生成时间
    public static final String DEVICE_TS_SUFFIX = "_ts";
    // APP类型
    public static final String DEVICE_APP_TYPE_SUFFIX = "_at";
    // 设备类型
    public static final String DEVICE_DEVICE_TYPE_SUFFIX = "_t";
    // TAG
    public static final String DEVICE_TAG_SUFFIX = "_tag";
    // 信誉值
    public static final String DEVICE_DEVICE_REPUTATION_SUFFIX = "_dr";
    // 真实IP
    public static final String DEVICE_TRUE_IP_SUFFIX = "_tip";
    // 真实IP所在国家
    public static final String DEVICE_TRUE_IP_COUNTRY_SUFFIX = "_cr";
    // 真实IP所在省份
    public static final String DEVICE_TRUE_IP_PROVINCE_SUFFIX = "_rg";
    // 真实IP所在城市
    public static final String DEVICE_TRUE_IP_CITY_SUFFIX = "_ct";
    // 真是的IP所在区县
    public static final String DEVICE_TRUE_IP_DISTRICT_SUFFIX = "_county";
    // 真实IP所在地址
    public static final String DEVICE_TRUE_IP_ADDRESS_SUFFIX = "_add";
    // 真实IP运营商
    public static final String DEVICE_TRUE_IP_ISP_SUFFIX = "_isp";
    // 真实IP地址经度
    public static final String DEVICE_TRUE_IP_LONGITUDE_SUFFIX = "_ln";
    // 真实IP地址纬度
    public static final String DEVICE_TRUE_IP_LATITUDE_SUFFIX = "_la";
    // 真实IP地址经纬度
    public static final String DEVICE_TRUE_IP_LOCATION_SUFFIX = "_l";
    // IP
    public static final String DEVICE_IP_SUFFIX = "_arip";
    // IP所在国家
    public static final String DEVICE_IP_COUNTRY_SUFFIX = "_arcr";
    // IP所在省份
    public static final String DEVICE_IP_PROVINCE_SUFFIX = "_arrg";
    // IP所在城市
    public static final String DEVICE_IP_CITY_SUFFIX = "_arct";
    // IP所在区县
    public static final String DEVICE_IP_DISTRICT_SUFFIX = "_arcounty";
    // IP所在地址
    public static final String DEVICE_IP_ADDRESS_SUFFIX = "_aradd";
    // IP运营商
    public static final String DEVICE_IP_ISP_SUFFIX = "_arisp";
    // IP地址经度
    public static final String DEVICE_IP_LONGITUDE_SUFFIX = "_arln";
    // IP地址纬度
    public static final String DEVICE_IP_LATITUDE_SUFFIX = "_arla";
    // IP地址经纬度
    public static final String DEVICE_IP_LOCATION_SUFFIX = "_arl";
    // 是否代理
    public static final String DEVICE_IS_PROXY_SUFFIX = "_ip";
    // 代理类型(HTTP/VPN/SOCKS/TOR)
    public static final String DEVICE_PROXY_TYPE_SUFFIX = "_pt";
    // 操作系统
    public static final String DEVICE_OS_SUFFIX = "_o";
    // 操作系统版本
    public static final String DEVICE_OS_VER_SUFFIX = "_ov";
    // 应用名称
    public static final String DEVICE_APP_SUFFIX = "_a";
    // 应用版本
    public static final String DEVICE_APP_VER_SUFFIX = "_av";
    // 应用签名
    public static final String DEVICE_APP_SIGN_SUFFIX = "_as";
    // 浏览器名称
    public static final String DEVICE_BROWSER_SUFFIX = "_br";
    // 浏览器版本
    public static final String DEVICE_BROWSER_VER_SUFFIX = "_brv";
    // 屏幕高度
    public static final String DEVICE_SCREEN_HEIGHT_SUFFIX = "_sh";
    // 屏幕宽度
    public static final String DEVICE_SCREEN_WIDTH_SUFFIX = "_sw";
    // 手机号码
    public static final String DEVICE_PHONE_SUFFIX = "_p";
    // MAC_ADDRESS
    public static final String DEVICE_MAC_SUFFIX = "_m";
    // IMEI
    public static final String DEVICE_IMEI_SUFFIX = "_i";
    // GPS
    public static final String DEVICE_GPS_SUFFIX = "_gps";
    // GPS解析国家
    public static final String DEVICE_GPS_COUNTRY_SUFFIX = "_gpscr";
    // GPS解析省份
    public static final String DEVICE_GPS_REGION_SUFFIX = "_gpsrg";
    // GPS解析城市
    public static final String DEVICE_GPS_CITY_SUFFIX = "_gpsct";
    // GPS解析区县
    public static final String DEVICE_GPS_DISTRICT_SUFFIX = "_gpsdt";
    // GPS解析街道
    public static final String DEVICE_GPS_STREET_SUFFIX = "_gpsst";
    // GPS解析街道门牌号
    public static final String DEVICE_GPS_STREET_NO_SUFFIX = "_gpsstn";
    // GPS解析地址
    public static final String DEVICE_GPS_ADDRESS_SUFFIX = "_gpsadd";
    // GPS解析商圈
    public static final String DEVICE_GPS_BUSINESS_SUFFIX = "_gpsb";
    // VendorID
    public static final String DEVICE_VENDOR_ID_SUFFIX = "_vid";
    // IMSI
    public static final String DEVICE_IMSI_SUFFIX = "_imsi";
    // UserAgent
    public static final String DEVICE_USERAGENT_SUFFIX = "_ua";
    // URL
    public static final String DEVICE_URL_SUFFIX = "_u";
    // 是否初始化
    public static final String DEVICE_IS_INIT_SUFFIX = "_ii";
    // 是否机器人
    public static final String DEVICE_IS_MACHINE_SUFFIX = "_im";
    // 是否模拟器
    public static final String DEVICE_IS_SIMULATOR_SUFFIX = "_is";
    // 是否虚拟机
    public static final String DEVICE_IS_VM_SUFFIX = "_iv";
    // 是否调试
    public static final String DEVICE_IS_DEBUG_SUFFIX = "_id";
    // 是否安装作弊软件
    public static final String DEVICE_IS_CHEAT_SUFFIX = "_ic";
    // 是否使用VPN
    public static final String DEVICE_IS_VPN_SUFFIX = "_in";
    // 是否篡改参数
    public static final String DEVICE_IS_MODIFY_SUFFIX = "_iy";
    // 是否ROOT/越狱
    public static final String DEVICE_IS_ROOT_JAILBREAK_SUFFIX = "_ir";
    // 相似设备1
    public static final String DEVICE_SAME_DID_1_NO_SUFFIX = "_sim1";
    // 相似设备1的相似程度
    public static final String DEVICE_SAME_DID_1_PROB_SUFFIX = "_p1";
    // 相似设备2
    public static final String DEVICE_SAME_DID_2_NO_SUFFIX = "_sim2";
    // 相似设备2的相似程度
    public static final String DEVICE_SAME_DID_2_PROB_SUFFIX = "_p2";
    // 相似设备3
    public static final String DEVICE_SAME_DID_3_NO_SUFFIX = "_sim3";
    // 相似设备3的相似程度
    public static final String DEVICE_SAME_DID_3_PROB_SUFFIX = "_p3";
    // 精准位置国家
    public static final String DEVICE_LOCATION_COUNTRY_SUFFIX = "_rlcr";
    // 精准位置省份
    public static final String DEVICE_LOCATION_REGION_SUFFIX = "_rlrg";
    // 精准位置城市
    public static final String DEVICE_LOCATION_CITY_SUFFIX = "_rlct";
    // 精准位置地址
    public static final String DEVICE_LOCATION_ADD_SUFFIX = "_rladd";
    // 精准位置准确度
    public static final String DEVICE_LOCATION_ACCURACY_SUFFIX = "_rlac";
    public static final String DEVICE_IDFA_SUFFIX = "_idfa";
    public static final String DEVICE_MESSAGE_SUFFIX = "_msg";
    // 系统
    public static final String DEVICE_SYSTEM_SUFFIX = "_o";
    // 系统版本
    public static final String DEVICE_SYSTEM_VERSION_SUFFIX = "_ov";
    // 屏幕高度
    public static final String DEVICE_SCREENHEIGHT_SUFFIX = "_sh";
    // 屏幕亮度
    public static final String DEVICE_SCREENWIDTH_SUFFIX = "_sw";
    // 是否模拟器
    public static final String DEVICE_NULLISEMULATOR_SUFFIX = "_is";
    // 手机品牌
    public static final String DEVICE_BRAND_SUFFIX = "_product";
    // 设备类型/设备品牌
    public static final String DEVICE_MODEL_SUFFIX = "_platform";

    /**
     * 以下为蓝海新增
     */
    // 手机制造商
    public static final String DEVICE_EXTEND_PRODUCT_SUFFIX = "_product";
    // 手机型号
    public static final String DEVICE_EXTEND_PLATFORM_SUFFIX = "_platform";
    // 开机日期
    public static final String DEVICE_EXTEND_SYSTEM_UPTIME_SUFFIX = "_system_uptime";
    // WIFI_MAC
    public static final String DEVICE_EXTEND_WIFI_BSSID_SUFFIX = "_wifi_bssid";
    // WIFI名称
    public static final String DEVICE_EXTEND_WIFI_SSID_SUFFIX = "_wifi_ssid";
    // 是否有SIM卡
    public static final String DEVICE_EXTEND_IS_SIM_SUFFIX = "_is_SIM";
    // App安装列表
    public static final String DEVICE_EXTEND_INSTALLED_APPS_SUFFIX = "_installed_apps";

    public static final String DEVICE_MESSAGE = "did_msg";
    public static final String DEVICE_STATUS = "did_status";

    private static final List<String> nameList = new ArrayList<String>();
    private static final List<String> allNameList = new ArrayList<String>();
    private static final Map<String, String> understandNameMap = new HashMap<String, String>();

    static {

        nameList.add(DEVICE_SESSION + DEVICE_EXTEND_PRODUCT_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_EXTEND_PLATFORM_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_EXTEND_SYSTEM_UPTIME_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_EXTEND_WIFI_BSSID_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_EXTEND_WIFI_SSID_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_EXTEND_IS_SIM_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_EXTEND_INSTALLED_APPS_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_ID_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_TS_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_DEVICE_TYPE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_DEVICE_REPUTATION_SUFFIX);
        // nameList.add(DEVICE_SESSION + DEVICE_BROWSER_ID_SUFFIX);
        // nameList.add(DEVICE_SESSION + DEVICE_TIMEZONE_SUFFIX);
        // nameList.add(DEVICE_SESSION + DEVICE_APP_TYPE_SUFFIX);
        // nameList.add(DEVICE_SESSION + DEVICE_IP_ADDRESS_SUFFIX);
        // nameList.add(DEVICE_SESSION + DEVICE_TAG_SUFFIX);
        // nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_ADDRESS_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_COUNTRY_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_PROVINCE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_CITY_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_DISTRICT_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_LONGITUDE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_LATITUDE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_LOCATION_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_ISP_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_IP_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IP_COUNTRY_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IP_PROVINCE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IP_CITY_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IP_DISTRICT_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_IP_LONGITUDE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IP_LATITUDE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IP_LOCATION_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IP_ISP_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_IS_PROXY_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_PROXY_TYPE_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_OS_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_OS_VER_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_APP_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_APP_VER_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_APP_SIGN_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_BROWSER_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_BROWSER_VER_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_SCREEN_HEIGHT_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_SCREEN_WIDTH_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_PHONE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_MAC_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IMEI_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_GPS_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_VENDOR_ID_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IMSI_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_USERAGENT_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_URL_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_IS_INIT_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IS_MACHINE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IS_SIMULATOR_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IS_VM_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IS_DEBUG_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_IS_VPN_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IS_MODIFY_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IS_ROOT_JAILBREAK_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_IS_CHEAT_SUFFIX);

        nameList.add(DEVICE_SESSION + DEVICE_GPS_COUNTRY_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_GPS_REGION_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_GPS_CITY_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_GPS_DISTRICT_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_GPS_STREET_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_GPS_STREET_NO_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_GPS_ADDRESS_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_GPS_BUSINESS_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_MESSAGE_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_IDFA_SUFFIX);
        //
        nameList.add(DEVICE_SESSION + DEVICE_SYSTEM_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_SCREENHEIGHT_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_SCREENWIDTH_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_BRAND_SUFFIX);
        nameList.add(DEVICE_SESSION + DEVICE_MODEL_SUFFIX);
        nameList.add(DEVICE_NULLISEMULATOR_SUFFIX);

        understandNameMap.put(DEVICE_SESSION + DEVICE_EXTEND_PRODUCT_SUFFIX, "product");
        understandNameMap.put(DEVICE_SESSION + DEVICE_EXTEND_PLATFORM_SUFFIX, "platform");
        understandNameMap.put(DEVICE_SESSION + DEVICE_EXTEND_SYSTEM_UPTIME_SUFFIX, "system_uptime");
        understandNameMap.put(DEVICE_SESSION + DEVICE_EXTEND_WIFI_BSSID_SUFFIX, "wifi_bssid");
        understandNameMap.put(DEVICE_SESSION + DEVICE_EXTEND_WIFI_SSID_SUFFIX, "wifi_ssid");
        understandNameMap.put(DEVICE_SESSION + DEVICE_EXTEND_IS_SIM_SUFFIX, "is_SIM");
        understandNameMap.put(DEVICE_SESSION + DEVICE_EXTEND_INSTALLED_APPS_SUFFIX, "installed_apps");

        understandNameMap.put(DEVICE_SESSION + DEVICE_ID_SUFFIX, "deviceId");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TS_SUFFIX, "deviceFirstTs");

        understandNameMap.put(DEVICE_SESSION + DEVICE_DEVICE_TYPE_SUFFIX, "deviceType");
        // understandNameMap.put(DEVICE_SESSION + DEVICE_TAG_SUFFIX, "tag");
        // understandNameMap.put(DEVICE_SESSION + DEVICE_TIMEZONE_SUFFIX, "timezone");
        // understandNameMap.put(DEVICE_SESSION + DEVICE_APP_TYPE_SUFFIX, "appType");
        understandNameMap.put(DEVICE_SESSION + DEVICE_DEVICE_REPUTATION_SUFFIX, "reputation");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TRUE_IP_SUFFIX, "trueIp");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TRUE_IP_COUNTRY_SUFFIX, "trueIpCountry");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TRUE_IP_PROVINCE_SUFFIX, "trueIpRegion");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TRUE_IP_CITY_SUFFIX, "trueIpCity");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TRUE_IP_DISTRICT_SUFFIX, "trueIpCounty");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TRUE_IP_LONGITUDE_SUFFIX, "trueIpLongitude");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TRUE_IP_LATITUDE_SUFFIX, "trueIpLatitude");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TRUE_IP_LOCATION_SUFFIX, "trueIpCoordinate");
        understandNameMap.put(DEVICE_SESSION + DEVICE_TRUE_IP_ISP_SUFFIX, "trueIpIsp");

        understandNameMap.put(DEVICE_SESSION + DEVICE_IP_SUFFIX, "ip");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IP_COUNTRY_SUFFIX, "ipCountry");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IP_PROVINCE_SUFFIX, "ipRegion");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IP_CITY_SUFFIX, "ipCity");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IP_DISTRICT_SUFFIX, "ipCounty");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IP_LONGITUDE_SUFFIX, "ipLongitude");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IP_LATITUDE_SUFFIX, "ipLatitude");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IP_LOCATION_SUFFIX, "ipCoordinate");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IP_ISP_SUFFIX, "ipIsp");

        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_PROXY_SUFFIX, "proxy");
        understandNameMap.put(DEVICE_SESSION + DEVICE_PROXY_TYPE_SUFFIX, "proxyType");
        understandNameMap.put(DEVICE_SESSION + DEVICE_OS_SUFFIX, "os");
        understandNameMap.put(DEVICE_SESSION + DEVICE_OS_VER_SUFFIX, "osVersion");
        understandNameMap.put(DEVICE_SESSION + DEVICE_APP_SUFFIX, "app");
        understandNameMap.put(DEVICE_SESSION + DEVICE_APP_VER_SUFFIX, "appVersion");
        understandNameMap.put(DEVICE_SESSION + DEVICE_APP_SIGN_SUFFIX, "appSign");
        understandNameMap.put(DEVICE_SESSION + DEVICE_BROWSER_SUFFIX, "browser");
        understandNameMap.put(DEVICE_SESSION + DEVICE_BROWSER_VER_SUFFIX, "browserVersion");
        understandNameMap.put(DEVICE_SESSION + DEVICE_SCREEN_HEIGHT_SUFFIX, "screenHeight");
        understandNameMap.put(DEVICE_SESSION + DEVICE_SCREEN_WIDTH_SUFFIX, "screenWidth");
        understandNameMap.put(DEVICE_SESSION + DEVICE_PHONE_SUFFIX, "phone");
        understandNameMap.put(DEVICE_SESSION + DEVICE_MAC_SUFFIX, "mac");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IMEI_SUFFIX, "imei");
        understandNameMap.put(DEVICE_SESSION + DEVICE_GPS_SUFFIX, "gps");
        understandNameMap.put(DEVICE_SESSION + DEVICE_VENDOR_ID_SUFFIX, "vendorId");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IMSI_SUFFIX, "imsi");
        understandNameMap.put(DEVICE_SESSION + DEVICE_USERAGENT_SUFFIX, "useragent");
        understandNameMap.put(DEVICE_SESSION + DEVICE_URL_SUFFIX, "url");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_INIT_SUFFIX, "isInit");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_MACHINE_SUFFIX, "isBot");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_SIMULATOR_SUFFIX, "isSimulator");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_VM_SUFFIX, "isVm");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_DEBUG_SUFFIX, "isDebug");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_VPN_SUFFIX, "isVPN");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_MODIFY_SUFFIX, "isModify");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_ROOT_JAILBREAK_SUFFIX, "isRootJailbreak");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IS_CHEAT_SUFFIX, "haveCheatApp");

        understandNameMap.put(DEVICE_SESSION + DEVICE_GPS_COUNTRY_SUFFIX, "gpsCountry");
        understandNameMap.put(DEVICE_SESSION + DEVICE_GPS_REGION_SUFFIX, "gpsRegion");
        understandNameMap.put(DEVICE_SESSION + DEVICE_GPS_CITY_SUFFIX, "gpsCity");
        understandNameMap.put(DEVICE_SESSION + DEVICE_GPS_DISTRICT_SUFFIX, "gpsDistrict");
        understandNameMap.put(DEVICE_SESSION + DEVICE_GPS_STREET_SUFFIX, "gpsStreet");
        understandNameMap.put(DEVICE_SESSION + DEVICE_GPS_STREET_NO_SUFFIX, "gpsStreetNo");
        understandNameMap.put(DEVICE_SESSION + DEVICE_GPS_ADDRESS_SUFFIX, "gpsAddress");
        understandNameMap.put(DEVICE_SESSION + DEVICE_GPS_BUSINESS_SUFFIX, "gpsBusiness");
        understandNameMap.put(DEVICE_SESSION + DEVICE_MESSAGE_SUFFIX, "didMessage");
        understandNameMap.put(DEVICE_SESSION + DEVICE_IDFA_SUFFIX, "IDFA");

        understandNameMap.put(DEVICE_SESSION + DEVICE_SYSTEM_SUFFIX, "system");
        understandNameMap.put(DEVICE_SESSION + DEVICE_SCREENHEIGHT_SUFFIX, "screenHeight");
        understandNameMap.put(DEVICE_SESSION + DEVICE_SCREENWIDTH_SUFFIX, "screenWidth");
        understandNameMap.put(DEVICE_SESSION + DEVICE_BRAND_SUFFIX, "brand");
        understandNameMap.put(DEVICE_SESSION + DEVICE_MODEL_SUFFIX, "model");

        understandNameMap.put(DEVICE_NULLISEMULATOR_SUFFIX, "is_emulator");

        // -----
        allNameList.add(DEVICE_SESSION + DEVICE_ID_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_BROWSER_ID_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TS_SUFFIX);
        //allNameList.add(DEVICE_SESSION + DEVICE_TIMEZONE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_APP_TYPE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_DEVICE_TYPE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TAG_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_DEVICE_REPUTATION_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_COUNTRY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_PROVINCE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_CITY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_DISTRICT_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_ADDRESS_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_LONGITUDE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_LATITUDE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_TRUE_IP_LOCATION_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_IP_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IP_COUNTRY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IP_PROVINCE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IP_CITY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IP_ADDRESS_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IP_DISTRICT_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IP_LONGITUDE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IP_LATITUDE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IP_LOCATION_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_IS_PROXY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_PROXY_TYPE_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_OS_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_OS_VER_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_APP_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_APP_VER_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_APP_SIGN_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_BROWSER_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_BROWSER_VER_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_SCREEN_HEIGHT_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_SCREEN_WIDTH_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_PHONE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_MAC_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IMEI_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_USERAGENT_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_URL_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_IS_INIT_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IS_MACHINE_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IS_SIMULATOR_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IS_VM_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IS_DEBUG_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IS_VPN_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IS_MODIFY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IS_ROOT_JAILBREAK_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_IS_CHEAT_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_SAME_DID_1_NO_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_SAME_DID_1_PROB_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_SAME_DID_2_NO_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_SAME_DID_2_PROB_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_SAME_DID_3_NO_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_SAME_DID_3_PROB_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_LOCATION_COUNTRY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_LOCATION_REGION_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_LOCATION_CITY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_LOCATION_ADD_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_LOCATION_ACCURACY_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_GPS_COUNTRY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_GPS_CITY_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_GPS_ADDRESS_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_GPS_STREET_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_GPS_STREET_NO_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_GPS_BUSINESS_SUFFIX);

        allNameList.add(DEVICE_SESSION + DEVICE_SYSTEM_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_SCREENHEIGHT_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_SCREENWIDTH_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_BRAND_SUFFIX);
        allNameList.add(DEVICE_SESSION + DEVICE_MODEL_SUFFIX);

        allNameList.add(DEVICE_NULLISEMULATOR_SUFFIX);

    }

    private DeviceInfoConstant() {

    }

    public static List<String> getNameList() {
        return nameList;
    }

    public static List<String> getAllList() {
        return allNameList;
    }

    public static String getUnderstandName(String innerName) {
        return understandNameMap.get(innerName);
    }

}
