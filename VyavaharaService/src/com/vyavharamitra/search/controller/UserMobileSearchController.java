package com.vyavharamitra.search.controller;

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
import com.vyavharamitra.search.service.IUserMobileSearchService;
import com.vyavharamitra.search.to.request.UserMobileSearchRequest;
import com.vyavharamitra.search.to.response.UserMobileSearchResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping(value="/user")
public class UserMobileSearchController {
	@Autowired
	private IUserMobileSearchService iUserMobileSearchService;
	@RequestMapping(value = "/mobile", method = RequestMethod.POST)
	@ResponseBody
	public UserMobileSearchResponse getUserMobileonblur(@RequestBody UserMobileSearchRequest userMobileSearchRequest) {
		UserMobileSearchResponse userMobileSearchResponse=new UserMobileSearchResponse();
		List<CashSalesBean> cashSalesBean = Collections.emptyList();
		cashSalesBean = iUserMobileSearchService.getUserMobileonblur(userMobileSearchRequest);
		if (CollectionUtils.isEmpty(cashSalesBean)) {
			userMobileSearchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			userMobileSearchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			userMobileSearchResponse.setCashSalesBean(cashSalesBean);
			userMobileSearchResponse.setStatusCode(StatusCodes.OK);
			userMobileSearchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
		}
		return userMobileSearchResponse;
	}

}
