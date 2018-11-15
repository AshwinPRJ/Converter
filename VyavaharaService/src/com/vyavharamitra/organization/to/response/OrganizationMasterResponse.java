package com.vyavharamitra.organization.to.response;
import java.util.List;

import com.vyavharamitra.organization.bean.OrganizationLogoBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;

/**
 * @author : lavanya
 * @created date : 24 Nov 2017
 * @modified by : 
 * @modified date :
 */


public class OrganizationMasterResponse  extends VyavaharaResponse {

	private OrganizationMasterBean organizationMasterBean;
	private List<UserCreationBean> userCreationBean;
	private OrganizationLogoBean organizationLogoBean;
	
	
	

	/**
	 * @return the organizationLogoBean
	 */
	public OrganizationLogoBean getOrganizationLogoBean() {
		return organizationLogoBean;
	}

	/**
	 * @param organizationLogoBean the organizationLogoBean to set
	 */
	public void setOrganizationLogoBean(OrganizationLogoBean organizationLogoBean) {
		this.organizationLogoBean = organizationLogoBean;
	}

	/**
	 * @return the organizationMasterBean
	 */
	public OrganizationMasterBean getOrganizationMasterBean() {
		return organizationMasterBean;
	}

	/**
	 * @param organizationMasterBean the organizationMasterBean to set
	 */
	public void setOrganizationMasterBean(OrganizationMasterBean organizationMasterBean) {
		this.organizationMasterBean = organizationMasterBean;
	}

	/**
	 * @return the userCreationBean
	 */
	public List<UserCreationBean> getUserCreationBean() {
		return userCreationBean;
	}

	/**
	 * @param userCreationBean2 the userCreationBean to set
	 */
	public void setUserCreationBean(List<UserCreationBean> userCreationBean) {
		this.userCreationBean = userCreationBean;
	}


}
