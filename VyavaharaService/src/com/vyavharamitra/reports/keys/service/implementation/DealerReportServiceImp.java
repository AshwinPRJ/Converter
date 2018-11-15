package com.vyavharamitra.reports.keys.service.implementation;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.reports.keys.dao.IDealerReportDao;
import com.vyavharamitra.reports.keys.service.IDealerReportService;
import com.vyavharamitra.reports.keys.to.request.DealerReportRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

import resources.HibernateUtil;

@Service
public class DealerReportServiceImp implements IDealerReportService{
	@Autowired
	private	IDealerReportDao iDealerReportDao;
	
	private SessionFactory sessionFactory;
	public DealerReportServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<UserCreationBean> getdealerreportdetails(DealerReportRequest dealerReportRequest)
	{
		return  iDealerReportDao.getdealerreportdetails(sessionFactory,dealerReportRequest);
	}
	
	
	
}


