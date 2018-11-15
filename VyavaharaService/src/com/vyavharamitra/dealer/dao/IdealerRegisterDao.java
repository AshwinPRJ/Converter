package com.vyavharamitra.dealer.dao;

import java.util.List;

/**
 * @author : Brahmani
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;

public interface IdealerRegisterDao {


	 public DealerRegisterBean dealerCreateDao(SessionFactory sessionFactory, DealerRegisterBean dealerRegisterBean);
	
	
	 
	 
	 public List<OrganizationMasterBean> dealersOrgReadDao(SessionFactory sessionFactory,DealerRegisterBean dealerRegisterBean);

	 
	 
	 
	 
}
