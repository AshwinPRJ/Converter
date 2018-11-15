package com.vyavharamitra.unitofmeasurement.service.implementation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.dao.IModifyPurchaseBillDao;
import com.vyavharamitra.unitofmeasurement.service.IModifyPurchaseBillService;
import com.vyavharamitra.unitofmeasurement.to.request.PurchaseBillRequest;

import resources.HibernateUtil;
@Service
public class ModifyPurchaseBillServiceImp implements IModifyPurchaseBillService{
	@Autowired
	private IModifyPurchaseBillDao iModifyPurchaseBillDao;
	protected SessionFactory sessionFactory;
	
	
	public ModifyPurchaseBillServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public PurchaseBillBean purchaseUpdateService(PurchaseBillRequest purchaseBillRequest) {
		

		return iModifyPurchaseBillDao.purchaseUpdateDao(sessionFactory, purchaseBillRequest.getPurchaseBillBean(), purchaseBillRequest.getPurchasedItemBean());
	}

/*
	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public PurchaseBillBean deletePurchaseDetailsService(PurchaseBillRequest purchaseBillRequest) {
	
		return iModifyPurchaseBillDao.deletePurchaseDetailsDao(sessionFactory, purchaseBillRequest);
	}
	*/
	
	
}
