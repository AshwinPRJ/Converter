package com.vyavharamitra.usercreation.service;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserAdminUpdateRequest;

public interface IUserAdminUpdateService {

	public UserCreationBean useradminstatusUpdateService(UserAdminUpdateRequest useradminstatusRequest);
	
	
	
	public List<UserCreationBean> userStatusReadService(Integer branchNumber);

}



