package com.vyavharamitra.dealerkeygeneration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.service.IDealerKeyGenerationService;
import com.vyavharamitra.dealerkeygeneration.to.request.DealerKeyGenerationRequest;
import com.vyavharamitra.dealerkeygeneration.to.response.DealerKeyGenerationResopnse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
@Controller
@RequestMapping(value = "/keygeneration")
public class DealerKeyGenerationController {

	@Autowired
	private IDealerKeyGenerationService iDealerKeyGenerationService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DealerKeyGenerationResopnse dealerKeyGenerationCreateController(@RequestBody DealerKeyGenerationRequest dealerKeyGenerationRequest) {
		
		DealerKeyGenerationResopnse dealerKeyGenerationResopnse = new DealerKeyGenerationResopnse();

		DealerKeyGenerationBean dealerKeyGenerationBean;
		dealerKeyGenerationBean = iDealerKeyGenerationService.dealerKeyGenerationCreateService(dealerKeyGenerationRequest);
		
		if (dealerKeyGenerationBean != null) {
			dealerKeyGenerationResopnse.setStatusCode(StatusCodes.OK);
			dealerKeyGenerationResopnse.setStatusMessage("Keys Generated Successfully");
		} else {
			dealerKeyGenerationResopnse.setStatusCode(StatusCodes.NO_CONTENT);
			dealerKeyGenerationResopnse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}

		return dealerKeyGenerationResopnse;
	}
}
