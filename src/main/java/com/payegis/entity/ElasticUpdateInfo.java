package com.payegis.entity;

import lombok.Data;

@Data
public class ElasticUpdateInfo {
    /**
     * 更新到es中的key
     */
    private String fieldName;

    /**
     * 更新值
     */
    private String fieldValue;
}
