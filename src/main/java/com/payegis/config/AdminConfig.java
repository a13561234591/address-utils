package com.payegis.config;

import org.apache.commons.lang3.StringUtils;

/**
 * 描述: Admin获取参数
 * 创建: zhishang.wang
 * 时间: 2018-06-13 11:00
 **/
public class AdminConfig {

    /**
     * 手机号归属地文件地址
     */
    public static String getMobileAttributePath() {
        ThunderConfig.getConfig();
        return PropKit.get("mobile.attribute.path");
    }

    public static String getPhoneAttributePath() {
        ThunderConfig.getConfig();
        return PropKit.get("phone.attribute.path");
    }

    public static String getBaiduUrl() {
        ThunderConfig.getConfig();
        return PropKit.get("baidu.api.url");
    }

    public static String getBaiduAk() {
        ThunderConfig.getConfig();
        return PropKit.get("baidu.api.ak");
    }

    public static String getGeocoderUrl() {
        ThunderConfig.getConfig();
        return PropKit.get("baidu.geocoder.api.url");
    }

    /**
     * 国家源文件地址
     *
     * @return
     */
    public static String getCountryArea() {
        ThunderConfig.getConfig();
        return PropKit.get("countryArea.path");
    }

    /**
     * 国家源文件地址
     *
     * @return
     */
    public static String getForeignInfo() {
        ThunderConfig.getConfig();
        return PropKit.get("foreignInfo.path");
    }

    /*service*/

    /**
     * 获取指标的缓存超时时间
     *
     * @return
     */
    public static int getFactorCacheExpireSecond() {
        ThunderConfig.getConfig();
        return PropKit.getInt("factor.cache.expire.second", 0);
    }

    /**
     * 获取设备指纹数据文件地址
     *
     * @return
     */
    public static String getGeoipDBFilePath() {
        ThunderConfig.getConfig();
        return PropKit.get("geoip.dbfile.path");
    }

    /**
     * 获取设备指纹数据文件地址 V2
     *
     * @return
     */
    public static String getGeoipDBFilePathV2() {
        ThunderConfig.getConfig();
        return PropKit.get("geoip.dbfile.path.v2");
    }

    public static String getGroupId() {
        ThunderConfig.getConfig();
        return PropKit.get("dataservice.groupid");
    }

    public static String getGroupKey() {
        ThunderConfig.getConfig();
        return PropKit.get("dataservice.groupkey");
    }

    public static String getEncryptKey() {
        ThunderConfig.getConfig();
        return PropKit.get("dataservice.encryptkey");
    }

    public static String getPrivateKey() {
        ThunderConfig.getConfig();
        return PropKit.get("dataservice.privatekey");
    }

    public static String getPublicKey() {
        ThunderConfig.getConfig();
        return PropKit.get("dataservice.publickey");
    }

    public static String getUsernature() {
        ThunderConfig.getConfig();
        return PropKit.get("usernature.url");
    }

    /**
     * 获取设备指纹经纬度文件地址
     *
     * @return
     */
    public static String getGeoipLngLatFilePath() {
        ThunderConfig.getConfig();
        return PropKit.get("geoip.lnglatfile.path");
    }

    /**
     * 获取设备指纹经纬度文件地址 V2
     *
     * @return
     */
    public static String getGeoipLngLatFilePathV2() {
        ThunderConfig.getConfig();
        return PropKit.get("geoip.lnglatfile.path.v2");
    }

    /**
     * 获取SAS url
     *
     * @return
     */
    public static String getThunderSasUrl() {
        ThunderConfig.getConfig();
        return PropKit.get("sas.url");
    }

    /**
     * 身份证归属地文件地址
     */
    public static String getIdcardAreaPath() {
        ThunderConfig.getConfig();
        return PropKit.get("idcard.area.path");
    }

    public static String getActAddress() {
        ThunderConfig.getConfig();
        return PropKit.get("act.Address");
    }

    public static String getSmsAddress() {
        ThunderConfig.getConfig();
        return PropKit.get("sms.Address");
    }

