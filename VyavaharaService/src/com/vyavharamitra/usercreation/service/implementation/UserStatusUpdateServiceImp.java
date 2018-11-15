package com.vyavharamitra.usercreation.service.implementation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.dao.IUserAdminUpdateDao;
import com.vyavharamitra.usercreation.service.IUserStatusUpdateService;
import com.vyavharamitra.usercreation.to.request.UserStatusUpdateRequest;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service

public class UserStatusUpdateServiceImp implements IUserStatusUpdateService{
	@Autowired
	private IUserAdminUpdateDao iUserAdminUpdateDao;
	protected SessionFactory sessionFactory;
	
	
	DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
	Calendar calenderObj = Calendar.getInstance();
	Date date = new Date();
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	public UserStatusUpdateServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public UserCreationBean userstatusUpdateService(UserStatusUpdateRequest userStatusUpdateRequest) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		userStatusUpdateRequest.getUserCreationBean().setUpdateBy(ucb.getUserNumber());
		userStatusUpdateRequest.getUserCreationBean().setUpdateDate(date);
		userStatusUpdateRequest.getUserCreationBean().setUpdateTime(dateFormate.format(calenderObj.getTime()));
			return iUserAdminUpdateDao.userUpdateDao(sessionFactory, userStatusUpdateRequest.getUserCreationBean());
	}


}
