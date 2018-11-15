package com.vyavharamitra.changepassword.dao.implimentation;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.changepassword.dao.IChangePSWDao;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
@SuppressWarnings("serial")
@Repository
public class ChangePSWDaoImp implements IChangePSWDao, Serializable {
	private Session session;
	
	public UserCreationBean changePSWUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query changePSWUpdateQuery = session.createQuery("UPDATE UserCreationBean  SET userFirstPassword=:userFirstPassword,userSecondPassword=:userSecondPassword,passwordReset=:passwordReset where userNumber=:userNumber");

		changePSWUpdateQuery.setParameter("userFirstPassword", userCreationBean.getUserFirstPassword());
		changePSWUpdateQuery.setParameter("userSecondPassword", userCreationBean.getUserSecondPassword());
		changePSWUpdateQuery.setParameter("userNumber", userCreationBean.getUserNumber());
		changePSWUpdateQuery.setParameter("passwordReset", "N");

		changePSWUpdateQuery.executeUpdate();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(userCreationBean)) {
			return userCreationBean;
		}
		return userCreationBean;
	}
	public UserCreationBean currentPasswordValid(SessionFactory sessionFactory,  String strUserid) {

	session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserCreationBean fetchCurrentPSW = (UserCreationBean) session.createCriteria(UserCreationBean.class)
				.add(Restrictions.eq("userNumber", strUserid))
				.add(Restrictions.eq("userStatus", "A")).uniqueResult();
		
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(fetchCurrentPSW)) {
			return fetchCurrentPSW;
		}
		return fetchCurrentPSW;

	}
}
