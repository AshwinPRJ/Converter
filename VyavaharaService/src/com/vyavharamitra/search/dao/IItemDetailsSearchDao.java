package com.vyavharamitra.search.dao;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.search.to.request.ItemDetailsSearchRequest;

public interface IItemDetailsSearchDao {
	List<ItemMasterBean> getItemDetailsDao(SessionFactory sessionFactory);
	List<ItemMasterBean> getItemDetailsDaoblur(SessionFactory sessionFactory,ItemDetailsSearchRequest itemDetailsSearchRequest);

}
