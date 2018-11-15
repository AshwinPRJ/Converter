package com.vyavharamitra.search.dao;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;


public interface IUnitMeasurementSearchDao {

	List<UnitOfMeasurementBean> getUOMDetailsDao(SessionFactory sessionFactory);

}
