package com.vyavharamitra.dealerkeyactivation.service.implementation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.common.service.implementation.AESencrypt;
import com.vyavharamitra.dealerkeyactivation.dao.IDealerKeyActivationDao;
import com.vyavharamitra.dealerkeyactivation.service.IDealerKeyActivationService;
import com.vyavharamitra.dealerkeyactivation.to.request.DealerKeyActivationRequest;
import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;

import resources.HibernateUtil;

/**
 * @author : Lavanya
 * @created date : 07 Dec 2017
 * @modified by :
 * @modified date :
 */
@Service
public class DealerKeyActivationServiceImp implements IDealerKeyActivationService {

	@Autowired
	private IDealerKeyActivationDao iDealerKeyActivationDao;
	private SessionFactory sessionFactory;

	public DealerKeyActivationServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	AESencrypt aes = new AESencrypt();

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public DealerEncyKeyGenerationBean dealerKeyActivationService(DealerKeyActivationRequest dealerKeyActivationRequest)
			throws Exception {

		DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean = new DealerEncyKeyGenerationBean();
		
		String Key = aes.encrypt(dealerKeyActivationRequest.getDealerEncyKeyGenerationBean().getDealerKey());
		

		dealerEncyKeyGenerationBean.setDealerKey(Key);
		dealerEncyKeyGenerationBean.setDealerID(dealerKeyActivationRequest.getDealerEncyKeyGenerationBean().getDealerID());

		dealerEncyKeyGenerationBean = iDealerKeyActivationDao.dealerKeyActivationDao(sessionFactory, dealerEncyKeyGenerationBean);
		

		if (dealerEncyKeyGenerationBean != null) {
			

			if (dealerEncyKeyGenerationBean.getKeyStatus().equalsIgnoreCase("Y")) {
				/*System.out.println("You have Already Defined Organization for this License Key");*/
			} else {
				/*System.err.println("Re direct to organisation details page");*/
			}

		} else {
			/*System.out.println("Please Enter Valid Details...");*/

		}

		return dealerEncyKeyGenerationBean;

	}

}
