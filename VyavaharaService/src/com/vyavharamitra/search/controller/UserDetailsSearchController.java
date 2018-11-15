package com.vyavharamitra.search.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.search.service.IUserDetailsSearchService;
import com.vyavharamitra.search.to.response.UserDetailsSearchResponce;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Brahmani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
@Controller
@RequestMapping(value = "/userdetails")
public class UserDetailsSearchController {
	@Autowired
	private IUserDetailsSearchService iUserDetailsSearchService;
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@ResponseBody
	public UserDetailsSearchResponce getDetailsSearch() {
		UserDetailsSearchResponce userDetailsSearchResponce = new UserDetailsSearchResponce();
		List<UserCreationBean> userCreationBean = Collections.emptyList();
		userCreationBean= iUserDetailsSearchService.getUserDetails();
		if (CollectionUtils.isEmpty(userCreationBean) ){
			userDetailsSearchResponce.setStatusCode(StatusCodes.NO_CONTENT);
			userDetailsSearchResponce.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			userDetailsSearchResponce.setUserCreationBean(userCreationBean);

			userDetailsSearchResponce.setStatusCode(StatusCodes.OK);
			userDetailsSearchResponce.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
		}
		return userDetailsSearchResponce;
	}
	
	
	
	@RequestMapping(value = "/read/single/record", method = RequestMethod.POST)
	@ResponseBody
	public UserDetailsSearchResponce getuserdetailsonblur(@RequestBody UserCreationRequest userCreationRequest) {
		UserDetailsSearchResponce userDetailsSearchResponce = new UserDetailsSearchResponce();
		List<UserCreationBean> userCreationBean = Collections.emptyList();
		userCreationBean= iUserDetailsSearchService.getuserdetailsonblur(userCreationRequest);
		if (CollectionUtils.isEmpty(userCreationBean) ){
			userDetailsSearchResponce.setStatusCode(StatusCodes.NO_CONTENT);
			userDetailsSearchResponce.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			userDetailsSearchResponce.setUserCreationBean(userCreationBean);

			userDetailsSearchResponce.setStatusCode(StatusCodes.OK);
			userDetailsSearchResponce.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
		}
		return userDetailsSearchResponce;
	}
}
