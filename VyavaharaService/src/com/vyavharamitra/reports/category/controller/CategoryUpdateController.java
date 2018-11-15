package com.vyavharamitra.reports.category.controller;



import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;
import com.vyavharamitra.reports.category.service.ICategoryUpdateService;
import com.vyavharamitra.reports.category.to.request.CategoryUpdateRequest;
import com.vyavharamitra.reports.category.to.response.CategoryUpdateResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */

@Controller
/*@CrossOrigin(origins = VyavaharaConstants.URL)*/
@RequestMapping(value = "/category")
public class CategoryUpdateController {
	@Autowired
	private ICategoryUpdateService iCategoryUpdateService;
	/**
	 * Category Update Read
	 */
	@RequestMapping(value = "/update/read", method = RequestMethod.POST)
	@ResponseBody
	public CategoryUpdateResponse categoryUpdateReadController(@RequestBody CategoryUpdateRequest categoryUpdateRequest ) {
		CategoryUpdateResponse categoryUpdateResponse=new CategoryUpdateResponse();	
		List<UpdateCategoryOfItemBean> updateCategoryOfItemBean ;
		updateCategoryOfItemBean= iCategoryUpdateService.categoryService(categoryUpdateRequest.getUpdateCategoryOfItemBean().getCategoryName());
		if (CollectionUtils.isEmpty(updateCategoryOfItemBean)) {
			categoryUpdateResponse.setStatusCode(StatusCodes.NO_CONTENT);
			categoryUpdateResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			categoryUpdateResponse.setUpdateCategoryOfItemBean(updateCategoryOfItemBean);
			categoryUpdateResponse.setStatusCode(StatusCodes.OK);
			categoryUpdateResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return categoryUpdateResponse;
	}

	/**
	 * 	Category Delete Read
	 */


	@RequestMapping(value = "/delete/read", method = RequestMethod.POST)
	@ResponseBody
	public CategoryUpdateResponse categoryDeleteReadController(@RequestBody CategoryUpdateRequest categoryUpdateRequest ) {
		CategoryUpdateResponse categoryUpdateResponse=new CategoryUpdateResponse();	
		List<DeleteCategoryOfItemBean> deleteCategoryOfItemBean ;
		deleteCategoryOfItemBean= iCategoryUpdateService.categoryDeleteReadService(categoryUpdateRequest);
		if (CollectionUtils.isEmpty(deleteCategoryOfItemBean)) {
			categoryUpdateResponse.setStatusCode(StatusCodes.NO_CONTENT);
			categoryUpdateResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		} else {
			categoryUpdateResponse.setDeleteCategoryOfItemBean(deleteCategoryOfItemBean);
			categoryUpdateResponse.setStatusCode(StatusCodes.OK);
			categoryUpdateResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		}
		return categoryUpdateResponse;
	}
}

