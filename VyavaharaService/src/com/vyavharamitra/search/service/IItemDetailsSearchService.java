package com.vyavharamitra.search.service;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.search.to.request.ItemDetailsSearchRequest;

public interface IItemDetailsSearchService {

	List<ItemMasterBean> getItemDetails();
	
	List<ItemMasterBean> getItemDetailsblur(ItemDetailsSearchRequest itemDetailsSearchRequest);
}
