package com.vyavharamitra.dealer.dao;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealer.to.request.DealerStatusRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

public interface IdealerStatusDao {

    
    public List<DealerRegisterBean> dealerRegisterReadDao(SessionFactory sessionFactory,Integer dealerId);

public	UserCreationBean dealerUpdateDao(SessionFactory sessionFactory,DealerStatusRequest dealerStatusRequest);




}
