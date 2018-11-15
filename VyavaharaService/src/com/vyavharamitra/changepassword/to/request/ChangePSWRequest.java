package com.vyavharamitra.changepassword.to.request;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public class ChangePSWRequest {

	private UserCreationBean  userCreationBean;

	/**
	 * @return the userCreationBean
	 */
	public UserCreationBean getUserCreationBean() {
		return userCreationBean;
	}

	/**
	 * @param userCreationBean the userCreationBean to set
	 */
	public void setUserCreationBean(UserCreationBean userCreationBean) {
		this.userCreationBean = userCreationBean;
	}
}
