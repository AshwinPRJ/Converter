package com.vyavharamitra.reports.dashboard.service.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.reports.dashboard.dao.IDashboardDao;
import com.vyavharamitra.reports.dashboard.service.IDashboardService;
import com.vyavharamitra.reports.dashboard.to.request.DashboardRequest;

import resources.HibernateUtil;
@Service
public class DashboardServiceImpl implements IDashboardService{
	@Autowired
	private	IDashboardDao iDashboardDao;
	private SessionFactory sessionFactory;
	public DashboardServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public	List<DealerRegisterBean> noofDealers(){
		return  iDashboardDao.noofDealers(sessionFactory);
	}

	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public	List<DealerRegisterBean> noofBills(){
		return  iDashboardDao.noofBills(sessionFactory);
	}

	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public	List<DealerRegisterBean> dealerDatiels(){
		return  iDashboardDao.dealerDatiels(sessionFactory);
	}
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public	List<DealerRegisterBean> dOrgDatiels(DashboardRequest dashboardRequest){
		return  iDashboardDao.dOrgDatiels(dashboardRequest,sessionFactory);
	}
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public	List<DealerRegisterBean> orgNoOfBills(DashboardRequest dashboardRequest){
		return  iDashboardDao.orgNoOfBills(dashboardRequest,sessionFactory);
	}
	
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public	List<DealerRegisterBean> billNos(DashboardRequest dashboardRequest){

		return  iDashboardDao.billNos(dashboardRequest,sessionFactory);
	}

	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<DealerRegisterBean> users() {
		return  iDashboardDao.users(sessionFactory);
	}


}
