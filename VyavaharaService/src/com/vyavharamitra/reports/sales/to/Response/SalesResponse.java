package com.vyavharamitra.reports.sales.to.Response;
/**
 * @author : Mohan M
 * @created date : 
 */
import java.util.List;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class SalesResponse extends VyavaharaResponse{
	private List<CashSalesBean> cashSalesBean;
	private List<CashSalesLineBean> cashSalesLineBean;
	private List<ItemMasterBean> itemMasterBean;
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
	/**
	 * @return the cashSalesLineBean
	 */
	public List<CashSalesLineBean> getCashSalesLineBean() {
		return cashSalesLineBean;
	}
	/**
	 * @param cashSalesLineBean the cashSalesLineBean to set
	 */
	public void setCashSalesLineBean(List<CashSalesLineBean> cashSalesLineBean) {
		this.cashSalesLineBean = cashSalesLineBean;
	}
	/**
	 * @return the itemMasterBean
	 */
	public List<ItemMasterBean> getItemMasterBean() {
		return itemMasterBean;
	}
	/**
	 * @param itemMasterBean the itemMasterBean to set
	 */
	public void setItemMasterBean(List<ItemMasterBean> itemMasterBean) {
		this.itemMasterBean = itemMasterBean;
	}
}
