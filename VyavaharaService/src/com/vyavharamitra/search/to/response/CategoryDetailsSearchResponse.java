package com.vyavharamitra.search.to.response;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class CategoryDetailsSearchResponse extends VyavaharaResponse {
	private List<CategoryOfItemBean> categoryOfItemBean;

	/**
	 * @return the categoryOfItemBean
	 */
	public List<CategoryOfItemBean> getCategoryOfItemBean() {
		return categoryOfItemBean;
	}

	/**
	 * @param categoryOfItemBean the categoryOfItemBean to set
	 */
	public void setCategoryOfItemBean(List<CategoryOfItemBean> categoryOfItemBean) {
		this.categoryOfItemBean = categoryOfItemBean;
	}
}
