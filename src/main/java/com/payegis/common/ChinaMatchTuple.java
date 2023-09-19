package com.payegis.common;



import com.payegis.config.CommonCache;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.Map.Entry;

@Data
public class ChinaMatchTuple {

	private static      ChinaMatchTuple           addressComp  = null;
	private             List<Map<String, String>> areaCodeInfo = new ArrayList<Map<String, String>>();
	private             int                       areaCodeInfoSize;
	public static final String                    china        = "中国";
	private             List<String>              city_old     = null;
	private             List<String>              city_new     = null;
	private             List<String>              area_old     = null;
	private             List<String>              area_new     = null;

	public synchronized static ChinaMatchTuple getInstance() {
		if (addressComp == null) {
			addressComp = new ChinaMatchTuple();
		}
		return addressComp;
	}

	public ChinaMatchTuple() {
		areaCodeInfo = AreaCode.getInstance().readCode(CommonCache.getCommonProperties().getCountryArea());
		areaCodeInfoSize = areaCodeInfo.size();

		city_old =
				Arrays.asList("\u65E5\u5580\u5219\u5730\u533A", "\u6797\u829D\u5730\u533A", "\u660C\u90FD\u5730\u533A",
							  "\u5410\u9C81\u756A\u5730\u533A", "\u5C71\u5357\u5730\u533A", "\u54C8\u5BC6\u5730\u533A",
							  "\u94DC\u4EC1\u5730\u533A", "\u6BD5\u8282\u5730\u533A", "\u6D77\u4E1C\u5730\u533A",
							  "\u9976\u5E73\u533A");
		city_new = Arrays.asList("\u65E5\u5580\u5219\u5E02", "\u6797\u829D\u5E02", "\u660C\u90FD\u5E02",
								 "\u5410\u9C81\u756A\u5E02", "\u5C71\u5357\u5E02", "\u54C8\u5BC6\u5E02",
								 "\u94DC\u4EC1\u5E02", "\u6BD5\u8282\u5E02", "\u6D77\u4E1C\u5E02",
								 "\u9976\u5E73\u53BF");
		area_old = Arrays.asList("\u5C71\u4E1C\u7701_\u4E1C\u8425\u5E02_\u57A6\u5229\u53BF",
								 "\u5C71\u4E1C\u7701_\u6D4E\u5B81\u5E02_\u5156\u5DDE\u5E02",
								 "\u5C71\u4E1C\u7701_\u83CF\u6CFD\u5E02_\u5B9A\u9676\u53BF",
								 "\u5C71\u4E1C\u7701_\u6EE8\u5DDE\u5E02_\u6CBE\u5316\u53BF",
								 "\u5C71\u4E1C\u7701_\u5A01\u6D77\u5E02_\u6587\u767B\u5E02",
								 "\u6C5F\u82CF\u7701_\u5E38\u5DDE\u5E02_\u91D1\u575B\u5E02",
								 "\u6C5F\u82CF\u7701_\u8FDE\u4E91\u6E2F\u5E02_\u8D63\u6986\u53BF",
								 "\u6C5F\u82CF\u7701_\u626C\u5DDE\u5E02_\u6C5F\u90FD\u5E02",
								 "\u6C5F\u82CF\u7701_\u5357\u4EAC\u5E02_\u9AD8\u6DF3\u53BF",
								 "\u6C5F\u82CF\u7701_\u5357\u4EAC\u5E02_\u6EA7\u6C34\u53BF",
								 "\u6C5F\u82CF\u7701_\u6DEE\u5B89\u5E02_\u6D2A\u6CFD\u53BF",
								 "\u6C5F\u82CF\u7701_\u76D0\u57CE\u5E02_\u5927\u4E30\u5E02",
								 "\u6C5F\u82CF\u7701_\u5F90\u5DDE\u5E02_\u94DC\u5C71\u53BF",
								 "\u6C5F\u82CF\u7701_\u82CF\u5DDE\u5E02_\u5434\u6C5F\u5E02",
								 "\u6C5F\u82CF\u7701_\u6CF0\u5DDE\u5E02_\u59DC\u5830\u5E02",
								 "\u6C5F\u82CF\u7701_\u5357\u901A\u5E02_\u901A\u5DDE\u5E02",
								 "\u4E91\u5357\u7701_\u7389\u6EAA\u5E02_\u6C5F\u5DDD\u53BF",
								 "\u4E91\u5357\u7701_\u66F2\u9756\u5E02_\u6CBE\u76CA\u53BF",
								 "\u4E91\u5357\u7701_\u6587\u5C71\u58EE\u65CF\u82D7\u65CF\u81EA\u6CBB\u5DDE_\u6587\u5C71\u53BF",
								 "\u4E91\u5357\u7701_\u4FDD\u5C71\u5E02_\u817E\u51B2\u53BF",
								 "\u4E91\u5357\u7701_\u8FEA\u5E86\u85CF\u65CF\u81EA\u6CBB\u5DDE_\u9999\u683C\u91CC\u62C9\u53BF",
								 "\u4E91\u5357\u7701_\u6606\u660E\u5E02_\u5448\u8D21\u53BF",
								 "\u4E91\u5357\u7701_\u7EA2\u6CB3\u54C8\u5C3C\u65CF\u5F5D\u65CF\u81EA\u6CBB\u5DDE_\u5F25\u52D2\u53BF",
								 "\u4E91\u5357\u7701_\u7EA2\u6CB3\u54C8\u5C3C\u65CF\u5F5D\u65CF\u81EA\u6CBB\u5DDE_\u8499\u81EA\u53BF",
								 "\u4E91\u5357\u7701_\u6012\u6C5F\u5088\u50F3\u65CF\u81EA\u6CBB\u5DDE_\u6CF8\u6C34\u53BF",
								 "\u9655\u897F\u7701_\u5EF6\u5B89\u5E02_\u5B89\u585E\u53BF",
								 "\u9655\u897F\u7701_\u897F\u5B89\u5E02_\u9AD8\u9675\u53BF",
								 "\u9655\u897F\u7701_\u6986\u6797\u5E02_\u6A2A\u5C71\u53BF",
								 "\u5E7F\u897F\u58EE\u65CF\u81EA\u6CBB\u533A_\u767E\u8272\u5E02_\u9756\u897F\u53BF",
								 "\u5E7F\u897F\u58EE\u65CF\u81EA\u6CBB\u533A_\u67F3\u5DDE\u5E02_\u67F3\u6C5F\u53BF",
								 "\u5E7F\u897F\u58EE\u65CF\u81EA\u6CBB\u533A_\u5357\u5B81\u5E02_\u6B66\u9E23\u53BF",
								 "\u5E7F\u897F\u58EE\u65CF\u81EA\u6CBB\u533A_\u6842\u6797\u5E02_\u4E34\u6842\u53BF",
								 "\u9ED1\u9F99\u6C5F\u7701_\u4F73\u6728\u65AF\u5E02_\u629A\u8FDC\u53BF",
								 "\u9ED1\u9F99\u6C5F\u7701_\u54C8\u5C14\u6EE8\u5E02_\u53CC\u57CE\u5E02",
								 "\u9ED1\u9F99\u6C5F\u7701_\u7261\u4E39\u6C5F\u5E02_\u4E1C\u5B81\u53BF",
								 "\u6C5F\u897F\u7701_\u8D63\u5DDE\u5E02_\u5357\u5EB7\u5E02",
								 "\u6C5F\u897F\u7701_\u4E0A\u9976\u5E02_\u5E7F\u4E30\u53BF",
								 "\u6C5F\u897F\u7701_\u4E5D\u6C5F\u5E02_\u5E90\u5C71\u533A",
								 "\u6C5F\u897F\u7701_\u5357\u660C\u5E02_\u65B0\u5EFA\u53BF",
								 "\u6D59\u6C5F\u7701_\u6E29\u5DDE\u5E02_\u6D1E\u5934\u53BF",
								 "\u6D59\u6C5F\u7701_\u676D\u5DDE\u5E02_\u5BCC\u9633\u5E02",
								 "\u6D59\u6C5F\u7701_\u7ECD\u5174\u5E02_\u4E0A\u865E\u5E02",
								 "\u897F\u85CF\u81EA\u6CBB\u533A_\u62C9\u8428\u5E02_\u5806\u9F99\u5FB7\u5E86\u53BF",
								 "\u9752\u6D77\u7701_\u7389\u6811\u85CF\u65CF\u81EA\u6CBB\u5DDE_\u7389\u6811\u53BF",
								 "\u9752\u6D77\u7701_\u6D77\u4E1C\u5E02_\u5E73\u5B89\u53BF",
								 "\u56DB\u5DDD\u7701_\u7709\u5C71\u5E02_\u5F6D\u5C71\u53BF",
								 "\u56DB\u5DDD\u7701_\u5B9C\u5BBE\u5E02_\u5357\u6EAA\u53BF",
								 "\u56DB\u5DDD\u7701_\u96C5\u5B89\u5E02_\u540D\u5C71\u53BF",
								 "\u56DB\u5DDD\u7701_\u963F\u575D\u85CF\u65CF\u7F8C\u65CF\u81EA\u6CBB\u5DDE_\u9A6C\u5C14\u5EB7\u53BF",
								 "\u56DB\u5DDD\u7701_\u7518\u5B5C\u85CF\u65CF\u81EA\u6CBB\u5DDE_\u5EB7\u5B9A\u53BF",
								 "\u56DB\u5DDD\u7701_\u6210\u90FD\u5E02_\u53CC\u6D41\u53BF",
								 "\u8FBD\u5B81\u7701_\u76D8\u9526\u5E02_\u5927\u6D3C\u53BF",
								 "\u8FBD\u5B81\u7701_\u6C88\u9633\u5E02_\u8FBD\u4E2D\u53BF",
								 "\u8FBD\u5B81\u7701_\u5927\u8FDE\u5E02_\u666E\u5170\u5E97\u5E02",
								 "\u6E56\u5357\u7701_\u957F\u6C99\u5E02_\u671B\u57CE\u53BF",
								 "\u5409\u6797\u7701_\u677E\u539F\u5E02_\u6276\u4F59\u53BF",
								 "\u5409\u6797\u7701_\u957F\u6625\u5E02_\u4E5D\u53F0\u5E02",
								 "\u8D35\u5DDE\u7701_\u5B89\u987A\u5E02_\u5E73\u575D\u53BF",
								 "\u5E7F\u4E1C\u7701_\u5E7F\u5DDE\u5E02_\u589E\u57CE\u5E02",
								 "\u5E7F\u4E1C\u7701_\u5E7F\u5DDE\u5E02_\u4ECE\u5316\u5E02",
								 "\u5E7F\u4E1C\u7701_\u9633\u6C5F\u5E02_\u9633\u4E1C\u53BF",
								 "\u5E7F\u4E1C\u7701_\u6E05\u8FDC\u5E02_\u6E05\u65B0\u53BF",
								 "\u5E7F\u4E1C\u7701_\u8087\u5E86\u5E02_\u9AD8\u8981\u5E02",
								 "\u5E7F\u4E1C\u7701_\u8302\u540D\u5E02_\u7535\u767D\u53BF",
								 "\u5E7F\u4E1C\u7701_\u4E91\u6D6E\u5E02_\u4E91\u5B89\u53BF",
								 "\u5E7F\u4E1C\u7701_\u63ED\u9633\u5E02_\u63ED\u4E1C\u53BF",
								 "\u5E7F\u4E1C\u7701_\u6F6E\u5DDE\u5E02_\u6F6E\u5B89\u53BF",
								 "\u798F\u5EFA\u7701_\u9F99\u5CA9\u5E02_\u6C38\u5B9A\u53BF",
								 "\u798F\u5EFA\u7701_\u5357\u5E73\u5E02_\u5EFA\u9633\u5E02",
								 "\u6CB3\u5317\u7701_\u5F20\u5BB6\u53E3\u5E02_\u5BA3\u5316\u53BF",
								 "\u6CB3\u5317\u7701_\u5F20\u5BB6\u53E3\u5E02_\u4E07\u5168\u53BF",
								 "\u6CB3\u5317\u7701_\u5F20\u5BB6\u53E3\u5E02_\u5D07\u793C\u53BF",
								 "\u6CB3\u5317\u7701_\u77F3\u5BB6\u5E84\u5E02_\u85C1\u57CE\u5E02",
								 "\u6CB3\u5317\u7701_\u77F3\u5BB6\u5E84\u5E02_\u9E7F\u6CC9\u5E02",
								 "\u6CB3\u5317\u7701_\u77F3\u5BB6\u5E84\u5E02_\u683E\u57CE\u53BF",
								 "\u6CB3\u5317\u7701_\u4FDD\u5B9A\u5E02_\u5F90\u6C34\u53BF",
								 "\u6CB3\u5317\u7701_\u4FDD\u5B9A\u5E02_\u6EE1\u57CE\u53BF",
								 "\u6CB3\u5317\u7701_\u4FDD\u5B9A\u5E02_\u6E05\u82D1\u53BF",
								 "\u6CB3\u5317\u7701_\u8861\u6C34\u5E02_\u5180\u5DDE\u5E02",
								 "\u6CB3\u5317\u7701_\u79E6\u7687\u5C9B\u5E02_\u629A\u5B81\u53BF");
		area_new = Arrays.asList("\u57A6\u5229\u533A", "\u5156\u5DDE\u533A", "\u5B9A\u9676\u533A", "\u6CBE\u5316\u533A",
								 "\u6587\u767B\u533A", "\u91D1\u575B\u533A", "\u8D63\u6986\u533A", "\u6C5F\u90FD\u533A",
								 "\u9AD8\u6DF3\u533A", "\u6EA7\u6C34\u533A", "\u6D2A\u6CFD\u533A", "\u5927\u4E30\u533A",
								 "\u94DC\u5C71\u533A", "\u5434\u6C5F\u533A", "\u59DC\u5830\u533A", "\u901A\u5DDE\u533A",
								 "\u6C5F\u5DDD\u533A", "\u6CBE\u76CA\u533A", "\u6587\u5C71\u5E02", "\u817E\u51B2\u5E02",
								 "\u9999\u683C\u91CC\u62C9\u5E02", "\u5448\u8D21\u533A", "\u5F25\u52D2\u5E02",
								 "\u8499\u81EA\u5E02", "\u6CF8\u6C34\u5E02", "\u5B89\u585E\u533A", "\u9AD8\u9675\u533A",
								 "\u6A2A\u5C71\u533A", "\u9756\u897F\u5E02", "\u67F3\u6C5F\u533A", "\u6B66\u9E23\u533A",
								 "\u4E34\u6842\u533A", "\u629A\u8FDC\u5E02", "\u53CC\u57CE\u533A", "\u4E1C\u5B81\u5E02",
								 "\u5357\u5EB7\u533A", "\u5E7F\u4E30\u533A", "\u5E90\u5C71\u5E02", "\u65B0\u5EFA\u533A",
								 "\u6D1E\u5934\u533A", "\u5BCC\u9633\u533A", "\u4E0A\u865E\u533A",
								 "\u5806\u9F99\u5FB7\u5E86\u533A", "\u7389\u6811\u5E02", "\u5E73\u5B89\u533A",
								 "\u5F6D\u5C71\u533A", "\u5357\u6EAA\u533A", "\u540D\u5C71\u533A",
								 "\u9A6C\u5C14\u5EB7\u5E02", "\u5EB7\u5B9A\u5E02", "\u53CC\u6D41\u533A",
								 "\u5927\u6D3C\u533A", "\u8FBD\u4E2D\u533A", "\u666E\u5170\u5E97\u533A",
								 "\u671B\u57CE\u533A", "\u6276\u4F59\u5E02", "\u4E5D\u53F0\u533A", "\u5E73\u575D\u533A",
								 "\u589E\u57CE\u533A", "\u4ECE\u5316\u533A", "\u9633\u4E1C\u533A", "\u6E05\u65B0\u533A",
								 "\u9AD8\u8981\u533A", "\u7535\u767D\u533A", "\u4E91\u5B89\u533A", "\u63ED\u4E1C\u533A",
								 "\u6F6E\u5B89\u533A", "\u6C38\u5B9A\u533A", "\u5EFA\u9633\u533A", "\u5BA3\u5316\u533A",
								 "\u4E07\u5168\u533A", "\u5D07\u793C\u533A", "\u85C1\u57CE\u533A", "\u9E7F\u6CC9\u533A",
								 "\u683E\u57CE\u533A", "\u5F90\u6C34\u533A", "\u6EE1\u57CE\u533A", "\u6E05\u82D1\u533A",
								 "\u5180\u5DDE\u533A", "\u629A\u5B81\u533A");
	}

