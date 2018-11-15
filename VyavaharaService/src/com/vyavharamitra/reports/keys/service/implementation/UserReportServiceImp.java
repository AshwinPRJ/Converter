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

import com.vyavharamitra.reports.keys.dao.IUserReportDao;
import com.vyavharamitra.reports.keys.service.IUserReportService;
import com.vyavharamitra.reports.keys.to.request.DealerReportRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

import resources.HibernateUtil;

@Service
public class UserReportServiceImp implements IUserReportService{
	@Autowired
	private	IUserReportDao iUserReportDao;
	
	private SessionFactory sessionFactory;
	public UserReportServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<UserCreationBean> getuserdetails(DealerReportRequest dealerReportRequest)
	{
		return  iUserReportDao.getuserdetails(sessionFactory,dealerReportRequest);
	}
	
}
