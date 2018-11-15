package com.vyavharamitra.greetings.to.response;
import java.util.List;

import com.vyavharamitra.greetings.beans.GreetingsBean;
import com.vyavharamitra.utils.VyavaharaResponse;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
public class GreetingsResponse extends VyavaharaResponse  {
	
	private List<GreetingsBean> greetingsBean;

	/**
	 * @return the greetingsBean
	 */
	public List<GreetingsBean> getGreetingsBean() {
		return greetingsBean;
	}

	/**
	 * @param greetingsBean the greetingsBean to set
	 */
	public void setGreetingsBean(List<GreetingsBean> greetingsBean) {
		this.greetingsBean = greetingsBean;
	}

	public void setGreetingsBean(GreetingsBean greetingsBean2) {

		
	}
	
	

}

