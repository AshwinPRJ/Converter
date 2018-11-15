package com.vyavharamitra.unitofmeasurement.service.implementation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.unitofmeasurement.bean.CustomerBean;
import com.vyavharamitra.unitofmeasurement.dao.ICustomerDao;
import com.vyavharamitra.unitofmeasurement.service.ICustomerService;
import com.vyavharamitra.unitofmeasurement.to.request.CustomerRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
@Service
public class CustomerServiceImp implements ICustomerService{
	@Autowired
	private ICustomerDao iCustomerDao;

	private SessionFactory sessionFactory;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	@Autowired
	private HttpServletRequest httpServletRequest;
	public CustomerServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public CustomerBean customerCreateService(CustomerRequest customerRequest) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		customerRequest.getCustomerBean().setCustomerEnteredBy(ucb.getUserNumber());
		return iCustomerDao.customerCreateDao(sessionFactory, customerRequest.getCustomerBean());
	}
}
