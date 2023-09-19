package com.payegis.dto;

import java.io.Serializable;
import java.util.Set;

public class KnowledgeDTO implements Serializable {

    private static final long serialVersionUID = -2583461134711144108L;
    private String knowledgeTypeCode;
    private String key;
    private Set<Integer> group;

    public KnowledgeDTO(String knowledgeTypeCode, String key, Set<Integer> group) {
        this.knowledgeTypeCode = knowledgeTypeCode;
        this.key = key;
        this.group = group;
    }

    public String getKey() {
        return key;
    }

    public Set<Integer> getGroup() {
        return group;
    }

    public String getKnowledgeTypeCode() {
        return knowledgeTypeCode;
    }

    @Override
    public String toString() {
        return "KnowledgeDTO{" + "knowledgeTypeCode='" + knowledgeTypeCode + '\'' + ", key='" + key + '\'' +
                ", group=" + group + '}';
    }

}
