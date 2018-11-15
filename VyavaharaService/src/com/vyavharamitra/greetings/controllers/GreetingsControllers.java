package com.vyavharamitra.greetings.controllers;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.greetings.beans.GreetingsBean;
import com.vyavharamitra.greetings.service.IGreetingsService;
import com.vyavharamitra.greetings.to.request.GreetingsRequest;
import com.vyavharamitra.greetings.to.response.GreetingsResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping(value = "/greetings")
public class GreetingsControllers {
	@Autowired
	private IGreetingsService iGreetingsService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public GreetingsResponse greetingsCreateController(@RequestBody GreetingsRequest greetingsRequest) {
		GreetingsResponse greetingsResponse = new GreetingsResponse();

		GreetingsBean greetingsBean;
		greetingsBean = iGreetingsService.greetingsCreateService(greetingsRequest);
		if (greetingsBean != null) {
			greetingsResponse.setGreetingsBean(greetingsBean);
			greetingsResponse.setStatusCode(StatusCodes.OK);
			greetingsResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
			greetingsResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			greetingsResponse.setStatusCode(StatusCodes.NO_CONTENT);
			greetingsResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
			
		}
		return greetingsResponse;
	}
	
	
	//read greetings
	
	@RequestMapping(value="/read", method = RequestMethod.POST)
	@ResponseBody
	public GreetingsResponse getGreetingsDeatils(@RequestBody GreetingsRequest greetingsRequest){
		GreetingsResponse greetingsResponse = new GreetingsResponse();
		List<GreetingsBean> greetingsBean ;
		greetingsBean= iGreetingsService.greetingsFetch(greetingsRequest);
		if (CollectionUtils.isEmpty(greetingsBean)) {
			greetingsResponse.setStatusCode(StatusCodes.NO_CONTENT);
			greetingsResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
			
		} else {
			greetingsResponse.setGreetingsBean(greetingsBean);
			greetingsResponse.setStatusCode(StatusCodes.OK);
			
			greetingsResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return greetingsResponse;
	}
	
	
	
}
	
	








