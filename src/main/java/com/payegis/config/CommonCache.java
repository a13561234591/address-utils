package com.payegis.config;

/**
 * 描述: common缓存
 * 创建: zhishang.wang
 * 时间: 2018-06-13 11:10
 **/
public class CommonCache {

	private static CommonProperties commonProperties;

	public static CommonProperties getCommonProperties() {
		return CommonCache.commonProperties;

	}

	public static void setCommonProperties(CommonProperties commonProperties) {
		CommonCache.commonProperties = commonProperties;
	}
}
