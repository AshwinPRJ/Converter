package com.vyavharamitra.reports.dashboard.to.response;
/**
 * @author : Mohan M
 * @created date : 
 */
import java.util.List;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class DashboardResponse extends VyavaharaResponse{

	private List<DealerRegisterBean> dealerRegisterBean;

	/**
	 * @return the dealerRegisterBean
	 */
	public List<DealerRegisterBean> getDealerRegisterBean() {
		return dealerRegisterBean;
	}

	/**
	 * @param dealerRegisterBean the dealerRegisterBean to set
	 */
	public void setDealerRegisterBean(List<DealerRegisterBean> dealerRegisterBean) {
		this.dealerRegisterBean = dealerRegisterBean;
	}
}
