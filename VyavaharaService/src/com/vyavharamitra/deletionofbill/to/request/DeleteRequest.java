package com.vyavharamitra.deletionofbill.to.request;

import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;

import com.vyavharamitra.deletionofbill.bean.DeleteSellitemBean;
/**
 * @author : Lavanya
 * @created date : 31 Jan 2018
 * @modified by :
 * @modified date :
 */
public class DeleteRequest {
	
	private DeleteBillBean deleteBillBean;
	private DeleteSellitemBean deleteSellitemBean;
	public DeleteBillBean getDeleteBillBean() {
		return deleteBillBean;
	}
	public void setDeleteBillBean(DeleteBillBean deleteBillBean) {
		this.deleteBillBean = deleteBillBean;
	}
	public DeleteSellitemBean getDeleteSellitemBean() {
		return deleteSellitemBean;
	}
	public void setDeleteSellitemBean(DeleteSellitemBean deleteSellitemBean) {
		this.deleteSellitemBean = deleteSellitemBean;
	}
	
	
}
