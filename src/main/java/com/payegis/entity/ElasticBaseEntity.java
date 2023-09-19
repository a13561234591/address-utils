package com.payegis.entity;

import com.payegis.excelListener.excelEntity.AddressInfo;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class ElasticBaseEntity {

    private transient int docId;
    private String id;
    private String type;
    private transient String index;
    private AddressInfo addressInfo;

    List<ElasticUpdateInfo> updateInfoList;

    private String creditApplyId;

    private String no;

    private String invokingType;





}
