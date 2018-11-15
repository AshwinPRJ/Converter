package com.vyavharamitra.search.controller;
/**
 * @author			: Brahmani
 * @created date	: 
 * @modified by		:  
 * @modified date	: 
 */
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.search.service.IUnitMeasurementSearchService;
import com.vyavharamitra.search.to.response.UnitMeasurementSearchResponse;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping("/unitmeasurementsearch")
public class UnitMeasurementSearchController {

	@Autowired
	private IUnitMeasurementSearchService iUnitMeasurementSearchService;
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@ResponseBody
	public UnitMeasurementSearchResponse getUOMDetailsSearch() {
		UnitMeasurementSearchResponse unitMeasurementSearchResponse = new UnitMeasurementSearchResponse();
		List<UnitOfMeasurementBean> unitOfMeasurementBean = Collections.emptyList();
		unitOfMeasurementBean = iUnitMeasurementSearchService.getUOMDetails();
		if (CollectionUtils.isEmpty(unitOfMeasurementBean)) {
			unitMeasurementSearchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			unitMeasurementSearchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			unitMeasurementSearchResponse.setUnitOfMeasurementBean(unitOfMeasurementBean);
			unitMeasurementSearchResponse.setStatusCode(StatusCodes.OK);
			unitMeasurementSearchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
		}
		return unitMeasurementSearchResponse;
	}
}