    public static String getSmsURL() {
        ThunderConfig.getConfig();
        return PropKit.get("sms.url");
    }

    /**
     * 获取异步保存线程池阻塞队列长度
     *
     * @return
     */
    public static int getAsyncWorkQueueSize() {
        ThunderConfig.getConfig();
        return PropKit.getInt("async.workqueue.size", 102400);
    }

    /**
     * 获取异步保存线程池核心线程数
     *
     * @return
     */
    public static int getAsyncCorePoolSize() {
        ThunderConfig.getConfig();
        return PropKit.getInt("async.corepool.size", 2);
    }

    /**
     * 获取异步保存线程池最大线程数
     *
     * @return
     */
    public static int getAsyncMaximumPoolSize() {
        ThunderConfig.getConfig();
        return PropKit.getInt("async.maximumpool.size", 5);
    }

    /**
     * 获取AES 密钥
     *
     * @return
     */
    public static String getAESPassWord() {
        ThunderConfig.getConfig();
        return PropKit.get("aes.password");
    }

    /*----------------------------------------------------------------*/

    /**
     * 获取elasticsearch IP
     *
     * @return
     */
    public static String getElasticsearchIp() {
        ThunderConfig.getConfig();
        return PropKit.get("elasticsearch.ip");
    }

    /**
     * 获取elasticsearch 端口
     *
     * @return
     */
    public static int getElasticsearchPort() {
        ThunderConfig.getConfig();
        return PropKit.getInt("elasticsearch.port");
    }

    public static int getElasticsearchHttpPort() {
        ThunderConfig.getConfig();
        return PropKit.getInt("elasticsearch.http.port");
    }

    /**
     * 获取Did 地址
     *
     * @return
     */
    public static String getDidAddress() {
        ThunderConfig.getConfig();
        return PropKit.get("did.make.url");
    }

    /**
     * 获取data_type
     *
     * @return
     */
    public static String getThunderDataType() {
        ThunderConfig.getConfig();
        return PropKit.get("sas.factor.return.data.type");
    }

    /**
     * 日报时间
     *
     * @return
     */
    public static int getProjectReportDay() {
        ThunderConfig.getConfig();
        return PropKit.getInt("project.report.day", 1);
    }

    public static String getSessionOutOfTime() {
        ThunderConfig.getConfig();
        return PropKit.get("sessionOutOfTime", "30");
    }

    /**
     * 规则指标配置最长统计范围
     *
     * @return
     */
    public static int getEventFactorTemplateMaxTime() {
        ThunderConfig.getConfig();
        return PropKit.getInt("event.factor_template.max_time", 6);
    }

    /**
     * 名单，配置最长时间范围
     *
     * @return
     */
    public static int getListFactorTemplateMaxTime() {
        ThunderConfig.getConfig();
        return PropKit.getInt("list.factor_template.max_time", 2);
    }

    /**
     * neo4j 相关配置
     */
    public static String getNeo4jDBConnectionUrl() {
        ThunderConfig.getConfig();
        return PropKit.get("neo4j.db.connection.url");
    }

    public static String getNeo4jDBUsername() {
        ThunderConfig.getConfig();
        return PropKit.get("neo4j.db.username");
    }

    public static String getNeo4jDBPassword() {
        ThunderConfig.getConfig();
        return PropKit.get("neo4j.db.password");
    }

    /**
     * 是否支持直接修改指标规则状态
     *
     * @return
     */
    public static boolean isSupportQa() {
        ThunderConfig.getConfig();
        return PropKit.getBoolean("request.qa.open", false);
    }

    /**
     * 可直接修改指标规则状态的ip集合
     *
     * @return
     */
    public static String getSupportQaIp() {
        ThunderConfig.getConfig();
        return PropKit.get("request.qa.ip", "");
    }

    public static String getFtpServerUrl() {
        ThunderConfig.getConfig();
        return PropKit.get("ftp.url", "");
    }

    public static int getFtpServerPort() {
        ThunderConfig.getConfig();
        return PropKit.getInt("ftp.port", 22);
    }

