package com.vyavharamitra.reports.category.to.request;
import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;
/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */
public class CategoryUpdateRequest {

	private UpdateCategoryOfItemBean updateCategoryOfItemBean;
	private DeleteCategoryOfItemBean deleteCategoryOfItemBean;

	/**
	 * @return the updateCategoryOfItemBean
	 */
	public UpdateCategoryOfItemBean getUpdateCategoryOfItemBean() {
		return updateCategoryOfItemBean;
	}

	/**
	 * @param updateCategoryOfItemBean the updateCategoryOfItemBean to set
	 */
	public void setUpdateCategoryOfItemBean(UpdateCategoryOfItemBean updateCategoryOfItemBean) {
		this.updateCategoryOfItemBean = updateCategoryOfItemBean;
	}

	/**
	 * @return the deleteCategoryOfItemBean
	 */
	public DeleteCategoryOfItemBean getDeleteCategoryOfItemBean() {
		return deleteCategoryOfItemBean;
	}

	/**
	 * @param deleteCategoryOfItemBean the deleteCategoryOfItemBean to set
	 */
	public void setDeleteCategoryOfItemBean(DeleteCategoryOfItemBean deleteCategoryOfItemBean) {
		this.deleteCategoryOfItemBean = deleteCategoryOfItemBean;
	}


}
