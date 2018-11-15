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

import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.service.IPurchaseBillService;
import com.vyavharamitra.unitofmeasurement.to.request.PurchaseBillRequest;
import com.vyavharamitra.unitofmeasurement.to.response.HelperPurchaseBean;
import com.vyavharamitra.unitofmeasurement.to.response.PurchaseBillResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
@Controller
@RequestMapping(value = "/purchase")
public class PurchaseBillControllers {

	@Autowired
	private IPurchaseBillService iPurchaseBillService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public PurchaseBillResponse purchaseCreateController(@RequestBody PurchaseBillRequest purchaseBillRequest) {
		PurchaseBillResponse purchaseBillResponse = new PurchaseBillResponse();
		PurchaseBillBean purchaseBillBean;
		purchaseBillBean = iPurchaseBillService.purchaseCreateService(purchaseBillRequest);
		if (purchaseBillBean != null) {
			purchaseBillResponse.setPurchaseBillBean(purchaseBillBean);
			purchaseBillResponse.setStatusCode(StatusCodes.OK);
			purchaseBillResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			purchaseBillResponse.setStatusCode(StatusCodes.NO_CONTENT);
			purchaseBillResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return purchaseBillResponse;
	}
	/*
	@RequestMapping(value = "/createSample", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public PurchaseBillResponse purchaseCreateControllerSample(@RequestBody PurchaseBillRequest purchaseBillRequest) {
		PurchaseBillResponse purchaseBillResponse = new PurchaseBillResponse();
		PurchaseBillBean purchaseBillBean;
		purchaseBillBean = iPurchaseBillService.purchaseCreateServiceSample(purchaseBillRequest);
		if (purchaseBillBean != null) {
			purchaseBillResponse.setPurchaseBillBean(purchaseBillBean);
			purchaseBillResponse.setStatusCode(StatusCodes.OK);
			purchaseBillResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			purchaseBillResponse.setStatusCode(StatusCodes.NO_CONTENT);
			purchaseBillResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return purchaseBillResponse;
	}
*/
	@RequestMapping(value = "/read", method = RequestMethod.POST,produces = "application/json", consumes = "application/json")
	@ResponseBody
	public PurchaseBillResponse getPurchaseDeatils(@RequestBody PurchaseBillRequest purchaseBillRequest) {
		PurchaseBillResponse purchaseBillResponse = new PurchaseBillResponse();
		 HelperPurchaseBean helperPurchaseBean=iPurchaseBillService.purchaseFetchService(purchaseBillRequest);
		 purchaseBillResponse.setHelperPurchaseBean(helperPurchaseBean);
		 if(helperPurchaseBean !=null)
		 {
			 purchaseBillResponse.setStatusCode(StatusCodes.OK);
				purchaseBillResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		 }
		 else
		 {
			 purchaseBillResponse.setStatusCode(StatusCodes.NO_CONTENT);
		     purchaseBillResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		 }
		 return purchaseBillResponse;
	}
}
