package com.payegis.common;


import com.payegis.config.CommonCache;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shirley on 2016/10/28.
 */
public class MobileAttributeUtil {

	private static final Logger                       LOGGER             =
			LoggerFactory.getLogger(MobileAttributeUtil.class);
	private static       Map<String, MobileAttribute> mobileAttributeMap = new ConcurrentHashMap<>();

	private MobileAttributeUtil() {

	}

	static {
		// String path = ThunderConfig.getMobileAttributePath();
		String path = CommonCache.getCommonProperties().getMobileAttributePath();
		if (StringUtils.isNotEmpty(path)) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				reader.readLine();
				String line;
				while ((line = reader.readLine()) != null) {
					String[] data = line.split("\t");
					if (data.length == 5) {
						MobileAttribute attribute = new MobileAttribute();
						String prefix = makeRowKey(data[1]);
						attribute.setMobile(prefix);
						attribute.setProvince(handleProvince(data[3]));
						attribute.setCity(handleCity(data[4]));
						if (data[2].startsWith("移动")) {
							attribute.setOperator("中国移动");
						} else if (data[2].startsWith("电信")) {
							attribute.setOperator("中国电信");
						} else if (data[2].startsWith("联通")) {
							attribute.setOperator("中国联通");
						} else {
							attribute.setOperator("虚拟运营商");
						}
						mobileAttributeMap.put(attribute.getMobile(), attribute);
					}
				}

			} catch (IOException e) {
				throw new RuntimeException("读取手机号码归属地文件失败...");
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
					LOGGER.error("error : 关闭流失败!", e);
				}
			}
		} else {
			LOGGER.error("api配置文件未配置手机号码归属地文件路径...");
		}
	}

	private static String handleProvince(String province) {
		String result;
		if (province.equals("北京") || province.equals("上海") || province.equals("天津") || province.equals("重庆")) {
			result = province + "市";
		} else if (province.equals("新疆")) {
			result = "新疆维吾尔自治区";
		} else if (province.equals("广西")) {
			result = "广西壮族自治区";
		} else if (province.equals("宁夏")) {
			result = "宁夏回族自治区";
		} else if (province.equals("内蒙古") || province.equals("西藏")) {
			result = province + "自治区";
		} else {
			result = province + "省";
		}
		return result;
	}

	private static String handleCity(String city) {
		if (!city.endsWith("区") && !city.endsWith("自治州")) {
			return city + "市";
		}
		return city;
	}

	public static MobileAttributeUtil getInstance() {
		return MobileAttributeUtilSingleton.instance;
	}

	private static String makeRowKey(String key) {
		String prefix = EncryptUtil.encryptMD5Password(key).substring(0, 1).toLowerCase();
		return (prefix + "_" + key);
	}

	public MobileAttribute getMobileInfo(String mobile) {
		MobileAttribute mobileAttribute;
		String prefix = makeRowKey(mobile);
		long begein = System.currentTimeMillis();
		mobileAttribute = mobileAttributeMap.get(prefix);
		//LOGGER.info("查询手机号码归属地耗时: " + (System.currentTimeMillis() - begein));
		return mobileAttribute;
	}

	private static class MobileAttributeUtilSingleton {

		private static MobileAttributeUtil instance = new MobileAttributeUtil();
	}

}
