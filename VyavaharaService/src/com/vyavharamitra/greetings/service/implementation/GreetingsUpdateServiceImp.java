package com.vyavharamitra.greetings.service.implementation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.greetings.beans.GreetingsBean;
import com.vyavharamitra.greetings.dao.IgreetingsUpdateDao;
import com.vyavharamitra.greetings.service.IgreetingsUpdateService;
import com.vyavharamitra.greetings.to.request.GreetingsUpdateRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service

public class GreetingsUpdateServiceImp implements IgreetingsUpdateService{
	@Autowired
	 IgreetingsUpdateDao igreetingsupdateDao;
	private SessionFactory sessionFactory;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	@Autowired
	private HttpServletRequest httpServletRequest;
	
		public GreetingsUpdateServiceImp() {
			/**
			 * getting SessionFactory from Hibernate Util
			 */
			this.sessionFactory = HibernateUtil.getSessionFactory();
		}

		
		
		
		@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
		public GreetingsBean greetingsUpdateService(GreetingsUpdateRequest greetingsupdateRequest) {
			UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
			greetingsupdateRequest.getGreetingsBean().setBranchEnteredBy(ucb.getUserNumber());
			greetingsupdateRequest.getGreetingsBean().setBranchDate(date);
			greetingsupdateRequest.getGreetingsBean().setBranchTime(dateFormat.format(date));
			
			return igreetingsupdateDao.greetingsUpdateDao(sessionFactory, greetingsupdateRequest.getGreetingsBean());
		}
		

}
