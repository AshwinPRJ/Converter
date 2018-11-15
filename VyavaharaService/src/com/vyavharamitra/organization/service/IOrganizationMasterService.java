package com.vyavharamitra.organization.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.vyavharamitra.organization.bean.OrganizationLogoBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.organization.to.request.OrganizationMasterRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

/**
 * @author : lavanya
 * @created date : 24 Nov 2017
 * @modified by : 
 * @modified date :
 */

public interface IOrganizationMasterService {

	public OrganizationMasterBean organizationMasterCreateService(OrganizationMasterRequest organizationMasterRequest);

	public OrganizationMasterBean organizationMasterUpdateService(OrganizationMasterRequest organizationMasterRequest);

	public List<UserCreationBean> organizationMasterFetch(String userNumber);

	public OrganizationLogoBean organizationLogo(CommonsMultipartFile fileUpload, Integer orgid);

    public OrganizationLogoBean organisationLogofetch(Integer OmgId);

	public OrganizationMasterBean organizationMasterFetchHeader(OrganizationMasterRequest organizationMasterRequest);
	
	public OrganizationMasterBean organisationSmsStatusUpdateService(OrganizationMasterRequest organizationMasterRequest);
	
	
    
    
    
}