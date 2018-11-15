package com.vyavharamitra.unitofmeasurement.service.implementation;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import javax.servlet.http.HttpServletRequest;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.unitofmeasurement.dao.IUnitOfMeasurementDao;
import com.vyavharamitra.unitofmeasurement.service.IUnitOfMeasurementService;
import com.vyavharamitra.unitofmeasurement.to.request.UnitOfMeasurementRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service
public class UnitOfMeasurementServiceImpl implements IUnitOfMeasurementService {

	@Autowired
	private IUnitOfMeasurementDao iUnitOfMeasurementDao;

	private SessionFactory sessionFactory;

	@Autowired
	private HttpServletRequest httpServletRequest;

	public UnitOfMeasurementServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public UnitOfMeasurementBean unitOfMeasurementCreateService(UnitOfMeasurementRequest unitOfMeasurementRequest) {

		UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
		unitOfMeasurementRequest.getUnitOfMeasurementBean().setEnteredBy(ucb.getUserNumber());

		return iUnitOfMeasurementDao.unitOfMeasurementCreateDao(sessionFactory, unitOfMeasurementRequest.getUnitOfMeasurementBean());
	}

	// fetching of unit details

	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public UnitOfMeasurementBean unitOfMeasurementReadService(UnitOfMeasurementRequest unitOfMeasurementRequest) {
		return iUnitOfMeasurementDao.unitOfMeasurementSelectDao(sessionFactory,
				unitOfMeasurementRequest.getUnitOfMeasurementBean());
	}

}
