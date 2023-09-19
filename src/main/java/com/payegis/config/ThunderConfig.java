package com.payegis.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.File;
import java.lang.reflect.Field;

@Slf4j
@Component
public class ThunderConfig  implements InitializingBean {

    protected final static Logger LOGGER = LoggerFactory.getLogger(ThunderConfig.class);

    private static long lastModifyTime = 0L;

    private static String configHome =
            System.getProperty("pesdk_home") == null ? System.getenv("pesdk_home") : System.getProperty("pesdk_home");

    private static String configFilePath;

    static {
        // configFilePath = configHome + File.separator + "conf" + File.separator + "thunder_api_local_redisstream.properties";
        try {
            Class c = Class.forName("com.payegis.config.SystemVariable");
            Field field = c.getDeclaredField("CONFIGE_FILE_NAME");
            field.setAccessible(true);
            Object object = c.newInstance();
            String configFileName = field.get(object).toString();
            configFilePath = configHome + File.separator + "conf" + File.separator + configFileName;
            LOGGER.info("configFilePath={}", configFilePath);
            initParam();
        } catch (Exception e) {
            LOGGER.debug("Error read SystemVariable Class", e);
        }
    }

    public static void getConfig() {
        if (lastModifyTime == 0L) {
            PropKit.use(new File(configFilePath));
            lastModifyTime = new File(configFilePath).lastModified();
        } else {
            if (getReload()) {
                long nowLastModifyTime = new File(configFilePath).lastModified();
                if (nowLastModifyTime != lastModifyTime) {
                    LOGGER.info("检测到配置文件有变动,重新加载配置文件");
                    PropKit.clear();
                    PropKit.use(new File(configFilePath));
                    lastModifyTime = nowLastModifyTime;
                }
            }
        }
    }

    public static void initParam() {

        //初始化Common参数
        CommonProperties commonProperties = new CommonProperties();
        commonProperties.setMobileAttributePath(AdminConfig.getMobileAttributePath());
        commonProperties.setPhoneAttributePath(AdminConfig.getPhoneAttributePath());
        commonProperties.setBaiduUrl(AdminConfig.getBaiduUrl());
        commonProperties.setBaiduAk(AdminConfig.getBaiduAk());
        commonProperties.setGeocoderUrl(AdminConfig.getGeocoderUrl());
        commonProperties.setCountryArea(AdminConfig.getCountryArea());
        commonProperties.setForeignInfo(AdminConfig.getForeignInfo());
        commonProperties.setThunderEncryption(AdminConfig.getThunderEncryptionPath());
        commonProperties.setAnalysisNodeCount(AdminConfig.getAnalysisNodeCount());
        commonProperties.setMakeDecisionAsyncFilePath(AdminConfig.getMakeDecisionAsyncFilePath());
        commonProperties.setBlazeCallCustomerStock(AdminConfig.getBalzeCallCustomerStock());
        // 车牌号解析
        commonProperties.setPlateNumberFilePath(AdminConfig.getPlateNumberPath());

        CommonCache.setCommonProperties(commonProperties);
        //初始化service参数
        ServiceProperties serviceProperties = LocalCache.serviceProperties;
        serviceProperties.setFactorCacheExpireSecond(AdminConfig.getFactorCacheExpireSecond());
        serviceProperties.setGeoipDBFilePath(AdminConfig.getGeoipDBFilePath());
        serviceProperties.setGeoipDBFilePathV2(AdminConfig.getGeoipDBFilePathV2());
        serviceProperties.setGeoipLngLatFilePath(AdminConfig.getGeoipLngLatFilePath());
        serviceProperties.setGeoipLngLatFilePathV2(AdminConfig.getGeoipLngLatFilePathV2());
        serviceProperties.setThunderSasUrl(AdminConfig.getThunderSasUrl());
        serviceProperties.setIdcardAreaPath(AdminConfig.getIdcardAreaPath());
        // todo delete
        serviceProperties.setIpDataFile(AdminConfig.getIPLibraryFileName());
        serviceProperties.setIpv6DataFile(AdminConfig.getIPV6LibraryFileName());
        serviceProperties.setDidHttpAddress(AdminConfig.getDidHttpAddress());
        serviceProperties.setDidMessageType(AdminConfig.getDidMessageType());
        //场景缓存参数添加
        serviceProperties.setSceneCacheAsyncCorePoolSize(AdminConfig.getSceneCacheCacheAsyncCorePoolSize());
        serviceProperties.setSceneCacheAsyncMaximumPoolSize(AdminConfig.getSceneCacheAsyncMaximumPoolSize());
        serviceProperties.setSceneCacheAsyncWorkQueueSize(AdminConfig.getSceneCacheAsyncWorkQueueSize());

        serviceProperties.setCommonKnowledgeFields(AdminConfig.getCommonKnowledgeFields());

    }
    /**
     * 获取是否动态家在配置文件
     *
     * @return
     */

    private static Boolean getReload() {
        return PropKit.getBoolean("config.reload", false);
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