	public Tuple<String, Integer> limitedAutoStateMachine(String addr, String mstring) {
		if (mstring == null || mstring.equals("null")) {
			return null;
		}
		if (mstring.equals("海南藏族自治州") && !addr.contains("海南藏族")) {
			return null;
		}
		if (mstring.equals("吉林市") && !addr.contains("吉林市")) {
			return null;
		}
		if (mstring.equals("自治区直辖县级行政区划")) {
			return null;
		}
		if (mstring.equals("龙江县") && addr.contains("黑龙江")) {
			String aString = addr.replace("黑龙江", "");
			if (!aString.contains("龙江")) {
				return null;
			}
		}
		if (mstring.equals("朝阳市") && addr.contains("朝阳区") && !addr.contains("朝阳市")) {        //辽宁省朝阳市，××市朝阳区
			return null;
		}
		if (mstring.equals("乌鲁木齐县") && addr.contains("乌鲁木齐市") && !addr.contains("乌鲁木齐县")) {    //乌鲁木齐市
			return null;
		}

		Tuple<String, Integer> hashMap = null;
		int index;

		for (int i = mstring.length(); i >= 2; i--) {
			String suffix = mstring.substring(0, i);
			if ((index = addr.indexOf(suffix)) > -1) {
				if ((suffix.equals("津市") && addr.contains("天津市")) || suffix.equals("张家")) {
					continue;
				}

                if (addr.indexOf(suffix + "街") > -1 || addr.indexOf(suffix + "路") > -1) {
                    continue;
                }

				hashMap = new Tuple<>(suffix, index);
				// hashMap.put(suffix, index);
				break;
			}
		}
		return hashMap;
	}

