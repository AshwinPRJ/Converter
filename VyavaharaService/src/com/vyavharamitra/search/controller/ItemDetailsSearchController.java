package com.vyavharamitra.search.controller;
/**
 * @author			: Brahmani
 * @created date	: 
 * @modified by		:  
 * @modified date	: 
 */
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.search.service.IItemDetailsSearchService;
import com.vyavharamitra.search.to.response.ItemDetailsSearchResponse;
import com.vyavharamitra.search.to.request.ItemDetailsSearchRequest;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping("/itemdetailssearch")
public class ItemDetailsSearchController {

	@Autowired
	private IItemDetailsSearchService iItemDetailsSearchService;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@ResponseBody
	public ItemDetailsSearchResponse getItemDetailsSearch() {
		ItemDetailsSearchResponse itemDetailsSearchResponse = new ItemDetailsSearchResponse();
		List<ItemMasterBean> itemMasterBean = Collections.emptyList();
		itemMasterBean = iItemDetailsSearchService.getItemDetails();
		if (CollectionUtils.isEmpty(itemMasterBean)) {
			itemDetailsSearchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			itemDetailsSearchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			itemDetailsSearchResponse.setItemMasterBean(itemMasterBean);
			itemDetailsSearchResponse.setStatusCode(StatusCodes.OK);
			itemDetailsSearchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
		}
		return itemDetailsSearchResponse;
	}
	
	
	@RequestMapping(value = "/read/single/record", method = RequestMethod.POST)
	@ResponseBody
	public ItemDetailsSearchResponse getItemDetailsOnBlur(@RequestBody ItemDetailsSearchRequest itemDetailsSearchRequest) {
		ItemDetailsSearchResponse itemDetailsSearchResponse = new ItemDetailsSearchResponse();
		List<ItemMasterBean> itemMasterBean = Collections.emptyList();
		itemMasterBean = iItemDetailsSearchService.getItemDetailsblur(itemDetailsSearchRequest);
		if (CollectionUtils.isEmpty(itemMasterBean)) {
			itemDetailsSearchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			itemDetailsSearchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			itemDetailsSearchResponse.setItemMasterBean(itemMasterBean);
			itemDetailsSearchResponse.setStatusCode(StatusCodes.OK);
			itemDetailsSearchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
		}
		return itemDetailsSearchResponse;
	}
}
