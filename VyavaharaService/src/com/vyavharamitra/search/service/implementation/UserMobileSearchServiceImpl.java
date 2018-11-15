package com.vyavharamitra.search.service.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.search.dao.IUserMobileSearchDao;
import com.vyavharamitra.search.service.IUserMobileSearchService;
import com.vyavharamitra.search.to.request.UserMobileSearchRequest;

import resources.HibernateUtil;

@Service
public class UserMobileSearchServiceImpl implements IUserMobileSearchService{
	@Autowired
	private	IUserMobileSearchDao iUserMobileSearchDao;

		private SessionFactory sessionFactory;
		public UserMobileSearchServiceImpl() {
			/**
			 * getting SessionFactory from Hibernate Util
			 */
			this.sessionFactory = HibernateUtil.getSessionFactory();
		}
		@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
		public List<CashSalesBean> getUserMobileonblur(UserMobileSearchRequest userMobileSearchRequest){
			return  iUserMobileSearchDao.getUserMobileonblurDao(userMobileSearchRequest,sessionFactory);
		}
}
