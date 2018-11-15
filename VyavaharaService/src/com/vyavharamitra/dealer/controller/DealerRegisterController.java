package com.vyavharamitra.dealer.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
/**
 * @author : Brahmani
 * @created date : 29 Nov 2017
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
import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealer.service.IdealerRegisterService;
import com.vyavharamitra.dealer.to.request.DealerRegisterRequest;
import com.vyavharamitra.dealer.to.response.DealerRegisterResponse;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping(value = "/dealer")
public class DealerRegisterController {
	@Autowired
	private IdealerRegisterService idealerRegisterService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DealerRegisterResponse dealerCreateController(@RequestBody DealerRegisterRequest dealerRegisterRequest) {
		DealerRegisterResponse dealerRegisterResponse = new DealerRegisterResponse();

		DealerRegisterBean dealerRegisterBean;
		dealerRegisterBean = idealerRegisterService.dealerCreateService(dealerRegisterRequest);
		if (dealerRegisterBean != null) {
			dealerRegisterResponse.setDealerRegisterBean(dealerRegisterBean);
			dealerRegisterResponse.setStatusCode(StatusCodes.OK);
			dealerRegisterResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			dealerRegisterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dealerRegisterResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return dealerRegisterResponse;
	}

	
	@RequestMapping(value = "/readOrgDetails", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DealerRegisterResponse dealersOrgReadController(@RequestBody DealerRegisterRequest dealerRegisterRequest)
	{
		System.out.println("dealer id="+dealerRegisterRequest.getDealerRegisterBean().getDealerId());
		
		DealerRegisterResponse dealerRegisterResponse=new DealerRegisterResponse();
		List<OrganizationMasterBean> organizationMasterBeans ;
		organizationMasterBeans= idealerRegisterService.dealersOrgReadService(dealerRegisterRequest);
		if (CollectionUtils.isEmpty(organizationMasterBeans)) {
			dealerRegisterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dealerRegisterResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			dealerRegisterResponse.setOrganizationMasterBeans(organizationMasterBeans);
			dealerRegisterResponse.setStatusCode(StatusCodes.OK);
			dealerRegisterResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
			
		}
		
		return dealerRegisterResponse;
	}
	
	
	
	
}
