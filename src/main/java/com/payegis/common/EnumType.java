package com.payegis.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payegis.constant.TypeConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumType extends Type {

    private static final long serialVersionUID = 8979702469685575394L;
    private static final Logger LOGGER = LoggerFactory.getLogger(EnumType.class);
    private String type = "enum";
    @JsonProperty("hbaseHead")
    private String hbaseHead = "s_";
    @JsonProperty("originalValue")
    private String val = null;

    public EnumType() {

    }

    public EnumType(String value) {
        String obj = null;
        if (value != null) {
            obj = value.toUpperCase();
        }
        val = obj;
    }

    @Override
    public Object getOriginalValue() {
        return val;
    }

    @Override
    public String getHBaseHead() {
        return hbaseHead;
    }

    @Override
    public String toString() {
        if (val != null) {
            return String.valueOf(val).trim().toUpperCase();
        } else {
            LOGGER.info("value is null");
            return TypeConstant.NULL_VALUE;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        EnumType t = (EnumType) obj;
        return this.val.equals(t.val);
    }

    @Override
    public int hashCode() {
        return this.val.hashCode();
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Object getIndexValue() {
        if (this.val == null) {
            return null;
        } else {
            return this.val.trim().toString().toUpperCase();
        }
    }

}
