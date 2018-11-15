package com.vyavharamitra.search.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public interface IUserDetailsSearchDao {

	List<UserCreationBean> getUserDetailsDao(SessionFactory sessionFactory, int branchnumber);

	List<UserCreationBean> getUserDetailsonblurDao(SessionFactory sessionFactory,
			UserCreationRequest userCreationRequest);

}
