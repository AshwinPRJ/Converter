package com.vyavharamitra.cashsales.to.response;

/**
 * @author : Brahmani
 * @created date : 28 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.organization.bean.BillVocherGenerationBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class CashSalesCreateResponse extends VyavaharaResponse {

	private CashSalesBean cashSalesBean;
	private CashSalesLineBean cashSalesLineBean;
	private ItemMasterBean itemMasterBean;
	private BillVocherGenerationBean billVocherGenerationBean;

	/**
	 * @return the billVocherGenerationBean
	 */
	public BillVocherGenerationBean getBillVocherGenerationBean() {
		return billVocherGenerationBean;
	}

	/**
	 * @param billVocherGenerationBean the billVocherGenerationBean to set
	 */
	public void setBillVocherGenerationBean(BillVocherGenerationBean billVocherGenerationBean) {
		this.billVocherGenerationBean = billVocherGenerationBean;
	}

	/**
	 * @return the cashSalesBean
	 */
	public CashSalesBean getCashSalesBean() {
		return cashSalesBean;
	}

	/**
	 * @param cashSalesBean
	 *            the cashSalesBean to set
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
	 * @param cashSalesLineBean
	 *            the cashSalesLineBean to set
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
	 * @param itemMasterBean
	 *            the itemMasterBean to set
	 */
	public void setItemMasterBean(ItemMasterBean itemMasterBean) {
		this.itemMasterBean = itemMasterBean;
	}

}
