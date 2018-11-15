package com.vyavharamitra.reports.keys.service.implementation;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.reports.keys.dao.IPurchaseBillReportDao;
import com.vyavharamitra.reports.keys.service.IPurchaseBillReportService;
import com.vyavharamitra.reports.keys.to.request.DealerReportRequest;
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service
public class PurchaseBillReportServiceImp implements IPurchaseBillReportService {
	@Autowired
	private	IPurchaseBillReportDao iPurchaseBillReportDao;
	
	private SessionFactory sessionFactory;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	
	public PurchaseBillReportServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<PurchaseBillBean> getpurchasedetails(DealerReportRequest dealerReportRequest)
	
	{
		UserCreationBean ucb=Utils.getCurrentUser(httpServletRequest);
		Integer dealerId=ucb.getBranchNumber();
		return  iPurchaseBillReportDao.getpurchasedetails(sessionFactory,dealerReportRequest,dealerId);
	}
	
	//purchase date range
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<PurchaseBillBean> getpurchasedatedetails(DealerReportRequest dealerReportRequest)
	{
		UserCreationBean ucb=Utils.getCurrentUser(httpServletRequest);
		Integer branchId=ucb.getBranchNumber();
		
		System.out.println("branch id purchase bill service()="+branchId);
		
		return  iPurchaseBillReportDao.getpurchasedatedetails(sessionFactory,dealerReportRequest,branchId);
	}
	
}
