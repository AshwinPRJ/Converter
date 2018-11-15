package com.vyavharamitra.dealerkeyactivation.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.dealerkeyactivation.dao.IDealerKeyActivationDao;
import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.utils.Utils;

/**
 * @author : Lavanya
 * @created date : 06 Dec 2017
 * @modified by :
 * @modified date :
 */

@Repository
public class DealerKeyActivationDaoImp implements IDealerKeyActivationDao {
	public DealerEncyKeyGenerationBean dealerKeyActivationDao(SessionFactory sessionFactory,
			DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean) {
		 Session session;
		session = sessionFactory.openSession();
		session.beginTransaction();
	
		dealerEncyKeyGenerationBean = (DealerEncyKeyGenerationBean) session.createCriteria(DealerEncyKeyGenerationBean.class)
				.add(Restrictions.eq("dealerKey", dealerEncyKeyGenerationBean.getDealerKey()))
				.add(Restrictions.eq("dealerID", dealerEncyKeyGenerationBean.getDealerID())).uniqueResult();
		session.getTransaction().commit();
		
		
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(dealerEncyKeyGenerationBean)) {
			return dealerEncyKeyGenerationBean;
		}
		return dealerEncyKeyGenerationBean;
	}
}