    public static String getFtpServerUserName() {
        ThunderConfig.getConfig();
        return PropKit.get("ftp.username", "");
    }

    public static String getFtpServerPassword() {
        ThunderConfig.getConfig();
        return PropKit.get("ftp.password", "");
    }

    public static String getFileRootPath() {
        ThunderConfig.getConfig();
        return PropKit.get("ftp.root.path", "");
    }

    public static String getCsmrId() {
        ThunderConfig.getConfig();
        return PropKit.get("image.csmrId", "");
    }

    public static String getImageUrl() {
        ThunderConfig.getConfig();
        return PropKit.get("image.url", "");
    }

    public static String getTranCode() {
        ThunderConfig.getConfig();
        return PropKit.get("image.tranCode", "");
    }

    public static String getSvcId() {
        ThunderConfig.getConfig();
        return PropKit.get("image.svcId", "");
    }

    public static String getImagePrivateKey() {
        ThunderConfig.getConfig();
        return PropKit.get("image.privateKeyOur", "");
    }

    public static String getImagePublicKey() {
        ThunderConfig.getConfig();
        return PropKit.get("image.publicKeyOther", "");
    }

    /**
     * 获取文件对应的字段
     */
    public static String getEsFields() {
        ThunderConfig.getConfig();
        return PropKit.get("upload.corresponding.field", "");
    }

    /**
     * 获取文件字段个数
     */
    public static int getFieldsNum() {
        ThunderConfig.getConfig();
        return PropKit.getInt("upload.file.fieldnum", 0);
    }

    /**
     * 获取文件对应的indexName
     */
    public static String getBusinessCode() {
        ThunderConfig.getConfig();
        return PropKit.get("upload.file.businesscode", "");
    }

    /**
     * 获取文件对应的indexName
     */
    public static String getSceneCode() {
        ThunderConfig.getConfig();
        return PropKit.get("upload.file.scenecode", "");
    }

    /**
     * 获取文件分隔符
     */
    public static String getFileSeparator() {
        ThunderConfig.getConfig();
        return PropKit.get("upload.file.separator", "|");
    }

    /**
     * 获取文件对应的读取行数
     */
    public static int getStartLine() {
        ThunderConfig.getConfig();
        return PropKit.getInt("upload.file.startline", 1);
    }

    public static int isFtpFile() {
        ThunderConfig.getConfig();
        return PropKit.getInt("upload.ftp.flag", 1);
    }

    public static String getUploadFilePath() {
        ThunderConfig.getConfig();
        return PropKit.get("upload.file.path", "");
    }

    /**
     * 获取小微跑批业务code
     */
    public static String getBatchBusinesscode() {
        ThunderConfig.getConfig();
        return PropKit.get("upload.file.batch.businesscode", "");
    }

    /**
     * 获取小微跑批场景code
     */
    public static String getBatchScenecode() {
        ThunderConfig.getConfig();
        return PropKit.get("upload.file.batch.scenecode", "");
    }

    /**
     * 获取小微跑批最大线程数
     */
    public static int getBatchThreadPool() {
        ThunderConfig.getConfig();
        return PropKit.getInt("upload.file.batch.thread.pool", 200);
    }

    /**
     * 获取授权文件地址
     */
    public static String getThunderEncryptionPath() {
        ThunderConfig.getConfig();
        return PropKit.get("thunder.encryption.path", "");
    }

    /**
     * IP解析库
     */
    //todo delete
 /*   public static String getIPLibraryAddress() {
        ThunderConfig.getConfig();
        return PropKit.get("ip.library.address", "");
    }*/

    /**
     * IP解析库
     */
    public static String getIPLibraryFileName() {
        ThunderConfig.getConfig();
        return PropKit.get("ip.library.file.name", "");
    }

    /**
     * IP6解析库
     */
    public static String getIPV6LibraryFileName() {
        ThunderConfig.getConfig();
        return PropKit.get("ipv6.library.file.name", "");
    }

    /**
     * 城市地址 持卡人使用（暂时未用）
     */
    public static String getCityCode() {
        ThunderConfig.getConfig();
        return PropKit.get("cityCode.path", "");
    }

