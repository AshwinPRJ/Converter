package com.vyavharamitra.reports.keys.service.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.reports.keys.dao.IDealerKeyDao;
import com.vyavharamitra.reports.keys.service.IDealerKeyService;
import com.vyavharamitra.reports.keys.to.request.DealerKeyRequest;

import resources.HibernateUtil;

/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */

@Service
public class DealerKeyServiceImp implements IDealerKeyService {

	@Autowired
	IDealerKeyDao iDealerKeyDao;

	private SessionFactory sessionFactory;

	public DealerKeyServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	/**
	 * Read Total Keys
	 */
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<DealerKeyGenerationBean> dealerKeyService(DealerKeyRequest dealerKeyRequest) {

		return iDealerKeyDao.dealerKeyDao(sessionFactory, dealerKeyRequest);
	}
	/**
	 * Read Key Status
	 */
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<DealerKeyGenerationBean> dealerKeyStatusService(DealerKeyRequest dealerKeyRequest){

		return iDealerKeyDao.dealerStatusKeyDao(sessionFactory, dealerKeyRequest);
	}
}