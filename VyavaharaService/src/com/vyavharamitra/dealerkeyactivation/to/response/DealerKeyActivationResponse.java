package com.vyavharamitra.dealerkeyactivation.to.response;

import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.utils.VyavaharaResponse;
public class DealerKeyActivationResponse extends VyavaharaResponse {
	private DealerEncyKeyGenerationBean  dealerEncyKeyGenerationBean;

	/**
	 * @return the dealerEncyKeyGenerationBean
	 */
	public DealerEncyKeyGenerationBean getDealerEncyKeyGenerationBean() {
		return dealerEncyKeyGenerationBean;
	}

	/**
	 * @param dealerEncyKeyGenerationBean the dealerEncyKeyGenerationBean to set
	 */
	public void setDealerEncyKeyGenerationBean(DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean) {
		this.dealerEncyKeyGenerationBean = dealerEncyKeyGenerationBean;
	}
	
	 
}