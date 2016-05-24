package com.freevice.hw.web.model;

import java.util.List;

public class Vendor {
	
	
	private String category;
	private String chain;
	private String location;
	private Address address; 
	private String vendorId;
	private String vendorName;
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	private List<VendorFacilities> availableServices;
	public List<VendorFacilities> getAvailableServices() {
		return availableServices;
	}
	public void setAvailableServices(List<VendorFacilities> availableServices) {
		this.availableServices = availableServices;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getChain() {
		return chain;
	}
	public void setChain(String chain) {
		this.chain = chain;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