	//	public Integer getValueFromHashMap(HashMap<String, Integer> hashMap) {
	//		Integer integer = -1;
	//		Set<String> set = hashMap.keySet();
	//		for (String s : set) {
	//			integer = hashMap.get(s);
	//			break;
	//		}
	//		return integer;
	//	}

	public String getKeyFromHashMap(HashMap<String, Integer> hashMap) {
		String string = "";
		Set<String> set = hashMap.keySet();
		for (String s : set) {
			string = s;
			break;
		}
		return string;
	}

	//map按照键值的键值(Integer)从小到大排序,若键值一样，则按照key的长度从大到小排序
	public List<Entry<Map<String, String>, Tuple<String, Integer>>> mapSort(
			HashMap<Map<String, String>, Tuple<String, Integer>> stack, String key, String addr) {
		List<Entry<Map<String, String>, Tuple<String, Integer>>> sList = new ArrayList<>(stack.entrySet());

		Collections.sort(sList, new Comparator<Entry<Map<String, String>, Tuple<String, Integer>>>() {

			public int compare(Entry<Map<String, String>, Tuple<String, Integer>> o1,
					Entry<Map<String, String>, Tuple<String, Integer>> o2) {
				if (o1.getValue().getRight() != o2.getValue().getRight()) {
					return (o1.getValue().getRight().compareTo(o2.getValue().getRight()));
				} else {
					return Integer.compare(o1.getValue().getLeft().length(), o2.getValue().getLeft().length());
				}
			}
		});

		String scity = "";
		String sarea = "";
		if (sList.size() > 0) {
			scity = sList.get(0).getKey().get("city");
			sarea = sList.get(0).getKey().get("area");
		}

		if (sList.size() > 1 && scity.length() > 0 && sarea.length() > 0 &&
				!scity.substring(0, scity.length() - 1).equals(sarea.substring(0, sarea.length() - 1))) {
			if (sList.get(0).getValue().getRight() == sList.get(1).getValue().getRight() &&
					sList.get(0).getValue().getLeft().length() > sList.get(1).getValue().getLeft().length()) {
				return sList.subList(0, 1);
			}
			if (sList.get(0).getValue().getRight() < sList.get(1).getValue().getRight() &&
					sList.get(0).getValue().getLeft().length() > sList.get(1).getValue().getLeft().length()) {
				return sList.subList(0, 1);
			}
			if (key.equals("area") && sarea.length() > 0 && addr.contains(sarea) &&
					addr.contains(sList.get(1).getKey().get("area")) &&
					scity.equals(sList.get(1).getKey().get("city")) &&
					sList.get(0).getKey().get("province").equals(sList.get(1).getKey().get("province"))) {
				return sList.subList(0, 1);
			}
		}
		return sList;
	}

