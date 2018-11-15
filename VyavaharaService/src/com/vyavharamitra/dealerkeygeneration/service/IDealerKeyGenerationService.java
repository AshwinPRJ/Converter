package com.vyavharamitra.dealerkeygeneration.service;

/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.to.request.DealerKeyGenerationRequest;

public interface IDealerKeyGenerationService {

	public DealerKeyGenerationBean dealerKeyGenerationCreateService(
			DealerKeyGenerationRequest dealerKeyGenerationRequest);

}
