package com.vyavharamitra.reports.keys.service;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.reports.keys.to.request.DealerReportRequest;
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;

public interface IPurchaseBillReportService {
	List<PurchaseBillBean> getpurchasedetails(DealerReportRequest dealerReportRequest);

	
	List<PurchaseBillBean> getpurchasedatedetails(DealerReportRequest dealerReportRequest);

	
	
}
