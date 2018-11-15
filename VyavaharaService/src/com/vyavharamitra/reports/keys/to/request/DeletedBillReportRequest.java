package com.vyavharamitra.reports.keys.to.request;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.deletionofbill.bean.DeleteSellitemBean;

public class DeletedBillReportRequest {
	private DeleteBillBean deleteBillBean;
	private DeleteSellitemBean deleteSellitemBean;
	
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
	

}