	//一级匹配：根据给定的key进行区/市/省匹配, 匹配结果按照匹配字符的起始位置正序排列,起始位置一样，则按照长度进行排序
	//key: area,city,province
	public List<Entry<Map<String, String>, Tuple<String, Integer>>> match_firstLevel(String addr, String key) {
		Tuple<String, Integer> hashMap = null;
		HashMap<Map<String, String>, Tuple<String, Integer>> stack = new HashMap<>();

		for (int i = 0; i < areaCodeInfoSize; i++) {
			Map<String, String> map = areaCodeInfo.get(i);
			String mString = map.get(key);

			hashMap = limitedAutoStateMachine(addr, mString);
			//匹配区的时候，如果市县同名且匹配到区名称完全一致，否则会把市当做区给匹配了，如中国河南省安阳市郊区
			if (key.equals("area") && map.get("city").replace("市", "").equals(map.get("area").replace("县", ""))) {
				if (!addr.contains(mString)) {
					continue;
				}
			}

			if (hashMap != null) {
				//				stack.put(jsonObject, hashMap);
				stack.put(map, hashMap);
			}

		}

		return mapSort(stack, key, addr);
	}

	//二级匹配：在一级匹配的基础上，根据给定的key进行再匹配
	public List<Entry<Map<String, String>, Tuple<String, Integer>>> match_secondLevel(String addr, String key,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> firstStack) throws Exception {
		HashMap<Map<String, String>, Tuple<String, Integer>> stack =
				new HashMap<Map<String, String>, Tuple<String, Integer>>();

      /*  for (Entry<Map<String, String>, Tuple<String, Integer>> entry : firstStack) {
            //JSONObject jsonObject = DeepCopy.copy(entry.getKey());
            Map<String, String> map =new HashMap<>();
            map.putAll(entry.getKey());
//            DeepCopy.copy(entry.getKey());

            Tuple<String, Integer> hashMap = entry.getValue();
            String match_string = hashMap.getLeft();
            Integer match_start = hashMap.getRight();

            String subAddr1 = addr.substring(0, match_start);
            //String subAddr2 = addr.substring(match_start + match_string.length());
            String subAddr2 = match_string + " " + addr.substring(match_start + match_string.length());

            Tuple<String, Integer> match_map = LimitedAutoStateMachine(subAddr1, map.get(key));
            if (match_map != null) {
                map.put("subAddr1", subAddr1);
                map.put("subAddr2", subAddr2);
                stack.put(map, match_map);
            }
        }*/

		for (int i = 0, size = firstStack.size(); i < size; i++) {
			//JSONObject jsonObject = DeepCopy.copy(entry.getKey());
			Entry<Map<String, String>, Tuple<String, Integer>> entry = firstStack.get(i);
			Map<String, String> map = new HashMap<>();

			map.putAll(entry.getKey());
			//            DeepCopy.copy(entry.getKey());

			Tuple<String, Integer> hashMap = entry.getValue();
			String match_string = hashMap.getLeft();
			Integer match_start = hashMap.getRight();

			String subAddr1 = addr.substring(0, match_start);
			//String subAddr2 = addr.substring(match_start + match_string.length());
			String subAddr2 = match_string + " " + addr.substring(match_start + match_string.length());

			Tuple<String, Integer> match_map = limitedAutoStateMachine(subAddr1, map.get(key));
			if (match_map != null) {
				map.put("subAddr1", subAddr1);
				map.put("subAddr2", subAddr2);
				stack.put(map, match_map);
			}
		}

		return mapSort(stack, key, addr);
	}

