package com.vyavharamitra.usercreation.dao;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.usercreation.bean.UserCreationBean;

public interface IUserStatusUpdateDao {
	UserCreationBean userUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);

}
