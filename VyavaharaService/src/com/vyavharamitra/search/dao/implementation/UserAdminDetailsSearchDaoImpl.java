package com.vyavharamitra.search.dao.implementation;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.search.dao.IUserAdminDetailsSearchDao;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.utils.Utils;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :M Mohan
 * @modified date :
 */
@Repository
public class UserAdminDetailsSearchDaoImpl implements IUserAdminDetailsSearchDao{


private Session session;
	
	@SuppressWarnings("unchecked")
	public List<UserCreationBean> getUserAdminDetailsDao(SessionFactory sessionFactory,int dealerId){
		List<UserCreationBean> userCreationBean = Collections.emptyList();
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			userCreationBean =(List<UserCreationBean>) session.createSQLQuery("select usm_sno,usm_sn,usm_bid,usm_sta from  bil_usm,bil_dlr,bil_om where usm_type='U' and usm_level='1' and  usm_bid=om_id  and om_dlrid=dlr_id and om_dlrid='"+dealerId+"' ").list();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		if(!Utils.isNullList(userCreationBean))
		{
			return userCreationBean;
		}
		return userCreationBean;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<UserCreationBean> getUserAdminDetailsonblurDao(SessionFactory sessionFactory,UserCreationRequest userCreationRequest) {
	
		List<UserCreationBean> userCreationBean = Collections.emptyList();
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer userId = userCreationRequest.getUserCreationBean().getSerialNumber();
			Integer dealerId = userCreationRequest.getUserCreationBean().getDealerId();
			userCreationBean =(List<UserCreationBean>)session.createSQLQuery("select usm_sno,usm_sn,usm_bid,usm_sta from bil_usm,bil_dlr,bil_om   WHERE usm_type='U' and usm_level='1' and usm_sno='" + userId + "' and usm_bid=om_id  and om_dlrid=dlr_id and dlr_id='"+dealerId+"' ").list();
		  session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
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
