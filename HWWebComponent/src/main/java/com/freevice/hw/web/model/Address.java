package com.freevice.hw.web.model;

public class Address {


	public String getFirstline() {
		return firstline;
	}

	public void setFirstline(String firstline) {
		this.firstline = firstline;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	private String firstline;

	private String secondLine;

	private Integer pincode;

	private String city;
	
	private String country;
	
	
}
