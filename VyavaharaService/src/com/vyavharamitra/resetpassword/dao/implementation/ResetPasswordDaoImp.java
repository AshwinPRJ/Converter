package com.vyavharamitra.resetpassword.dao.implementation;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;
import com.vyavharamitra.resetpassword.dao.IResetPasswordDao;


/**
 * @author : Lavanya
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */

@Repository
public class ResetPasswordDaoImp implements IResetPasswordDao {
	private Session session;

	/** 
	 * user admin password reset
	 */

	public UserCreationBean userAdminResetPasswordUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query userAdminResetQuery = session.createQuery("UPDATE UserCreationBean  SET passwordReset =:passwordReset where userLevel=:userLevel and userType=:userType and branchNumber =:branchNumber ");
		userAdminResetQuery.setParameter("passwordReset", "Y");
		userAdminResetQuery.setParameter("userLevel", "1");
		userAdminResetQuery.setParameter("userType", "U");
		userAdminResetQuery.setParameter("branchNumber", userCreationBean.getBranchNumber());
		userAdminResetQuery.executeUpdate();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(userCreationBean)) {
			return userCreationBean;
		}
		return userCreationBean;
	}

	/**
	 * user password reset
	 */
	public UserCreationBean userResetPasswordUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query userResetQuery = session.createQuery("UPDATE UserCreationBean  SET passwordReset =:passwordReset where userLevel=:userLevel and userType=:userType and serialNumber =:serialNumber ");
		userResetQuery.setParameter("passwordReset", "Y");
		userResetQuery.setParameter("userLevel", "2");
		userResetQuery.setParameter("userType", "U");
		userResetQuery.setParameter("serialNumber", userCreationBean.getSerialNumber());
		userResetQuery.executeUpdate();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(userCreationBean)) {
			return userCreationBean;
		}
		return userCreationBean;
	}


	/**
	 * dealer password reset
	 */
	public UserCreationBean dealerResetPasswordUpdateDao(SessionFactory sessionFactory,String userNumber) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		UserCreationBean userCreationBean = new UserCreationBean();
		Query dealerResetQuery = session.createSQLQuery("UPDATE bil_usm SET usm_reset='Y' from bil_dlr WHERE dlr_mobile = CAST(usm_uid as numeric) and   usm_uid =:userNumber ");
		dealerResetQuery=dealerResetQuery.setParameter("userNumber",userNumber);
		dealerResetQuery.executeUpdate();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(userCreationBean)) {
			return userCreationBean;
		}

		return userCreationBean ;
	}
}
