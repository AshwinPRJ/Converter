package com.vyavharamitra.pswdcreation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.pswdcreation.service.IPasswordCreationService;
import com.vyavharamitra.pswdcreation.to.PasswordCrationRequest;
import com.vyavharamitra.pswdcreation.to.PasswordCreationResponse;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Mohan M
 * @created date : 
 */
@Controller

@RequestMapping(value = "/passwordcreation")
public class PasswordCreationController {
	@Autowired
	private IPasswordCreationService iPasswordCreationService;
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public PasswordCreationResponse passwordcreationcreate(@RequestBody PasswordCrationRequest passwordCrationRequest) {
		PasswordCreationResponse passwordCreationResponse = new PasswordCreationResponse();
		UserCreationBean userCreationBean;
		userCreationBean=iPasswordCreationService.passwordcreationService(passwordCrationRequest);
		if (userCreationBean != null) {
			passwordCreationResponse.setStatusCode(StatusCodes.OK);
			passwordCreationResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		}
		else
		{
			passwordCreationResponse.setStatusCode(StatusCodes.NO_CONTENT);
			passwordCreationResponse.setStatusMessage("Password Not Created Created");
		
		}
		return passwordCreationResponse;
	}
	
}
