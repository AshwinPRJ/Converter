package com.vyavharamitra.usercreation.controller;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.service.IUserStatusUpdateService;
import com.vyavharamitra.usercreation.to.request.UserStatusUpdateRequest;
import com.vyavharamitra.usercreation.to.response.UserStatusUpdateResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;
@Controller
@RequestMapping(value = "/userstatus")
public class UserStatusUpdateController {
	
	@Autowired
	private IUserStatusUpdateService iUserStatusUpdateService;
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public UserStatusUpdateResponse userUpdateController(@RequestBody UserStatusUpdateRequest userStatusRequest) {
		UserStatusUpdateResponse userResponse = new UserStatusUpdateResponse();
		UserCreationBean userCreationBean;
		userCreationBean = iUserStatusUpdateService.userstatusUpdateService(userStatusRequest);
		if (userCreationBean != null) {
			userResponse.setUserCreationBean(userCreationBean);
			userResponse.setStatusCode(StatusCodes.OK);
			userResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
		} else {
			userResponse.setStatusCode(StatusCodes.NO_CONTENT);
			userResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
		}
		return userResponse;
	}	
	

}
