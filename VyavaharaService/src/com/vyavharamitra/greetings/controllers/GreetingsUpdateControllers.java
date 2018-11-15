package com.vyavharamitra.greetings.controllers;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.greetings.beans.GreetingsBean;
import com.vyavharamitra.greetings.service.IgreetingsUpdateService;
import com.vyavharamitra.greetings.to.request.GreetingsUpdateRequest;
import com.vyavharamitra.greetings.to.response.GreetingsUpdateResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping(value = "/greetingsstatus")
public class GreetingsUpdateControllers {
	
	@Autowired
	private IgreetingsUpdateService igreetingsUpdateService;

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public GreetingsUpdateResponse greetingsUpdateController(@RequestBody GreetingsUpdateRequest greetingsUpdateRequest) {
		GreetingsUpdateResponse greetingsUpdateResponse = new GreetingsUpdateResponse();
		GreetingsBean greetingsBean;
		greetingsBean = igreetingsUpdateService.greetingsUpdateService(greetingsUpdateRequest);
		if (greetingsBean != null) {
			greetingsUpdateResponse.setGreetingsBean(greetingsBean);
			greetingsUpdateResponse.setStatusCode(StatusCodes.OK);
			greetingsUpdateResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
		} else {
			greetingsUpdateResponse.setStatusCode(StatusCodes.NO_CONTENT);
			greetingsUpdateResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
		}
		return greetingsUpdateResponse;
	}

}
