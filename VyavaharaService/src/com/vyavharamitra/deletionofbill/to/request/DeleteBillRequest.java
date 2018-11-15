package com.vyavharamitra.deletionofbill.to.request;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.deletionofbill.bean.DeleteSellitemBean;

public class DeleteBillRequest {
	
	private DeleteBillBean deleteBillBean;
	private DeleteSellitemBean deleteSellitemBean;
	private CashSalesBean cashSalesBean;
	private CashSalesLineBean cashSalesLineBean;
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
	 * @return the deleteBillBean
	 */
	public DeleteBillBean getDeleteBillBean() {
		return deleteBillBean;
	}
	/**
	 * @param deleteBillBean the deleteBillBean to set
	 */
	public void setDeleteBillBean(DeleteBillBean deleteBillBean) {
		this.deleteBillBean = deleteBillBean;
	}
	/**
	 * @return the deleteSellitemBean
	 */
	public DeleteSellitemBean getDeleteSellitemBean() {
		return deleteSellitemBean;
	}
	/**
	 * @param deleteSellitemBean the deleteSellitemBean to set
	 */
	public void setDeleteSellitemBean(DeleteSellitemBean deleteSellitemBean) {
		this.deleteSellitemBean = deleteSellitemBean;
	}
	
	

	
	
}
