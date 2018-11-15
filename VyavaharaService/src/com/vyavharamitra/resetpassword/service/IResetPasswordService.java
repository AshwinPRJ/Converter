package com.vyavharamitra.resetpassword.service;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.resetpassword.to.request.ResetPasswordRequest;


/**
 * @author : Lavanya
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */


public interface IResetPasswordService {
	public UserCreationBean userAdminResetPasswordUpdateService(ResetPasswordRequest resetPasswordRequest);
	
	public UserCreationBean userResetPasswordUpdateService(ResetPasswordRequest resetPasswordRequest);
	
	public UserCreationBean dealerResetPasswordUpdateService(String userNUmber);


}
