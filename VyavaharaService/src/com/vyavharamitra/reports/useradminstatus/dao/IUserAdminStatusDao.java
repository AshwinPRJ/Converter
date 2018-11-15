package com.vyavharamitra.reports.useradminstatus.dao;
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.reports.useradminstatus.to.request.UserAdminStatusRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
/**
 * @author : Lavanya
 * @created date :04 Jan 2018
 * @modified by :
 * @modified date :
 */
public interface IUserAdminStatusDao {
	public List<UserCreationBean> userAdminStatusDao(SessionFactory sessionFactory,UserAdminStatusRequest userAdminStatusRequest);

}
