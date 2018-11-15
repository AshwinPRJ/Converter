package com.vyavharamitra.reports.keys.to.request;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
public class DealerReportRequest {
	private UserCreationBean userCreationBean;
	
	private PurchaseBillBean purchaseBillBean;

	/**
	 * @return the purchaseBillBean
	 */
	public PurchaseBillBean getPurchaseBillBean() {
		return purchaseBillBean;
	}

	/**
	 * @param purchaseBillBean the purchaseBillBean to set
	 */
	public void setPurchaseBillBean(PurchaseBillBean purchaseBillBean) {
		this.purchaseBillBean = purchaseBillBean;
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
	
	

}
