package com.payegis.constant;

import java.nio.charset.Charset;

public final class SystemConstant {

    public static final String SYSTEM_ID = "thunder";
    public static final String CHARSET_UTF8 = "utf-8";
    public static final Charset UTF8 = Charset.forName("utf-8");
    public static final String CONFIGE_LOGFILE_NAME = "log4j2.properties";
    public static final String CONFIGE_LOGFILE_XML_NAME = "log4j2.xml";
    public static final String SYSTEM_PASSWORD = "5ar4y5E";
    public static final String SYSTEM_USER = "system";

    public static final String CACHE_LOCATION_PREFIX = SYSTEM_ID + "location";

    public static final String CACHE_ENTITY_KEY = SYSTEM_ID + "_entity";

    public static final String CACHE_ENTITY_EXIST_KEY = SYSTEM_ID + "_entity_exist";

    public static final String CACHE_SMS_KEY_PERFIX = SYSTEM_ID + "_sms";

    public static final String CACHE_MODEL_CONTENT_KEY = SYSTEM_ID + "model_content";
    public static final String CACHE_MODEL_PARAMS_KEY = SYSTEM_ID + "model_params";

    public static final String ES_INDEX_EVENTINFO_PREFIX = "event_";

    public static final String ES_INDEX_EXPERIENCE_PREFIX = "experience_event_";

    public static final String ES_INDEX_CHALLENGE_PREFIX = "challenge_event_";

    public static final String ES_INDEX = "index";
    public static final String ES_TYPE = "type";

    public static final String ES_INDEX_NAMELIST = SystemConstant.SYSTEM_ID + "_namelist";//索引名称
    public static final String ES_TYPE_NAMELIST = "namelist";

    public static final int CACHE_KEY_NO_EXPIRE = -1;

    /*
     * 权限AES密码
     * */
    public static final String AES_PASS = "thunder.payegis.local";

    /*
     * 系统标识，每个版本都有一个对应的标识
     * */
    public static final String SYSTEM_IDENTIFY = "thunder.payegis.local";

    public static final String SYSTEM_CACHE_KEY_FOR_SCENE = SYSTEM_ID + "_scene_compression";
    public static final String SYSTEM_CACHE_KEY_FOR_SCENE_FIELD = SYSTEM_ID + "_scene_field_compression";

    public static final String SYSTEM_CACHE_KEY_FOR_STRING = SYSTEM_ID + "_string";

    public static final String SYSTEM_CACHE_KEY_FOR_EVENT = SYSTEM_ID + "_event";

    //    public static final String SYSTEM_CACHE_KEY_FOR_NAMELIST = SYSTEM_ID + "_namelist";
    public static final String SYSTEM_CACHE_KEY_FOR_NAMELIST = "nameList";

    public static final String SYSTEM_CACHE_KEY_FOR_WHITELIST = "whiteList";

    public static final String SYSTEM_CACHE_KEY_FOR_NAMELISTOUT = "nameListOut";

    public static final String SYSTEM_CACHE_KEY_FOR_NAMELISTIN = "nameListIn";

    public static final String SYSTEM_CACHE_KEY_FOR_APPDETAILLIST = "appDetailList";

    public static final String CACHE_SYS_SEVEREST_REJECTION_CODE_KEY = SYSTEM_ID + "_severest_rejection_code";

    public static final String SYSTEM_CACHE_KEY_FOR_CUSTOMERSTOCKLIST = "customerStock";

    public static final String SYSTEM_CACHE_KEY_FOR_CUSTOMERSTOCKOPERLOG = "customerStockOperLog";

    // 大屏累计数据
    public static final String SYSTEM_CACHE_KEY_FOR_BIGSCREEN_DATAS = "bigScreenDatas";
    // 大屏当天数据
    public static final String SYSTEM_CACHE_KEY_FOR_BIGSCREEN_DATAS_CURRENT = "bigScreenDatasCurrent";

}
