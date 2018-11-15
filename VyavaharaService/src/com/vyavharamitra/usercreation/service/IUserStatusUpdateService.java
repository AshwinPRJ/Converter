package com.vyavharamitra.usercreation.service;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserStatusUpdateRequest;

public interface IUserStatusUpdateService {
	public UserCreationBean userstatusUpdateService(UserStatusUpdateRequest userStatusUpdateRequest);

}
