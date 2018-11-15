package com.vyavharamitra.search.to.response;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class UserAdminDetailsResponse extends VyavaharaResponse{
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
