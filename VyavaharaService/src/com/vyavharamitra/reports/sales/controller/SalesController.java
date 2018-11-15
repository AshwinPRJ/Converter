package com.vyavharamitra.reports.sales.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.reports.sales.service.ISalesService;
import com.vyavharamitra.reports.sales.to.Request.SalesRequest;
import com.vyavharamitra.reports.sales.to.Response.SalesResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Mohan M
 * @created date : 
 */
@Controller
@RequestMapping(value = "/sales")
public class SalesController {
	@Autowired
	private ISalesService iSalesService;
	
	/**
	 * 
	 * Sales by Branch report
	 * @param salesRequest
	 * @return
	 */
	@RequestMapping(value = "/bybranch", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public SalesResponse salesByBranch(@RequestBody SalesRequest salesRequest) {
	
		SalesResponse salesResponse = new SalesResponse();
		List<CashSalesBean> cashSalesBean = Collections.emptyList();

		cashSalesBean=iSalesService.salesByBranch(salesRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			
			salesResponse.setStatusCode(StatusCodes.NO_CONTENT);
			salesResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		
		}
		else
		{
			salesResponse.setCashSalesBean(cashSalesBean);
			salesResponse.setStatusCode(StatusCodes.OK);
			salesResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return salesResponse;
	}
	
	/**
	 * 
	 * Sales Summary Report 
	 * @param salesRequest
	 * @return
	 */

	@RequestMapping(value = "/summery", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public SalesResponse salesSummery(@RequestBody SalesRequest salesRequest) {
	
		SalesResponse salesResponse = new SalesResponse();
		List<CashSalesBean> cashSalesBean = Collections.emptyList();

		cashSalesBean=iSalesService.salesSummery(salesRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			salesResponse.setStatusCode(StatusCodes.NO_CONTENT);
			salesResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		
		}
		else
		{
			salesResponse.setCashSalesBean(cashSalesBean);
			salesResponse.setStatusCode(StatusCodes.OK);
			salesResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return salesResponse;
	}
	
	/**
	 * 
	 * Sales Summary Report By Date Range
	 * @param salesRequest
	 * @return
	 */

	@RequestMapping(value = "/bydate", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public SalesResponse salesSummeryByDate(@RequestBody SalesRequest salesRequest) {
	
		SalesResponse salesResponse = new SalesResponse();
		List<CashSalesBean> cashSalesBean = Collections.emptyList();

		cashSalesBean=iSalesService.salesSummeryByDate(salesRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			salesResponse.setStatusCode(StatusCodes.NO_CONTENT);
			salesResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		
		}
		else
		{
			salesResponse.setCashSalesBean(cashSalesBean);
			salesResponse.setStatusCode(StatusCodes.OK);
			salesResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return salesResponse;
	}
	
	
	
	
	/**
	 * 
	 * Sales Summary Report By Customer
	 * @param salesRequest
	 * @return
	 */

	@RequestMapping(value = "/bycustomer", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public SalesResponse salesSummeryByCustomer(@RequestBody SalesRequest salesRequest) {
	
		SalesResponse salesResponse = new SalesResponse();
		List<CashSalesBean> cashSalesBean = Collections.emptyList();

		cashSalesBean=iSalesService.salesSummeryByCustomer(salesRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			salesResponse.setStatusCode(StatusCodes.NO_CONTENT);
			salesResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		
		}
		else
		{
			salesResponse.setCashSalesBean(cashSalesBean);
			salesResponse.setStatusCode(StatusCodes.OK);
			salesResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return salesResponse;
	}
	
	
	/**
	 * 
	 * Sales Summary Report[Round numbers]
	 * @param salesRequest
	 * @return
	 */

	@RequestMapping(value = "/billsummery", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public SalesResponse salesSummerybillsummery(@RequestBody SalesRequest salesRequest) {
	
		SalesResponse salesResponse = new SalesResponse();
		List<CashSalesBean> cashSalesBean = Collections.emptyList();

		cashSalesBean=iSalesService.salesSummerybillsummery(salesRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			salesResponse.setStatusCode(StatusCodes.NO_CONTENT);
			salesResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		
		}
		else
		{
			salesResponse.setCashSalesBean(cashSalesBean);
			salesResponse.setStatusCode(StatusCodes.OK);
			salesResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return salesResponse;
	}
	
	/**
	 * 
	 * One item Quantity B/W Dates 
	 * @param Quantity
	 * @return
	 */

	@RequestMapping(value = "/Quantity", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public SalesResponse salesSummeryQuantity(@RequestBody SalesRequest salesRequest) {
	
		SalesResponse salesResponse = new SalesResponse();
		List<CashSalesBean> cashSalesBean = Collections.emptyList();

		cashSalesBean=iSalesService.salesSummeryQuantity(salesRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			salesResponse.setStatusCode(StatusCodes.NO_CONTENT);
			salesResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		
		}
		else
		{
			salesResponse.setCashSalesBean(cashSalesBean);
			salesResponse.setStatusCode(StatusCodes.OK);
			salesResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return salesResponse;
	}
	
	
	
	}



