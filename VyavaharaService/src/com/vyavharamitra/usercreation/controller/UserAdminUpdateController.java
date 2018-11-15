package com.vyavharamitra.usercreation.controller;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.service.IUserAdminUpdateService;
import com.vyavharamitra.usercreation.to.request.UserAdminUpdateRequest;
import com.vyavharamitra.usercreation.to.response.UserAdminUpdateResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;
@Controller
@RequestMapping(value = "/useradminstatus")
public class UserAdminUpdateController {
	
	@Autowired
	private IUserAdminUpdateService iUserAdminUpdateService;
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public UserAdminUpdateResponse useradminUpdateController(@RequestBody UserAdminUpdateRequest useradminStatusRequest) {
		UserAdminUpdateResponse useradminResponse = new UserAdminUpdateResponse();
		UserCreationBean userCreationBean;
		userCreationBean = iUserAdminUpdateService.useradminstatusUpdateService(useradminStatusRequest);
		if (userCreationBean != null) {
			useradminResponse.setUserCreationBean(userCreationBean);
			useradminResponse.setStatusCode(StatusCodes.OK);
			useradminResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
		} else {
			useradminResponse.setStatusCode(StatusCodes.NO_CONTENT);
			useradminResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
		}
		return useradminResponse;
	}

	
	
	
	// read user status
	@RequestMapping(value = "/readuserstatus", method = RequestMethod.POST)
	@ResponseBody
	public List<UserCreationBean> userStatusReadController(@RequestBody UserAdminUpdateRequest userAdminRequest ) {
		return iUserAdminUpdateService.userStatusReadService(userAdminRequest.getUserCreationBean().getBranchNumber());

	}
}
