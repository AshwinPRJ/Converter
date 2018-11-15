package com.vyavharamitra.reports.keys.service.implementation;
import java.util.List;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.reports.keys.dao.IDeletedBillReportDao;
import com.vyavharamitra.reports.keys.service.IDeletedBillReportService;
import com.vyavharamitra.reports.keys.to.request.DeletedBillReportRequest;

import resources.HibernateUtil;

@Service
public class DeletedBillReportServiceImp implements IDeletedBillReportService{
	@Autowired
	private	IDeletedBillReportDao iDeletedBillReportDao;
	
	private SessionFactory sessionFactory;
	public DeletedBillReportServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<DeleteBillBean> getdeletereportdetails(DeletedBillReportRequest deletedBillReportRequest)
	{
		return  iDeletedBillReportDao.getdeletereportdetails(sessionFactory,deletedBillReportRequest);
	}
	
}
