package com.vyavharamitra.search.to.response;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class ItemDetailsSearchResponse extends VyavaharaResponse{

	private List<ItemMasterBean> itemMasterBean;

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
