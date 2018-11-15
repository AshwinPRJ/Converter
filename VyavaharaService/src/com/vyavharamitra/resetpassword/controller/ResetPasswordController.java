package com.vyavharamitra.resetpassword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.resetpassword.service.IResetPasswordService;
import com.vyavharamitra.resetpassword.to.request.ResetPasswordRequest;
import com.vyavharamitra.resetpassword.to.response.ResetPasswordResponse;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Lavanya
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */


@Controller
@RequestMapping(value = "/resetpassword")
public class ResetPasswordController {

	@Autowired
	private IResetPasswordService iResetPasswordService;

	/**
	 * user admin password reset
	 */

	@RequestMapping(value = "/useradmin/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResetPasswordResponse userAdminResetPasswordController(@RequestBody ResetPasswordRequest resetPasswordRequest) {
		ResetPasswordResponse resetPasswordResponse = new ResetPasswordResponse();
		UserCreationBean userCreationBean=new UserCreationBean();
		userCreationBean=iResetPasswordService.userAdminResetPasswordUpdateService(resetPasswordRequest);
		if (userCreationBean != null) {
			resetPasswordResponse.setUserCreationBean(userCreationBean);
			resetPasswordResponse.setStatusCode(StatusCodes.OK);
			resetPasswordResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
		} else {
			resetPasswordResponse.setStatusCode(StatusCodes.NO_CONTENT);
			resetPasswordResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
		}
		return resetPasswordResponse;
	}


	/**
	 * user password reset
	 */

	@RequestMapping(value = "/user/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResetPasswordResponse userResetPasswordController(@RequestBody ResetPasswordRequest resetPasswordRequest) {
		ResetPasswordResponse resetPasswordResponse = new ResetPasswordResponse();
		UserCreationBean userCreationBean=new UserCreationBean();
		userCreationBean=iResetPasswordService.userResetPasswordUpdateService(resetPasswordRequest);
		if (userCreationBean != null) {
			resetPasswordResponse.setUserCreationBean(userCreationBean);
			resetPasswordResponse.setStatusCode(StatusCodes.OK);
			resetPasswordResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
		} else {
			resetPasswordResponse.setStatusCode(StatusCodes.NO_CONTENT);
			resetPasswordResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
		}
		return resetPasswordResponse;
	}



	/**
	 * dealer password reset
	 */

	@RequestMapping(value = "/dealer/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResetPasswordResponse dealerAdminResetPasswordController(@RequestBody ResetPasswordRequest resetPasswordRequest) {
		ResetPasswordResponse resetPasswordResponse = new ResetPasswordResponse();
		UserCreationBean userCreationBean=new UserCreationBean();
		userCreationBean=iResetPasswordService.dealerResetPasswordUpdateService(resetPasswordRequest.getUserCreationBean().getUserNumber());
		if (userCreationBean != null) {
			resetPasswordResponse.setUserCreationBean(userCreationBean);
			resetPasswordResponse.setStatusCode(StatusCodes.OK);
			resetPasswordResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
		} else {
			resetPasswordResponse.setStatusCode(StatusCodes.NO_CONTENT);
			resetPasswordResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
		}
		return resetPasswordResponse;
	}


}
