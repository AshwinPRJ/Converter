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

import com.vyavharamitra.search.service.IValidUserSearchService;
import com.vyavharamitra.search.to.request.ValidUserSearchRequest;
import com.vyavharamitra.search.to.response.ValidUserSearchResponse;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;
/**
 * @author : lavanya
 * @created date : 09 Jan 2018
 * @modified by : 
 * @modified date :
 */

@Controller
@RequestMapping("/user")
public class ValidUserSearchController {

	@Autowired
	private IValidUserSearchService iValidUserSearchService;

	@RequestMapping(value ="/valid/search" ,method=RequestMethod.POST)
	@ResponseBody
	public ValidUserSearchResponse userController(@RequestBody ValidUserSearchRequest validUserSearchRequest)
	{
		ValidUserSearchResponse validUserSearchResponse=new ValidUserSearchResponse();
		List<UserCreationBean> userCreationBean =Collections.emptyList();
		userCreationBean=iValidUserSearchService.userService(validUserSearchRequest.getUserCreationBean().getUserNumber());
		if (CollectionUtils.isEmpty(userCreationBean))
		{
			validUserSearchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			validUserSearchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		}else
		{
			validUserSearchResponse.setUserCreationBean(userCreationBean);
			validUserSearchResponse.setStatusCode(StatusCodes.OK);
			validUserSearchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);

		} return validUserSearchResponse;
	}


}
