package com.vyavharamitra.vyavaharamenus.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;
import com.vyavharamitra.vyavaharamenus.bean.VyavaharaMenuBean;
import com.vyavharamitra.vyavaharamenus.service.IVyavaharaMenuService;
import com.vyavharamitra.vyavaharamenus.to.request.VyavaharaMenuRequest;
import com.vyavharamitra.vyavaharamenus.to.response.VyavaharaMenuResponse;

@Controller
@RequestMapping(value = "/menudetails")
public class VyavaharaMenuController {
	@Autowired
	private IVyavaharaMenuService iVyavaharaMenuService;

	@RequestMapping(value = "/read", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public VyavaharaMenuResponse getMenues(@RequestBody VyavaharaMenuRequest vyavaharaMenuRequest) {

		VyavaharaMenuResponse vyavaharaMenuResponse = new VyavaharaMenuResponse();
		List<VyavaharaMenuBean> vyavaharaMenuBean = Collections.emptyList();
		vyavaharaMenuBean = iVyavaharaMenuService.getMenues(vyavaharaMenuRequest);
		if (CollectionUtils.isEmpty(vyavaharaMenuBean)) {
			vyavaharaMenuResponse.setStatusCode(StatusCodes.NO_CONTENT);
			vyavaharaMenuResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			vyavaharaMenuResponse.setVyavaharaMenuBean(vyavaharaMenuBean);

			vyavaharaMenuResponse.setStatusCode(StatusCodes.OK);
			vyavaharaMenuResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return vyavaharaMenuResponse;
	}

}
