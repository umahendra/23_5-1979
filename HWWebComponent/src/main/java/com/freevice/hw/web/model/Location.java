package com.freevice.hw.web.model;

import java.io.Serializable;

public class Location implements Serializable {

	public Location() {
		// TODO Auto-generated constructor stub
	}
	public Location(String longitude,String latitude) {
		// TODO Auto-generated constructor stub
		this.longitude = longitude;
		this.latitude = latitude;
		
	}
	String longitude ;
	String latitude;
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
	
}
