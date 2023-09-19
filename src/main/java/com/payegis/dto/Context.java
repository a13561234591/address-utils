package com.payegis.dto;

import java.util.HashMap;
import java.util.Map;

public class Context {
    // 蓝海返回扩展字段(目前只处理地址，IP，mobile，身份证)
    private Map<String, Object> lhKnowledgeMap = new HashMap<>();

    public Map<String, Object> getLhKnowledgeMap() {
        return lhKnowledgeMap;
    }

    public void setLhKnowledgeMap(Map<String, Object> lhKnowledgeMap) {
        this.lhKnowledgeMap = lhKnowledgeMap;
    }
}
