package com.vyavharamitra.reports.keys.to.response;

import java.util.List;

import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.utils.VyavaharaResponse;

/**
 * @author : lavanya
 * @created date : 18 Dec 2017
 * @modified by :
 * @modified date :
 */

public class DealerKeyResponse extends VyavaharaResponse {

	private List<DealerKeyGenerationBean> dealerKeyGenerationBean;

	/**
	 * @return the dealerKeyGenerationBean
	 */
	public List<DealerKeyGenerationBean> getDealerKeyGenerationBean() {
		return dealerKeyGenerationBean;
	}

	/**
	 * @param dealerKeyGenerationBean the dealerKeyGenerationBean to set
	 */
	public void setDealerKeyGenerationBean(List<DealerKeyGenerationBean> dealerKeyGenerationBean) {
		this.dealerKeyGenerationBean = dealerKeyGenerationBean;
	}

}
