package com.vyavharamitra.pswdcreation.dao;


import org.hibernate.SessionFactory;

import com.vyavharamitra.usercreation.bean.UserCreationBean;

/**
 * @author : Mohan M
 * @created date : 
 */
public interface IPasswordCreationDao {

	UserCreationBean passwordcreationDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);

}
