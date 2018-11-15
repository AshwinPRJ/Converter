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
import com.vyavharamitra.usercreation.bean.UserCreationBean;

public interface IDealerReportDao {
	
	List<UserCreationBean> getdealerreportdetails(SessionFactory sessionFactory,DealerReportRequest dealerReportRequest);

	

}
