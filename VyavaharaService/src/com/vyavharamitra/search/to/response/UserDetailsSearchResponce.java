package com.vyavharamitra.search.to.response;

import java.util.List;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public class UserDetailsSearchResponce extends VyavaharaResponse {
	private List<UserCreationBean> userCreationBean;

	/**
	 * @return the userCreationBean
	 */
	public List<UserCreationBean> getUserCreationBean() {
		return userCreationBean;
	}

	/**
	 * @param userCreationBean the userCreationBean to set
	 */
	public void setUserCreationBean(List<UserCreationBean> userCreationBean) {
		this.userCreationBean = userCreationBean;
	}


}
