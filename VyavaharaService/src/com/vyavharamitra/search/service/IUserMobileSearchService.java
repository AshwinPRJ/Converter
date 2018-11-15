package com.vyavharamitra.search.service;

import java.util.List;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.search.to.request.UserMobileSearchRequest;

public interface IUserMobileSearchService {

	List<CashSalesBean> getUserMobileonblur(UserMobileSearchRequest userMobileSearchRequest);
}
