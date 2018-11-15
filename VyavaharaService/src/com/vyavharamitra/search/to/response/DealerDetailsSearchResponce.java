package com.vyavharamitra.search.to.response;

import java.util.List;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.utils.VyavaharaResponse;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public class DealerDetailsSearchResponce extends VyavaharaResponse {
private List<DealerRegisterBean> dealerRegisterBean;

/**
 * @return the dealerRegisterBean
 */
public List<DealerRegisterBean> getDealerRegisterBean() {
	return dealerRegisterBean;
}

/**
 * @param dealerRegisterBean the dealerRegisterBean to set
 */
public void setDealerRegisterBean(List<DealerRegisterBean> dealerRegisterBean) {
	this.dealerRegisterBean = dealerRegisterBean;
}



}
