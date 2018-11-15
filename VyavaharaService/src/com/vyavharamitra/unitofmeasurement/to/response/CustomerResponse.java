package com.vyavharamitra.unitofmeasurement.to.response;
import com.vyavharamitra.unitofmeasurement.bean.CustomerBean;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.utils.VyavaharaResponse;
public class CustomerResponse extends VyavaharaResponse {
	
	
	private CustomerBean customerBean;

	/**
	 * @return the customerBean
	 */
	public CustomerBean getCustomerBean() {
		return customerBean;
	}

	/**
	 * @param customerBean the customerBean to set
	 */
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}
	
	
	
}
