package com.vyavharamitra.unitofmeasurement.controller;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.unitofmeasurement.bean.VendorMasterBean;
import com.vyavharamitra.unitofmeasurement.service.IVendorMasterService;
import com.vyavharamitra.unitofmeasurement.to.request.VendorMasterRequest;
import com.vyavharamitra.unitofmeasurement.to.response.VendorMasterResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping(value = "/vendor")
public class VendorMasterControllers {
	@Autowired
	private IVendorMasterService iVendorMasterService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public VendorMasterResponse vendorCreateController(@RequestBody VendorMasterRequest vendorMasterRequest) {
		VendorMasterResponse vendorMasterResponse = new VendorMasterResponse();

		VendorMasterBean vendorMasterBean;
		vendorMasterBean = iVendorMasterService.vendorCreateService(vendorMasterRequest);
		if (vendorMasterBean != null) {
			vendorMasterResponse.setVendorMasterBean(vendorMasterBean);
			vendorMasterResponse.setStatusCode(StatusCodes.OK);
			vendorMasterResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			vendorMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			vendorMasterResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return vendorMasterResponse;
	}
	
	
	
}
