package com.vyavharamitra.reports.bill.to.response;


import java.util.List;

import com.vyavharamitra.cashsales.beans.CashSalesBean;

import com.vyavharamitra.utils.VyavaharaResponse;


/**
 * @author : Lavanya
 * @created date :19 Dec 2017
 * @modified by :
 * @modified date :
 */

public class BillResponse  extends VyavaharaResponse{
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
