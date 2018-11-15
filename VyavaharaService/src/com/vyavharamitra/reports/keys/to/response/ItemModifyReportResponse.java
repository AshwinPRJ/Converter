package com.vyavharamitra.reports.keys.to.response;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.itemdetails.beans.UpdateItemMasterBean;
import com.vyavharamitra.utils.VyavaharaResponse;


public class ItemModifyReportResponse extends VyavaharaResponse{
	private List<UpdateItemMasterBean> updateItemMasterBean;
	


	/**
	 * @return the updateItemMasterBean
	 */
	public List<UpdateItemMasterBean> getUpdateItemMasterBean() {
		return updateItemMasterBean;
	}

	/**
	 * @param updateItemMasterBean the updateItemMasterBean to set
	 */
	public void setUpdateItemMasterBean(List<UpdateItemMasterBean> updateItemMasterBean) {
		this.updateItemMasterBean = updateItemMasterBean;
	}
	

}
