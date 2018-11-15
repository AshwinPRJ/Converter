package com.vyavharamitra.deletionofbill.to.response;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.utils.VyavaharaResponse;
public class DeleteBillResponse extends VyavaharaResponse{
	
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
