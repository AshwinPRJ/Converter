package com.vyavharamitra.reports.useradminstatus.to.response;
import java.util.List;


import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;
/**
 * @author : lavanya
 * @created date : 04 Jan 2018
 * @modified by :
 * @modified date :
 */

public class UserAdminStatusResponse  extends VyavaharaResponse {
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
