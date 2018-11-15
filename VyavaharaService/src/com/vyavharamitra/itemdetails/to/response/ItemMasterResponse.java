package com.vyavharamitra.itemdetails.to.response;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class ItemMasterResponse extends VyavaharaResponse {
	private ItemMasterBean itemMasterBean;
	private CategoryOfItemBean categoryOfItemBean;
	private UnitOfMeasurementBean unitOfMeasurementBean;

	/**
	 * @return the itemMasterBean
	 */
	public ItemMasterBean getItemMasterBean() {
		return itemMasterBean;
	}

	/**
	 * @param itemMasterBean the itemMasterBean to set
	 */
	public void setItemMasterBean(ItemMasterBean itemMasterBean) {
		this.itemMasterBean = itemMasterBean;
	}

	/**
	 * @return the categoryOfItemBean
	 */
	public CategoryOfItemBean getCategoryOfItemBean() {
		return categoryOfItemBean;
	}

	/**
	 * @param categoryOfItemBean the categoryOfItemBean to set
	 */
	public void setCategoryOfItemBean(CategoryOfItemBean categoryOfItemBean) {
		this.categoryOfItemBean = categoryOfItemBean;
	}

	/**
	 * @return the unitOfMeasurementBean
	 */
	public UnitOfMeasurementBean getUnitOfMeasurementBean() {
		return unitOfMeasurementBean;
	}

	/**
	 * @param unitOfMeasurementBean the unitOfMeasurementBean to set
	 */
	public void setUnitOfMeasurementBean(UnitOfMeasurementBean unitOfMeasurementBean) {
		this.unitOfMeasurementBean = unitOfMeasurementBean;
	}

	
}
