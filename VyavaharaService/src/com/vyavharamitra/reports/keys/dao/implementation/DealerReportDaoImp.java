package com.vyavharamitra.reports.keys.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.reports.keys.dao.IDealerReportDao;
import com.vyavharamitra.reports.keys.to.request.DealerReportRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;
/**
 * @author : Kalyani
 * @created date : 
 * @modified by :
 * @modified date :
 */
@Repository
public class DealerReportDaoImp implements IDealerReportDao{

private Session session;
	@SuppressWarnings("unchecked")
	public List<UserCreationBean>getdealerreportdetails(SessionFactory sessionFactory,DealerReportRequest dealerReportRequest) {
		List<UserCreationBean> userCreationBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();	
			
			
			String accountType="D";
			String accountLevel="1";
			String orderBy=dealerReportRequest.getUserCreationBean().getUserStatus();
			userCreationBean =(List<UserCreationBean>) session.createSQLQuery("select usm_sno,usm_uid,usm_sn,usm_eby,to_char(usm_edt,'dd Mon yyyy') as usm_edt,usm_et,usm_uby,to_char(usm_udt,'dd Mon yyyy') as usm_udt,usm_ut from bil_usm where usm_type = '"+accountType+"' and usm_level = '"+accountLevel+"' and usm_sta='"
+ orderBy + "' order by usm_sno").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				
			}
		}
		if(!Utils.isNullList(userCreationBean))
		{
			return userCreationBean;
		}
		return userCreationBean;
	}
	
	
		
}



