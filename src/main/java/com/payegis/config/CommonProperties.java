package com.payegis.config;

/**
 * 描述: 连接coomn使用参数
 * 创建: zhishang.wang
 * 时间: 2018-06-13 11:06
 **/
public class CommonProperties {

    /**
     * 固定电话归属地文件地址
     * getTelephoneAttributePath()
     */
    private String phoneAttributePath;

    /**
     * 手机号归属地文件地址
     * getMobileAttributePath()
     */
    private String mobileAttributePath;
    /**
     * getBaiduUrl()
     */
    private String baiduUrl;
    /**
     * getBaiduAk()
     */
    private String baiduAk;
    /**
     * getGeocoderUrl()
     */
    private String geocoderUrl;
    /**
     * 国家源文件地址
     * getCountryArea()
     */
    private String countryArea;
    /**
     * 国家源文件地址
     * getForeignInfo()
     */
    private String foreignInfo;

    /**
     * 加密文件
     */
    private String thunderEncryption;

    /**
     * 关系图谱节点默认返回个数
     */
    private Integer analysisNodeCount;

    /**
     * 异步风控回调地址配置文件地址
     */
    private String makeDecisionAsyncFilePath;

    /**
     * 异步推送数据请求头信息
     */
    private String asyncNotifyHeaders;

    private String asyncNotifyExchangeField;

    /**
     * 调用blaze配置
     */
    private String blazeCallCustomerStock;

    /**
     * 车牌号解析地址
     *
     * @return
     */
    private String plateNumberFilePath;

    public String getPlateNumberFilePath() {
        return plateNumberFilePath;
    }

    public void setPlateNumberFilePath(String plateNumberFilePath) {
        this.plateNumberFilePath = plateNumberFilePath;
    }

    public String getMakeDecisionAsyncFilePath() {
        return makeDecisionAsyncFilePath;
    }

    public void setMakeDecisionAsyncFilePath(String makeDecisionAsyncFilePath) {
        this.makeDecisionAsyncFilePath = makeDecisionAsyncFilePath;
    }

    public String getThunderEncryption() {
        return thunderEncryption;
    }

    public void setThunderEncryption(String thunderEncryption) {
        this.thunderEncryption = thunderEncryption;
    }

    public String getMobileAttributePath() {
        return mobileAttributePath;
    }

    public void setMobileAttributePath(String mobileAttributePath) {
        this.mobileAttributePath = mobileAttributePath;
    }

    public String getBaiduUrl() {
        return baiduUrl;
    }

    public void setBaiduUrl(String baiduUrl) {
        this.baiduUrl = baiduUrl;
    }

    public String getBaiduAk() {
        return baiduAk;
    }

    public void setBaiduAk(String baiduAk) {
        this.baiduAk = baiduAk;
    }

    public String getGeocoderUrl() {
        return geocoderUrl;
    }

    public void setGeocoderUrl(String geocoderUrl) {
        this.geocoderUrl = geocoderUrl;
    }

    public String getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(String countryArea) {
        this.countryArea = countryArea;
    }

    public String getForeignInfo() {
        return foreignInfo;
    }

    public void setForeignInfo(String foreignInfo) {
        this.foreignInfo = foreignInfo;
    }

    public String getPhoneAttributePath() {
        return phoneAttributePath;
    }

    public void setPhoneAttributePath(String phoneAttributePath) {
        this.phoneAttributePath = phoneAttributePath;
    }

    public Integer getAnalysisNodeCount() {
        return analysisNodeCount;
    }

    public void setAnalysisNodeCount(Integer analysisNodeCount) {
        this.analysisNodeCount = analysisNodeCount;
    }

    public String getAsyncNotifyHeaders() {
        return asyncNotifyHeaders;
    }

    public void setAsyncNotifyHeaders(String asyncNotifyHeaders) {
        this.asyncNotifyHeaders = asyncNotifyHeaders;
    }

    public String getAsyncNotifyExchangeField() {
        return asyncNotifyExchangeField;
    }

    public void setAsyncNotifyExchangeField(String asyncNotifyExchangeField) {
        this.asyncNotifyExchangeField = asyncNotifyExchangeField;
    }

    public String getBlazeCallCustomerStock() {
        return blazeCallCustomerStock;
    }

    public void setBlazeCallCustomerStock(String blazeCallCustomerStock) {
        this.blazeCallCustomerStock = blazeCallCustomerStock;
    }

}
