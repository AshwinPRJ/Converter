package com.vyavharamitra.reports.category.service;

import java.util.List;
import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;
import com.vyavharamitra.reports.category.to.request.CategoryUpdateRequest;
import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;

/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */
public interface ICategoryUpdateService {
	public List<UpdateCategoryOfItemBean> categoryService(String categoryName);
	public List<DeleteCategoryOfItemBean> categoryDeleteReadService(CategoryUpdateRequest categoryUpdateRequest);
}

