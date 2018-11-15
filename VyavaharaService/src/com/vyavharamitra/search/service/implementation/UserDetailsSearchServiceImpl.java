package com.vyavharamitra.search.service.implementation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.search.dao.IUserDetailsSearchDao;
import com.vyavharamitra.search.service.IUserDetailsSearchService;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service
public class UserDetailsSearchServiceImpl implements IUserDetailsSearchService{
	@Autowired
	private	IUserDetailsSearchDao iUserDetailsSearchDao;
	@Autowired
	private HttpServletRequest httpServletRequest;
		private SessionFactory sessionFactory;
		public UserDetailsSearchServiceImpl() {
			/**
			 * getting SessionFactory from Hibernate Util
			 */
			this.sessionFactory = HibernateUtil.getSessionFactory();
		}
		@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
		public List<UserCreationBean> getUserDetails(){
			UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
			int branchnumber=ucb.getBranchNumber();

			return  iUserDetailsSearchDao.getUserDetailsDao(sessionFactory,branchnumber);
		}
		@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)

		public List<UserCreationBean> getuserdetailsonblur(UserCreationRequest userCreationRequest){
			UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
			userCreationRequest.getUserCreationBean().setBranchNumber(ucb.getBranchNumber());
			return  iUserDetailsSearchDao.getUserDetailsonblurDao(sessionFactory,userCreationRequest);
		}
}
