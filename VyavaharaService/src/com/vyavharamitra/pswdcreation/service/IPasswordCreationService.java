package com.vyavharamitra.pswdcreation.service;

/**
 * @author : Mohan M
 * @created date : 
 */
import com.vyavharamitra.pswdcreation.to.PasswordCrationRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

public interface IPasswordCreationService {

	UserCreationBean passwordcreationService(PasswordCrationRequest passwordCrationRequest);

}
