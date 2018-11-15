package com.vyavharamitra.search.service.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.vyavharamitra.search.dao.IValidUserSearchDao;
import com.vyavharamitra.search.service.IValidUserSearchService;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

import resources.HibernateUtil;
/**
 * @author : lavanya
 * @created date : 09 Jan 2018
 * @modified by : 
 * @modified date :
 */

@Service
public class ValidUserSearchServiceImp  implements IValidUserSearchService{
	@Autowired
	private IValidUserSearchDao iValidUserSearchDao;
	private SessionFactory sessionFactory;
	public ValidUserSearchServiceImp()
	{
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory =HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<UserCreationBean> userService(String userNumber) 
	{
		return iValidUserSearchDao.userDao(sessionFactory,userNumber);
	}






}
