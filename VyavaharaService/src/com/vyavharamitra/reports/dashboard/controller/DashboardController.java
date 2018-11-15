package com.vyavharamitra.reports.dashboard.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.reports.dashboard.service.IDashboardService;
import com.vyavharamitra.reports.dashboard.to.request.DashboardRequest;
import com.vyavharamitra.reports.dashboard.to.response.DashboardResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Mohan M
 * @created date : 
 */
@Controller
@RequestMapping(value = "/dashboard")

public class DashboardController {

	@Autowired
	private IDashboardService iDashboardService;
	@RequestMapping(value = "/nodealers", method = RequestMethod.GET)
	@ResponseBody
	public DashboardResponse noofDealers() {
			DashboardResponse dashboardResponse = new DashboardResponse();
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		dealerRegisterBean=iDashboardService.noofDealers();
		if (CollectionUtils.isEmpty(dealerRegisterBean)) {
			dashboardResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dashboardResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
				}
		else
		{
			dashboardResponse.setDealerRegisterBean(dealerRegisterBean);
			dashboardResponse.setStatusCode(StatusCodes.OK);
			dashboardResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dashboardResponse;
	}
	
	@RequestMapping(value = "/noofBills", method = RequestMethod.GET)
	@ResponseBody
	public DashboardResponse noofBills() {
			DashboardResponse dashboardResponse = new DashboardResponse();
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		dealerRegisterBean=iDashboardService.noofBills();
		if (CollectionUtils.isEmpty(dealerRegisterBean)) {
			dashboardResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dashboardResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
				}
		else
		{
			dashboardResponse.setDealerRegisterBean(dealerRegisterBean);
			dashboardResponse.setStatusCode(StatusCodes.OK);
			dashboardResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dashboardResponse;
	}
	
	@RequestMapping(value = "/ddatiels", method = RequestMethod.GET)
	@ResponseBody
	public DashboardResponse dealerDatiels() {
		DashboardResponse dashboardResponse = new DashboardResponse();
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		dealerRegisterBean=iDashboardService.dealerDatiels();
		if (CollectionUtils.isEmpty(dealerRegisterBean)) {
			dashboardResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dashboardResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
				}
		else
		{
			dashboardResponse.setDealerRegisterBean(dealerRegisterBean);
			dashboardResponse.setStatusCode(StatusCodes.OK);
			dashboardResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dashboardResponse;
	}
	
	
	@RequestMapping(value = "/dorg", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DashboardResponse dOrgDatiels(@RequestBody DashboardRequest dashboardRequest) {
		DashboardResponse dashboardResponse = new DashboardResponse();
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		dealerRegisterBean=iDashboardService.dOrgDatiels(dashboardRequest);
		if (CollectionUtils.isEmpty(dealerRegisterBean)) {
			dashboardResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dashboardResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
				}
		else
		{
			dashboardResponse.setDealerRegisterBean(dealerRegisterBean);
			dashboardResponse.setStatusCode(StatusCodes.OK);
			dashboardResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dashboardResponse;
	}
	
	@RequestMapping(value = "/orgnobills", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DashboardResponse orgNoOfBills(@RequestBody DashboardRequest dashboardRequest) {
		DashboardResponse dashboardResponse = new DashboardResponse();
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		dealerRegisterBean=iDashboardService.orgNoOfBills(dashboardRequest);
		if (CollectionUtils.isEmpty(dealerRegisterBean)) {
			dashboardResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dashboardResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
				}
		else
		{
			dashboardResponse.setDealerRegisterBean(dealerRegisterBean);
			dashboardResponse.setStatusCode(StatusCodes.OK);
			dashboardResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dashboardResponse;
	}
	@RequestMapping(value = "/bills", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public DashboardResponse billNos(@RequestBody DashboardRequest dashboardRequest) {
		DashboardResponse dashboardResponse = new DashboardResponse();
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		dealerRegisterBean=iDashboardService.billNos(dashboardRequest);
		if (CollectionUtils.isEmpty(dealerRegisterBean)) {
			dashboardResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dashboardResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
				}
		else
		{
			dashboardResponse.setDealerRegisterBean(dealerRegisterBean);
			dashboardResponse.setStatusCode(StatusCodes.OK);
			dashboardResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dashboardResponse;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public DashboardResponse users() {
		DashboardResponse dashboardResponse = new DashboardResponse();
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		dealerRegisterBean=iDashboardService.users();
		if (CollectionUtils.isEmpty(dealerRegisterBean)) {
			dashboardResponse.setStatusCode(StatusCodes.NO_CONTENT);
			dashboardResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
				}
		else
		{
			dashboardResponse.setDealerRegisterBean(dealerRegisterBean);
			dashboardResponse.setStatusCode(StatusCodes.OK);
			dashboardResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return dashboardResponse;
	}
}
