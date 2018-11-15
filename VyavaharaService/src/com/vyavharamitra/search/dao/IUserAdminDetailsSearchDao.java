package com.vyavharamitra.search.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
public interface IUserAdminDetailsSearchDao {

	List<UserCreationBean> getUserAdminDetailsDao(SessionFactory sessionFactory,int dealerId);

	List<UserCreationBean> getUserAdminDetailsonblurDao(SessionFactory sessionFactory,
			UserCreationRequest userCreationRequest);

	
}
