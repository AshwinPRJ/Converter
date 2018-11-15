package com.vyavharamitra.dealer.service;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealer.to.request.DealerStatusRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

public interface IdealerStatusService {



	public List<DealerRegisterBean> dealerRegisterReadService(Integer dealerId);

	public UserCreationBean dealerUpdateService(DealerStatusRequest dealerStatusRequest);
	

}
