package com.vyavharamitra.categoryofitem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.categoryofitem.service.ICategoryOfItemService;
import com.vyavharamitra.categoryofitem.to.request.CategoryOfItemRequest;
import com.vyavharamitra.categoryofitem.to.response.CategoryOfItemResponse;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;


/**
 * @author : Lavanya
 * @created date :24 Nov 2017
 * @modified by : Brahmani(GST calculation added)
 * @modified date :
 */

@Controller
/*@CrossOrigin(origins = VyavaharaConstants.URL)*/
@RequestMapping(value = "/categoryofitem")
public class CategoryOfItemController {
	@Autowired
	private ICategoryOfItemService iCategoryOfItemService;

	/**
	 * Create category
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public CategoryOfItemResponse categoryOfItemCreateController(
			@RequestBody CategoryOfItemRequest categoryOfItemRequest) {
		CategoryOfItemResponse categoryOfItemResponse = new CategoryOfItemResponse();

		CategoryOfItemBean categoryOfIteamBean;
		categoryOfIteamBean = iCategoryOfItemService.categoryOfItemCreateService(categoryOfItemRequest);
		if (categoryOfIteamBean != null) {

			categoryOfItemResponse.setCategoryOfItemBean(categoryOfIteamBean);
			categoryOfItemResponse.setStatusCode(StatusCodes.OK);
			categoryOfItemResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			categoryOfItemResponse.setStatusCode(StatusCodes.NO_CONTENT);
			categoryOfItemResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return categoryOfItemResponse;
	}

	/**
	 *  update category
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public CategoryOfItemResponse categoryOfItemUpdateController(
			@RequestBody CategoryOfItemRequest categoryOfItemRequest) {
		CategoryOfItemResponse categoryOfItemResponse = new CategoryOfItemResponse();

		CategoryOfItemBean categoryOfIteamBean;
		categoryOfIteamBean = iCategoryOfItemService.categoryOfItemUpdateService(categoryOfItemRequest);
		if (categoryOfIteamBean != null) {
			categoryOfItemResponse.setCategoryOfItemBean(categoryOfIteamBean);
			categoryOfItemResponse.setStatusCode(StatusCodes.OK);
			categoryOfItemResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);
		} else {
			categoryOfItemResponse.setStatusCode(StatusCodes.NO_CONTENT);
			categoryOfItemResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
		}
		return categoryOfItemResponse;
	}



	/**
	 * read category
	 */

	@RequestMapping(value = "/read", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public CategoryOfItemResponse categoryOfItemReadController(
			@RequestBody CategoryOfItemRequest categoryOfItemRequest) {
		CategoryOfItemResponse categoryOfItemResponse = new CategoryOfItemResponse();

		CategoryOfItemBean categoryOfIteamBean;
		categoryOfIteamBean = iCategoryOfItemService.categoryOfItemReadService(categoryOfItemRequest);
		if (categoryOfIteamBean != null) {
			categoryOfItemResponse.setCategoryOfItemBean(categoryOfIteamBean);
			categoryOfItemResponse.setStatusCode(StatusCodes.OK);
			categoryOfItemResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		} else {
			categoryOfItemResponse.setStatusCode(StatusCodes.NO_CONTENT);
			categoryOfItemResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		}
		return categoryOfItemResponse;
	}


	/**
	 * delete  category
	 */

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public CategoryOfItemResponse categoryOfItemDeleteController(
			@RequestBody CategoryOfItemRequest categoryOfItemRequest) {
		CategoryOfItemResponse categoryOfItemResponse = new CategoryOfItemResponse();

		CategoryOfItemBean categoryOfIteamBean;
		categoryOfIteamBean = iCategoryOfItemService.categoryOfItemDeleteService(categoryOfItemRequest);
		if (categoryOfIteamBean != null) {
			categoryOfItemResponse.setCategoryOfItemBean(categoryOfIteamBean);
			categoryOfItemResponse.setStatusCode(StatusCodes.OK);
			categoryOfItemResponse.setStatusMessage(StatusMessages.DELETE_SUCCESS_MSG);
		} else {
			categoryOfItemResponse.setStatusCode(StatusCodes.NO_CONTENT);
			categoryOfItemResponse.setStatusMessage(StatusMessages.DELETE_FAILURE_MSG);
		}
		return categoryOfItemResponse;
	}

	/**
	 * Calculation
	 * 
	 */
	@RequestMapping(value = "/gst/algorithm", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public CategoryOfItemResponse gstCalculationController(@RequestBody CategoryOfItemRequest categoryOfItemRequest) {
		CategoryOfItemResponse categoryOfItemResponse = new CategoryOfItemResponse();

		CategoryOfItemBean categoryOfIteamBean;
		categoryOfIteamBean = iCategoryOfItemService.gstCalcService(categoryOfItemRequest);
		if (categoryOfIteamBean != null) {
			categoryOfItemResponse.setCategoryOfItemBean(categoryOfIteamBean);
			categoryOfItemResponse.setStatusCode(StatusCodes.OK);
			categoryOfItemResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);
		} else {
			categoryOfItemResponse.setStatusCode(StatusCodes.NO_CONTENT);
			categoryOfItemResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		}
		return categoryOfItemResponse;
	}


}
