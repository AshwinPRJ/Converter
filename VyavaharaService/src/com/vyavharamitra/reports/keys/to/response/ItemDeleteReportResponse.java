package com.vyavharamitra.reports.keys.to.response;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.itemdetails.beans.DeleteItemMasterBean;
import com.vyavharamitra.utils.VyavaharaResponse;
public class ItemDeleteReportResponse extends VyavaharaResponse {
	private List<DeleteItemMasterBean> deleteItemMasterBean;

	/**
	 * @return the deleteItemMasterBean
	 */
	public List<DeleteItemMasterBean> getDeleteItemMasterBean() {
		return deleteItemMasterBean;
	}

	/**
	 * @param deleteItemMasterBean the deleteItemMasterBean to set
	 */
	public void setDeleteItemMasterBean(List<DeleteItemMasterBean> deleteItemMasterBean) {
		this.deleteItemMasterBean = deleteItemMasterBean;
	}

	
}
