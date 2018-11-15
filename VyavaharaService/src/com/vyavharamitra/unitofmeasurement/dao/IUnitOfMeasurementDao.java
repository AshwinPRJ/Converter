package com.vyavharamitra.unitofmeasurement.dao;

/**
 * @author : Kalyani
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;

public interface IUnitOfMeasurementDao {

	UnitOfMeasurementBean unitOfMeasurementCreateDao(SessionFactory sessionFactory, UnitOfMeasurementBean unitOfMeasurementBean);

	
	
	public UnitOfMeasurementBean unitOfMeasurementSelectDao(SessionFactory sessionFactory, UnitOfMeasurementBean unitOfMeasurementBean);


}
