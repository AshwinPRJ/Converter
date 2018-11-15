package com.vyavharamitra.reports.useradminstatus.service;


import java.util.List;

import com.vyavharamitra.reports.useradminstatus.to.request.UserAdminStatusRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

/**
 * @author : Lavanya
 * @created date :04 Jan 2018
 * @modified by :
 * @modified date :
 */
public interface IUserAdminStatusSerrvice {
	public List<UserCreationBean> userAdminStatusService(UserAdminStatusRequest userAdminStatusRequest);

}
