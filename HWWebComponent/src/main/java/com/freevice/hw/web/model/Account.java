package com.freevice.hw.web.model;

import java.io.Serializable;

public class Account implements Serializable{

	
	String acountId;
	public String getAcountId() {
		return acountId;
	}
	public void setAcountId(String acountId) {
		this.acountId = acountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String accountType; //facebook,Internal etc.
	String password;
}
