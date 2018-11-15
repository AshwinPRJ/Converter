package com.vyavharamitra.reports.keys.to.response;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.deletionofbill.bean.DeleteSellitemBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.utils.VyavaharaResponse;
public class DeletedBillReportResponse extends VyavaharaResponse{
	private List<DeleteBillBean> deleteBillBean;
	private List<DeleteSellitemBean> deleteSellitemBean;
	private List<ItemMasterBean> itemMasterBean;
	/**
	 * @return the deleteBillBean
	 */
	public List<DeleteBillBean> getDeleteBillBean() {
		return deleteBillBean;
	}
	/**
	 * @param deleteBillBean the deleteBillBean to set
	 */
	public void setDeleteBillBean(List<DeleteBillBean> deleteBillBean) {
		this.deleteBillBean = deleteBillBean;
	}
	/**
	 * @return the deleteSellitemBean
	 */
	public List<DeleteSellitemBean> getDeleteSellitemBean() {
		return deleteSellitemBean;
	}
	/**
	 * @param deleteSellitemBean the deleteSellitemBean to set
	 */
	public void setDeleteSellitemBean(List<DeleteSellitemBean> deleteSellitemBean) {
		this.deleteSellitemBean = deleteSellitemBean;
	}
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
