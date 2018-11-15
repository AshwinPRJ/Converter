package com.vyavharamitra.itemdetails.service;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.itemdetails.to.request.ItemMasterRequest;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;


public interface IItemMasterService {
	
	public ItemMasterBean itemMasterCreateService(ItemMasterRequest itemMasterRequest);
	
	public CategoryOfItemBean fetchCategoryDetailsService(ItemMasterRequest itemMasterRequest);

	public UnitOfMeasurementBean fetchUnitMeasurementDetailsService(ItemMasterRequest itemMasterRequest);
	
	public ItemMasterBean updateItemDetailsService(ItemMasterRequest itemMasterRequest);

	public ItemMasterBean deleteItemDetailsService(ItemMasterRequest itemMasterRequest);

}
	