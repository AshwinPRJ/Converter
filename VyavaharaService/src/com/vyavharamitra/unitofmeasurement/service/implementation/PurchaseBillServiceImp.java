package com.vyavharamitra.unitofmeasurement.service.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.dao.IPurchaseBillDao;
import com.vyavharamitra.unitofmeasurement.service.IPurchaseBillService;
import com.vyavharamitra.unitofmeasurement.to.request.PurchaseBillRequest;
import com.vyavharamitra.unitofmeasurement.to.response.HelperPurchaseBean;
import com.vyavharamitra.unitofmeasurement.to.response.PurchaseBillResponse;

import resources.HibernateUtil;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
@Service
public class PurchaseBillServiceImp implements IPurchaseBillService {
	@Autowired
	private IPurchaseBillDao iPurchaseBillDao;

	private SessionFactory sessionFactory;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	@Autowired
	private HttpServletRequest httpServletRequest;

	public PurchaseBillServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public PurchaseBillBean purchaseCreateService(PurchaseBillRequest purchaseBillRequest) {
		purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean().getPurchaseSuplierGSTNo();
		System.out
				.println(purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean().getPurchaseSuplierGSTNo());
		System.out.println(purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean().getPurchaseBillNo());
		System.out.println(purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean().getPurchaseBranchId());

		return iPurchaseBillDao.purchaseCreateDao(sessionFactory, purchaseBillRequest.getPurchaseBillBean(),
				purchaseBillRequest.getPurchasedItemBean());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public HelperPurchaseBean purchaseFetchService(PurchaseBillRequest purchaseBillRequest) {
		return iPurchaseBillDao.purchaseFetch(sessionFactory, purchaseBillRequest);
	}

}
