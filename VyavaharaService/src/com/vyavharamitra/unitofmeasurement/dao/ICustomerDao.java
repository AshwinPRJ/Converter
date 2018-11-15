package com.vyavharamitra.unitofmeasurement.dao;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.unitofmeasurement.bean.CustomerBean;

public interface ICustomerDao {
	
	CustomerBean customerCreateDao(SessionFactory sessionFactory, CustomerBean customerBean);


}
