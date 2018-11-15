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

import com.vyavharamitra.unitofmeasurement.bean.VendorMasterBean;
import com.vyavharamitra.unitofmeasurement.dao.IVendorMasterDao;
import com.vyavharamitra.unitofmeasurement.service.IVendorMasterService;
import com.vyavharamitra.unitofmeasurement.to.request.VendorMasterRequest;
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
public class VendorMasterServiceImp implements IVendorMasterService{
	@Autowired
	private IVendorMasterDao iVendorMasterDao;

	private SessionFactory sessionFactory;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	@Autowired
	private HttpServletRequest httpServletRequest;
	public VendorMasterServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public VendorMasterBean vendorCreateService(VendorMasterRequest vendorMasterRequest) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		vendorMasterRequest.getVendorMasterBean().setVendorEnteredBy(ucb.getUserNumber());
		return iVendorMasterDao.vendorCreateDao(sessionFactory, vendorMasterRequest.getVendorMasterBean());
	}
	
}
