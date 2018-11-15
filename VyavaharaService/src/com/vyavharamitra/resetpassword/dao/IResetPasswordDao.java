package com.vyavharamitra.resetpassword.dao;


import org.hibernate.SessionFactory;
import com.vyavharamitra.usercreation.bean.UserCreationBean;


/**
 * @author : Lavanya
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */



public interface IResetPasswordDao {
	
	UserCreationBean userAdminResetPasswordUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);
	
	UserCreationBean userResetPasswordUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);
	
	UserCreationBean dealerResetPasswordUpdateDao(SessionFactory sessionFactory, String userNumber);


}
