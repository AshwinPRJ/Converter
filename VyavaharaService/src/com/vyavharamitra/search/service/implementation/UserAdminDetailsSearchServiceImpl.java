package com.vyavharamitra.search.service.implementation;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.search.dao.IUserAdminDetailsSearchDao;
import com.vyavharamitra.search.service.IUserAdminDetailsSearchService;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service
public class UserAdminDetailsSearchServiceImpl implements IUserAdminDetailsSearchService{
	@Autowired
	private	IUserAdminDetailsSearchDao iUserAdminDetailsSearchDao;
	@Autowired
	private HttpServletRequest httpServletRequest;
	
		private SessionFactory sessionFactory;
		public UserAdminDetailsSearchServiceImpl() {
			/**
			 * getting SessionFactory from Hibernate Util
			 */
			this.sessionFactory = HibernateUtil.getSessionFactory();
		}
		@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
		public List<UserCreationBean> getUserAdminDetails(){
			UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
		int dealerId=ucb.getDealerId();
			return  iUserAdminDetailsSearchDao.getUserAdminDetailsDao(sessionFactory,dealerId);
		}
		@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)

		public List<UserCreationBean> getuseradmindetailsonblur(UserCreationRequest userCreationRequest){
			UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
			userCreationRequest.getUserCreationBean().setDealerId(ucb.getDealerId());
			return  iUserAdminDetailsSearchDao.getUserAdminDetailsonblurDao(sessionFactory,userCreationRequest);
		}
}
