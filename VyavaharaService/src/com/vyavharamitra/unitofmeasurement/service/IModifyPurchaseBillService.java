package com.vyavharamitra.unitofmeasurement.service;

import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.to.request.PurchaseBillRequest;

public interface IModifyPurchaseBillService {
	public PurchaseBillBean purchaseUpdateService(PurchaseBillRequest purchaseBillRequest);
	
	

/*	public PurchaseBillBean deletePurchaseDetailsService(PurchaseBillRequest purchaseBillRequest);
*/	
}