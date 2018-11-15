package com.vyavharamitra.reports.bill.service.implementation;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.reports.bill.dao.IBillDao; 
import com.vyavharamitra.reports.bill.service.IBillService;
import com.vyavharamitra.reports.bill.to.request.BillRequest;


import resources.HibernateUtil;


/**
 * @author : Lavanya
 * @created date :19 Dec 2017
 * @modified by :
 * @modified date :
 */
@Service
public class BillServiceImp implements IBillService {

	@Autowired
	IBillDao iBillDao;

	private SessionFactory sessionFactory;

	public BillServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> billReadService1(BillRequest billRequest)
	{
		return iBillDao.billReadDao1(sessionFactory, billRequest);
	}
	
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> billReadService2(BillRequest billRequest)
	{
		return iBillDao.billReadDao2(sessionFactory, billRequest);
	}
	
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> billReadService3(BillRequest billRequest)
	{
		return iBillDao.billReadDao3(sessionFactory, billRequest);
	}
	
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> billReadService4(BillRequest billRequest)
	{
		return iBillDao.billReadDao4(sessionFactory, billRequest);
	}
	
	
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> billReadService5(BillRequest billRequest)
	{
		return iBillDao.billReadDao5(sessionFactory, billRequest);
	}
	
	
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> billReadService6(BillRequest billRequest)
	{
		return iBillDao.billReadDao6(sessionFactory, billRequest);
	}
	
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CashSalesBean> billService(BillRequest billRequest)
	{
		return iBillDao.billDao(sessionFactory, billRequest);
	}



}
