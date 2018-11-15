package com.vyavharamitra.vyavaharamenus.service.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.vyavaharamenus.bean.VyavaharaMenuBean;
import com.vyavharamitra.vyavaharamenus.dao.IVyavaharaMenuDao;
import com.vyavharamitra.vyavaharamenus.service.IVyavaharaMenuService;
import com.vyavharamitra.vyavaharamenus.to.request.VyavaharaMenuRequest;

import resources.HibernateUtil;
@Service
public class VyavaharaMenuServiceImpl implements IVyavaharaMenuService{
	@Autowired
	private	IVyavaharaMenuDao iVyavaharaMenuDao;

		private SessionFactory sessionFactory;
		public VyavaharaMenuServiceImpl() {
			/**
			 * getting SessionFactory from Hibernate Util
			 */
			this.sessionFactory = HibernateUtil.getSessionFactory();
		}
		
		@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
		public List<VyavaharaMenuBean> getMenues(VyavaharaMenuRequest vyavaharaMenuRequest){
			return  iVyavaharaMenuDao.getMenues(vyavaharaMenuRequest,sessionFactory);
		}

		
}
