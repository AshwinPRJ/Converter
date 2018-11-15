package com.vyavharamitra.changepassword.to.response;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public class ChangePSWResponse  extends VyavaharaResponse{

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
