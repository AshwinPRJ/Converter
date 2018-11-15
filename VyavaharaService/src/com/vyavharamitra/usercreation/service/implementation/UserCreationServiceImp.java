package com.vyavharamitra.usercreation.service.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.dao.IUserCreationDao;
import com.vyavharamitra.usercreation.service.IUserCreationService;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

/**
 * @author : Lavanya
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */

@Service
public class UserCreationServiceImp implements IUserCreationService{


	@Autowired
	IUserCreationDao iUserCreationDao;

	private SessionFactory sessionFactory;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	@Autowired
	private HttpServletRequest httpServletRequest;

	public UserCreationServiceImp() {
	/**
	  * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public UserCreationBean userCreationCreateService(UserCreationRequest userCreationRequest) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		userCreationRequest.getUserCreationBean().setEnteredBy(ucb.getUserNumber());
		String userStatus="A";
		 String userType="U";
		 String userLevel="2";
		 String passwordReset="Y";
		 userCreationRequest.getUserCreationBean().setEnterTime(dateFormat.format(date));
		 userCreationRequest.getUserCreationBean().setEnterDate(date);
		 userCreationRequest.getUserCreationBean().setUserStatus(userStatus);
		 userCreationRequest.getUserCreationBean().setUserType(userType);
		 userCreationRequest.getUserCreationBean().setUserLevel(userLevel);
		 userCreationRequest.getUserCreationBean().setPasswordReset(passwordReset);
	return iUserCreationDao.userCreationCreateDao(sessionFactory, userCreationRequest.getUserCreationBean());
	}
}

