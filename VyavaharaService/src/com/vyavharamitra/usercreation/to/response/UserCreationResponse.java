package com.vyavharamitra.usercreation.to.response;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;

/**
 * @author : Lavanya
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */


public class UserCreationResponse extends VyavaharaResponse {
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
