package com.vyavharamitra.unitofmeasurement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.unitofmeasurement.service.IUnitOfMeasurementService;
import com.vyavharamitra.unitofmeasurement.to.request.UnitOfMeasurementRequest;
import com.vyavharamitra.unitofmeasurement.to.response.UnitOfMeasurementResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Kalyani
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */

@RestController
@RequestMapping(value = "/unitmeasurement")
public class UnitOfMeasurementController {
	@Autowired
	private IUnitOfMeasurementService iUnitOfMeasurementService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public UnitOfMeasurementResponse unitOfMeasurementCreateController(
			@RequestBody @Valid UnitOfMeasurementRequest unitOfMeasurementRequest, BindingResult bindingResult, Error error) {
		UnitOfMeasurementResponse unitOfMeasurementResponse = new UnitOfMeasurementResponse();

		System.err.println("bindingResult : " + bindingResult);
		if (bindingResult.hasErrors()) {
			unitOfMeasurementResponse.setStatusCode(StatusCodes.BAD_REQUEST);
			unitOfMeasurementResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			UnitOfMeasurementBean unitOfMeasurementBean;
			unitOfMeasurementBean = iUnitOfMeasurementService.unitOfMeasurementCreateService(unitOfMeasurementRequest);
			if (unitOfMeasurementBean != null) {
				unitOfMeasurementResponse.setUnitOfMeasurementBean(unitOfMeasurementBean);
				unitOfMeasurementResponse.setStatusCode(StatusCodes.OK);
				unitOfMeasurementResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
			} else {
				unitOfMeasurementResponse.setStatusCode(StatusCodes.NO_CONTENT);
				unitOfMeasurementResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
			}
		}

		return unitOfMeasurementResponse;
	}

	@RequestMapping(value = "/read", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public UnitOfMeasurementResponse unitOfMeasurementReadController(
			@RequestBody UnitOfMeasurementRequest categoryOfItemRequest) {
		UnitOfMeasurementResponse unitOfMeasurementResponse = new UnitOfMeasurementResponse();

		UnitOfMeasurementBean unitOfMeasurementBean;
		unitOfMeasurementBean = iUnitOfMeasurementService.unitOfMeasurementReadService(categoryOfItemRequest);
		if (unitOfMeasurementBean != null) {
			unitOfMeasurementResponse.setUnitOfMeasurementBean(unitOfMeasurementBean);
			unitOfMeasurementResponse.setStatusCode(StatusCodes.OK);
			unitOfMeasurementResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		} else {
			unitOfMeasurementResponse.setStatusCode(StatusCodes.NO_CONTENT);
			unitOfMeasurementResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		}
		return unitOfMeasurementResponse;
	}

}