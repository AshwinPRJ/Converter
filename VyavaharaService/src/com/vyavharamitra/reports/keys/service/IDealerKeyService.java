package com.vyavharamitra.reports.keys.service;

import java.util.List;

import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.reports.keys.to.request.DealerKeyRequest;


/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */


public interface IDealerKeyService {

	public List<DealerKeyGenerationBean> dealerKeyService(DealerKeyRequest dealerKeyRequest);

	public List<DealerKeyGenerationBean> dealerKeyStatusService(DealerKeyRequest dealerKeyRequest);


}



