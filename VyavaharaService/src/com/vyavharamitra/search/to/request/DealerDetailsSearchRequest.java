package com.vyavharamitra.search.to.request;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.dealer.bean.DealerRegisterBean;

public class DealerDetailsSearchRequest {
private DealerRegisterBean dealerRegisterBean;

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
}
