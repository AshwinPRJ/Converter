package com.vyavharamitra.usercreation.dao;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.usercreation.bean.UserCreationBean;


public interface IUserAdminUpdateDao {
	UserCreationBean useradminUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);
	
	
	UserCreationBean userUpdateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);

	
    public List<UserCreationBean> userStatusReadDao(SessionFactory sessionFactory,Integer branchNumber);

}



