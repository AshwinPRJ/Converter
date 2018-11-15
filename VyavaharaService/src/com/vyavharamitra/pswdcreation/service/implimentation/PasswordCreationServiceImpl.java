package com.vyavharamitra.pswdcreation.service.implimentation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.common.service.implementation.PasswordEncrypt;
import com.vyavharamitra.pswdcreation.dao.IPasswordCreationDao;
import com.vyavharamitra.pswdcreation.service.IPasswordCreationService;
import com.vyavharamitra.pswdcreation.to.PasswordCrationRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

import resources.HibernateUtil;

/**
 * @author : Mohan M
 * @created date : 
 */
@Service
public class PasswordCreationServiceImpl implements IPasswordCreationService {
	@Autowired
	private IPasswordCreationDao iPasswordCreationDao;
	private SessionFactory sessionFactory;
	public PasswordCreationServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public UserCreationBean passwordcreationService(PasswordCrationRequest passwordCrationRequest) {
		UserCreationBean userCreationBean=new UserCreationBean();
		
		String FirstPassword=passwordCrationRequest.getUserCreationBean().getUserFirstPassword();
		String Secondpassword=passwordCrationRequest.getUserCreationBean().getUserSecondPassword();
		String strUserid=passwordCrationRequest.getUserCreationBean().getUserNumber();

		String strFirstPassword=PasswordEncrypt.PWDEncrypt(strUserid + "First" +FirstPassword);
		String strSecondpassword=PasswordEncrypt.PWDEncrypt(Secondpassword + "second" + strUserid);
	
		
		if((FirstPassword.trim()).equals((Secondpassword.trim()))){
			userCreationBean.setUserNumber(strUserid);
			userCreationBean.setUserFirstPassword(strFirstPassword);
			userCreationBean.setUserSecondPassword(strSecondpassword);
		userCreationBean= iPasswordCreationDao.passwordcreationDao(sessionFactory, userCreationBean);		
		
		return userCreationBean;
		}
		else{
			
			return null;
			
		}
		
		}

}
