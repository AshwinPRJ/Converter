package com.vyavharamitra.reports.keys.to.request;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.itemdetails.beans.DeleteItemMasterBean;
import com.vyavharamitra.itemdetails.beans.UpdateItemMasterBean;

public class ItemModifyReportRequest {
	private UpdateItemMasterBean updateItemMasterBean;

	private DeleteItemMasterBean deleteItemMasterBean;
	
	/**
	 * @return the deleteItemMasterBean
	 */
	public DeleteItemMasterBean getDeleteItemMasterBean() {
		return deleteItemMasterBean;
	}

	/**
	 * @param deleteItemMasterBean the deleteItemMasterBean to set
	 */
	public void setDeleteItemMasterBean(DeleteItemMasterBean deleteItemMasterBean) {
		this.deleteItemMasterBean = deleteItemMasterBean;
	}

	/**
	 * @return the updateItemMasterBean
	 */
	public UpdateItemMasterBean getUpdateItemMasterBean() {
		return updateItemMasterBean;
	}

	/**
	 * @param updateItemMasterBean the updateItemMasterBean to set
	 */
	public void setUpdateItemMasterBean(UpdateItemMasterBean updateItemMasterBean) {
		this.updateItemMasterBean = updateItemMasterBean;
	}
	
	
}
