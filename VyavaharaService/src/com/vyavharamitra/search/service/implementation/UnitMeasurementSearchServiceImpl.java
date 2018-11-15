package com.vyavharamitra.search.service.implementation;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.search.dao.IUnitMeasurementSearchDao;
import com.vyavharamitra.search.service.IUnitMeasurementSearchService;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;

import resources.HibernateUtil;

@Service
public class UnitMeasurementSearchServiceImpl implements IUnitMeasurementSearchService{

	@Autowired
	private IUnitMeasurementSearchDao iUnitMeasurementSearchDao;
	private SessionFactory sessionFactory;
	public UnitMeasurementSearchServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<UnitOfMeasurementBean> getUOMDetails(){
		return  iUnitMeasurementSearchDao.getUOMDetailsDao(sessionFactory);
	}
}
