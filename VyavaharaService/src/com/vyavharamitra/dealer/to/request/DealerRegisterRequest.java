package com.vyavharamitra.dealer.to.request;

/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;

public class DealerRegisterRequest {
	
	private DealerRegisterBean dealerRegisterBean;
	private OrganizationMasterBean organizationMasterBean;

	
	/**
	 * @return the dealerRegisterBean
	 */
	public DealerRegisterBean getDealerRegisterBean() {
		return dealerRegisterBean;
	}

	/**
	 * @param dealerRegisterBean the dealerRegisterBean to set
	 */
	public void setDealerRegisterBean(DealerRegisterBean dealerRegisterBean) {
		this.dealerRegisterBean = dealerRegisterBean;
	}

	public String getUserCreationBean() {
		
		return null;
	}

	public OrganizationMasterBean getOrganizationMasterBean() {
		return organizationMasterBean;
	}

	public void setOrganizationMasterBean(OrganizationMasterBean organizationMasterBean) {
		this.organizationMasterBean = organizationMasterBean;
	}

	@Override
	public String toString() {
		return "DealerRegisterRequest [dealerRegisterBean=" + dealerRegisterBean + ", organizationMasterBean="
				+ organizationMasterBean + "]";
	}
	
	

}
