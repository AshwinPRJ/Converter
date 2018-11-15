package com.vyavharamitra.resetpassword.service.implementation;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.resetpassword.dao.IResetPasswordDao;
import com.vyavharamitra.resetpassword.service.IResetPasswordService;
import com.vyavharamitra.resetpassword.to.request.ResetPasswordRequest;
import resources.HibernateUtil;

/**
 * @author : Lavanya
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */


@Service
public class IResetPasswordServiceImp implements IResetPasswordService{


		@Autowired
		private IResetPasswordDao iResetPasswordDao;
		private SessionFactory sessionFactory;
		public IResetPasswordServiceImp() {
			/**
			 * getting SessionFactory from Hibernate Util
			 */
			this.sessionFactory = HibernateUtil.getSessionFactory();
		}
		
		
	
  /**
   * user admin password reset
   */
		@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
		public UserCreationBean userAdminResetPasswordUpdateService(ResetPasswordRequest resetPasswordRequest) {
			
			return iResetPasswordDao.userAdminResetPasswordUpdateDao(sessionFactory, resetPasswordRequest.getUserCreationBean());
		}
		
	/**
	 * user password reset	
	 */
		@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)	
	public UserCreationBean userResetPasswordUpdateService(ResetPasswordRequest resetPasswordRequest) {
			
			return iResetPasswordDao.userResetPasswordUpdateDao(sessionFactory, resetPasswordRequest.getUserCreationBean());
		}
	
	/**
	 * dealer password reset
	 */
		@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
		public UserCreationBean dealerResetPasswordUpdateService(String userNumber) {
				
				return iResetPasswordDao.dealerResetPasswordUpdateDao(sessionFactory,userNumber);
			}
	}



