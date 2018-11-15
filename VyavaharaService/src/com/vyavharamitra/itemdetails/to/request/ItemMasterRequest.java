package com.vyavharamitra.itemdetails.to.request;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;


public class ItemMasterRequest {
	private ItemMasterBean itemMasterBean;
	private CategoryOfItemBean categoryOfItemBean;
	private UnitOfMeasurementBean unitOfMeasurementBean;

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

	public ItemMasterBean getItemMasterBean() {
		return itemMasterBean;
	}

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

	
}
