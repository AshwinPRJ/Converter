package com.vyavharamitra.dealerkeyactivation.service;

import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;

import com.vyavharamitra.dealerkeyactivation.to.request.DealerKeyActivationRequest;

/**
 * @author :Lavanya
 * @created date : 07 Dec 2017
 * @modified by :
 * @modified date :
 */

public interface IDealerKeyActivationService {


	public DealerEncyKeyGenerationBean dealerKeyActivationService(DealerKeyActivationRequest DealerKeyActivationRequest) throws Exception;


}
