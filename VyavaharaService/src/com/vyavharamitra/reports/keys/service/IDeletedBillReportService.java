package com.vyavharamitra.reports.keys.service;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.reports.keys.to.request.DeletedBillReportRequest;

public interface IDeletedBillReportService {
	List<DeleteBillBean> getdeletereportdetails(DeletedBillReportRequest deletedBillReportRequest);

}
