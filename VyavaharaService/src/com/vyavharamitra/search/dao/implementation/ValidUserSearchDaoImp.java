package com.vyavharamitra.search.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.search.dao.IValidUserSearchDao;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;
/**
 * @author : lavanya
 * @created date : 09 Jan 2018
 * @modified by : 
 * @modified date :
 */

@Repository
public class ValidUserSearchDaoImp  implements IValidUserSearchDao {

	private Session session;
	@SuppressWarnings("unchecked")
	public List<UserCreationBean> userDao(SessionFactory sessionFactory, String userNumber) {
		List<UserCreationBean> userCreationBeanList =null;
		try
		{
			 session=sessionFactory.openSession();
			session.getTransaction().begin();
			userCreationBeanList=(List<UserCreationBean>) session.createSQLQuery("select usm_uid as \"userNumber\" from bil_usm where usm_uid =:userNumber")
					.setResultTransformer(Transformers.aliasToBean(UserCreationBean.class))
					.setParameter("userNumber",userNumber)
					.list();
			session.getTransaction().commit();

		}catch(Exception e)
		{Utils.logger("Exception : " + e);
		}finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}

		}
		if(!Utils.isNullList(userCreationBeanList)) {
			return userCreationBeanList;
		}return userCreationBeanList;
	}

}
