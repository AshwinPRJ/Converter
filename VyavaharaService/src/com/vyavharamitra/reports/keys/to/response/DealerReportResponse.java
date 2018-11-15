package com.vyavharamitra.reports.keys.to.response;

import java.util.List;

import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.VyavaharaResponse;

/**
 * @author : Kalyani
 * @created date : 
 * @modified by :
 * @modified date :
 */
public class DealerReportResponse extends VyavaharaResponse{
	private List<UserCreationBean> userCreationBean;
	
	private List<PurchaseBillBean> purchaseBillBean;

	/**
	 * @return the purchaseBillBean
	 */
	public List<PurchaseBillBean> getPurchaseBillBean() {
		return purchaseBillBean;
	}

	/**
	 * @param purchaseBillBean the purchaseBillBean to set
	 */
	public void setPurchaseBillBean(List<PurchaseBillBean> purchaseBillBean) {
		this.purchaseBillBean = purchaseBillBean;
	}

	/**
	 * @return the userCreationBean
	 */
	public List<UserCreationBean> getUserCreationBean() {
		return userCreationBean;
	}

	/**
	 * @param userCreationBean the userCreationBean to set
	 */
	public void setUserCreationBean(List<UserCreationBean> userCreationBean) {
		this.userCreationBean = userCreationBean;
	}
	
	
}
