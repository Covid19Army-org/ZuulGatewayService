package com.covid19army.ZuulGatewayService.dtos;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

public class UserResponseDto {

	private long userid;
	private long mobileNumber;
	private String password;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return "nopassword";
	}
	public void setPassword(String password) {
		this.password = "nopassword";
	}
	
	@Override
	public String toString() {
		return mobileNumber + "";
	}
	
}
