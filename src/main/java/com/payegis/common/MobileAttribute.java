package com.payegis.common;

import java.io.Serializable;

/**
 * Created by jun.zhang on 2017/3/28.
 */
public class MobileAttribute implements Serializable {

	private String mobile;
	private String province;
	private String city;
	private String operator;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
