package com.payegis.common.knowledge;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobileUtil {

	private static final Logger logger     = LoggerFactory.getLogger(MobileUtil.class);

	private static final String XIAOHAO    = "小号";
	private static final String PINGTAI    = "平台";
	private static final String DIANSHANG  = "电商";
	private static final String HULIANWANG = "互联网";

	private static MobileUtil instance = new MobileUtil();
	//	private static final String dataServiceAppId  =
	//			ThunderConfig.getInstance().getString(ConfigConstant.DATASERIVCE_APPID);
	//	private static final String dataServiceAppKey =
	//			ThunderConfig.getInstance().getString(ConfigConstant.DATASERIVCE_APPKEY);
	//	private static final String blackListUrl      =
	//			ThunderConfig.getInstance().getString(ConfigConstant.MOBILE_BLACKLIST);
	//	private static final String statusUrl         = ThunderConfig.getInstance().getString(ConfigConstant.MOBILE_STATUS);
	//	private static final String innetUrl          = ThunderConfig.getInstance().getString(ConfigConstant.MOBILE_INNET);
	//	private static final String infoverifyUrl     =
	//			ThunderConfig.getInstance().getString(ConfigConstant.MOBILE_INFOVERIFY);
	//
	//	private static Cache<String, String[]> cache = null;

	//	private MobileUtil() {
	//		cache = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(10, TimeUnit.SECONDS).
	//				build();
	//	}

	public static MobileUtil getInstance() {
		return instance;
	}

	private String[] getBlacklistResult(String mobile) {
		//		String[] result = cache.getIfPresent(mobile);
		//		if (result != null) {
		//			return result;
		//		} else {
		//			Set<String> blacklistResult = MobileBlackLibUtil.getInstance().getMobileBlackType(mobile);
		//			logger.info("[MobileBlackList] " + mobile + " : {}", blacklistResult);
		//
		//			List<String> innerBlackListResult = new ArrayList<String>();
		//			if (blacklistResult != null && blacklistResult.size() > 0) {
		//				for (String blackList : blacklistResult) {
		//					if (StringUtils.contains(blackList, PINGTAI)) {
		//						innerBlackListResult.add(PINGTAI);
		//					} else if (StringUtils.contains(blackList, XIAOHAO)) {
		//						innerBlackListResult.add(XIAOHAO);
		//					} else if (StringUtils.contains(blackList, DIANSHANG)) {
		//						innerBlackListResult.add(DIANSHANG);
		//					} else if (StringUtils.contains(blackList, HULIANWANG)) {
		//						innerBlackListResult.add(HULIANWANG);
		//					}
		//				}
		//			}
		//			if (innerBlackListResult != null && innerBlackListResult.size() > 0) {
		//				result = innerBlackListResult.toArray(new String[innerBlackListResult.size()]);
		//				cache.put(mobile, result);
		//			}
		//			return result;

		//		}
		return new String[]{};
	}

	public Boolean isXiaohao(String mobile) {
		String[] result = getBlacklistResult(mobile);
		if (ArrayUtils.contains(result, XIAOHAO)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isJiema(String mobile) {
		String[] result = getBlacklistResult(mobile);
		if (ArrayUtils.contains(result, PINGTAI)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isDianshang(String mobile) {
		String[] result = getBlacklistResult(mobile);
		if (ArrayUtils.contains(result, DIANSHANG)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isHulianwang(String mobile) {
		String[] result = getBlacklistResult(mobile);
		if (ArrayUtils.contains(result, HULIANWANG)) {
			return true;
		} else {
			return false;
		}
	}

	public String getStatus(String mobile) throws Exception {
		String status = "";
		//		Map<String, String> param = new HashMap<String, String>();
		//
		//		param.put("mobile", mobile);
		//		JSONObject statusJsonObject =
		//				HttpConnectionUtil.post(param, dataServiceAppId, dataServiceAppKey, statusUrl, 500);
		//
		//		JSONObject content = statusJsonObject.getJSONObject("result");
		//		String statCode = content.getString("statCode");
		//
		//		if (statCode.equals("1511")) {
		//			status = "1511"; // "停机";
		//		} else if (statCode.equals("1512")) {
		//			status = "1512"; // "在网不可用";
		//		} else if (statCode.equals("1513")) {
		//			status = "1513"; // "销号/未启用";
		//		} else if (statCode.equals("1510")) {
		//			status = "1510"; // "正常在网";
		//		}
		return status;
	}

	public String getInnet(String mobile) throws Exception {
		String innet = "";
		//		Map<String, String> param = new HashMap<String, String>();
		//
		//		param.put("mobile", mobile);
		//		JSONObject statusJsonObject =
		//				HttpConnectionUtil.post(param, dataServiceAppId, dataServiceAppKey, innetUrl, 500);
		//
		//		JSONObject content = statusJsonObject.getJSONObject("result");
		//		String state = content.optString("state");
		//		if ("A".equals(state)) {
		//			innet = "A";
		//		} else if ("B".equals(state) || "C".equals(state)) {
		//			innet = "B";
		//		} else if ("D".equals(state) || "E".equals(state)) {
		//			innet = "C";
		//		}
		return innet;
	}

	public Boolean getInfoverify(String mobile, String name, String idcard) throws Exception {
		Boolean pass = false;
		//		Map<String, String> param = new HashMap<String, String>();
		//		param.put("mobile", mobile);
		//		param.put("name", name);
		//		param.put("idNo", idcard);
		//		JSONObject statusJsonObject =
		//				HttpConnectionUtil.post(param, dataServiceAppId, dataServiceAppKey, infoverifyUrl, 500);
		//		JSONObject content = statusJsonObject.getJSONObject("result");
		//		String statCode = content.getString("statCode");
		//		if ("1500".equals(statCode)) {
		//			pass = true;
		//		} else {
		//			pass = false;
		//		}
		//		logger.info(content.toString());
		return pass;
	}

}