	//获取最优匹配信息（首项）
	public Map<String, String> getMatchInfo(List<Entry<Map<String, String>, Tuple<String, Integer>>> sList) {
		Map<String, String> map = new HashMap<String, String>();
		Entry<Map<String, String>, Tuple<String, Integer>> entry = sList.get(0);
		Map<String, String> oriInfo = entry.getKey();
		Tuple<String, Integer> hashMap = entry.getValue();

		String match_string = hashMap.getLeft();
		Integer match_start = hashMap.getRight();

		map.put("match_string", match_string);
		map.put("match_len", Integer.toString(match_string.length()));
		map.put("match_start", Integer.toString(match_start));
		map.put("match_area", oriInfo.get("area"));
		map.put("match_city", oriInfo.get("city"));
		map.put("match_province", oriInfo.get("province"));
		return map;
	}

	//将匹配到的信息加至原地址中，返回补全地址
	public Map<String, String> getAddress(String addr, List<Entry<Map<String, String>, Tuple<String, Integer>>> sList,
			int flag) {
		String resultAddr = "";
		String fullAddr = "";
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("country", "");
		resultMap.put("province", "");
		resultMap.put("city", "");
		resultMap.put("area", "");
		resultMap.put("addr", "");
		resultMap.put("fullAddr", fullAddr);

		String splitStr = "";
		Map<String, String> map = sList.get(0).getKey();

		if (map.containsKey("subAddr1") && !map.get("subAddr2").trim().equals(map.get("area"))) {
			splitStr = map.get("subAddr1");
			String[] subsplit = map.get("subAddr2").split(" ");
			resultAddr = subsplit[subsplit.length - 1];
		} else {
			splitStr = addr;
		}

		Map<String, String> matchInfo = getMatchInfo(sList);
		String string = splitStr.substring(
				Integer.parseInt(matchInfo.get("match_start")) + Integer.parseInt(matchInfo.get("match_len"))).trim();

		if (string.equals(map.get("area"))) {
			string = "";
		}
		if (map.get("city").equals("市辖区") && string.equals(map.get("province"))) {
			string = "";
		}

		switch (flag) {
			case 1:
				fullAddr = new StringBuilder(china).append(" ")
												   .append(map.get("province"))
												   .append(" ")
												   .append(string)
												   .append(" ")
												   .append(resultAddr)
												   .toString();
				fullAddr = fullAddr.replace("null", "").trim();
				resultMap.put("foreign", "false");
				resultMap.put("country", china);
				resultMap.put("province", map.get("province"));
				resultMap.put("addr", (string + " " + resultAddr).trim());
				resultMap.put("fullAddr", fullAddr);
				break;
			case 2:
				fullAddr = new StringBuilder(china).append(" ")
												   .append(map.get("province"))
												   .append(" ")
												   .append(map.get("city"))
												   .append(" ")
												   .append(string)
												   .append(" ")
												   .append(resultAddr)
												   .toString();
				fullAddr = fullAddr.replace("null", "").trim();
				resultMap.put("foreign", "false");
				resultMap.put("country", china);
				resultMap.put("province", map.get("province"));
				resultMap.put("city", map.get("city"));
				resultMap.put("addr", (string + " " + resultAddr).trim());
				resultMap.put("fullAddr", fullAddr);
				break;
			case 3:
				fullAddr = new StringBuilder(china).append(" ")
												   .append(map.get("province"))
												   .append(" ")
												   .append(map.get("city"))
												   .append(" ")
												   .append(map.get("area"))
												   .append(" ")
												   .append(string)
												   .append(" ")
												   .append(resultAddr)
												   .toString();
				fullAddr = fullAddr.replace("null", "").trim();
				resultMap.put("foreign", "false");
				resultMap.put("country", china);
				resultMap.put("province", map.get("province"));
				resultMap.put("city", map.get("city"));
				resultMap.put("area", map.get("area"));
				resultMap.put("addr", (string + " " + resultAddr).trim());
				resultMap.put("fullAddr", fullAddr);
				break;
			case 4:
				fullAddr = new StringBuilder(china).append(" ")
												   .append(map.get("province"))
												   .append(" ")
												   .append(map.get("area"))
												   .append(" ")
												   .append(string)
												   .append(" ")
												   .append(resultAddr)
												   .toString();
				fullAddr = fullAddr.replace("null", "").trim();
				resultMap.put("foreign", "false");
				resultMap.put("country", china);
				resultMap.put("province", map.get("province"));
				resultMap.put("area", map.get("area"));
				resultMap.put("addr", (string + " " + resultAddr).trim());
				resultMap.put("fullAddr", fullAddr);
				break;
			default:
				fullAddr = addr;
				resultMap.put("foreign", "unknown");
				resultMap.put("fullAddr", fullAddr.trim());
				break;
		}

		return resultMap;
	}

