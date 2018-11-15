package com.vyavharamitra.usercreation.dao.implementation;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;
@Repository
public class UserStatusUpdateDaoImp {
	private Session session;
	public UserCreationBean userstatusUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query userStatusUpdateQuery = session.createQuery("UPDATE UserCreationBean  SET userStatus =:userStatus,updateBy =:updateBy,updateDate =:updateDate,updateTime =:updateTime  where serialNumber =:serialNumber and userType =:userType and userLevel=:userLevel");
		userStatusUpdateQuery.setParameter("userStatus", userCreationBean.getUserStatus());
		userStatusUpdateQuery.setParameter("updateBy", userCreationBean.getUpdateBy());
		userStatusUpdateQuery.setParameter("updateDate", userCreationBean.getUpdateDate());
		userStatusUpdateQuery.setParameter("updateTime", userCreationBean.getUpdateTime());
		userStatusUpdateQuery.setParameter("serialNumber", userCreationBean.getSerialNumber());
		userStatusUpdateQuery.setParameter("userType", "U");
		userStatusUpdateQuery.setParameter("userLevel","2");

		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(userCreationBean))
		{
			return userCreationBean;
		}
		return userCreationBean;
}
}
