package com.vyavharamitra.dealerkeyactivation.dao;

import org.hibernate.SessionFactory;

import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;

/**
 * @author : Lavanya
 * @created date : 07 Dec 2017
 * @modified by :
 * @modified date :
 */

public interface IDealerKeyActivationDao {

	public DealerEncyKeyGenerationBean dealerKeyActivationDao(SessionFactory sessionFactory,
			DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean);

}
