package com.vyavharamitra.itemdetails.dao;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.itemdetails.beans.DeleteItemMasterBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.organization.bean.ItemVocherGenerationBean;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;

public interface IItemMasterDao {
	
	ItemMasterBean createItemDetailsDao(SessionFactory sessionFactory, ItemMasterBean itemMasterBean);
	
	CategoryOfItemBean fetchCategoryDetailsDao(CategoryOfItemBean categoryOfItemBean, SessionFactory sessionFactory);
	
	UnitOfMeasurementBean fetchUnitMeasurementDetailsDao(UnitOfMeasurementBean unitOfMeasurementBean, SessionFactory sessionFactory);
	
	ItemMasterBean deleteItemDetailsDao(SessionFactory sessionFactory, ItemMasterBean itemMasterBean);

	ItemMasterBean selectItemDetailsDao(SessionFactory sessionFactory, ItemMasterBean itemMasterBean);

	DeleteItemMasterBean createDeleteItemDetailsDao(SessionFactory sessionFactory, DeleteItemMasterBean deleteItemMasterBean);
	
	
	ItemMasterBean updateItemDetailsDao(SessionFactory sessionFactory, ItemMasterBean itemMasterBean);

	ItemVocherGenerationBean createItemNumberDao(SessionFactory sessionFactory, Integer branchID);

	ItemVocherGenerationBean selectItemNumberDao(SessionFactory sessionFactory, Integer branchID);


}
