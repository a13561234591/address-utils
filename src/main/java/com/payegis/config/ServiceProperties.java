package com.payegis.config;

/**
 * 描述: thunder-service使用参数
 * 创建: zhishang.wang
 * 时间: 2018-06-12 9:46
 **/
public class ServiceProperties {

    /**
     * 指标的缓存超时时间
     * getFactorCacheExpireSecond()
     */
    private int factorCacheExpireSecond;

    /**
     * 设备指纹数据文件地址
     * getGeoipDBFilePath()
     */
    private String geoipDBFilePath;

    /**
     * 设备指纹数据文件地址 V2
     * getGeoipDBFilePathV2()
     */
    private String geoipDBFilePathV2;

    /**
     * getGroupId()
     */
    private String groupId;

    /**
     * getGroupKey()
     */
    private String groupKey;

    /**
     * getEncryptKey()
     */
    private String encryptKey;

    /**
     * getPrivateKey()
     */
    private String privateKey;

    /**
     * getPublicKey()
     */
    private String publicKey;

    /**
     * getUsernature()
     */
    private String usernature;

    /**
     * 设备指纹经纬度文件地址
     * getGeoipLngLatFilePath()
     */
    private String geoipLngLatFilePath;

    /**
     * 设备指纹经纬度文件地址 V2
     * GeoipLngLatFilePathV2()
     */
    private String geoipLngLatFilePathV2;

    /**
     * 获取SAS url
     * getThunderSasUrl()
     */
    private String thunderSasUrl;

    /**
     * 身份证归属地文件地址
     * getIdcardAreaPath()
     */
    private String idcardAreaPath;

    /**
     * api返回参数
     * getBackParams
     */
    private String backParams;

    /**
     * getActAddress()
     */
    private String actAddress;

    /**
     * getSmsAddress
     */
    private String smsAddress;

    /**
     * getSmsURL()
     */
    private String smsURL;

    /**
     * 获取异步线程池阻塞队列长度
     * getAsyncSaveWorkQueueSize()
     */
    private int asyncWorkQueueSize;

    /**
     * 获取异步线程池核心线程数
     * getAsyncSaveCorePoolSize()
     */
    private int asyncCorePoolSize;

    /**
     * 获取异步线程池最大线程数
     * getAsyncSaveMaximumPoolSize()
     */
    private int asyncMaximumPoolSize;

    /**
     * 获取异步线程池阻塞队列长度
     * getDecisionAsyncSaveWorkQueueSize()
     */
    private int decisionAsyncWorkQueueSize;

    /**
     * 获取异步线程池核心线程数
     * getDecisionAsyncSaveCorePoolSize()
     */
    private int decisionAsyncCorePoolSize;

    /**
     * 获取异步线程池最大线程数
     * getDecisionAsyncSaveMaximumPoolSize()
     */
    private int decisionAsyncMaximumPoolSize;

    /**
     * 获取AES 密钥
     * getAESPassWord()
     */
    private String AESPassWord;

    /**
     * IP地址
     */
    // todo delete
//    private String ipDatFile;

    private String IpDataFile;
    private String Ipv6DataFile;

    /**
     * api提交时间
     */
    private int producerPeriodTime;

    /**
     * 设备指纹http接口地址
     */
    private String didHttpAddress;

    /**
     * 是否使用rmi方式。
     * rmi方式
     * http方式
     */
    private String didMessageType;

    /**
     * zk连接地址
     */
    private String zooKeeperConnStr;

    /**
     * zk连接超时时间
     */
    private Integer zooKeeperSessionTimeout;

    /**
     * zk注册目录
     */
    private String zooKeeperRegistryPath;

    /**
     * rmi超时时间(毫秒)
     */
    private Integer rmiTcpResponseTimeout;

    /**
     * 获取场景缓存异步线程池阻塞队列长度
     * getAsyncSaveWorkQueueSize()
     */
    private int sceneCacheAsyncWorkQueueSize;

    /**
     * 获取场景缓存异步线程池核心线程数
     * getAsyncSaveCorePoolSize()
     */
    private int sceneCacheAsyncCorePoolSize;

    /**
     * 获取场景缓存异步线程池最大线程数
     * getAsyncSaveMaximumPoolSize()
     */
    private int sceneCacheAsyncMaximumPoolSize;

    /**
     * 接口调用线程池最大线程数
     */
    private int interfaceCallMaxPoolSize;

