package com.vyavharamitra.unitofmeasurement.dao;
import java.util.List;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchasedItemBean;
import com.vyavharamitra.unitofmeasurement.to.request.PurchaseBillRequest;
import com.vyavharamitra.unitofmeasurement.to.response.HelperPurchaseBean;

public interface IPurchaseBillDao {
	
	PurchaseBillBean purchaseCreateDao(SessionFactory sessionFactory, PurchaseBillBean purchaseBillBean, List<PurchasedItemBean> list);
	
	HelperPurchaseBean purchaseFetch(SessionFactory sessionFactory, PurchaseBillRequest purchaseBillRequest );


	
}



