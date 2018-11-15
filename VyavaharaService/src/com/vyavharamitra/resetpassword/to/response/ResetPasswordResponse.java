package com.vyavharamitra.resetpassword.to.response;


import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;

/**
 * @author : Lavanya
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */


public class ResetPasswordResponse extends VyavaharaResponse {
	private UserCreationBean userCreationBean;

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
