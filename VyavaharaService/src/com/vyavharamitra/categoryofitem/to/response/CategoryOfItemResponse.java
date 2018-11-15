package com.vyavharamitra.categoryofitem.to.response;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.utils.VyavaharaResponse;

/**
 * @author : Lavanya
 * @created date :24 Nov 2017
 * @modified by :
 * @modified date :
 */

public class CategoryOfItemResponse extends VyavaharaResponse {
	private CategoryOfItemBean categoryOfItemBean;

	/**
	 * @return the categoryOfItemBean
	 */
	public CategoryOfItemBean getCategoryOfItemBean() {
		return categoryOfItemBean;
	}

	/**
	 * @param categoryOfItemBean the categoryOfItemBean to set
	 */
	public void setCategoryOfItemBean(CategoryOfItemBean categoryOfItemBean) {
		this.categoryOfItemBean = categoryOfItemBean;
	}

}

