package com.vyavharamitra.changepassword.service;

import com.vyavharamitra.changepassword.to.request.ChangePSWRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
public interface IChangePSWService {

	public UserCreationBean changepasswordUpdateService(ChangePSWRequest changePSWRequest);

	
}
