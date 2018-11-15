package com.vyavharamitra.reports.keys.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.reports.keys.to.request.DealerKeyRequest;

/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */

public interface IDealerKeyDao {

	public List<DealerKeyGenerationBean> dealerKeyDao(SessionFactory sessionFactory,
			DealerKeyRequest dealerKeyRequest);

	public List<DealerKeyGenerationBean> dealerStatusKeyDao(SessionFactory sessionFactory,
			DealerKeyRequest dealerKeyRequest);


}
