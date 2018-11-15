package com.vyavharamitra.greetings.service;
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
import com.vyavharamitra.greetings.beans.GreetingsBean;
import com.vyavharamitra.greetings.to.request.GreetingsRequest;

public interface IGreetingsService {
	public GreetingsBean greetingsCreateService(GreetingsRequest greetingsRequest);
//read greetings
	public List<GreetingsBean> greetingsFetch(GreetingsRequest greetingsRequest);


}
