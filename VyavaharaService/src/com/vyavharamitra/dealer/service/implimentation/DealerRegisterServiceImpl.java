package com.vyavharamitra.dealer.service.implimentation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Brahmani
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealer.dao.IdealerRegisterDao;
import com.vyavharamitra.dealer.service.IdealerRegisterService;
import com.vyavharamitra.dealer.to.request.DealerRegisterRequest;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service
public class DealerRegisterServiceImpl implements IdealerRegisterService {

	@Autowired
	IdealerRegisterDao idealerRegisterDao;

	private SessionFactory sessionFactory;
	
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	@Autowired
	private HttpServletRequest httpServletRequest;
	
	public DealerRegisterServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public DealerRegisterBean dealerCreateService(DealerRegisterRequest dealerRegisterRequest) {

		UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
		 String dealerStatus="A";
		 dealerRegisterRequest.getDealerRegisterBean().setDealerStatus(dealerStatus);
		dealerRegisterRequest.getDealerRegisterBean().setDealerEnteredBy(ucb.getEnteredBy());
		dealerRegisterRequest.getDealerRegisterBean().setDealerEnteredOn(date);
		dealerRegisterRequest.getDealerRegisterBean().setDealerEnteredTime(dateFormat.format(date));
		
		return idealerRegisterDao.dealerCreateDao(sessionFactory, dealerRegisterRequest.getDealerRegisterBean());

	}

	@Override
	public List<OrganizationMasterBean> dealersOrgReadService(DealerRegisterRequest dealerRegisterRequest) {

		
	
		return idealerRegisterDao.dealersOrgReadDao(sessionFactory, dealerRegisterRequest.getDealerRegisterBean());
	}

}
