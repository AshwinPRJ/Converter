package com.vyavharamitra.reports.keys.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.reports.keys.service.IPurchaseBillReportService;
import com.vyavharamitra.reports.keys.to.request.DealerReportRequest;
import com.vyavharamitra.reports.keys.to.response.DealerReportResponse;
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
@Controller
@RequestMapping(value = "/Purchase")
public class PurchaseBillReportController {
	@Autowired
	private IPurchaseBillReportService iPurchaseBillReportService;
	
	@RequestMapping(value = "/PurchaseReport", method = RequestMethod.POST)
	@ResponseBody
	public DealerReportResponse getpurchasedetails(@RequestBody DealerReportRequest dealerReportRequest) {
		DealerReportResponse dealerSearchResponse = new DealerReportResponse();
		List<PurchaseBillBean> purchaseBillBean = Collections.emptyList();
		purchaseBillBean= iPurchaseBillReportService.getpurchasedetails(dealerReportRequest);
		if (CollectionUtils.isEmpty(purchaseBillBean) ){
			dealerSearchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dealerSearchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
			
			
		} else {
			dealerSearchResponse.setPurchaseBillBean(purchaseBillBean);

			dealerSearchResponse.setStatusCode(StatusCodes.OK);
			dealerSearchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dealerSearchResponse;
	}
	
	
	//Deleted item history report
			@RequestMapping(value = "/Date", method = RequestMethod.POST)
			@ResponseBody
			public DealerReportResponse getpurchasedatedetails(@RequestBody DealerReportRequest dealerReportRequest) {
				DealerReportResponse dealerReportResponse = new DealerReportResponse();
				List<PurchaseBillBean> deleteItemMasterBean = Collections.emptyList();
				deleteItemMasterBean= iPurchaseBillReportService.getpurchasedatedetails(dealerReportRequest);
				if (CollectionUtils.isEmpty(deleteItemMasterBean) ){
					dealerReportResponse.setStatusCode(StatusCodes.NO_CONTENT);
					dealerReportResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
					
					
				} else {
					dealerReportResponse.setPurchaseBillBean(deleteItemMasterBean);

					dealerReportResponse.setStatusCode(StatusCodes.OK);
					dealerReportResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
				}
				return dealerReportResponse;
			}
			
	
	
}