    /**
     * did http接口
     */
    public static String getDidHttpAddress() {
        ThunderConfig.getConfig();
        return PropKit.get("did.http.url", "");
    }

    /**
     * did 请求类型。rmi http
     */
    public static String getDidMessageType() {
        ThunderConfig.getConfig();
        return PropKit.get("did.message.type", "http");
    }

    /**
     * zk连接地址
     */
    public static String getZooKeeperConnStr() {
        ThunderConfig.getConfig();
        return PropKit.get("zk.connection.string");
    }

    /**
     * zk连接超时时间
     */
    public static Integer getZooKeeperSessionTimeout() {
        ThunderConfig.getConfig();
        return PropKit.getInt("zk.session.timeout");
    }

    /**
     * zk注册目录
     */
    public static String getZooKeeperRegistryPath() {
        ThunderConfig.getConfig();
        return PropKit.get("zk.registry.path");
    }

    /**
     * 风控接口和更新接口的最大时间间隔 单位秒
     */
    public static Integer getRiskAPIUpdateAPIMaxInterval() {
        ThunderConfig.getConfig();
        return PropKit.getInt("riskapi.updateapi.max.interval", 3000);
    }

    /**
     * @auther: zhishang.wang
     * @date: 2018/12/10 16:40
     * @describe: rmi服务超时时间(毫秒)默认2秒
     */
    public static Integer getRmiTcpResponseTimeout() {
        ThunderConfig.getConfig();
        return PropKit.getInt("rmi.tcp.response.timeout", 2000);
    }

    public static Boolean getIgniteClientMode() {
        ThunderConfig.getConfig();
        return PropKit.getBoolean("ignite.client.mode", false);
    }

    public static String getIgniteCacheDataRegionName() {
        ThunderConfig.getConfig();
        return PropKit.get("ignite.data.region.name", "default");
    }

    public static Integer getFactorLastValueRange() {
        ThunderConfig.getConfig();
        return PropKit.getInt("last.value.factor.init.range", 7);
    }

    public static Integer getFactorLastValueRangeMultiple() {
        ThunderConfig.getConfig();
        return PropKit.getInt("last.value.factor.init.range.multiple", 7);
    }

    /**
     * api请求地址
     */
    public static String getApiRestfulUrl() {
        ThunderConfig.getConfig();
        return PropKit.get("thunder.api.restful.url", "");
    }


    public static String getKafkaACKS() {
        ThunderConfig.getConfig();
        return PropKit.get("kafka.acks", "0");
    }

    public static String getKafkaLingerMs() {
        ThunderConfig.getConfig();
        return PropKit.get("kafka.linger.ms", "100");
    }

    public static String getKafkaBatchSize() {
        ThunderConfig.getConfig();
        return PropKit.get("kafka.batch.size", "163840");
    }

    public static String getKafkaBufferMemory() {
        ThunderConfig.getConfig();
        return PropKit.get("kafka.buffer.memory", "33554432");
    }

    public static String getKafkaBootstrapServers() {
        ThunderConfig.getConfig();
        return PropKit.get("kafka.bootstrap.servers", "10.6.62.243:9092,10.6.62.223:9092,10.6.62.125:9092");
    }

    public static Boolean getKafkaSecurityOpen() {
        ThunderConfig.getConfig();
        return PropKit.getBoolean("kafka.security.open", false);
    }

    public static String getKafkaGroupId() {
        ThunderConfig.getConfig();
        return PropKit.get("kafka.group.id", "groupId");
    }

    public static String getKafkaTopic() {
        ThunderConfig.getConfig();
        return PropKit.get("kafka.topic", "topic");
    }

    public static String getSecurityAuthLoginConfigFilePath() {
        ThunderConfig.getConfig();
        return PropKit.get("java.security.auth.login.config.file.path");
    }

    /**
     * 蓝海银行：人工审核后，行方通知地址
     *
     * @return
     */
    public static String getLanHaiAuditNotifyUrl() {
        ThunderConfig.getConfig();
        return PropKit.get("lanhai.audit.notify.url", "");
    }

