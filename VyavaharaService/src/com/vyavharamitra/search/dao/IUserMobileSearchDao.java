package com.vyavharamitra.search.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.search.to.request.UserMobileSearchRequest;

public interface IUserMobileSearchDao {
	List<CashSalesBean> getUserMobileonblurDao(UserMobileSearchRequest userMobileSearchRequest, SessionFactory sessionFactory);

}
