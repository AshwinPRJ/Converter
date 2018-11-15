package com.vyavharamitra.usercreation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.service.IUserCreationService;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.usercreation.to.response.UserCreationResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Lavanya
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */

@Controller
@RequestMapping(value = "/usercreation")
public class UserCreationController {
	@Autowired
	private IUserCreationService iUserCreationService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public UserCreationResponse userCreationCreateController(@RequestBody UserCreationRequest userCreationRequest) {
		UserCreationResponse userCreationResponse = new UserCreationResponse();

		UserCreationBean userCreationBean;
		userCreationBean = iUserCreationService.userCreationCreateService(userCreationRequest);
		if (userCreationBean != null) {
			userCreationResponse.setUserCreationBean(userCreationBean);
			userCreationResponse.setStatusCode(StatusCodes.OK);
			userCreationResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			userCreationResponse.setStatusCode(StatusCodes.NO_CONTENT);
			userCreationResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return userCreationResponse;
	}
}