    /**
     * 接口调用线程池队列长度
     */
    private int interfaceCallQueueSize;

    /**
     * 知识图谱用到的场景——定制
     *
     * @return
     */
    private String knowledgeGraphCodes;

    /**
     * 地址解析公用部分字段——定制
     */
    private String commonKnowledgeFields;

    private String kafkaGroupId;

    private String kafkaTopic;

    private Boolean kafkaSecurityOpen;

    private String securityAuthLoginConfigFilePath;

    private String kafkaACKS;
    private String kafkaBatchSize;
    private String kafkaLingerMs;
    private String kafkaBufferMemory;
    private String kafkaBootstrapServers;

    private String kafkaConsumerGroupId;
    private String kafkaConumerEnableAutoCommit;
    private String kafkaConsumerAutoCommitIntervalMs;

    public int getSceneCacheAsyncWorkQueueSize() {
        return sceneCacheAsyncWorkQueueSize;
    }

    public void setSceneCacheAsyncWorkQueueSize(int sceneCacheAsyncWorkQueueSize) {
        this.sceneCacheAsyncWorkQueueSize = sceneCacheAsyncWorkQueueSize;
    }

    public int getSceneCacheAsyncCorePoolSize() {
        return sceneCacheAsyncCorePoolSize;
    }

    public void setSceneCacheAsyncCorePoolSize(int sceneCacheAsyncCorePoolSize) {
        this.sceneCacheAsyncCorePoolSize = sceneCacheAsyncCorePoolSize;
    }

    public int getSceneCacheAsyncMaximumPoolSize() {
        return sceneCacheAsyncMaximumPoolSize;
    }

    public void setSceneCacheAsyncMaximumPoolSize(int sceneCacheAsyncMaximumPoolSize) {
        this.sceneCacheAsyncMaximumPoolSize = sceneCacheAsyncMaximumPoolSize;
    }

    private Integer riskAPIUpdateAPIMaxInterval;//风控接口和更新接口的最大时间间隔 单位秒

    private String makeDecisionAsyncFile;

    public Integer getRiskAPIUpdateAPIMaxInterval() {
        return riskAPIUpdateAPIMaxInterval;
    }

    public void setRiskAPIUpdateAPIMaxInterval(Integer riskAPIUpdateAPIMaxInterval) {
        this.riskAPIUpdateAPIMaxInterval = riskAPIUpdateAPIMaxInterval;
    }

    public int getFactorCacheExpireSecond() {
        return factorCacheExpireSecond;
    }

    public void setFactorCacheExpireSecond(int factorCacheExpireSecond) {
        this.factorCacheExpireSecond = factorCacheExpireSecond;
    }

    public String getGeoipDBFilePath() {
        return geoipDBFilePath;
    }

    public void setGeoipDBFilePath(String geoipDBFilePath) {
        this.geoipDBFilePath = geoipDBFilePath;
    }

    public String getGeoipDBFilePathV2() {
        return geoipDBFilePathV2;
    }

