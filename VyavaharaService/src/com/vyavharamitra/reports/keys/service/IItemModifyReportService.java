package com.vyavharamitra.reports.keys.service;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.itemdetails.beans.DeleteItemMasterBean;
import com.vyavharamitra.itemdetails.beans.UpdateItemMasterBean;
import com.vyavharamitra.reports.keys.to.request.ItemDeleteReportRequest;
import com.vyavharamitra.reports.keys.to.request.ItemModifyReportRequest;

public interface IItemModifyReportService {
	
	List<UpdateItemMasterBean> getitemreportdetails(ItemModifyReportRequest itemModifyReportRequest);
	
	
	List<DeleteItemMasterBean> getitemdeletereportdetails(ItemDeleteReportRequest itemDeleteReportRequest);

}
