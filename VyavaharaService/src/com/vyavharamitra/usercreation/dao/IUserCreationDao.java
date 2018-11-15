package com.vyavharamitra.usercreation.dao;

import org.hibernate.SessionFactory;

import com.vyavharamitra.usercreation.bean.UserCreationBean;

/**
 * @author : Lavanya
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */

public interface IUserCreationDao {
	UserCreationBean userCreationCreateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);

}
