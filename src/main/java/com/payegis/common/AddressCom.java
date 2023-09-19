package com.payegis.common;

import java.util.HashMap;
import java.util.Map;

public class AddressCom {

	private static AddressCom addressCom = null;

	public synchronized static AddressCom getInstance() {
		if (addressCom == null) {
			addressCom = new AddressCom();
		}
		return addressCom;
	}

	public Map<String, String> run(String addr) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("fullAddr", addr);
		map.put("province", "");
		//只要省份和全量地址两个字段，但是为了防止其他的字段不要出现空指针
		map.put("country", "");
		map.put("city", "");
		map.put("area", "");
		map.put("addr", "");

		if (addr.startsWith("中国")) {
			String remainAddr = addr.substring(2);
			if (remainAddr.length() > 0) {
				map = ChinaMatchTuple.getInstance().run(addr.substring(2));
			} else {

				map.put("fullAddr", addr);
				map.put("country", "中国");
			}
		}else{
			map = ChinaMatchTuple.getInstance().run(addr);
			map.put("country", "中国");
		}
		return map;
	}

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		String addr = "江苏省江都市丁伙镇新杭村尤庄组12号";
		addr = "江苏省张家港市凤凰镇凤凰大道18号张家港奇耘物资有限公司";
		addr = "广东广州增城荔城大道北雅居乐商铺1一3号广州市振明网络科技有限公司";
		addr = "辽宁省大连市普湾新区铁西办事处花儿山社区大连栩阳苗木基地";
		addr = "北京市东城区朝阳门内南小街南竹竿胡同鹰城商务酒店307室";
		addr = "杭州市余杭区仁和镇西南山东路云会水产60号318000";
		addr = "辽宁省瓦房店市铁东办事处健康街22号75栋119号新升物资招待所";
		addr = "江苏省盱眙县经济开发区牡丹大道东侧江苏威斯特汽车工业有限公司51050";
		addr = "新疆维吾尔自治区乌鲁木齐市新市区鲤鱼山南路388号汇展园小区南区4";
		addr = "江苏省苏州市吴江区盛泽镇南麻开发区织庄路吴江市云瑞喷织厂";
		addr = "河北省张家口市宣化县赵川镇张家夭村";
		addr = "广东广州增城荔城大道北雅居乐商铺1一3号广州市振明网络科技有限公司";
		addr = "山西省晋城市城区西安街101号1楼111室泽州县招商局";
		addr = "湖北省黄石市铁山区鹿獐大道1-9号铁山区盛记狗肉馆";
		addr = "广东潮州市饶平区黄冈镇大澳新市中路52号后面饶平县清靓影服饰商行";
		addr = "重庆九龙坡区红狮大道6号巴国茶城A092号九龙坡区九龙园区梦龙春茶行";
		addr = "中国 重庆市 重庆市 九龙坡区 红狮大道6号巴国茶城A092号九龙坡区九龙园区梦龙春茶行";
		addr = "龙江县";
		addr = "江苏省苏州现代大道";
		addr = "江苏省南通市通州区";
		//		addr = "中国 江苏省 南通市 通州区";
		//		addr = "上海市浦东区中山南路";
		//		addr = "中国 上海市 上海市 浦东新区 中山南路";
		//		addr = "北京市市辖区朝阳区将台地区办事处瞰都嘉园社区居委会";
		//		addr = "中国 北京市 北京市 朝阳区 将台地区办事处瞰都嘉园社区居委会";
		//		addr = "124545213435";
		//		addr = "苏州";
		addr = "中国 北京市 北京市 海淀区";
		addr = "乌鲁木齐市";
//		addr = "意大利";
		addr = "山东省青岛市崂山区永新国际金融中心2号";
		System.out.println(AddressCom.getInstance().run(addr));
		long endTime = System.currentTimeMillis();
		System.out.println("当前程序耗时：" + (endTime - startTime) + "ms");
	}
}
