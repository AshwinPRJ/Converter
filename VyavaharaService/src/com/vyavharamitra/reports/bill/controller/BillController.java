package com.vyavharamitra.reports.bill.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.reports.bill.service.IBillService;
import com.vyavharamitra.reports.bill.to.request.BillRequest;
import com.vyavharamitra.reports.bill.to.response.BillResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;


/**
 * @author : Lavanya
 * @created date :19 Dec 2017
 * @modified by :
 * @modified date :
 */
@Controller
/*@CrossOrigin(origins = VyavaharaConstants.URL)*/
@RequestMapping(value = "/bill")
public class BillController {
	@Autowired
	private IBillService iBillService;

	@RequestMapping(value = "/read", method = RequestMethod.POST)
	@ResponseBody
	public BillResponse billReadController1(@RequestBody BillRequest billRequest ) {
		BillResponse billResponse=new BillResponse();	
		List<CashSalesBean> cashSalesBean ;
		cashSalesBean= iBillService.billReadService1(billRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			billResponse.setStatusCode(StatusCodes.NO_CONTENT);
			billResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			billResponse.setCashSalesBean(cashSalesBean);
			billResponse.setStatusCode(StatusCodes.OK);
			billResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return billResponse;
	}
	
	
	@RequestMapping(value = "/read/header", method = RequestMethod.POST)
	@ResponseBody
	public BillResponse billReadController2(@RequestBody BillRequest billRequest ) {
		BillResponse billResponse=new BillResponse();	
		List<CashSalesBean> cashSalesBean ;
		cashSalesBean= iBillService.billReadService2(billRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			billResponse.setStatusCode(StatusCodes.NO_CONTENT);
			billResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			billResponse.setCashSalesBean(cashSalesBean);
			billResponse.setStatusCode(StatusCodes.OK);
			billResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return billResponse;
	}
	@RequestMapping(value = "/read/itemlist", method = RequestMethod.POST)
	@ResponseBody
	public BillResponse billReadController3(@RequestBody BillRequest billRequest ) {
		BillResponse billResponse=new BillResponse();	
		List<CashSalesBean> cashSalesBean ;
		cashSalesBean= iBillService.billReadService3(billRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			billResponse.setStatusCode(StatusCodes.NO_CONTENT);
			billResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			billResponse.setCashSalesBean(cashSalesBean);
			billResponse.setStatusCode(StatusCodes.OK);
			billResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return billResponse;
	}
	@RequestMapping(value = "/read/gst", method = RequestMethod.POST)
	@ResponseBody
	public BillResponse billReadController4(@RequestBody BillRequest billRequest ) {
		BillResponse billResponse=new BillResponse();	
		List<CashSalesBean> cashSalesBean ;
		cashSalesBean= iBillService.billReadService4(billRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			billResponse.setStatusCode(StatusCodes.NO_CONTENT);
			billResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			billResponse.setCashSalesBean(cashSalesBean);
			billResponse.setStatusCode(StatusCodes.OK);
			billResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return billResponse;
	}
	@RequestMapping(value = "/read/generatedby", method = RequestMethod.POST)
	@ResponseBody
	public BillResponse billReadController5(@RequestBody BillRequest billRequest ) {
		BillResponse billResponse=new BillResponse();	
		List<CashSalesBean> cashSalesBean ;
		cashSalesBean= iBillService.billReadService5(billRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			billResponse.setStatusCode(StatusCodes.NO_CONTENT);
			billResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			billResponse.setCashSalesBean(cashSalesBean);
			billResponse.setStatusCode(StatusCodes.OK);
			billResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return billResponse;
	}
	@RequestMapping(value = "/read/greetings", method = RequestMethod.POST)
	@ResponseBody
	public BillResponse billReadController6(@RequestBody BillRequest billRequest ) {
		BillResponse billResponse=new BillResponse();	
		List<CashSalesBean> cashSalesBean ;
		cashSalesBean= iBillService.billReadService6(billRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			billResponse.setStatusCode(StatusCodes.NO_CONTENT);
			billResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			billResponse.setCashSalesBean(cashSalesBean);
			billResponse.setStatusCode(StatusCodes.OK);
			billResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return billResponse;
	}
	@RequestMapping(value = "/deatils/read", method = RequestMethod.POST)
	@ResponseBody
	public BillResponse billController(@RequestBody BillRequest billRequest ) {
		BillResponse billResponse=new BillResponse();	
		List<CashSalesBean> cashSalesBean ;
		cashSalesBean= iBillService.billService(billRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			billResponse.setStatusCode(StatusCodes.NO_CONTENT);
			billResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			billResponse.setCashSalesBean(cashSalesBean);
			billResponse.setStatusCode(StatusCodes.OK);
			billResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return billResponse;
	}


}
