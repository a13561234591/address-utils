package com.payegis.knowledge;


import com.alibaba.fastjson2.JSONObject;
import com.payegis.common.GeoIpManager;
import com.payegis.common.knowledge.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class IpKnowledge {

    private static final long serialVersionUID = 7031623034908230427L;





    public JSONObject learn(String value) {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isEmpty(value)) {
            log.error("value为空");
            return jsonObject;
        }

        boolean verify = verify(value);
        if (verify) {
            jsonObject = GeoIpManager.getIpInfo(value);
            return jsonObject;
        }
        return jsonObject;
    }



    private static Boolean verify(String ip) {
        return IpUtil.isIpFormat(ip);
    }
}
