package com.vyavharamitra.dealer.to.request;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.usercreation.bean.UserCreationBean;

public class DealerStatusRequest {

	
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
