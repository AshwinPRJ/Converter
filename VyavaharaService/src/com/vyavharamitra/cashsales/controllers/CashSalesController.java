package com.vyavharamitra.cashsales.controllers;

/**
 * @author			: Brahmani
 * @created date	: 23 Nov 2017
 * @modified by		:  
 * @modified date	: 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.cashsales.service.ICashSalesService;
import com.vyavharamitra.cashsales.to.request.CashSalesCreateRequest;
import com.vyavharamitra.cashsales.to.response.CashSalesCreateResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping("/cashsales")
public class CashSalesController {
	@Autowired
	private ICashSalesService iCashSalesService;

	/**
	 * Create CashSales
	 * 
	 * @param cashSalesCreateRequest
	 * @return
	 */
	@RequestMapping(value = "/gst/algorithm", method = RequestMethod.POST)
	@ResponseBody
	public CashSalesCreateResponse Cotroller(@RequestBody CashSalesCreateRequest cashSalesCreateRequest) {
		CashSalesCreateResponse cashSalesCreateResponse = new CashSalesCreateResponse();

		CashSalesLineBean cashSalesLineBean;
		cashSalesLineBean = iCashSalesService.cashSalesCalculationService(cashSalesCreateRequest);
		
		if (cashSalesLineBean != null) {
			cashSalesCreateResponse.setCashSalesLineBean(cashSalesLineBean);
			cashSalesCreateResponse.setStatusCode(StatusCodes.OK);
			cashSalesCreateResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		} else {
			cashSalesCreateResponse.setStatusCode(StatusCodes.NO_CONTENT);
			cashSalesCreateResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		}
		return cashSalesCreateResponse;
	}
}
