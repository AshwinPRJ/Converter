package com.vyavharamitra.search.dao.implementation;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.search.dao.IUserDetailsSearchDao;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.utils.Utils;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
@Repository
public class UserDetailsSearchDaoImpl implements IUserDetailsSearchDao{


private Session session;
	
	@SuppressWarnings("unchecked")
	public List<UserCreationBean> getUserDetailsDao (SessionFactory sessionFactory,int branchnumber) {
		List<UserCreationBean> userCreationBean = null;
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			
			userCreationBean =(List<UserCreationBean>) session.createSQLQuery("select usm_sno,usm_sn,usm_sta from  bil_usm where usm_type='U' and usm_level='2' and  usm_bid='" + branchnumber
					+ "'   ").list();

			session.getTransaction().commit();
			
		} catch (Exception e) {
		Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		return userCreationBean;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<UserCreationBean>getUserDetailsonblurDao(SessionFactory sessionFactory,	UserCreationRequest userCreationRequest) {
		List<UserCreationBean> userCreationBean = Collections.emptyList();
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			userCreationBean = session.createCriteria(UserCreationBean.class).add(Restrictions.eq("branchNumber",userCreationRequest.getUserCreationBean().getBranchNumber()))
					 .add(Restrictions.eq("userType","U"))
					 .add(Restrictions.eq("userLevel", "2"))
					 .add(Restrictions.eq("serialNumber",userCreationRequest.getUserCreationBean().getSerialNumber()))
					.list();
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
