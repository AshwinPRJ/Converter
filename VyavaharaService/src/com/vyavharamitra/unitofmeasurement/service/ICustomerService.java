package com.vyavharamitra.unitofmeasurement.service;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.unitofmeasurement.bean.CustomerBean;
import com.vyavharamitra.unitofmeasurement.to.request.CustomerRequest;

public interface ICustomerService {

	
	public CustomerBean customerCreateService(CustomerRequest customerRequest);

}
