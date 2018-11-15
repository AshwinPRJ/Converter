package com.vyavharamitra.usercreation.service.implementation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.dao.IUserAdminUpdateDao;
import com.vyavharamitra.usercreation.service.IUserAdminUpdateService;
import com.vyavharamitra.usercreation.to.request.UserAdminUpdateRequest;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;
@Service

public class UserAdminUpdateServiceImp implements IUserAdminUpdateService{
	@Autowired
	private IUserAdminUpdateDao iUserAdminUpdateDao;
	protected SessionFactory sessionFactory;
	
	DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
	Calendar calenderObj = Calendar.getInstance();
	Date date = new Date();
	
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	public UserAdminUpdateServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public UserCreationBean useradminstatusUpdateService(UserAdminUpdateRequest useradminstatusRequest) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		useradminstatusRequest.getUserCreationBean().setUpdateBy(ucb.getUserNumber());
	
	    useradminstatusRequest.getUserCreationBean().setUpdateTime(dateFormate.format(calenderObj.getTime()));
	    useradminstatusRequest.getUserCreationBean().setUpdateDate(date);
		return iUserAdminUpdateDao.useradminUpdateDao(sessionFactory, useradminstatusRequest.getUserCreationBean());
	}

	
	
	// read user status
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)

			public List<UserCreationBean> userStatusReadService(Integer branchNumber){
						
					return iUserAdminUpdateDao.userStatusReadDao(sessionFactory,branchNumber);
				}

			
		
}



