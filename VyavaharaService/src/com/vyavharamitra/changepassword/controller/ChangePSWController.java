package com.vyavharamitra.changepassword.controller;
/**
 * @author : M Mohan
 * @created date : 
 * @modified by :
 * @modified date :
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.changepassword.service.IChangePSWService;
import com.vyavharamitra.changepassword.to.request.ChangePSWRequest;
import com.vyavharamitra.changepassword.to.response.ChangePSWResponse;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.StatusCodes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@Controller
@RequestMapping(value = "/changepassword")
public class ChangePSWController {

	@Autowired
	private IChangePSWService iChangePSWService;
	
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ChangePSWResponse changepasswordCreateController(@RequestBody ChangePSWRequest changePSWRequest) {
	ChangePSWResponse changePSWResponse = new ChangePSWResponse();
	UserCreationBean userCreationBean;
	userCreationBean=iChangePSWService.changepasswordUpdateService(changePSWRequest);
	if(userCreationBean != null) {
		changePSWResponse.setStatusCode(StatusCodes.OK);
		changePSWResponse.setStatusMessage("Password Updated Successfully");
	} 
	else{
		changePSWResponse.setStatusCode(StatusCodes.NO_CONTENT);
		changePSWResponse.setStatusMessage("Password Not Updated");
	}
	
	return changePSWResponse;
}
	
}


