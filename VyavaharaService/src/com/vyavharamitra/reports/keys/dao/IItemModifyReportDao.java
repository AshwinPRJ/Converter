package com.vyavharamitra.reports.keys.dao;
/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.itemdetails.beans.DeleteItemMasterBean;
import com.vyavharamitra.itemdetails.beans.UpdateItemMasterBean;
import com.vyavharamitra.reports.keys.to.request.ItemDeleteReportRequest;
import com.vyavharamitra.reports.keys.to.request.ItemModifyReportRequest;

public interface IItemModifyReportDao {

	List<UpdateItemMasterBean> getitemreportdetails(SessionFactory sessionFactory,ItemModifyReportRequest itemModifyReportRequest);

	
	List<DeleteItemMasterBean> getitemdeletereportdetails(SessionFactory sessionFactory,ItemDeleteReportRequest itemDeleteReportRequest);

}
