package com.vyavharamitra.changepassword.dao;

import org.hibernate.SessionFactory;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public interface IChangePSWDao {

	UserCreationBean changePSWUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);


	UserCreationBean currentPasswordValid(SessionFactory sessionFactory, String strUserid);

}
