package com.vyavharamitra.unitofmeasurement.dao.implementation;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.unitofmeasurement.bean.CustomerBean;
import com.vyavharamitra.unitofmeasurement.dao.ICustomerDao;
import com.vyavharamitra.utils.Utils;

@Repository
public class CustomerDaoImp implements ICustomerDao{
	private Session session;
	DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
	Calendar calenderObj = Calendar.getInstance();
	Date date = new Date();
	
	
public CustomerBean customerCreateDao(SessionFactory sessionFactory, CustomerBean customerBean) {
	customerBean.setCustomerEnteredTime(dateFormate.format(calenderObj.getTime()));
	customerBean.setCustomerEnteredDate(date);
		session = sessionFactory.openSession();
		session.save(customerBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(customerBean))
		{
			return customerBean;
		}
		return customerBean;
	}
}
