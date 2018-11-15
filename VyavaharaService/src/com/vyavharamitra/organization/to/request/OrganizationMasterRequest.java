package com.vyavharamitra.organization.to.request;
import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.organization.bean.OrganizationLogoBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

/**
 * @author : lavanya
 * @created date : 24 Nov 2017
 * @modified by : 
 * @modified date :
 */


public class OrganizationMasterRequest {
	private DealerRegisterBean dealerRegisterBean;
	private OrganizationMasterBean organizationMasterBean;
	private UserCreationBean userCreationBean;
	private DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean;
	private DealerKeyGenerationBean dealerKeyGenerationBean;
	private OrganizationLogoBean organiationLogoBean;

	
	
	
	
	
	
	public DealerRegisterBean getDealerRegisterBean() {
		return dealerRegisterBean;
	}

	public void setDealerRegisterBean(DealerRegisterBean dealerRegisterBean) {
		this.dealerRegisterBean = dealerRegisterBean;
	}

	public OrganizationLogoBean getOrganiationLogoBean() {
		return organiationLogoBean;
	}

	public void setOrganiationLogoBean(OrganizationLogoBean organiationLogoBean) {
		this.organiationLogoBean = organiationLogoBean;
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
	public UserCreationBean getUserCreationBean() {
		return userCreationBean;
	}

	/**
	 * @param userCreationBean the userCreationBean to set
	 */
	public void setUserCreationBean(UserCreationBean userCreationBean) {
		this.userCreationBean = userCreationBean;
	}

	/**
	 * @return the dealerEncyKeyGenerationBean
	 */
	public DealerEncyKeyGenerationBean getDealerEncyKeyGenerationBean() {
		return dealerEncyKeyGenerationBean;
	}

	/**
	 * @param dealerEncyKeyGenerationBean the dealerEncyKeyGenerationBean to set
	 */
	public void setDealerEncyKeyGenerationBean(DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean) {
		this.dealerEncyKeyGenerationBean = dealerEncyKeyGenerationBean;
	}

	/**
	 * @return the dealerKeyGenerationBean
	 */
	public DealerKeyGenerationBean getDealerKeyGenerationBean() {
		return dealerKeyGenerationBean;
	}

	/**
	 * @param dealerKeyGenerationBean the dealerKeyGenerationBean to set
	 */
	public void setDealerKeyGenerationBean(DealerKeyGenerationBean dealerKeyGenerationBean) {
		this.dealerKeyGenerationBean = dealerKeyGenerationBean;
	}

	

}

