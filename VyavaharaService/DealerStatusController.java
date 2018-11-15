package com.vyavharamitra.dealer.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealer.service.IdealerStatusService;
import com.vyavharamitra.dealer.to.request.DealerRegisterRequest;
import com.vyavharamitra.dealer.to.request.DealerStatusRequest;
import com.vyavharamitra.dealer.to.response.DealerStatusResponse;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
@Controller
@RequestMapping(value = "/dealerstatus")
public class DealerStatusController {
	@Autowired
	private IdealerStatusService idealerStatusService;


	@RequestMapping(value = "/dealerstatus", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DealerStatusResponse dealerstatusController(@RequestBody DealerStatusRequest dealerStatusRequest) {
		DealerStatusResponse dealerStatusResponse = new DealerStatusResponse();
		UserCreationBean userCreationBean;
		userCreationBean=idealerStatusService.dealerUpdateService(dealerStatusRequest);
		if (userCreationBean != null) {
			dealerStatusResponse.setUserCreationBean(userCreationBean);
			dealerStatusResponse.setStatusCode(StatusCodes.OK);
			dealerStatusResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);		
			}else{
				dealerStatusResponse.setStatusCode(StatusCodes.NO_CONTENT);
				dealerStatusResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
			}
		return dealerStatusResponse;
	}

	
	
	/**
	 * read category of item
	 * @param dealerRegisterRequest
	 * @return
	 */

	@RequestMapping(value = "/read", method = RequestMethod.POST)
	@ResponseBody
	public List<DealerRegisterBean> dealerRegisterReadController(@RequestBody DealerRegisterRequest dealerRegisterRequest ) {
		return idealerStatusService.dealerRegisterReadService(dealerRegisterRequest.getDealerRegisterBean().getDealerId());
		
	}
	
	
	
}
