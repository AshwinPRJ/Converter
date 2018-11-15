package com.vyavharamitra.reports.keys.dao;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.reports.keys.to.request.DeletedBillReportRequest;

public interface IDeletedBillReportDao {

	
	List<DeleteBillBean> getdeletereportdetails(SessionFactory sessionFactory, DeletedBillReportRequest deletedBillReportRequest);

	
}
