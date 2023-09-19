package com.payegis.knowledge;


import com.payegis.common.AddressCom;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun.zhang on 2017/2/23.
 */
@Slf4j
public class AddressKnowledge {



    public Map<String, String> learn(String value) {
        Map<String, String> dataMap = new HashMap<>();
        if (StringUtils.isNotBlank(value) && !value.equalsIgnoreCase("NA")) {
            // 地址进行判断是否是国内地址，是的就保存，不是就直接存国家

            try {
                dataMap = AddressCom.getInstance().run(value);
            } catch (Exception e) {
                log.error("AddressCom地址解析异常，error!"+ e);
            }
            //log.info("AddressCom run result :{}", dataMap);
            //获取所在省份
            return dataMap;
        }
        return null;
    }

}
