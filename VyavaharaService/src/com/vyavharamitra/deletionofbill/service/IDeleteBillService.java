package com.vyavharamitra.deletionofbill.service;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.deletionofbill.to.request.DeleteBillRequest;
import com.vyavharamitra.deletionofbill.to.request.DeleteRequest;

public interface IDeleteBillService {
	
	public List<CashSalesBean> sellitemFetch(DeleteBillRequest deleteBillRequest);

	public DeleteBillBean create(DeleteRequest deleteRequest);

}
