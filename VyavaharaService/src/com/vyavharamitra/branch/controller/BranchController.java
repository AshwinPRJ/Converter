package com.vyavharamitra.branch.controller;
/**
 * @author : mohan
 * @created date :29 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.branch.service.IBranchService;
import com.vyavharamitra.branch.to.BranchRequest;
import com.vyavharamitra.branch.to.BranchResponse;
import com.vyavharamitra.greetings.beans.BranchBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping(value = "/branchname")
public class BranchController {
	
	@Autowired
	private IBranchService iBranchService;
	/**
	 * Branch Details Read
	 */
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	@ResponseBody
	public BranchResponse getBranchName(@RequestBody BranchRequest branchRequest) {
		
		BranchResponse branchResponse=new BranchResponse();
		BranchBean branchBean;
		branchBean = iBranchService.getBranchName(branchRequest);
		if (branchBean != null) {
			branchResponse.setBranchBean(branchBean);

			branchResponse.setStatusCode(StatusCodes.OK);
			branchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
			
		} 
		else {
			branchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			branchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		}
		return branchResponse;
	}
}
