package com.vyavharamitra.search.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
/**
 * @author : lavanya
 * @created date : 09 Jan 2018
 * @modified by : 
 * @modified date :
 */
public interface IValidUserSearchDao {

	List<UserCreationBean> userDao(SessionFactory sessionFactory, String userNumber);

}
