package com.vyavharamitra.search.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.search.to.request.DealerDetailsSearchRequest;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public interface IDealerDetailsSearchDao {


	List<DealerRegisterBean> getDealerDetailsDao(SessionFactory sessionFactory);

	List<DealerRegisterBean> getDealerDetailsonblurDao(DealerDetailsSearchRequest dealerDetailsSearchRequest,
			SessionFactory sessionFactory);

}
