package com.vyavharamitra.search.service;

import java.util.List;


import com.vyavharamitra.usercreation.bean.UserCreationBean;

/**
 * @author : lavanya
 * @created date : 09 Jan 2018
 * @modified by : 
 * @modified date :
 */

public interface IValidUserSearchService {

	List<UserCreationBean> userService(String userNumber);

}
