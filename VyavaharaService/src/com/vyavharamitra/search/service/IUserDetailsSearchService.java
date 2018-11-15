package com.vyavharamitra.search.service;

import java.util.List;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public interface IUserDetailsSearchService {

	List<UserCreationBean> getUserDetails();

	List<UserCreationBean> getuserdetailsonblur(UserCreationRequest userCreationRequest);

}
