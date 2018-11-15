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

import com.vyavharamitra.itemdetails.beans.DeleteItemMasterBean;
import com.vyavharamitra.itemdetails.beans.UpdateItemMasterBean;
import com.vyavharamitra.reports.keys.dao.IItemModifyReportDao;
import com.vyavharamitra.reports.keys.service.IItemModifyReportService;
import com.vyavharamitra.reports.keys.to.request.ItemDeleteReportRequest;
import com.vyavharamitra.reports.keys.to.request.ItemModifyReportRequest;

import resources.HibernateUtil;

@Service
public class ItemModifyReportServiceImp implements IItemModifyReportService{
	@Autowired
	private	IItemModifyReportDao iItemModifyReportDao;
	
	private SessionFactory sessionFactory;
	public ItemModifyReportServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<UpdateItemMasterBean> getitemreportdetails(ItemModifyReportRequest itemModifyReportRequest)
	{
		return  iItemModifyReportDao.getitemreportdetails(sessionFactory,itemModifyReportRequest);
	}
	
	
	
	
	//deleted Item history report
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<DeleteItemMasterBean> getitemdeletereportdetails(ItemDeleteReportRequest itemDeleteReportRequest)
	{
		return  iItemModifyReportDao.getitemdeletereportdetails(sessionFactory,itemDeleteReportRequest);
	}
	
	
	
	
}



