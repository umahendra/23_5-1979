package com.freevice.hw.web.service;

import com.freevice.hw.web.common.exception.BusinessException;
import com.freevice.hw.web.model.User;
import com.freevice.hw.web.model.Vendor;
import com.freevice.hw.web.model.VendorFacilities;

public interface BookingService {


	
	public void bookVendorServices(Vendor vendor,User user,VendorFacilities requestedFacilities) throws BusinessException;
	
}
