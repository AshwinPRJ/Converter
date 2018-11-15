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

import com.vyavharamitra.unitofmeasurement.bean.VendorMasterBean;
import com.vyavharamitra.unitofmeasurement.dao.IVendorMasterDao;
import com.vyavharamitra.utils.Utils;

@Repository
public class VendorMasterDaoImp implements IVendorMasterDao{
	private Session session;
	DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
	Calendar calenderObj = Calendar.getInstance();
	Date date = new Date();
	
	
public VendorMasterBean vendorCreateDao(SessionFactory sessionFactory, VendorMasterBean vendorMasterBean) {
	vendorMasterBean.setVendorEnteredTime(dateFormate.format(calenderObj.getTime()));
	vendorMasterBean.setVendorEnteredDate(date);
		session = sessionFactory.openSession();
		session.save(vendorMasterBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(vendorMasterBean))
		{
			return vendorMasterBean;
		}
		return vendorMasterBean;
	}
	
	
}
