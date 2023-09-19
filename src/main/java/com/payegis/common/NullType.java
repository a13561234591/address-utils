package com.payegis.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payegis.constant.TypeConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NullType extends Type {

	private static final long serialVersionUID = 1851663643812621890L;
	private static final Logger LOGGER = LoggerFactory.getLogger(NullType.class);

	private String type      = "null";
	@JsonProperty("hbaseHead")
	private String hbaseHead = "n_";
	@JsonProperty("originalValue")
	private String val       = null;

	public NullType() {

	}

	@Override
	public Object getOriginalValue() {
		return null;
	}

	@Override
	public String getHBaseHead() {
		return hbaseHead;
	}

	@Override
	public String toString() {
		return TypeConstant.NULL_VALUE;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		NullType t = (NullType) obj;
		return (t.val == null);
	}

	@Override
	public int hashCode() {
		return "".hashCode();
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public Object getIndexValue() {
		return null;
	}

}
