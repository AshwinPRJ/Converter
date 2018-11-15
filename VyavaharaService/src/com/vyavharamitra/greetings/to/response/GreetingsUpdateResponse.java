package com.vyavharamitra.greetings.to.response;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.greetings.beans.GreetingsBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class GreetingsUpdateResponse extends  VyavaharaResponse{
	private GreetingsBean greetingsBean;

	/**
	 * @return the greetingsBean
	 */
	public GreetingsBean getGreetingsBean() {
		return greetingsBean;
	}

	/**
	 * @param greetingsBean the greetingsBean to set
	 */
	public void setGreetingsBean(GreetingsBean greetingsBean) {
		this.greetingsBean = greetingsBean;
	}
	
	
	

}
