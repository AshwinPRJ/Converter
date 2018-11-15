package com.vyavharamitra.unitofmeasurement.service;
import com.vyavharamitra.unitofmeasurement.bean.VendorMasterBean;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.unitofmeasurement.to.request.VendorMasterRequest;
public interface IVendorMasterService {

	public VendorMasterBean vendorCreateService(VendorMasterRequest vendorMasterRequest);


	
}
