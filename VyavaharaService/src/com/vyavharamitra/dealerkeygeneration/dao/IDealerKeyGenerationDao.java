package com.vyavharamitra.dealerkeygeneration.dao;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;

public interface IDealerKeyGenerationDao {

	public DealerKeyGenerationBean dealerKeyGenerationCreateDao(SessionFactory sessionFactory,DealerKeyGenerationBean dealerKeyGenerationBean);

	public void dealerKeyGenerationCreateDao1(SessionFactory sessionFactory,DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean);

}
