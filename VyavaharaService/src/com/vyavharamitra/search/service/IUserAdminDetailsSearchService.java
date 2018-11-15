package com.vyavharamitra.search.service;

import java.util.List;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
public interface IUserAdminDetailsSearchService {

	List<UserCreationBean> getUserAdminDetails();

	List<UserCreationBean> getuseradmindetailsonblur(UserCreationRequest userCreationRequest);


}
