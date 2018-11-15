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

import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.reports.keys.service.IDeletedBillReportService;
import com.vyavharamitra.reports.keys.to.request.DeletedBillReportRequest;
import com.vyavharamitra.reports.keys.to.response.DeletedBillReportResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
@Controller
@RequestMapping(value = "/delete")
public class DeletedBillReportController {
	@Autowired
	private IDeletedBillReportService  iDeletedBillReportService;
	
	@RequestMapping(value = "/Delete/Report", method = RequestMethod.POST)
	@ResponseBody
	public DeletedBillReportResponse getdeletereportdetails(@RequestBody DeletedBillReportRequest deletedBillReportRequest) {
		DeletedBillReportResponse deletedBillReportResponse = new DeletedBillReportResponse();
		List<DeleteBillBean> deleteBillBean = Collections.emptyList();
		deleteBillBean= iDeletedBillReportService.getdeletereportdetails(deletedBillReportRequest);
		if (CollectionUtils.isEmpty(deleteBillBean) ){
			deletedBillReportResponse.setStatusCode(StatusCodes.NO_CONTENT);
			deletedBillReportResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
			
			
		} else {
			deletedBillReportResponse.setDeleteBillBean(deleteBillBean);

			deletedBillReportResponse.setStatusCode(StatusCodes.OK);
			deletedBillReportResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return deletedBillReportResponse;
	}
}
