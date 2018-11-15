package com.vyavharamitra.organization.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.vyavharamitra.organization.bean.OrganizationLogoBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.organization.service.IOrganizationMasterService;
import com.vyavharamitra.organization.to.request.OrganizationMasterRequest;
import com.vyavharamitra.organization.to.response.OrganizationMasterResponse;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : lavanya
 * @created date : 24 Nov 2017
 * @modified by :
 * @modified date :
 */

@Controller
@RequestMapping(value = "/organization")
public class OrganizationMasterController {
	@Autowired
	private IOrganizationMasterService iOrganizationMasterService;
	private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif");
	/**
	 * create organization details
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public OrganizationMasterResponse organizationMasterCreateController(
			@RequestBody OrganizationMasterRequest organizationMasterRequest) {
		OrganizationMasterResponse organizationMasterResponse = new OrganizationMasterResponse();
		OrganizationMasterBean organizationMasterBean;
		OrganizationLogoBean organizationLogoBean;
		organizationMasterBean = iOrganizationMasterService.organizationMasterCreateService(organizationMasterRequest);

		if (organizationMasterBean != null) {
			organizationMasterResponse.setOrganizationMasterBean(organizationMasterBean);
			organizationMasterResponse.setStatusCode(StatusCodes.OK);
			organizationMasterResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			organizationMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			organizationMasterResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return organizationMasterResponse;
	}

	/*
	 * upload file organization
	 */

	@RequestMapping(value = "/createFile", method = RequestMethod.POST)
	@ResponseBody
	public OrganizationMasterResponse organizationMasterCreateController(@RequestParam CommonsMultipartFile fileUpload,
			@RequestParam("orgid") Integer orgid) {
		OrganizationMasterResponse organizationMasterResponse = new OrganizationMasterResponse();

		OrganizationLogoBean organizationLogoBean = new OrganizationLogoBean();
		if(contentTypes.contains(fileUpload.getContentType())) {
			organizationLogoBean = iOrganizationMasterService.organizationLogo(fileUpload, orgid);
			organizationMasterResponse.setStatusCode(StatusCodes.OK);
			organizationMasterResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		}else {
			organizationMasterResponse.setStatusCode(StatusCodes.UN_AUTHORIZED);
			organizationMasterResponse.setStatusMessage("Not is proper format");
		}
		return organizationMasterResponse;
	}

	/**
	 * readFile organization
	 */

	@RequestMapping(value = "/readFile", method = RequestMethod.GET)
	@ResponseBody
	public OrganizationMasterResponse fetchOrganisationLogo(
			@RequestParam ("orgid") Integer orgid) {
		OrganizationMasterResponse organizationMasterResponse = new OrganizationMasterResponse();
		OrganizationLogoBean organizationLogoBean;
		organizationLogoBean = iOrganizationMasterService.organisationLogofetch(orgid);
		if (organizationLogoBean != null) {
			organizationMasterResponse.setOrganizationLogoBean(organizationLogoBean);
			organizationMasterResponse.setStatusCode(StatusCodes.OK);
			organizationMasterResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			organizationMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			organizationMasterResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		}

		return organizationMasterResponse;
	}


	/**
	 * update organization details
	 */

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public OrganizationMasterResponse organizationMasterUpdateController(
			@RequestBody OrganizationMasterRequest organizationMasterRequest) {
		OrganizationMasterResponse organizationMasterResponse = new OrganizationMasterResponse();

		OrganizationMasterBean organizationMasterBean;
		organizationMasterBean = iOrganizationMasterService.organizationMasterUpdateService(organizationMasterRequest);
		if (organizationMasterBean != null) {
			organizationMasterResponse.setOrganizationMasterBean(organizationMasterBean);
			organizationMasterResponse.setStatusCode(StatusCodes.OK);
			organizationMasterResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
		} else {
			organizationMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			organizationMasterResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
		}
		return organizationMasterResponse;
	}

	/**
	 * read organization details
	 * 
	 */

	@RequestMapping(value = "/read", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public OrganizationMasterResponse getOrganizationDeatils(
			@RequestBody OrganizationMasterRequest organizationMasterRequest) {
		OrganizationMasterResponse organizationMasterResponse = new OrganizationMasterResponse();
		List<UserCreationBean> userCreationBean;
		userCreationBean = iOrganizationMasterService
				.organizationMasterFetch(organizationMasterRequest.getUserCreationBean().getUserNumber());
		if (CollectionUtils.isEmpty(userCreationBean)) {
			organizationMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			organizationMasterResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			organizationMasterResponse.setUserCreationBean(userCreationBean);
			organizationMasterResponse.setStatusCode(StatusCodes.OK);
			organizationMasterResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return organizationMasterResponse;
	}
	
	
	@RequestMapping(value = "/readHeader", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public OrganizationMasterResponse getOrganizationDeatilsHeader(@RequestBody OrganizationMasterRequest organizationMasterRequest) {
		OrganizationMasterResponse organizationMasterResponse = new OrganizationMasterResponse();
		OrganizationMasterBean organizationMasterBean;
		organizationMasterBean = iOrganizationMasterService
				.organizationMasterFetchHeader(organizationMasterRequest);
		if (organizationMasterBean == null ) {
			organizationMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			organizationMasterResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			organizationMasterResponse.setOrganizationMasterBean(organizationMasterBean);
			organizationMasterResponse.setStatusCode(StatusCodes.OK);
			organizationMasterResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return organizationMasterResponse;
	}
	
	@RequestMapping(value = "/updateSmsStatus", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public OrganizationMasterResponse updateOrgSmsStausOfOrganization(@RequestBody OrganizationMasterRequest organizationMasterRequest) {
		System.out.println("orgsanisationId="+organizationMasterRequest.getOrganizationMasterBean().getOrganizationId());
		System.out.println("organisationSMSStatus="+organizationMasterRequest.getOrganizationMasterBean().getOrgSmsStatus());
		OrganizationMasterResponse organizationMasterResponse = new OrganizationMasterResponse();
		OrganizationMasterBean organizationMasterBean;
		organizationMasterBean = iOrganizationMasterService.organisationSmsStatusUpdateService(organizationMasterRequest);
		if (organizationMasterBean == null ) {
			organizationMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			organizationMasterResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			organizationMasterResponse.setOrganizationMasterBean(organizationMasterBean);
			organizationMasterResponse.setStatusCode(StatusCodes.OK);
			organizationMasterResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return organizationMasterResponse;
	}
	
	
}
