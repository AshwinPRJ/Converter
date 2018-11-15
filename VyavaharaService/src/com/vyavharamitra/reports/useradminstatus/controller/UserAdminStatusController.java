package com.vyavharamitra.reports.useradminstatus.controller;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.reports.useradminstatus.service.IUserAdminStatusSerrvice;
import com.vyavharamitra.reports.useradminstatus.to.request.UserAdminStatusRequest;

import com.vyavharamitra.reports.useradminstatus.to.response.UserAdminStatusResponse;

/**
 * @author : Lavanya
 * @created date :04 Jan 2018
 * @modified by :
 * @modified date :
 */

@Controller
/* @CrossOrigin(origins = VyavaharaConstants.URL) */
@RequestMapping(value = "/useradmin")
public class UserAdminStatusController {
	@Autowired
	private IUserAdminStatusSerrvice iUserAdminStatusSerrvice;
	/**
	 * Read UserAdmin Status
	 */
	@RequestMapping(value = "/status/report", method = RequestMethod.POST)
	@ResponseBody
	public UserAdminStatusResponse userAdminStatusController(@RequestBody UserAdminStatusRequest userAdminStatusRequest) {
		UserAdminStatusResponse userAdminStatusResponse = new UserAdminStatusResponse();
		List<UserCreationBean> userCreationBean;
		userCreationBean = iUserAdminStatusSerrvice
				.userAdminStatusService(userAdminStatusRequest);
		if (CollectionUtils.isEmpty(userCreationBean)) {
			userAdminStatusResponse.setStatusCode(StatusCodes.NO_CONTENT);
			userAdminStatusResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			userAdminStatusResponse.setUserCreationBean(userCreationBean);
			userAdminStatusResponse.setStatusCode(StatusCodes.OK);
			userAdminStatusResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return userAdminStatusResponse;
	}

}