	//级别最高原则：
	//一级匹配市和一级匹配到的区所在市不一致，以一级匹配市为准
	//一级匹配省和一级匹配区/市所在省不一致，以一级匹配省为准
	public Map<String, Integer> compareCheck(String addr, String key, int flag,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> sList1,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> sList2) {
		Map<String, String> matchInfo1 = getMatchInfo(sList1);
		Map<String, String> matchInfo2 = getMatchInfo(sList2);
		Map<String, Integer> checkResult = new HashMap<String, Integer>();
		checkResult.put("compareCheck", -1);
		checkResult.put("flag", -1);

		if (!matchInfo2.get(key).equals(matchInfo1.get(key))) {
			checkResult.put("compareCheck", 1);    //1-true, 0-false
			checkResult.put("flag", flag);
		}
		return checkResult;
	}

	//同一位置同时匹配到市和区，保留市，舍弃区，如连云港、连云区都匹配到连云，则保留连云港
	//sList1-区匹配信息，sList2-市匹配信息
	public Map<String, Integer> compareMatch(String addr,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> sList1,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> sList2) {
		Map<String, Integer> matchResult = new HashMap<String, Integer>();
		Map<String, String> matchInfo1 = getMatchInfo(sList1);
		Map<String, String> matchInfo2 = getMatchInfo(sList2);
		matchResult.put("compareMatch", -1);
		matchResult.put("flag", -1);

		if (matchInfo1.get("match_start").equals(matchInfo2.get("match_start"))) {
			if (matchInfo2.get("match_string").indexOf(matchInfo1.get("match_string")) > -1) {
				matchResult.put("compareMatch", 1);        //1-true, 0-false
				matchResult.put("flag", 2);
			}
		}
		return matchResult;
	}

	//一级匹配省
	public Map<String, String> matchFromProvince(String addr,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> match_province) {
		Map<String, String> resultMap = new HashMap<String, String>();
		if (match_province.size() > 0) {
			resultMap = getAddress(addr, match_province, 1);
		}
		return resultMap;
	}

	//一级匹配市
	public Map<String, String> matchFromCity(String addr,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> match_city,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> match_province) {
		Map<String, String> resultMap = new HashMap<String, String>();
		if (match_city.size() > 0) {
			if (match_province.size() > 0) {
				Map<String, Integer> map = compareCheck(addr, "match_province", 1, match_city, match_province);
				if (map.get("compareCheck") == 1) {
					resultMap = getAddress(addr, match_province, map.get("flag"));
				} else {
					resultMap = getAddress(addr, match_city, 2);
				}
			} else {
				resultMap = getAddress(addr, match_city, 2);
			}
		}
		return resultMap;
	}

