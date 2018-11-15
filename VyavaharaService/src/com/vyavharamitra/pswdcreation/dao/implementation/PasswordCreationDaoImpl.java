package com.vyavharamitra.pswdcreation.dao.implementation;

/**
 * @author : Mohan M
 * @created date : 
 */
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.pswdcreation.dao.IPasswordCreationDao;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class PasswordCreationDaoImpl implements IPasswordCreationDao {
	private Session session;

	public UserCreationBean passwordcreationDao(SessionFactory sessionFactory, UserCreationBean userCreationBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();

		Query createPSWUpdateQuery = session.createQuery(
				"UPDATE UserCreationBean SET userFirstPassword=:userFirstPassword,userSecondPassword=:userSecondPassword,passwordReset=:passwordReset where userNumber=:userNumber");

		createPSWUpdateQuery.setParameter("userFirstPassword", userCreationBean.getUserFirstPassword());
		createPSWUpdateQuery.setParameter("userSecondPassword", userCreationBean.getUserSecondPassword());
		createPSWUpdateQuery.setParameter("userNumber", userCreationBean.getUserNumber());
		createPSWUpdateQuery.setParameter("passwordReset", "N");

		createPSWUpdateQuery.executeUpdate();

		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(userCreationBean)) {
			return userCreationBean;
		}
		return userCreationBean;
	}
}
