package com.vyavharamitra.search.to.request;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
/**
 * @author : lavanya
 * @created date : 09 Jan 2018
 * @modified by : 
 * @modified date :
 */
public class ValidUserSearchRequest {
	private UserCreationBean userCreationBean;

	public UserCreationBean getUserCreationBean() {
		return userCreationBean;
	}

	public void setUserCreationBean(UserCreationBean userCreationBean) {
		this.userCreationBean = userCreationBean;
	}


}
