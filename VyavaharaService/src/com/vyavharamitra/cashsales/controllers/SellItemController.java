package com.vyavharamitra.cashsales.controllers;
/**
 * @author : Brahmani
 * @created date : 20 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.service.ISellItemService;
import com.vyavharamitra.cashsales.to.request.CashSalesCreateRequest;
import com.vyavharamitra.cashsales.to.response.CashSalesCreateResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping(value = "/cashsales")
public class SellItemController {

	@Autowired
	private ISellItemService iSellItemService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public CashSalesCreateResponse sellItemController(@RequestBody CashSalesCreateRequest cashSalesCreateRequest) {
		CashSalesCreateResponse cashSalesCreateResponse = new CashSalesCreateResponse();

		CashSalesBean cashSalesBean = new CashSalesBean();
		cashSalesBean = iSellItemService.createCashSalesService(cashSalesCreateRequest);
		System.out.println("cashsales/create  "+cashSalesBean);
		if (cashSalesBean != null) {
			cashSalesCreateResponse.setCashSalesBean(cashSalesBean);
			cashSalesCreateResponse.setStatusCode(StatusCodes.OK);
			cashSalesCreateResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			cashSalesCreateResponse.setStatusCode(StatusCodes.NO_CONTENT);
			cashSalesCreateResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return cashSalesCreateResponse;
	}
	
	
}
