package com.vyavharamitra.loginvalidations.dao;
/**
 * @author : M Mohan
 * @created date : 
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;

public interface ILoginValidationsDao {

	UserCreationBean loginValidationsDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);

	UserCreationBean userLoginValuesDao(SessionFactory sessionFactory);

	UserCreationBean userLogoutValuesDao(SessionFactory sessionFactory);

}
