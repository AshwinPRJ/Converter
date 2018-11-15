package com.vyavharamitra.dealerkeyactivation.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.dealerkeyactivation.service.IDealerKeyActivationService;
import com.vyavharamitra.dealerkeyactivation.to.request.DealerKeyActivationRequest;
import com.vyavharamitra.dealerkeyactivation.to.response.DealerKeyActivationResponse;
import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author :Lavanya
 * @created date : 07 Dec 2017
 * @modified by :
 * @modified date :
 */

@Controller
@RequestMapping(value = "/keyactivation")
public class DealerKeyActivationController {

	@Autowired
	private IDealerKeyActivationService iDealerKeyActivationService;
	@RequestMapping(value = "/dealer", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DealerKeyActivationResponse dealerKeyActivationController(@RequestBody DealerKeyActivationRequest dealerKeyActivationRequest) throws Exception {
		DealerKeyActivationResponse dealerKeyActivationResponse = new DealerKeyActivationResponse();
		DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean;
		dealerEncyKeyGenerationBean=iDealerKeyActivationService.dealerKeyActivationService(dealerKeyActivationRequest);
		if (dealerEncyKeyGenerationBean != null) {
			dealerKeyActivationResponse.setDealerEncyKeyGenerationBean(dealerEncyKeyGenerationBean);
			dealerKeyActivationResponse.setStatusCode(StatusCodes.OK);
			dealerKeyActivationResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		} else {
			dealerKeyActivationResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dealerKeyActivationResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		}
		return dealerKeyActivationResponse;
	}

}
