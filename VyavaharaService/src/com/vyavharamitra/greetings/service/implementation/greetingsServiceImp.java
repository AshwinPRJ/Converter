package com.vyavharamitra.greetings.service.implementation;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.vyavharamitra.greetings.dao.IGreetingsDao;
import com.vyavharamitra.greetings.service.IGreetingsService;
import com.vyavharamitra.greetings.to.request.GreetingsRequest;
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
public class greetingsServiceImp implements IGreetingsService {
	
	@Autowired
	private IGreetingsDao iGreetingsDao;

	private SessionFactory sessionFactory;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	@Autowired
	private HttpServletRequest httpServletRequest;
	public greetingsServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public GreetingsBean greetingsCreateService(GreetingsRequest greetingsRequest) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		String branchStatus="A";
		greetingsRequest.getGreetingsBean().setBranchStatus(branchStatus);
		greetingsRequest.getGreetingsBean().setBranchEnteredBy(ucb.getUserNumber());
		return iGreetingsDao.greetingsCreateDao(sessionFactory, greetingsRequest.getGreetingsBean());
	}

	
	//read greetings
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<GreetingsBean> greetingsFetch(GreetingsRequest greetingsRequest) {
		return iGreetingsDao.greetingsFetch(sessionFactory,greetingsRequest);
	}
}
	
	
	
	
	
	


	


