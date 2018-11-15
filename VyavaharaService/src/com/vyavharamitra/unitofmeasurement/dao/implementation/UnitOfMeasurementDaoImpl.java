package com.vyavharamitra.unitofmeasurement.dao.implementation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.unitofmeasurement.dao.IUnitOfMeasurementDao;
import com.vyavharamitra.utils.Utils;
/**
 * @author : Kalyani
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */
@Repository
public class UnitOfMeasurementDaoImpl implements IUnitOfMeasurementDao {

	private Session session;
	DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
	Calendar calenderObj = Calendar.getInstance();
	Date date = new Date();

	public UnitOfMeasurementBean unitOfMeasurementCreateDao(SessionFactory sessionFactory, UnitOfMeasurementBean unitOfMeasurementBean) {
		
		unitOfMeasurementBean.setEnteredTime(dateFormate.format(calenderObj.getTime()));
		unitOfMeasurementBean.setEnteredDate(date);
		session = sessionFactory.openSession();
		session.save(unitOfMeasurementBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(unitOfMeasurementBean))
		{
			return unitOfMeasurementBean;
		}
		return unitOfMeasurementBean;
	}
	
	

	public UnitOfMeasurementBean unitOfMeasurementSelectDao(SessionFactory sessionFactory,UnitOfMeasurementBean unitOfMeasurementBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		UnitOfMeasurementBean unitDetails = (UnitOfMeasurementBean) session.createCriteria(UnitOfMeasurementBean.class).add(Restrictions.eq("unitMeasurementNumber", unitOfMeasurementBean.getUnitMeasurementNumber())).uniqueResult();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(unitDetails))
		{
			return unitDetails;
		}
		return unitDetails;
	}
}
