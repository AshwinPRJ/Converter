package com.vyavharamitra.search.to.response;

import java.util.List;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class UserMobileSearchResponse extends VyavaharaResponse{
	private List<CashSalesBean> cashSalesBean;

	/**
	 * @return the cashSalesBean
	 */
	public List<CashSalesBean> getCashSalesBean() {
		return cashSalesBean;
	}

	/**
	 * @param cashSalesBean the cashSalesBean to set
	 */
	public void setCashSalesBean(List<CashSalesBean> cashSalesBean) {
		this.cashSalesBean = cashSalesBean;
	}

	
}
