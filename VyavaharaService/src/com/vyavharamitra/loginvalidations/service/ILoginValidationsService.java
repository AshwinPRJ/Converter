package com.vyavharamitra.loginvalidations.service;
import javax.validation.Valid;

/**
 * @author : M Mohan
 * @created date : 
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;

public interface ILoginValidationsService {

	UserCreationBean loginvalidationsReadService(UserCreationRequest userCreationRequest);

	UserCreationBean userLoginValuesService();

	UserCreationBean userLogoutValuesService();

}
