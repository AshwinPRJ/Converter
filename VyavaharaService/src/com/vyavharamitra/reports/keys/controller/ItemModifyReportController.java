package com.vyavharamitra.reports.keys.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.itemdetails.beans.DeleteItemMasterBean;
import com.vyavharamitra.itemdetails.beans.UpdateItemMasterBean;
import com.vyavharamitra.reports.keys.service.implementation.ItemModifyReportServiceImp;
import com.vyavharamitra.reports.keys.to.request.ItemDeleteReportRequest;
import com.vyavharamitra.reports.keys.to.request.ItemModifyReportRequest;
import com.vyavharamitra.reports.keys.to.response.ItemDeleteReportResponse;
import com.vyavharamitra.reports.keys.to.response.ItemModifyReportResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Kalyani
 * @created date :30 Nov 2017
 * @modified by :
 * @modified date :
 */@Controller
 @RequestMapping(value = "/ItemModify")
public class ItemModifyReportController {
	 @Autowired
		private ItemModifyReportServiceImp itemModifyReportServiceImp;
		
		@RequestMapping(value = "/ItemModifyReport", method = RequestMethod.POST)
		@ResponseBody
		public ItemModifyReportResponse getitemreportdetails(@RequestBody ItemModifyReportRequest itemModifyReportRequest) {
			ItemModifyReportResponse itemModifyReportResponse = new ItemModifyReportResponse();
			List<UpdateItemMasterBean> updateItemMasterBean = Collections.emptyList();
			updateItemMasterBean= itemModifyReportServiceImp.getitemreportdetails(itemModifyReportRequest);
			if (CollectionUtils.isEmpty(updateItemMasterBean) ){
				itemModifyReportResponse.setStatusCode(StatusCodes.NO_CONTENT);
				itemModifyReportResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
				
				
			} else {
				itemModifyReportResponse.setUpdateItemMasterBean(updateItemMasterBean);

				itemModifyReportResponse.setStatusCode(StatusCodes.OK);
				itemModifyReportResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
			}
			return itemModifyReportResponse;
		}
		
	
		//Deleted item history report
		@RequestMapping(value = "/ItemDeleteReport", method = RequestMethod.POST)
		@ResponseBody
		public ItemDeleteReportResponse getitemdeletereportdetails(@RequestBody ItemDeleteReportRequest itemDeleteReportRequest) {
			ItemDeleteReportResponse itemDeleteReportResponse = new ItemDeleteReportResponse();
			List<DeleteItemMasterBean> deleteItemMasterBean = Collections.emptyList();
			deleteItemMasterBean= itemModifyReportServiceImp.getitemdeletereportdetails(itemDeleteReportRequest);
			if (CollectionUtils.isEmpty(deleteItemMasterBean) ){
				itemDeleteReportResponse.setStatusCode(StatusCodes.NO_CONTENT);
				itemDeleteReportResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
				
				
			} else {
				itemDeleteReportResponse.setDeleteItemMasterBean(deleteItemMasterBean);

				itemDeleteReportResponse.setStatusCode(StatusCodes.OK);
				itemDeleteReportResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
			}
			return itemDeleteReportResponse;
		}
		
		
}
