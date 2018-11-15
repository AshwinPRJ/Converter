package com.vyavharamitra.reports.keys.dao;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.reports.keys.to.request.DealerReportRequest;
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;

public interface IPurchaseBillReportDao {

	
	List<PurchaseBillBean> getpurchasedetails(SessionFactory sessionFactory,DealerReportRequest dealerReportRequest,Integer dealerId);

	
	List<PurchaseBillBean> getpurchasedatedetails(SessionFactory sessionFactory,DealerReportRequest dealerReportRequest,Integer dealerId);

}
