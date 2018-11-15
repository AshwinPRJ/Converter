package com.vyavharamitra.dealer.service.implimentation;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealer.dao.IdealerStatusDao;
import com.vyavharamitra.dealer.service.IdealerStatusService;
import com.vyavharamitra.dealer.to.request.DealerStatusRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

import resources.HibernateUtil;
@Service

public class DealerStatusServiceImp implements IdealerStatusService{
	@Autowired
	private IdealerStatusDao idealerStatusDao;
	protected SessionFactory sessionFactory;

		public DealerStatusServiceImp() {
			/**
			 * getting SessionFactory from Hibernate Util
			 */
			this.sessionFactory = HibernateUtil.getSessionFactory();
		}

		@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
		public UserCreationBean dealerUpdateService(DealerStatusRequest dealerStatusRequest) {
		return idealerStatusDao.dealerUpdateDao(sessionFactory,dealerStatusRequest);
	}

		// read category item
		@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)

		public List<DealerRegisterBean> dealerRegisterReadService(Integer dealerId){
					
				return idealerStatusDao.dealerRegisterReadDao(sessionFactory,dealerId);
			}	
	
}