    /**
     * 蓝海银行：RSA公钥文件地址
     *
     * @return
     */
    public static String getLanHaiRsaPublicKeyFileLocation() {
        ThunderConfig.getConfig();
        return PropKit.get("lanhai.rsa.publickey.file.location", "");
    }

    /**
     * 蓝海银行：RSA私钥文件地址
     *
     * @return
     */
    public static String getLanHaiRsaPrivateKeyFileLocation() {
        ThunderConfig.getConfig();
        return PropKit.get("lanhai.rsa.privatekey.file.location", "");
    }

    /**
     * 蓝海银行：RSA私钥文件密码
     *
     * @return
     */
    public static String getLanHaiRsaPrivateKeyPwd() {
        ThunderConfig.getConfig();
        return PropKit.get("lanhai.rsa.privatekey.pwd", "");
    }

    /**
     * 蓝海银行：ChannelId
     *
     * @return
     */
    public static String getLanHaiChannelId() {
        ThunderConfig.getConfig();
        return PropKit.get("lanhai.audit.channel.id", "");
    }

    /**
     * 蓝海银行：ChannelId
     *
     * @return
     */
    public static String getLanHaiCooperateId() {
        ThunderConfig.getConfig();
        return PropKit.get("lanhai.audit.cooperate.id", "");
    }

    /**
     * @author: xiaofeng.wang
     * @date: 2019-12-17 10:24:58
     * @describe: 文件保存路径
     */
    public static String getFileSavePath() {
        ThunderConfig.getConfig();
        return PropKit.get("file.path", "");
    }

    /**
     * @author: zhishang.wang
     * @date: 2019-12-31 16:22:27
     * @describe: 关系图谱节点默认返回个数
     */
    public static Integer getAnalysisNodeCount() {
        ThunderConfig.getConfig();
        return PropKit.getInt("analysis.node.count", 10);
    }

    public static String getApiReturnParams() {
        ThunderConfig.getConfig();
        return PropKit.get("api.return.params", "riskScore,cost,strategyList,factorList");
    }

    /**
     * 异步风控回调地址配置文件地址
     */
    public static String getMakeDecisionAsyncFilePath() {
        ThunderConfig.getConfig();
        return PropKit.get("make.decision.async.file.path", "");
    }

    /**
     * 场景缓存核心线程数
     *
     * @return
     */
    public static int getSceneCacheCacheAsyncCorePoolSize() {
        ThunderConfig.getConfig();
        return PropKit.getInt("scene.cache.async.corepool.size", 2);
    }

    /**
     * 场景缓存最大线程数
     *
     * @return
     */
    public static int getSceneCacheAsyncMaximumPoolSize() {
        ThunderConfig.getConfig();
        return PropKit.getInt("scene.cache.async.maximumpool.size", 5);
    }

    /**
     * 场景缓存队列长度
     *
     * @return
     */
    public static int getSceneCacheAsyncWorkQueueSize() {
        ThunderConfig.getConfig();
        return PropKit.getInt("scene.cache.async.workqueue.size", 102400);
    }

    public static String getBalzeCallCustomerStock() {
        ThunderConfig.getConfig();
        return PropKit.get("blaze.call.customer.stock", "");
    }

    public static Boolean getRefreshSceneAuditFlowCache() {
        ThunderConfig.getConfig();
        return PropKit.getBoolean("refresh.scene.audit.flow.cache", false);
    }

    /**
     * @author qian.wang
     * @date 2022/02/23
     * @describe 公用字段解析地域【定制】
     */
    public static String getCommonKnowledgeFields() {
        ThunderConfig.getConfig();
        return PropKit.get("knowledge.common.codes", StringUtils.EMPTY);
    }

    /**
     * @author qian.wang
     * @date 2022/03/16
     * @describe 车牌号配置文件地址
     */
    public static String getPlateNumberPath() {
        ThunderConfig.getConfig();
        return PropKit.get("plate.number.path", StringUtils.EMPTY);
    }



}
