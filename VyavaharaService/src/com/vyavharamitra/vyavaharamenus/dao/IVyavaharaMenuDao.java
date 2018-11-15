package com.vyavharamitra.vyavaharamenus.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.vyavaharamenus.bean.VyavaharaMenuBean;
import com.vyavharamitra.vyavaharamenus.to.request.VyavaharaMenuRequest;

public interface IVyavaharaMenuDao {

	public List<VyavaharaMenuBean> getMenues(VyavaharaMenuRequest vyavaharaMenuRequest, SessionFactory sessionFactory);

}
