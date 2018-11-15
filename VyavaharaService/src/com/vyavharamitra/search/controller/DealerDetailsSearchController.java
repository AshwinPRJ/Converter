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

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.search.service.IDealerDetailsSearchService;
import com.vyavharamitra.search.to.request.DealerDetailsSearchRequest;
import com.vyavharamitra.search.to.response.DealerDetailsSearchResponce;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : mohan
 * @created date :29 Nov 2017
 * @modified by :
 * @modified date :
 */
@Controller
@RequestMapping(value = "/dealerdetails")
public class DealerDetailsSearchController {
	@Autowired
	private IDealerDetailsSearchService iDealerDetailsSearchService;
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@ResponseBody
	public DealerDetailsSearchResponce getDealerDetailsSearch() {
		DealerDetailsSearchResponce dealerDetailsSearchResponce = new DealerDetailsSearchResponce();
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		dealerRegisterBean = iDealerDetailsSearchService.getDealerDetails();
		if (CollectionUtils.isEmpty(dealerRegisterBean)) {
			dealerDetailsSearchResponce.setStatusCode(StatusCodes.NO_CONTENT);
			dealerDetailsSearchResponce.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			dealerDetailsSearchResponce.setDealerRegisterBean(dealerRegisterBean);
			dealerDetailsSearchResponce.setStatusCode(StatusCodes.OK);
			dealerDetailsSearchResponce.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
		}
		return dealerDetailsSearchResponce;
	}
	
	
	@RequestMapping(value = "/read/single/record", method = RequestMethod.POST)
	@ResponseBody
	public DealerDetailsSearchResponce getDealerDetailsonblur(@RequestBody DealerDetailsSearchRequest dealerDetailsSearchRequest) {
		
		DealerDetailsSearchResponce dealerDetailsSearchResponce=new DealerDetailsSearchResponce();
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		dealerRegisterBean = iDealerDetailsSearchService.getDealerDetailsonblur(dealerDetailsSearchRequest);
		if (CollectionUtils.isEmpty(dealerRegisterBean)) {
			dealerDetailsSearchResponce.setStatusCode(StatusCodes.NO_CONTENT);
			dealerDetailsSearchResponce.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			dealerDetailsSearchResponce.setDealerRegisterBean(dealerRegisterBean);

			dealerDetailsSearchResponce.setStatusCode(StatusCodes.OK);
			dealerDetailsSearchResponce.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
		}
		return dealerDetailsSearchResponce;
	}
	
}
