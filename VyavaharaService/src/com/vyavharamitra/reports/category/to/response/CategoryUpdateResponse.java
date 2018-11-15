package com.vyavharamitra.reports.category.to.response;
import java.util.List;

import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;
import com.vyavharamitra.utils.VyavaharaResponse;

/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */

public class CategoryUpdateResponse  extends VyavaharaResponse{
	private List<UpdateCategoryOfItemBean> updateCategoryOfItemBean;
	private List<DeleteCategoryOfItemBean> deleteCategoryOfItemBean;

	/**
	 * @return the updateCategoryOfItemBean
	 */
	public List<UpdateCategoryOfItemBean> getUpdateCategoryOfItemBean() {
		return updateCategoryOfItemBean;
	}

	/**
	 * @param updateCategoryOfItemBean the updateCategoryOfItemBean to set
	 */
	public void setUpdateCategoryOfItemBean(List<UpdateCategoryOfItemBean> updateCategoryOfItemBean) {
		this.updateCategoryOfItemBean = updateCategoryOfItemBean;
	}

	/**
	 * @return the deleteCategoryOfItemBean
	 */
	public List<DeleteCategoryOfItemBean> getDeleteCategoryOfItemBean() {
		return deleteCategoryOfItemBean;
	}

	/**
	 * @param deleteCategoryOfItemBean the deleteCategoryOfItemBean to set
	 */
	public void setDeleteCategoryOfItemBean(List<DeleteCategoryOfItemBean> deleteCategoryOfItemBean) {
		this.deleteCategoryOfItemBean = deleteCategoryOfItemBean;
	}


}

