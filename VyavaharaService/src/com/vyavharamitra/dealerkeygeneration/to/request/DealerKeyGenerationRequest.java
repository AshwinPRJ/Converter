package com.vyavharamitra.dealerkeygeneration.to.request;

import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public class DealerKeyGenerationRequest {

	private DealerKeyGenerationBean dealerKeyGenerationBean;
	private DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean;

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

	/**
	 * @return the dealerKeyGenerationBean
	 */
	public DealerKeyGenerationBean getDealerKeyGenerationBean() {
		return dealerKeyGenerationBean;
	}

	/**
	 * @param dealerKeyGenerationBean the dealerKeyGenerationBean to set
	 */
	public void setDealerKeyGenerationBean(DealerKeyGenerationBean dealerKeyGenerationBean) {
		this.dealerKeyGenerationBean = dealerKeyGenerationBean;
	}
}
