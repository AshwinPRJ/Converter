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

import com.vyavharamitra.reports.keys.service.IDealerReportService;
import com.vyavharamitra.reports.keys.to.request.DealerReportRequest;
import com.vyavharamitra.reports.keys.to.response.DealerReportResponse;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
@Controller
@RequestMapping(value = "/Dealer")
public class DealerReportController {
	@Autowired
	private IDealerReportService iDealerReportService;
	
	@RequestMapping(value = "/Report", method = RequestMethod.POST)
	@ResponseBody
	public DealerReportResponse getdealerreportdetails(@RequestBody DealerReportRequest dealerReportRequest) {
		
		DealerReportResponse dealerSearchResponse = new DealerReportResponse();
		List<UserCreationBean> userCreationBean = Collections.emptyList();
		userCreationBean= iDealerReportService.getdealerreportdetails(dealerReportRequest);
		if (CollectionUtils.isEmpty(userCreationBean) ){
			dealerSearchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dealerSearchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
			
			
		} else {
			dealerSearchResponse.setUserCreationBean(userCreationBean);

			dealerSearchResponse.setStatusCode(StatusCodes.OK);
			dealerSearchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dealerSearchResponse;
	}
}



