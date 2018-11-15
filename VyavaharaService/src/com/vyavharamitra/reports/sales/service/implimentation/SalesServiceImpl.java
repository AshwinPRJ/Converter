package com.vyavharamitra.reports.sales.service.implimentation;
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

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.reports.sales.dao.ISalesDao;
import com.vyavharamitra.reports.sales.service.ISalesService;
import com.vyavharamitra.reports.sales.to.Request.SalesRequest;

import resources.HibernateUtil;
@Service
public class SalesServiceImpl implements ISalesService{
	@Autowired
	private	ISalesDao iSalesDao;
	private SessionFactory sessionFactory;
	public SalesServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> salesByBranch(SalesRequest salesRequest){
		return  iSalesDao.salesByBranch(salesRequest,sessionFactory);
	}

	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> salesSummery(SalesRequest salesRequest){
		return  iSalesDao.salesSummery(salesRequest,sessionFactory);
	}
	
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> salesSummeryByDate(SalesRequest salesRequest){
		return  iSalesDao.salesSummeryByDate(salesRequest,sessionFactory);
	}
	
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> salesSummeryByCustomer(SalesRequest salesRequest){
		return  iSalesDao.salesSummeryByCustomer(salesRequest,sessionFactory);
	}
	
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> salesSummerybillsummery(SalesRequest salesRequest){
		return  iSalesDao.salesSummerybillsummery(salesRequest,sessionFactory);
	}
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> salesSummeryQuantity(SalesRequest salesRequest){
		return  iSalesDao.salesSummeryQuantity(salesRequest,sessionFactory);
	}


	
}