	//一级匹配区
	public Map<String, String> matchFromArea(String addr,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> match_area,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> match_city,
			List<Entry<Map<String, String>, Tuple<String, Integer>>> match_province) throws Exception {
		Map<String, String> resultMap = new HashMap<String, String>();

		if (match_area.size() == 0) {
			//未匹配到区
			resultMap = matchFromCity(addr, match_city, match_province);
			if (resultMap.size() == 0) {
				resultMap = matchFromProvince(addr, match_province);
			}
		} else if (match_area.size() == 1) {
			//匹配到一个区
			if (match_city.size() > 0) {
				Map<String, Integer> js1 = compareCheck(addr, "match_city", 2, match_area, match_city);
				Map<String, Integer> js2 = new HashMap<String, Integer>();
				Map<String, Integer> js3 = new HashMap<String, Integer>();

				js2.put("compareCheck", -1);
				js2.put("flag", -1);
				js3.put("compareCheck", -1);
				js3.put("flag", -1);

				if (match_province.size() > 0) {
					js2 = compareCheck(addr, "match_province", 1, match_city, match_province);
					js3 = compareCheck(addr, "match_province", 1, match_area, match_province);
				}

				if (js1.get("compareCheck") == 1) {
					if (js2.get("compareCheck") == 1) {
						if (js3.get("compareCheck") == 1) {
							resultMap = getAddress(addr, match_province, js2.get("flag"));
						} else {
							resultMap = getAddress(addr, match_area, 3);
						}
					} else {
						resultMap = getAddress(addr, match_city, js1.get("flag"));
					}
				} else {
					if (js2.get("compareCheck") == 1) {
						resultMap = getAddress(addr, match_province, js2.get("flag"));
					} else {
						if (compareMatch(addr, match_area, match_city).get("compareMatch") == 1) {
							resultMap = getAddress(addr, match_city, 2);
						} else {
							resultMap = getAddress(addr, match_area, 3);
						}
					}
				}
			} else if (match_province.size() > 0) {        //一级匹配到区和省的时候，检查区中的省是否与省中的省一致，优先级以省中的省最高
				Map<String, Integer> js = compareCheck(addr, "match_province", 1, match_area, match_province);

				if (js.get("compareCheck") == 1) {
					resultMap = getAddress(addr, match_province, js.get("flag"));
				} else {
					resultMap = getAddress(addr, match_area, 3);
				}
			} else {
				resultMap = getAddress(addr, match_area, 3);
			}
		} else {
			//匹配到多个区
			List<Entry<Map<String, String>, Tuple<String, Integer>>> matchSecond_city =
					match_secondLevel(addr, "city", match_area);
			if (matchSecond_city.size() == 0) {
				List<Entry<Map<String, String>, Tuple<String, Integer>>> matchSecond_province =
						match_secondLevel(addr, "province", match_area);

				if (matchSecond_province.size() == 0) {
					//二级匹配省市均未匹配到
					resultMap = matchFromCity(addr, match_city, match_province);
					if (resultMap.size() == 0) {
						resultMap = matchFromProvince(addr, match_province);
					}
				} else if (matchSecond_province.size() == 1) {
					resultMap = getAddress(addr, matchSecond_province, 3);
				} else if (matchSecond_province.size() == 2) {
					String area1 = matchSecond_province.get(0).getKey().get("area");
					String area2 = matchSecond_province.get(1).getKey().get("area");

					if (area1.substring(0, area1.length() - 1).equals(area2.substring(0, area2.length() - 1)) &&
							matchSecond_province.get(0)
												.getKey()
												.get("city")
												.equals(matchSecond_province.get(1).getKey().get("city")) &&
							matchSecond_province.get(0)
												.getKey()
												.get("province")
												.equals(matchSecond_province.get(1).getKey().get("province"))) {
						resultMap = getAddress(addr, matchSecond_province, 3);
					} else {
						resultMap = getAddress(addr, matchSecond_province, 4);
					}
				} else {
					resultMap = getAddress(addr, matchSecond_province, 4);
				}
			} else if (matchSecond_city.size() == 1) {
				resultMap = getAddress(addr, matchSecond_city, 3);
			} else {
				//二级匹配到多个市
				Map<String, String> msc1_map = matchSecond_city.get(0).getKey();
				Map<String, String> msc2_map = matchSecond_city.get(1).getKey();
				Tuple<String, Integer> msc1_hm = matchSecond_city.get(0).getValue();
				Tuple<String, Integer> msc2_hm = matchSecond_city.get(1).getValue();

				//处理比如同时且仅匹配到吴江市和吴江区的情况
				if (matchSecond_city.size() == 2 && msc1_map.get("province").equals(msc2_map.get("province")) &&
						msc1_map.get("city").equals(msc2_map.get("city")) && msc1_map.get("area")
																					 .substring(0, msc1_map.get("area")
																										   .length() -
																							 1)
																					 .equals(msc2_map.get("area")
																									 .substring(0,
																												msc2_map.get(
																														"area")
																														.length() -
																														1)) &&
						msc1_hm.getLeft().equals(msc2_hm.getLeft()) && msc1_hm.getRight() == msc2_hm.getRight()) {
					if (msc1_map.get("subAddr2").contains(msc1_map.get("area")) &&
							!msc2_map.get("subAddr2").contains(msc2_map.get("area"))) {
						matchSecond_city.remove(matchSecond_city.get(1));
					} else if (msc2_map.get("subAddr2").contains(msc2_map.get("area")) &&
							!msc1_map.get("subAddr2").contains(msc1_map.get("area"))) {
						matchSecond_city.remove(matchSecond_city.get(0));
					} else if (addr.indexOf(msc1_map.get("area")) <= addr.indexOf(msc2_map.get("area"))) {
						matchSecond_city.remove(matchSecond_city.get(1));
					} else if (addr.indexOf(msc1_map.get("area")) > addr.indexOf(msc2_map.get("area"))) {
						matchSecond_city.remove(matchSecond_city.get(0));
					}
					resultMap = getAddress(addr, matchSecond_city, 3);

				} else if (matchSecond_city.size() == 2 &&
						msc1_map.get("subAddr2").length() < msc2_map.get("subAddr2").length()) {
					matchSecond_city.remove(matchSecond_city.get(0));
					resultMap = getAddress(addr, matchSecond_city, 3);
				} else if (matchSecond_city.size() == 2 &&
						msc2_map.get("subAddr2").length() < msc1_map.get("subAddr2").length()) {
					matchSecond_city.remove(matchSecond_city.get(1));
					resultMap = getAddress(addr, matchSecond_city, 3);
				} else {
					List<Entry<Map<String, String>, Tuple<String, Integer>>> matchThird_province =
							match_secondLevel(addr, "province", matchSecond_city);
					if (matchThird_province.size() == 0) {
						resultMap = matchFromProvince(addr, match_province);
					} else if (matchThird_province.size() == 1) {
						resultMap = getAddress(addr, matchThird_province, 3);
					} else {
						resultMap = getAddress(addr, matchThird_province, 1);
					}
				}
			}
		}
		return resultMap;
	}

	public Map<String, String> run(String addr) throws Exception {

		List<Entry<Map<String, String>, Tuple<String, Integer>>> match_area = match_firstLevel(addr, "area");
		List<Entry<Map<String, String>, Tuple<String, Integer>>> match_area2 =
				new ArrayList<Entry<Map<String, String>, Tuple<String, Integer>>>();
		List<Entry<Map<String, String>, Tuple<String, Integer>>> match_city = match_firstLevel(addr, "city");
		List<Entry<Map<String, String>, Tuple<String, Integer>>> match_city2 =
				new ArrayList<Entry<Map<String, String>, Tuple<String, Integer>>>();
		List<Entry<Map<String, String>, Tuple<String, Integer>>> match_province = match_firstLevel(addr, "province");

		if (match_province.size() > 0 && match_province.get(0).getValue().getRight() > 10) {
			match_province = new ArrayList<Entry<Map<String, String>, Tuple<String, Integer>>>();
		}
		//System.out.println(match_area);
		//System.out.println(match_city);
		//System.out.println(match_province);

		if (addr.startsWith("北京") || addr.startsWith("天津") || addr.startsWith("重庆") || addr.startsWith("上海")) {
			match_city = new ArrayList<Entry<Map<String, String>, Tuple<String, Integer>>>();
		}

		Map<String, String> resultAddr = matchFromArea(addr, match_area, match_city, match_province);
		Map<String, String> resultAddr2 = matchFromArea(addr, match_area2, match_city, match_province);
		Map<String, String> resultAddr3 = matchFromArea(addr, match_area2, match_city2, match_province);
		//		System.out.println("11" + resultAddr);
		//		System.out.println("22" + resultAddr2);
		//		System.out.println("33" + resultAddr3);

		if (resultAddr.size() > 0 && resultAddr2.size() > 0 &&
				!resultAddr.get("city").equals(resultAddr2.get("city")) && !resultAddr.get("city").equals("市辖区") &&
				resultAddr2.get("city").length() > 0 &&
				((!addr.contains(resultAddr.get("addr")) && addr.contains(resultAddr2.get("addr"))) ||
						resultAddr.get("addr").length() <= resultAddr2.get("addr").length())) {
			resultAddr = DeepCopy.copy(resultAddr2);
		}
		if (resultAddr.size() > 0 && resultAddr3.size() > 0 &&
				!resultAddr.get("province").equals(resultAddr3.get("province")) &&
				((!addr.contains(resultAddr.get("addr")) && addr.contains(resultAddr3.get("addr"))) ||
						resultAddr.get("addr").length() <= resultAddr3.get("addr").length())) {
			resultAddr = DeepCopy.copy(resultAddr3);
		}
		resultAddr = special(addr, resultAddr);

		if (resultAddr.size() == 0 || resultAddr.get("fullAddr").length() < addr.length() ||
				(resultAddr.get("addr").length() > 0 && !addr.contains(resultAddr.get("addr")))) {
			resultAddr = special(addr, resultAddr2);
			if (resultAddr.size() == 0 || resultAddr.get("fullAddr").length() < addr.length()) {
				resultAddr = special(addr, resultAddr3);
				if (resultAddr.size() == 0 || resultAddr.get("fullAddr").length() < addr.length()) {
					resultAddr.put("foreign", "unknown");
					resultAddr.put("country", "");
					resultAddr.put("province", "");
					resultAddr.put("city", "");
					resultAddr.put("area", "");
					resultAddr.put("addr", "");
					resultAddr.put("fullAddr", addr);
				}
			}
		}
		return resultAddr;
	}

