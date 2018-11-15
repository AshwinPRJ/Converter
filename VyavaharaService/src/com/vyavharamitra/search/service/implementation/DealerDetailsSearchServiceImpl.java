package com.vyavharamitra.search.service.implementation;
/**
 * @author : Mohan M
 * @created date : 
 */
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.search.dao.IDealerDetailsSearchDao;
import com.vyavharamitra.search.service.IDealerDetailsSearchService;
import com.vyavharamitra.search.to.request.DealerDetailsSearchRequest;

import resources.HibernateUtil;

@Service
public class DealerDetailsSearchServiceImpl implements IDealerDetailsSearchService {
	@Autowired
private	IDealerDetailsSearchDao iDealerDetailsSearchDao;

	private SessionFactory sessionFactory;
	public DealerDetailsSearchServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<DealerRegisterBean> getDealerDetails(){
		return  iDealerDetailsSearchDao.getDealerDetailsDao(sessionFactory);
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<DealerRegisterBean> getDealerDetailsonblur(DealerDetailsSearchRequest dealerDetailsSearchRequest){
		return  iDealerDetailsSearchDao.getDealerDetailsonblurDao(dealerDetailsSearchRequest,sessionFactory);
	}

}
