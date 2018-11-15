package com.vyavharamitra.reports.useradminstatus.service.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.reports.useradminstatus.dao.IUserAdminStatusDao;
import com.vyavharamitra.reports.useradminstatus.service.IUserAdminStatusSerrvice;
import com.vyavharamitra.reports.useradminstatus.to.request.UserAdminStatusRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

import resources.HibernateUtil;

/**
 * @author : Lavanya
 * @created date :04 Jan 2018
 * @modified by :
 * @modified date :
 */

@Service
public class UserAdminStatusServiceImp implements IUserAdminStatusSerrvice {
	@Autowired
	IUserAdminStatusDao iUserAdminStatusDao;

	private SessionFactory sessionFactory;

	public UserAdminStatusServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	/**
	 * Read Total Keys
	 */
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<UserCreationBean> userAdminStatusService(UserAdminStatusRequest userAdminStatusRequest) {


		return iUserAdminStatusDao.userAdminStatusDao(sessionFactory,userAdminStatusRequest);
	}

}
