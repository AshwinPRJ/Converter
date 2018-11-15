package com.vyavharamitra.loginvalidations.service.implementation;

/**
 * @author : M Mohan
 * @created date : 
 * @modified by :
 * @modified date :
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.common.service.implementation.PasswordEncrypt;
import com.vyavharamitra.loginvalidations.dao.ILoginValidationsDao;
import com.vyavharamitra.loginvalidations.service.ILoginValidationsService;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.utils.VyavaharaConstants;

import resources.HibernateUtil;

@Service
public class LoginValidationsServiceImpl implements ILoginValidationsService {

	@Autowired
	private ILoginValidationsDao iLoginValidationsDao;
	private SessionFactory sessionFactory;
	@Autowired
	private HttpServletRequest httpServletRequest;

	public LoginValidationsServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public UserCreationBean loginvalidationsReadService(UserCreationRequest userCreationRequest) {
		String password1 = userCreationRequest.getUserCreationBean().getUserFirstPassword();
		String userid = userCreationRequest.getUserCreationBean().getUserNumber();
		String Password = PasswordEncrypt.PWDEncrypt(userid + "First" + password1);
		UserCreationBean userCreationBean = new UserCreationBean();
		
		userCreationBean.setUserFirstPassword(Password);
		userCreationBean.setUserNumber(userid);

		userCreationBean = iLoginValidationsDao.loginValidationsDao(sessionFactory, userCreationBean);
		if(userCreationBean != null ) {
			HttpSession httpSession = httpServletRequest.getSession(true);
			httpSession.setAttribute(VyavaharaConstants.USER, userCreationBean);
		}
		return userCreationBean;
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public UserCreationBean userLoginValuesService() {
		return iLoginValidationsDao.userLoginValuesDao(sessionFactory);
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public UserCreationBean userLogoutValuesService() {
		return iLoginValidationsDao.userLogoutValuesDao(sessionFactory);
	}
}