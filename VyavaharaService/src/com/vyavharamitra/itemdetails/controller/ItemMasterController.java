package com.vyavharamitra.itemdetails.controller;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.itemdetails.service.IItemMasterService;
import com.vyavharamitra.itemdetails.to.request.ItemMasterRequest;
import com.vyavharamitra.itemdetails.to.response.ItemMasterResponse;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.utils.StatusCodes;
import com.vyavharamitra.utils.StatusMessages;

@Controller
@RequestMapping(value = "/itemdetails")
public class ItemMasterController {
	@Autowired
	private IItemMasterService itemMasterService;
	
	/**
	 * Create Item Details
	 * 
	 * @param itemMasterRequest
	 * @return
	 */
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ItemMasterResponse itemDetailsCreateController(@RequestBody ItemMasterRequest itemMasterRequest) {
		ItemMasterResponse itemMasterResponse = new ItemMasterResponse();

		ItemMasterBean itemMasterBean;
		itemMasterBean = itemMasterService.itemMasterCreateService(itemMasterRequest);
		if (itemMasterBean != null) {
			itemMasterResponse.setItemMasterBean(itemMasterBean);
			itemMasterResponse.setStatusCode(StatusCodes.OK);
			itemMasterResponse.setStatusMessage(StatusMessages.CREATE_SUCCESS_MSG);
		} else {
			itemMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			itemMasterResponse.setStatusMessage(StatusMessages.CREATE_FAILURE_MSG);
		}
		return itemMasterResponse;
	}
	
	/**
	 * Fetching Category Details
	 * 
	 * @param itemMasterRequest
	 * @return
	 */
	
	 @RequestMapping(value = "/read/single/record/id",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	  @ResponseBody
	  public ItemMasterResponse getCategoryDetails(@RequestBody ItemMasterRequest itemMasterRequest){
		 ItemMasterResponse itemMasterResponse=new ItemMasterResponse();
	  CategoryOfItemBean categoryOfItemBean;
	  categoryOfItemBean = itemMasterService.fetchCategoryDetailsService(itemMasterRequest);
	 
	  if(categoryOfItemBean!=null){
		  itemMasterResponse.setCategoryOfItemBean(categoryOfItemBean);
		  itemMasterResponse.setStatusCode(StatusCodes.OK);
		  itemMasterResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);		
		}else{
			itemMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			itemMasterResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		}
		return itemMasterResponse;
	}
	/**
	 * fetching unit measurement details
	 * 
	 * @param itemMasterRequest
	 * @return
	 */
	 
	 @RequestMapping(value = "/uom/read",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	  @ResponseBody
	  public ItemMasterResponse getUnitMeasurementDetails(@RequestBody ItemMasterRequest itemMasterRequest){
		 ItemMasterResponse itemMasterResponse=new ItemMasterResponse();
	  UnitOfMeasurementBean unitOfMeasurementBean;
	  unitOfMeasurementBean = itemMasterService.fetchUnitMeasurementDetailsService(itemMasterRequest);
	 
	  if(unitOfMeasurementBean!=null){
		  itemMasterResponse.setUnitOfMeasurementBean(unitOfMeasurementBean);
		  itemMasterResponse.setStatusCode(StatusCodes.OK);
		  itemMasterResponse.setStatusMessage(StatusMessages.READ_SUCCESS_MSG);		
		}else{
			itemMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
			itemMasterResponse.setStatusMessage(StatusMessages.READ_FAILURE_MSG);
		}
		return itemMasterResponse;
	}
	 
	/**
	 * Update Item Details
	 * 
	 * @param itemMasterRequest
	 * @return
	 */
	 
		 @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
			@ResponseBody
			public ItemMasterResponse updateItemController(@RequestBody ItemMasterRequest itemMasterRequest) {
			 ItemMasterResponse itemMasterResponse = new ItemMasterResponse();

				ItemMasterBean itemMasterBean;
				itemMasterBean = itemMasterService.updateItemDetailsService(itemMasterRequest);
				if (itemMasterBean != null) {
					itemMasterResponse.setItemMasterBean(itemMasterBean);
					 itemMasterResponse.setStatusCode(StatusCodes.OK);
					  itemMasterResponse.setStatusMessage(StatusMessages.UPDATED_SUCCESS_MSG);		
					}else{
						itemMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
						itemMasterResponse.setStatusMessage(StatusMessages.UPDATED_FAILURE_MSG);
					}
				return itemMasterResponse;
			}
	 /**
	  * Delete Item Details
	  * 
	  * @param itemMasterRequest
	  * @return
	  */
	 
	 @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseBody
		public ItemMasterResponse deleteItemController(@RequestBody ItemMasterRequest itemMasterRequest) {
		 ItemMasterResponse itemMasterResponse = new ItemMasterResponse();

			ItemMasterBean itemMasterBean;
			itemMasterBean = itemMasterService.deleteItemDetailsService(itemMasterRequest);
			if (itemMasterBean != null) {
				itemMasterResponse.setItemMasterBean(itemMasterBean);
				itemMasterResponse.setStatusCode(StatusCodes.OK);
				  itemMasterResponse.setStatusMessage(StatusMessages.DELETE_SUCCESS_MSG);		
				}else{
					itemMasterResponse.setStatusCode(StatusCodes.NO_CONTENT);
					itemMasterResponse.setStatusMessage(StatusMessages.DELETE_FAILURE_MSG);
				}
			return itemMasterResponse;
		}
	
}
