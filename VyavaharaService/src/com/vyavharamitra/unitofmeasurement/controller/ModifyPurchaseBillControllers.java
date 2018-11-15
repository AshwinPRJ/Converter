package com.vyavharamitra.unitofmeasurement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.service.IModifyPurchaseBillService;
import com.vyavharamitra.unitofmeasurement.to.request.PurchaseBillRequest;
import com.vyavharamitra.unitofmeasurement.to.response.PurchaseBillResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;
@Controller
@RequestMapping(value = "/purchase")
public class ModifyPurchaseBillControllers {
	@Autowired
	private IModifyPurchaseBillService iModifyPurchaseBillService;
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public PurchaseBillResponse purchaseUpdateController(@RequestBody PurchaseBillRequest purchaseBillRequest) {
		PurchaseBillResponse purchaseBillResponse = new PurchaseBillResponse();
		PurchaseBillBean purchaseBillBean;
		purchaseBillBean = iModifyPurchaseBillService.purchaseUpdateService(purchaseBillRequest);
		if (purchaseBillBean != null) {
			purchaseBillResponse.setPurchaseBillBean(purchaseBillBean);
			purchaseBillResponse.setStatusCode(StatusCodes.OK);
			purchaseBillResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
		} else {
			purchaseBillResponse.setStatusCode(StatusCodes.NO_CONTENT);
			purchaseBillResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
		}
		return purchaseBillResponse;
	}
	
/*	
	//delete purchase bill
	
	 @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseBody
		public PurchaseBillResponse deleteItemController(@RequestBody PurchaseBillRequest purchaseBillRequest) {
		 PurchaseBillResponse purchaseBillResponse = new PurchaseBillResponse();

		 PurchaseBillBean purchaseBillBean;
		 
		 purchaseBillBean = iModifyPurchaseBillService.deletePurchaseDetailsService(purchaseBillRequest);
			if (purchaseBillBean != null) {
				purchaseBillResponse.setPurchaseBillBean(purchaseBillBean);
				purchaseBillResponse.setStatusCode(StatusCodes.OK);
				purchaseBillResponse.setStatusMessage(StatusMessages.DELETE_SUCCESS_MSG);		
				}else{
					purchaseBillResponse.setStatusCode(StatusCodes.NO_CONTENT);
					purchaseBillResponse.setStatusMessage(StatusMessages.DELETE_FAILURE_MSG);
				}
			return purchaseBillResponse;
		}
	
	*/
	
	
}
