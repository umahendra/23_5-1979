package com.freevice.hw.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.freevice.hw.web.common.VendorRestURIConstants;
import com.freevice.hw.web.model.Vendor;
import com.freevice.hw.web.service.VendorService;
import com.freevice.hw.web.service.impl.VendorServiceImpl;

@RestController
public class VendorController {


	private VendorService vendorserviceImpl ;

	public VendorController(){
		vendorserviceImpl = new VendorServiceImpl();
	}
	public VendorService getUserDao() {
		return vendorserviceImpl;
	}

	public void setVendorDao(VendorService vendorDao) {
		this.vendorserviceImpl = vendorDao;
	}
	

	@RequestMapping(value = VendorRestURIConstants.GET_VENDOR_BY_ID, method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody Vendor getVendorById(@PathVariable("vendorId") String vendorId) {
		
		System.out.println("called VendorController getVendorById");
		
		return vendorserviceImpl.getVendor(vendorId);
	

	}
	@RequestMapping(value = VendorRestURIConstants.GET_ALL_VENDOR, method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<Vendor> getAllUser() {
		
		return vendorserviceImpl.getVendors();
	
	}
		
	

	
	
	/*@RequestMapping(value = UserRestURIConstants.DROP_DB, method = RequestMethod.DELETE,headers="Accept=application/json")
	public @ResponseBody void dropDB() {
		vendorDao.dropDB();
	
	}*/
		
	
	
	
	
	@RequestMapping(value = VendorRestURIConstants.CREATE_VENDOR, method = RequestMethod.POST)
	public @ResponseBody Vendor createUser(@RequestBody Vendor vendor) {
		System.out.println("called vendorController createVendor");
		vendorserviceImpl.createVendor(vendor);
		return vendor;
	}
	

	
	
	
	
}
