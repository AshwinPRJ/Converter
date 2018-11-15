package com.vyavharamitra.search.service;

import java.util.List;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.search.to.request.DealerDetailsSearchRequest;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public interface IDealerDetailsSearchService {


	List<DealerRegisterBean> getDealerDetails();

	List<DealerRegisterBean> getDealerDetailsonblur(DealerDetailsSearchRequest dealerDetailsSearchRequest);

}
