package com.vyavharamitra.categoryofitem.service;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.categoryofitem.to.request.CategoryOfItemRequest;


/**
 * @author : Lavanya
 * @created date :24 Nov 2017
 * @modified by :
 * @modified date :
 */

public interface ICategoryOfItemService {
	public CategoryOfItemBean categoryOfItemCreateService(CategoryOfItemRequest CategoryOfItemRequest);

	public CategoryOfItemBean categoryOfItemUpdateService(CategoryOfItemRequest CategoryOfItemRequest);

	public CategoryOfItemBean categoryOfItemReadService(CategoryOfItemRequest CategoryOfItemRequest);

	public CategoryOfItemBean categoryOfItemDeleteService(CategoryOfItemRequest CategoryOfItemRequest);

	public CategoryOfItemBean gstCalcService(CategoryOfItemRequest categoryOfItemRequest);

}

