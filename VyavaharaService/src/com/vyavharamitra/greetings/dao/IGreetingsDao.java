package com.vyavharamitra.greetings.dao;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.math.BigInteger;
import java.util.List;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.greetings.beans.GreetingsBean;
import com.vyavharamitra.greetings.to.request.GreetingsRequest;

public interface IGreetingsDao {
	
	GreetingsBean greetingsCreateDao(SessionFactory sessionFactory, GreetingsBean greetingsBean);
	List<GreetingsBean> greetingsFetch(SessionFactory sessionFactory, GreetingsRequest greetingsRequest);
}
