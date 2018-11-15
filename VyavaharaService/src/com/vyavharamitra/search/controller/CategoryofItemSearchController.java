package com.vyavharamitra.search.controller;
/**
 * @author			: Brahmani
 * @created date	: 
 * @modified by		:  
 * @modified date	: 
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.search.service.ICategoryDetailsSearchService;
import com.vyavharamitra.search.to.response.CategoryDetailsSearchResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping("/categorydetailssearch")
public class CategoryofItemSearchController {

	@Autowired
	private ICategoryDetailsSearchService iCategoryDetailsSearchService;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@ResponseBody
	public CategoryDetailsSearchResponse getCategoryDetailsSearch() {
		CategoryDetailsSearchResponse categoryDetailsSearchResponse = new CategoryDetailsSearchResponse();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<CategoryOfItemBean> categoryOfItemBean = new ArrayList();
		categoryOfItemBean = iCategoryDetailsSearchService.getCategoryDetails();
		if (CollectionUtils.isEmpty(categoryOfItemBean)) {
			categoryDetailsSearchResponse.setStatusCode(StatusCodes.NO_CONTENT);
			categoryDetailsSearchResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			categoryDetailsSearchResponse.setCategoryOfItemBean(categoryOfItemBean);
			categoryDetailsSearchResponse.setStatusCode(StatusCodes.OK);
			categoryDetailsSearchResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);	
		}
		return categoryDetailsSearchResponse;
	}
}
