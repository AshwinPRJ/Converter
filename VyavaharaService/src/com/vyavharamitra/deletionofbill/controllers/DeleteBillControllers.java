package com.vyavharamitra.deletionofbill.controllers;

import java.util.Collections;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.deletionofbill.service.IDeleteBillService;
import com.vyavharamitra.deletionofbill.to.request.DeleteBillRequest;
import com.vyavharamitra.deletionofbill.to.request.DeleteRequest;
import com.vyavharamitra.deletionofbill.to.response.DeleteBillResponse;
import com.vyavharamitra.deletionofbill.to.response.DeleteResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;


@Controller
@RequestMapping(value = "/delete/bill")
public class DeleteBillControllers {
	@Autowired
	private IDeleteBillService iDeleteBillService;

	@RequestMapping(value="/read", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DeleteBillResponse getSellitemDetails(@RequestBody DeleteBillRequest deleteBillRequest){
		DeleteBillResponse deleteBillResponse = new DeleteBillResponse();
		List<CashSalesBean> cashSalesBean = Collections.emptyList(); 
		cashSalesBean= iDeleteBillService.sellitemFetch(deleteBillRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			deleteBillResponse.setStatusCode(StatusCodes.NO_CONTENT);
			deleteBillResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			deleteBillResponse.setCashSalesBean(cashSalesBean);
			deleteBillResponse.setStatusCode(StatusCodes.OK);
			deleteBillResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return deleteBillResponse;
	}
	

	@RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DeleteResponse create(@RequestBody DeleteRequest deleteRequest){
		DeleteResponse deleteResponse = new DeleteResponse();
		DeleteBillBean deleteBillBean;
		deleteBillBean= iDeleteBillService.create(deleteRequest);
		if (deleteBillBean != null) {

			deleteResponse.setDeleteBillBean(deleteBillBean);
			deleteResponse.setStatusCode(StatusCodes.OK);
			deleteResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			deleteResponse.setStatusCode(StatusCodes.NO_CONTENT);
			deleteResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		
		return deleteResponse;
	}
}
