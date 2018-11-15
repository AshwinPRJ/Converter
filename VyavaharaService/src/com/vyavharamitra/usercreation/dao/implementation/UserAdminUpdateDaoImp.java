package com.vyavharamitra.usercreation.dao.implementation;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.dao.IUserAdminUpdateDao;
import com.vyavharamitra.utils.Utils;

@Repository
public class UserAdminUpdateDaoImp implements IUserAdminUpdateDao {
	private Session session;

	public UserCreationBean useradminUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query useradminStatusUpdateQuery = session.createQuery(
				"UPDATE UserCreationBean  SET userStatus =:userStatus,updateBy =:updateBy,updateDate =:updateDate,updateTime =:updateTime  where userType =:userType and branchNumber =:branchNumber");

		useradminStatusUpdateQuery.setParameter("userStatus", userCreationBean.getUserStatus());
		useradminStatusUpdateQuery.setParameter("updateBy", userCreationBean.getUpdateBy());
		useradminStatusUpdateQuery.setParameter("updateDate", userCreationBean.getUpdateDate());
		useradminStatusUpdateQuery.setParameter("updateTime", userCreationBean.getUpdateTime());
		useradminStatusUpdateQuery.setParameter("userType", "U");
		useradminStatusUpdateQuery.setParameter("branchNumber", userCreationBean.getBranchNumber());
		useradminStatusUpdateQuery.executeUpdate();

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

	// for update user status

	public UserCreationBean userUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();

		Query userStatusUpdateQuery1 = session.createQuery(
				"UPDATE UserCreationBean  SET userStatus =:userStatus,updateBy =:updateBy,updateDate =:updateDate,updateTime =:updateTime  where serialNumber =:serialNumber and userType =:userType and userLevel=:userLevel");
		userStatusUpdateQuery1.setParameter("userStatus", userCreationBean.getUserStatus());
		userStatusUpdateQuery1.setParameter("updateBy", userCreationBean.getUpdateBy());
		userStatusUpdateQuery1.setParameter("updateDate", userCreationBean.getUpdateDate());
		userStatusUpdateQuery1.setParameter("updateTime", userCreationBean.getUpdateTime());
		userStatusUpdateQuery1.setParameter("serialNumber", userCreationBean.getSerialNumber());
		userStatusUpdateQuery1.setParameter("userType", "U");
		userStatusUpdateQuery1.setParameter("userLevel", "2");

		userStatusUpdateQuery1.executeUpdate();
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

	// read user status

	@SuppressWarnings("unchecked")
	public List<UserCreationBean> userStatusReadDao(SessionFactory sessionFactory, Integer branchNumber) {
		List<UserCreationBean> userStatusList = Collections.emptyList();
		try {
			 session = sessionFactory.openSession();
			Criteria userDetails = session.createCriteria(UserCreationBean.class)
					.add(Restrictions.eq("branchNumber", branchNumber));
			userStatusList = userDetails.list();

		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		}
if(!Utils.isNullList(userStatusList))
		{
	return userStatusList;
		}
		return userStatusList;
	}

}
