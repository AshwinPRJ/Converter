package com.vyavharamitra.unitofmeasurement.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchasedItemBean;
import com.vyavharamitra.unitofmeasurement.to.request.PurchaseBillRequest;

public interface IModifyPurchaseBillDao {
	PurchaseBillBean purchaseUpdateDao(SessionFactory sessionFactory,PurchaseBillBean purchaseBillBean, List<PurchasedItemBean> list);
	/*PurchaseBillBean deletePurchaseDetailsDao(SessionFactory sessionFactory, PurchaseBillRequest purchaseBillRequest);*/
	

	

}
