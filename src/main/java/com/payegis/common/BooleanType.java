package com.payegis.common;

import com.payegis.constant.TypeConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooleanType extends Type {

    private static final long serialVersionUID = -7064258990821172150L;
    private static final Logger LOGGER = LoggerFactory.getLogger(BooleanType.class);

    private String type = "boolean";
    private String hbaseHead = "b_";
    private Boolean val = null;

    public BooleanType() {

    }

    public BooleanType(Boolean value) {
        this.val = value;
    }

    public BooleanType(String value) {
        if (value != null) {
            if (StringUtils.equalsIgnoreCase(value.trim(), TypeConstant.FALSE_VALUE)) {
                this.val = Boolean.FALSE;
            } else if (StringUtils.equalsIgnoreCase(value.trim(), TypeConstant.TRUE_VALUE)) {
                this.val = Boolean.TRUE;
            } else {
                LOGGER.info("value is null");
                this.val = null;
            }
        }
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
            if (val) {
                return TypeConstant.TRUE_VALUE;
            } else {
                return TypeConstant.FALSE_VALUE;
            }
        } else {
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
        BooleanType t = (BooleanType) obj;
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
            return this.val;
        }
    }

}
