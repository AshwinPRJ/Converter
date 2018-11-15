package com.vyavharamitra.cashsales.to.request;

/**
 * @author : Brahmani
 * @created date : 28 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.organization.bean.BillVocherGenerationBean;

public class CashSalesCreateRequest {
	private CashSalesBean cashSalesBean;
	private CashSalesLineBean cashSalesLineBean;
	private List<CashSalesLineBean> cashSalesLineBeanList;
	private BillVocherGenerationBean billVocherGenerationBean;

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
	 * @return the cashSalesLineBeanList
	 */
	public List<CashSalesLineBean> getCashSalesLineBeanList() {
		return cashSalesLineBeanList;
	}

	/**
	 * @param cashSalesLineBeanList
	 *            the cashSalesLineBeanList to set
	 */
	public void setCashSalesLineBeanList(List<CashSalesLineBean> cashSalesLineBeanList) {
		this.cashSalesLineBeanList = cashSalesLineBeanList;
	}

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

}
