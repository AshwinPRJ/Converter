package com.vyavharamitra.greetings.dao;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.greetings.beans.GreetingsBean;

public interface IgreetingsUpdateDao {

	GreetingsBean greetingsUpdateDao(SessionFactory sessionFactory, GreetingsBean greetingsBean);

}
