package com.vyavharamitra.changepassword.service.implimentation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.changepassword.dao.IChangePSWDao;
import com.vyavharamitra.changepassword.service.IChangePSWService;
import com.vyavharamitra.changepassword.to.request.ChangePSWRequest;
import com.vyavharamitra.common.service.implementation.PasswordEncrypt;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

import resources.HibernateUtil;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
@Service
public class ChangePSWServiceImp implements IChangePSWService{
	
	@Autowired
	private IChangePSWDao iChangePSWDao;
	private SessionFactory sessionFactory;
	public ChangePSWServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public UserCreationBean changepasswordUpdateService(ChangePSWRequest changePSWRequest) {
		UserCreationBean userCreationBean=new UserCreationBean();
	
		String currentpassword=changePSWRequest.getUserCreationBean().getCurrentPassword();
		String strUserid=changePSWRequest.getUserCreationBean().getUserNumber();

		String strCurrentPSW=PasswordEncrypt.PWDEncrypt(strUserid + "First" +currentpassword);
		UserCreationBean currentpasswordvalid=iChangePSWDao.currentPasswordValid(sessionFactory,strUserid);
		if((strCurrentPSW.trim()).equals(currentpasswordvalid.getUserFirstPassword().trim()))
		{
			String FirstPassword=changePSWRequest.getUserCreationBean().getUserFirstPassword();
			String Secondpassword=changePSWRequest.getUserCreationBean().getUserSecondPassword();
			
			String strFirstPassword=PasswordEncrypt.PWDEncrypt(strUserid + "First" +FirstPassword);
			String strSecondpassword=PasswordEncrypt.PWDEncrypt(Secondpassword + "second" + strUserid);
			if((FirstPassword.trim()).equals((Secondpassword.trim())))
			{
			
				userCreationBean.setUserFirstPassword(strFirstPassword);
				userCreationBean.setUserSecondPassword(strSecondpassword);
				userCreationBean.setUserNumber(strUserid);
				return iChangePSWDao.changePSWUpdateDao(sessionFactory,userCreationBean );

				
			}
			else
			{
				return null;
			}
		}
		else
		{
		return null;
		}
	}
}
		