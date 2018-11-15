package com.vyavharamitra.search.to.response;

import java.util.List;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;
/**
 * @author : lavanya
 * @created date : 09 Jan 2018
 * @modified by : 
 * @modified date :
 */
public class ValidUserSearchResponse extends VyavaharaResponse {

	private List<UserCreationBean> userCreationBean;

	public List<UserCreationBean> getUserCreationBean() {
		return userCreationBean;
	}

	public void setUserCreationBean(List<UserCreationBean> userCreationBean) {
		this.userCreationBean = userCreationBean;
	}





}
