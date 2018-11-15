package com.vyavharamitra.search.to.response;

import java.util.List;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
public class UserAdminDetailsSearchResponse extends VyavaharaResponse {
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
