package com.vyavharamitra.vyavaharamenus.to.response;

import java.util.List;

import com.vyavharamitra.utils.VyavaharaResponse;
import com.vyavharamitra.vyavaharamenus.bean.VyavaharaMenuBean;

public class VyavaharaMenuResponse extends VyavaharaResponse{

	private List<VyavaharaMenuBean> vyavaharaMenuBean;

	/**
	 * @return the vyavaharaMenuBean
	 */
	public List<VyavaharaMenuBean> getVyavaharaMenuBean() {
		return vyavaharaMenuBean;
	}

	/**
	 * @param vyavaharaMenuBean the vyavaharaMenuBean to set
	 */
	public void setVyavaharaMenuBean(List<VyavaharaMenuBean> vyavaharaMenuBean) {
		this.vyavaharaMenuBean = vyavaharaMenuBean;
	}

}
