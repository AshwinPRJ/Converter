package com.vyavharamitra.dealer.service;

import java.util.List;

/**
 * @author : Brahmani
 * @created date : 29 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealer.to.request.DealerRegisterRequest;
import com.vyavharamitra.dealer.to.response.DealerRegisterResponse;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;

public interface IdealerRegisterService {

	public DealerRegisterBean dealerCreateService(DealerRegisterRequest dealerRegisterRequest);
	
	public List<OrganizationMasterBean> dealersOrgReadService(DealerRegisterRequest dealerRegisterRequest);
	

	
}
