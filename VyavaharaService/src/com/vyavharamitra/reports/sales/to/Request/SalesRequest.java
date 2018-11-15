package com.vyavharamitra.reports.sales.to.Request;
/**
 * @author : Mohan M
 * @created date : 
 */
import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;

public class SalesRequest {
private CashSalesBean cashSalesBean;
private CashSalesLineBean cashSalesLineBean;
private ItemMasterBean itemMasterBean;
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
 * @return the itemMasterBean
 */
public ItemMasterBean getItemMasterBean() {
	return itemMasterBean;
}
/**
 * @param itemMasterBean the itemMasterBean to set
 */
public void setItemMasterBean(ItemMasterBean itemMasterBean) {
	this.itemMasterBean = itemMasterBean;
}
}
