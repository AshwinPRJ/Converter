package com.vyavharamitra.dealer.to.response;

import java.util.List;

/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class DealerRegisterResponse extends VyavaharaResponse {
	

	private DealerRegisterBean dealerRegisterBean;
	private List<OrganizationMasterBean> organizationMasterBeans;
    private OrganizationMasterBean organizationMasterBean;
    
    
	/**
	 * 
	 *
	 * @return the dealerRegisterBean
	 */
	public DealerRegisterBean getDealerRegisterBean() {
		return dealerRegisterBean;
	}

	/**
	 * @param dealerRegisterBean
	 *            the dealerRegisterBean to set
	 */
	public void setDealerRegisterBean(DealerRegisterBean dealerRegisterBean) {
		this.dealerRegisterBean = dealerRegisterBean;
	}

	public List<OrganizationMasterBean> getOrganizationMasterBeans() {
		return organizationMasterBeans;
	}

	public void setOrganizationMasterBeans(List<OrganizationMasterBean> organizationMasterBeans) {
		this.organizationMasterBeans = organizationMasterBeans;
	}

	public OrganizationMasterBean getOrganizationMasterBean() {
		return organizationMasterBean;
	}

	public void setOrganizationMasterBean(OrganizationMasterBean organizationMasterBean) {
		this.organizationMasterBean = organizationMasterBean;
	}

	@Override
	public String toString() {
		return "DealerRegisterResponse [dealerRegisterBean=" + dealerRegisterBean + ", organizationMasterBeans="
				+ organizationMasterBeans + ", organizationMasterBean=" + organizationMasterBean + "]";
	}

	
	
}
