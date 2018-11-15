package com.vyavharamitra.reports.bill.to.request;
import com.vyavharamitra.cashsales.beans.CashSalesHelper;
import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;

/**
 * @author : Lavanya
 * @created date :19 Dec 2017
 * @modified by :
 * @modified date :
 */

public class BillRequest {
	private CashSalesBean cashSalesBean;
	private CashSalesLineBean cashSalesLineBean;
	private CashSalesHelper cashSalesHelper;
	/**
	 * @return the cashSalesBean
	 */
	public CashSalesBean getCashSalesBean() {
		return cashSalesBean;
	}
	/**
	 * @param cashSalesBean the cashSalesBean to set
	 */
	public void setCashSalesBean(CashSalesBean cashSalesBean) {
		this.cashSalesBean = cashSalesBean;
	}
	/**
	 * @return the cashSalesLineBean
	 */
	public CashSalesLineBean getCashSalesLineBean() {
		return cashSalesLineBean;
	}
	/**
	 * @param cashSalesLineBean the cashSalesLineBean to set
	 */
	public void setCashSalesLineBean(CashSalesLineBean cashSalesLineBean) {
		this.cashSalesLineBean = cashSalesLineBean;
	}
	/**
	 * @return the cashSalesHelper
	 */
	public CashSalesHelper getCashSalesHelper() {
		return cashSalesHelper;
	}
	/**
	 * @param cashSalesHelper the cashSalesHelper to set
	 */
	public void setCashSalesHelper(CashSalesHelper cashSalesHelper) {
		this.cashSalesHelper = cashSalesHelper;
	}

}
