package com.vyavharamitra.vyavaharamenus.service;

import java.util.List;

import com.vyavharamitra.vyavaharamenus.bean.VyavaharaMenuBean;
import com.vyavharamitra.vyavaharamenus.to.request.VyavaharaMenuRequest;

public interface IVyavaharaMenuService {

public 	List<VyavaharaMenuBean> getMenues(VyavaharaMenuRequest vyavaharaMenuRequest);

}
