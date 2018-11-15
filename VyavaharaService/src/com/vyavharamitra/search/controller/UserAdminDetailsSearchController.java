package com.vyavharamitra.search.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vyavharamitra.search.service.IUserAdminDetailsSearchService;
import com.vyavharamitra.search.to.response.UserAdminDetailsSearchResponse;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Brahmani
 * @created date :o5 Dec 2017
 * @modified by :
 * @modified date :
 */
@RestController
@RequestMapping(value = "/useradmindetails")
public class UserAdminDetailsSearchController {
	
	@Autowired
	private IUserAdminDetailsSearchService iUserAdminDetailsSearchService;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public UserAdminDetailsSearchResponse getDetailsSearch() {
		UserAdminDetailsSearchResponse userAdminDetailsSearchResponse = new UserAdminDetailsSearchResponse();
		List<UserCreationBean> userCreationBean = Collections.emptyList();
		userCreationBean = iUserAdminDetailsSearchService.getUserAdminDetails();
		if (CollectionUtils.isEmpty(userCreationBean)) {
			userAdminDetailsSearchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			userAdminDetailsSearchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			userAdminDetailsSearchResponse.setUserCreationBean(userCreationBean);
			userAdminDetailsSearchResponse.setStatusCode(StatusCodes.OK);
			userAdminDetailsSearchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return userAdminDetailsSearchResponse;
	}

	@RequestMapping(value = "/read/single/record", method = RequestMethod.POST)
	public UserAdminDetailsSearchResponse getuseradmindetailsonblur(@RequestBody UserCreationRequest userCreationRequest) {
		UserAdminDetailsSearchResponse userAdminDetailsResponse = new UserAdminDetailsSearchResponse();
		List<UserCreationBean> userCreationBean = Collections.emptyList();
		userCreationBean = iUserAdminDetailsSearchService.getuseradmindetailsonblur(userCreationRequest);
		if (CollectionUtils.isEmpty(userCreationBean)) {
			userAdminDetailsResponse.setStatusCode(StatusCodes.NO_CONTENT);
			userAdminDetailsResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			userAdminDetailsResponse.setUserCreationBean(userCreationBean);
			userAdminDetailsResponse.setStatusCode(StatusCodes.OK);
			userAdminDetailsResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return userAdminDetailsResponse;
	}
}