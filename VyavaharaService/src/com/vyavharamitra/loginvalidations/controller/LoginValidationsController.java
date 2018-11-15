package com.vyavharamitra.loginvalidations.controller;

/**
 * @author : M Mohan
 * @created date : 
 * @modified by :
 * @modified date :
 */
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vyavharamitra.loginvalidations.service.ILoginValidationsService;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.usercreation.to.response.UserCreationResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@RestController
/* @CrossOrigin(origins = VyavaharaConstants.URL) */
@RequestMapping("/loginvalidations")
public class LoginValidationsController {
	@Autowired
	private ILoginValidationsService iLoginValidationsService;

	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public UserCreationResponse loginvalidationsCreateController(@RequestBody @Valid UserCreationRequest userCreationRequest, BindingResult bindingResult) {
		UserCreationResponse userCreationResponse = new UserCreationResponse();
		
		
		if(bindingResult.hasFieldErrors()) {
			userCreationResponse.setStatusCode(StatusCodes.BAD_REQUEST);
			userCreationResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			UserCreationBean userCreationBean;
			userCreationBean = iLoginValidationsService.loginvalidationsReadService(userCreationRequest);
			if (userCreationBean != null) {
				userCreationResponse.setUserCreationBean(userCreationBean);
				userCreationResponse.setStatusCode(StatusCodes.OK);
				userCreationResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
			} else {
				userCreationResponse.setStatusCode(StatusCodes.NO_CONTENT);
				userCreationResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
			}
		}
		
		return userCreationResponse;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public UserCreationResponse userLoginValues() {
		UserCreationResponse userCreationResponse = new UserCreationResponse();
		UserCreationBean userCreationBean;
			userCreationBean = iLoginValidationsService.userLoginValuesService();
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
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public UserCreationResponse userLogoutValues() {
		UserCreationResponse userCreationResponse = new UserCreationResponse();
		UserCreationBean userCreationBean;
			userCreationBean = iLoginValidationsService.userLogoutValuesService();
			if (userCreationBean != null) {
				userCreationResponse.setUserCreationBean(userCreationBean);
				userCreationResponse.setStatusCode(StatusCodes.OK);
				userCreationResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
			} else {
				userCreationResponse.setStatusCode(StatusCodes.NO_CONTENT);
				userCreationResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
			}
		
		
		return userCreationResponse;
	}
}
