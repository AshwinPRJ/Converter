package com.vyavharamitra.unitofmeasurement.service;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.to.request.PurchaseBillRequest;
import com.vyavharamitra.unitofmeasurement.to.response.HelperPurchaseBean;
import com.vyavharamitra.unitofmeasurement.to.response.PurchaseBillResponse;

public interface IPurchaseBillService {
	

	public PurchaseBillBean purchaseCreateService(PurchaseBillRequest purchaseBillRequest);

	public HelperPurchaseBean purchaseFetchService(PurchaseBillRequest purchaseBillRequest);

	
	
	



	






}
