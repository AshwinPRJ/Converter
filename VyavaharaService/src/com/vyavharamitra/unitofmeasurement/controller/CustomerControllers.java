package com.vyavharamitra.unitofmeasurement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.unitofmeasurement.bean.CustomerBean;
import com.vyavharamitra.unitofmeasurement.service.ICustomerService;
import com.vyavharamitra.unitofmeasurement.to.request.CustomerRequest;
import com.vyavharamitra.unitofmeasurement.to.response.CustomerResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping(value = "/customer")
public class CustomerControllers {
	@Autowired
	private ICustomerService iCustomerService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public CustomerResponse customerCreateController(@RequestBody CustomerRequest customerRequest) {
		CustomerResponse customerResponse = new CustomerResponse();

		CustomerBean customerBean;
		customerBean = iCustomerService.customerCreateService(customerRequest);
		if (customerBean != null) {
			customerResponse.setCustomerBean(customerBean);
			customerResponse.setStatusCode(StatusCodes.OK);
			customerResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			customerResponse.setStatusCode(StatusCodes.NO_CONTENT);
			customerResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return customerResponse;
	}
	
}
