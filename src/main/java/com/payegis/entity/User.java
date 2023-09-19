package com.payegis.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    private String id;

    private String name;

    private UserDetail userDetail;
    @JsonProperty("s_T01_CreditApplyId")
    private String applyId;

}
