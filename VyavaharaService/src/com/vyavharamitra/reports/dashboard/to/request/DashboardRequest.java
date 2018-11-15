package com.vyavharamitra.reports.dashboard.to.request;
/**
 * @author : Mohan M
 * @created date : 
 */
import com.vyavharamitra.dealer.bean.DealerRegisterBean;

public class DashboardRequest {

	private DealerRegisterBean dealerRegisterBean;

	/**
	 * @return the dealerRegisterBean
	 */
	public DealerRegisterBean getDealerRegisterBean() {
		return dealerRegisterBean;
	}

	/**
	 * @param dealerRegisterBean the dealerRegisterBean to set
	 */
	public void setDealerRegisterBean(DealerRegisterBean dealerRegisterBean) {
		this.dealerRegisterBean = dealerRegisterBean;
	}
}