    public void setGeoipDBFilePathV2(String geoipDBFilePathV2) {
        this.geoipDBFilePathV2 = geoipDBFilePathV2;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getUsernature() {
        return usernature;
    }

    public void setUsernature(String usernature) {
        this.usernature = usernature;
    }

    public String getGeoipLngLatFilePath() {
        return geoipLngLatFilePath;
    }

    public void setGeoipLngLatFilePath(String geoipLngLatFilePath) {
        this.geoipLngLatFilePath = geoipLngLatFilePath;
    }

    public String getGeoipLngLatFilePathV2() {
        return geoipLngLatFilePathV2;
    }

    public void setGeoipLngLatFilePathV2(String geoipLngLatFilePathV2) {
        this.geoipLngLatFilePathV2 = geoipLngLatFilePathV2;
    }

    public String getThunderSasUrl() {
        return thunderSasUrl;
    }

    public void setThunderSasUrl(String thunderSasUrl) {
        this.thunderSasUrl = thunderSasUrl;
    }

    public String getIdcardAreaPath() {
        return idcardAreaPath;
    }

    public void setIdcardAreaPath(String idcardAreaPath) {
        this.idcardAreaPath = idcardAreaPath;
    }

    public String getBackParams() {
        return backParams;
    }

    public void setBackParams(String backParams) {
        this.backParams = backParams;
    }

    public String getActAddress() {
        return actAddress;
    }

    public void setActAddress(String actAddress) {
        this.actAddress = actAddress;
    }

    public String getSmsAddress() {
        return smsAddress;
    }

    public void setSmsAddress(String smsAddress) {
        this.smsAddress = smsAddress;
    }

    public String getSmsURL() {
        return smsURL;
    }

    public void setSmsURL(String smsURL) {
        this.smsURL = smsURL;
    }

    public int getAsyncWorkQueueSize() {
        return asyncWorkQueueSize;
    }

    public void setAsyncWorkQueueSize(int asyncWorkQueueSize) {
        this.asyncWorkQueueSize = asyncWorkQueueSize;
    }

    public int getAsyncCorePoolSize() {
        return asyncCorePoolSize;
    }

    public void setAsyncCorePoolSize(int asyncCorePoolSize) {
        this.asyncCorePoolSize = asyncCorePoolSize;
    }

    public int getAsyncMaximumPoolSize() {
        return asyncMaximumPoolSize;
    }

    public void setAsyncMaximumPoolSize(int asyncMaximumPoolSize) {
        this.asyncMaximumPoolSize = asyncMaximumPoolSize;
    }

    public String getAESPassWord() {
        return AESPassWord;
    }

    public void setAESPassWord(String AESPassWord) {
        this.AESPassWord = AESPassWord;
    }

    // todo delete

  /*  public String getIpDatFile() {
        return ipDatFile;
    }

    public void setIpDatFile(String ipDatFile) {
        this.ipDatFile = ipDatFile;
    }*/

    public int getProducerPeriodTime() {
        return producerPeriodTime;
    }

    public void setProducerPeriodTime(int producerPeriodTime) {
        this.producerPeriodTime = producerPeriodTime;
    }

    public String getDidHttpAddress() {
        return didHttpAddress;
    }

    public void setDidHttpAddress(String didHttpAddress) {
        this.didHttpAddress = didHttpAddress;
    }

    public String getDidMessageType() {
        return didMessageType;
    }

    public void setDidMessageType(String didMessageType) {
        this.didMessageType = didMessageType;
    }

    public String getZooKeeperConnStr() {
        return zooKeeperConnStr;
    }

    public void setZooKeeperConnStr(String zooKeeperConnStr) {
        this.zooKeeperConnStr = zooKeeperConnStr;
    }

    public Integer getZooKeeperSessionTimeout() {
        return zooKeeperSessionTimeout;
    }

    public void setZooKeeperSessionTimeout(Integer zooKeeperSessionTimeout) {
        this.zooKeeperSessionTimeout = zooKeeperSessionTimeout;
    }

    public String getZooKeeperRegistryPath() {
        return zooKeeperRegistryPath;
    }

    public void setZooKeeperRegistryPath(String zooKeeperRegistryPath) {
        this.zooKeeperRegistryPath = zooKeeperRegistryPath;
    }

    public Integer getRmiTcpResponseTimeout() {
        return rmiTcpResponseTimeout;
    }

    public void setRmiTcpResponseTimeout(Integer rmiTcpResponseTimeout) {
        this.rmiTcpResponseTimeout = rmiTcpResponseTimeout;
    }

    public String getKafkaBootstrapServers() {
        return kafkaBootstrapServers;
    }

    public void setKafkaBootstrapServers(String kafkaBootstrapServers) {
        this.kafkaBootstrapServers = kafkaBootstrapServers;
    }

    public String getKafkaACKS() {
        return kafkaACKS;
    }

    public void setKafkaACKS(String kafkaACKS) {
        this.kafkaACKS = kafkaACKS;
    }

    public String getKafkaBatchSize() {
        return kafkaBatchSize;
    }

    public void setKafkaBatchSize(String kafkaBatchSize) {
        this.kafkaBatchSize = kafkaBatchSize;
    }

    public String getKafkaLingerMs() {
        return kafkaLingerMs;
    }

    public void setKafkaLingerMs(String kafkaLingerMs) {
        this.kafkaLingerMs = kafkaLingerMs;
    }

    public String getKafkaBufferMemory() {
        return kafkaBufferMemory;
    }

    public void setKafkaBufferMemory(String kafkaBufferMemory) {
        this.kafkaBufferMemory = kafkaBufferMemory;
    }

    public String getKafkaConsumerGroupId() {
        return kafkaConsumerGroupId;
    }

    public void setKafkaConsumerGroupId(String kafkaConsumerGroupId) {
        this.kafkaConsumerGroupId = kafkaConsumerGroupId;
    }

    public String getKafkaConumerEnableAutoCommit() {
        return kafkaConumerEnableAutoCommit;
    }

    public void setKafkaConumerEnableAutoCommit(String kafkaConumerEnableAutoCommit) {
        this.kafkaConumerEnableAutoCommit = kafkaConumerEnableAutoCommit;
    }

    public String getKafkaConsumerAutoCommitIntervalMs() {
        return kafkaConsumerAutoCommitIntervalMs;
    }

    public void setKafkaConsumerAutoCommitIntervalMs(String kafkaConsumerAutoCommitIntervalMs) {
        this.kafkaConsumerAutoCommitIntervalMs = kafkaConsumerAutoCommitIntervalMs;
    }

    public Boolean getKafkaSecurityOpen() {
        return kafkaSecurityOpen;
    }

    public void setKafkaSecurityOpen(Boolean kafkaSecurityOpen) {
        this.kafkaSecurityOpen = kafkaSecurityOpen;
    }

    public String getSecurityAuthLoginConfigFilePath() {
        return securityAuthLoginConfigFilePath;
    }

    public void setSecurityAuthLoginConfigFilePath(String securityAuthLoginConfigFilePath) {
        this.securityAuthLoginConfigFilePath = securityAuthLoginConfigFilePath;
    }

    public String getMakeDecisionAsyncFile() {
        return makeDecisionAsyncFile;
    }

    public void setMakeDecisionAsyncFile(String makeDecisionAsyncFile) {
        this.makeDecisionAsyncFile = makeDecisionAsyncFile;
    }

    public int getDecisionAsyncWorkQueueSize() {
        return decisionAsyncWorkQueueSize;
    }

    public void setDecisionAsyncWorkQueueSize(int decisionAsyncWorkQueueSize) {
        this.decisionAsyncWorkQueueSize = decisionAsyncWorkQueueSize;
    }

    public int getDecisionAsyncCorePoolSize() {
        return decisionAsyncCorePoolSize;
    }

    public void setDecisionAsyncCorePoolSize(int decisionAsyncCorePoolSize) {
        this.decisionAsyncCorePoolSize = decisionAsyncCorePoolSize;
    }

    public int getDecisionAsyncMaximumPoolSize() {
        return decisionAsyncMaximumPoolSize;
    }

    public void setDecisionAsyncMaximumPoolSize(int decisionAsyncMaximumPoolSize) {
        this.decisionAsyncMaximumPoolSize = decisionAsyncMaximumPoolSize;
    }

    public int getInterfaceCallMaxPoolSize() {
        return interfaceCallMaxPoolSize;
    }

    public void setInterfaceCallMaxPoolSize(int interfaceCallMaxPoolSize) {
        this.interfaceCallMaxPoolSize = interfaceCallMaxPoolSize;
    }

    public int getInterfaceCallQueueSize() {
        return interfaceCallQueueSize;
    }

    public void setInterfaceCallQueueSize(int interfaceCallQueueSize) {
        this.interfaceCallQueueSize = interfaceCallQueueSize;
    }

    public String getKnowledgeGraphCodes() {
        return knowledgeGraphCodes;
    }

    public void setKnowledgeGraphCodes(String knowledgeGraphCodes) {
        this.knowledgeGraphCodes = knowledgeGraphCodes;
    }

    public String getKafkaGroupId() {
        return kafkaGroupId;
    }

    public void setKafkaGroupId(String kafkaGroupId) {
        this.kafkaGroupId = kafkaGroupId;
    }

    public String getKafkaTopic() {
        return kafkaTopic;
    }

    public void setKafkaTopic(String kafkaTopic) {
        this.kafkaTopic = kafkaTopic;
    }

    public String getCommonKnowledgeFields() {
        return commonKnowledgeFields;
    }

    public void setCommonKnowledgeFields(String commonKnowledgeFields) {
        this.commonKnowledgeFields = commonKnowledgeFields;
    }

    public String getIpDataFile() {
        return IpDataFile;
    }

    public void setIpDataFile(String ipDataFile) {
        IpDataFile = ipDataFile;
    }

    public String getIpv6DataFile() {
        return Ipv6DataFile;
    }

    public void setIpv6DataFile(String ipv6DataFile) {
        Ipv6DataFile = ipv6DataFile;
    }

}
