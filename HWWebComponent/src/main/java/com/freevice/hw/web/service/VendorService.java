package com.freevice.hw.web.service;

import java.util.List;

import com.freevice.hw.web.model.Vendor;

public interface VendorService {



	String createVendor(Vendor vendor);

	Vendor getVendor(String vendorId);

	List<Vendor> getVendors();


	
}
