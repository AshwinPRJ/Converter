package com.vyavharamitra.reports.keys.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.reports.keys.service.IDealerKeyService;
import com.vyavharamitra.reports.keys.to.request.DealerKeyRequest;
import com.vyavharamitra.reports.keys.to.response.DealerKeyResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */

@Controller
/* @CrossOrigin(origins = VyavaharaConstants.URL) */
@RequestMapping(value = "/key")
public class DealerKeyController {
	@Autowired
	private IDealerKeyService iDealerKeyService;
	/**
	 * Read Total Keys
	 */
	@RequestMapping(value = "/read/total", method = RequestMethod.POST)
	@ResponseBody
	public DealerKeyResponse dealerKeyController(@RequestBody DealerKeyRequest dealerKeyRequest) {
		DealerKeyResponse dealerKeyResponse = new DealerKeyResponse();
		List<DealerKeyGenerationBean> dealerKeyGenerationBean;
		dealerKeyGenerationBean = iDealerKeyService
				.dealerKeyService(dealerKeyRequest);
		if (CollectionUtils.isEmpty(dealerKeyGenerationBean)) {
			dealerKeyResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dealerKeyResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			dealerKeyResponse.setDealerKeyGenerationBean(dealerKeyGenerationBean);
			dealerKeyResponse.setStatusCode(StatusCodes.OK);
			dealerKeyResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dealerKeyResponse;
	}
	/**
	 * Read Key Status
	 */
	@RequestMapping(value = "/read/status", method = RequestMethod.POST)
	@ResponseBody
	public DealerKeyResponse dealerKeyStatusController(@RequestBody DealerKeyRequest dealerKeyRequest) {
		DealerKeyResponse dealerKeyResponse = new DealerKeyResponse();
		List<DealerKeyGenerationBean> dealerKeyGenerationBean;
		dealerKeyGenerationBean = iDealerKeyService.dealerKeyStatusService(dealerKeyRequest);
		if (CollectionUtils.isEmpty(dealerKeyGenerationBean)) {
			dealerKeyResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dealerKeyResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			dealerKeyResponse.setDealerKeyGenerationBean(dealerKeyGenerationBean);
			dealerKeyResponse.setStatusCode(StatusCodes.OK);
			dealerKeyResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dealerKeyResponse;
	}

}