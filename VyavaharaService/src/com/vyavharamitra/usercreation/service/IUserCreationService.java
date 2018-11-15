package com.vyavharamitra.usercreation.service;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;

/**
 * @author : Lavanya
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */

public interface IUserCreationService {
	public UserCreationBean userCreationCreateService(UserCreationRequest userCreationRequest);

}