	public Map<String, String> special(String addr, Map<String, String> map) {
		if (map.size() == 0) {
			return map;
		}

		String cityStr = map.get("city");
		String proStr = map.get("province");

		//		if ((cityStr.equals("市辖区") || cityStr.equals("县"))) {
		//			String pro = map.get("province");
		//			map.put("city", pro);
		//			map.put("fullAddr", map.get("country") + " " + map.get("province") + " " + map.get("city") + " " + map.get("area") + " " + map.get("addr"));
		//		} else
		if (cityStr.equals("省直辖县级行政区划")) {
			map.put("city", "");
			map.put("fullAddr", map.get("fullAddr").replace("省直辖县级行政区划 ", ""));
		}

		if (proStr.equals("北京市") || proStr.equals("天津市") || proStr.equals("重庆市") || proStr.equals("上海市")) {
			map.put("city", proStr);

			if (map.get("addr").replaceAll(" ", "").equals(map.get("city") + map.get("area"))) {
				map.put("addr", "");
			}
			map.put("fullAddr",
					map.get("country") + " " + map.get("province") + " " + map.get("city") + " " + map.get("area") +
							" " + map.get("addr"));
		}

		String pcaStr = map.get("province") + "_" + map.get("city") + "_" + map.get("area");
		if (city_old.contains(cityStr)) {
			map.put("city", city_new.get(city_old.indexOf(cityStr)));
		}
		if (area_old.contains(pcaStr)) {
			map.put("area", area_new.get(area_old.indexOf(pcaStr)));
		}

		String areaStr = map.get("area");
		String addrStr = map.get("addr");
		String fullStr = map.get("fullAddr");

		if (areaStr.length() > 0 && addrStr.length() > 0 && areaStr.charAt(areaStr.length() - 1) == '县' &&
				addrStr.charAt(0) == '县' && !addr.contains("县县")) {
			map.put("addr", addrStr.substring(1, addrStr.length()));
			map.put("fullAddr", fullStr.replace("县 县", "县 "));
		}
		if (areaStr.length() > 0 && addrStr.length() > 0 && areaStr.charAt(areaStr.length() - 1) == '区' &&
				addrStr.charAt(0) == '区' && !addr.contains("区区")) {
			map.put("addr", addrStr.substring(1, addrStr.length()));
			map.put("fullAddr", fullStr.replace("区 区", "区 "));
		}

		return map;
	}

	public static void main(String[] args) throws Exception {
		//		String addr = "山东省南沙河镇北街村960号";
		//		addr = "江苏省张家港市凤凰镇凤凰大道18号张家港奇耘物资有限公司";
		//		addr = "广东广州增城荔城大道北雅居乐商铺1一3号广州市振明网络科技有限公司";
		//		addr = "辽宁省大连市普湾新区铁西办事处花儿山社区大连栩阳苗木基地";
		//		addr = "北京市东城区朝阳门内南小街南竹竿胡同鹰城商务酒店307室";
		//		addr = "杭州市余杭区仁和镇西南山东路云会水产60号318000";
		//		addr = "辽宁省瓦房店市铁东办事处健康街22号75栋119号新升物资招待所";
		//		addr = "江苏省盱眙县经济开发区牡丹大道东侧江苏威斯特汽车工业有限公司51050";
		//        addr = "新疆维吾尔自治区乌鲁木齐市新市区鲤鱼山南路388号汇展园小区南区4";
		//        addr = "江苏省苏州市吴江区盛泽镇南麻开发区织庄路吴江市云瑞喷织厂";
		//        addr = "河北省张家口市宣化县赵川镇张家夭村";
		//        addr = "广东广州增城荔城大道北雅居乐商铺1一3号广州市振明网络科技有限公司";
		//        addr = "山西省晋城市城区西安街101号1楼111室泽州县招商局";
		//        addr = "湖北省黄石市铁山区鹿獐大道1-9号铁山区盛记狗肉馆";
		//        addr = "广东潮州市饶平区黄冈镇大澳新市中路52号后面饶平县清靓影服饰商行";
		//        addr = "重庆九龙坡区红狮大道6号巴国茶城A092号九龙坡区九龙园区梦龙春茶行";
		//        addr = "龙江县";
		//        addr = "江苏省苏州现代大道";
		//      addr = "江苏省江都市丁伙镇新杭村尤庄组12号";
		//      addr = "上海市浦东区中山南路";
		//      addr = "124545213435";
		//		addr = "苏州";
		//		addr = "北京市 朝阳区 ";
		//		long startTime = System.currentTimeMillis();
		//		Map<String, String> result = ChinaMatchTuple.getInstance().run(addr);
		//		System.out.println(result);
		//		long endTime = System.currentTimeMillis();
		//		System.out.println("当前程序耗时：" + (endTime - startTime) + "ms");
	}
}
