package com.freevice.hw.web.service.impl;

import java.util.List;

import com.freevice.hw.web.model.Vendor;
import com.freevice.hw.web.mongo.dao.VendorDao;
import com.freevice.hw.web.service.VendorService;

public class VendorServiceImpl implements VendorService {
	
	private VendorDao  vendorDao = new VendorDao();
	
	public VendorServiceImpl() {
		vendorDao = new VendorDao();
	}
	
	public String createVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendorDao.createVendor(vendor);
	}

	public Vendor getVendor(String vendorId) {
		// TODO Auto-generated method stub
		return vendorDao.getVendor(vendorId);
	}

	public List<Vendor> getVendors() {
		// TODO Auto-generated method stub
		return vendorDao.getVendors();
	}

}
