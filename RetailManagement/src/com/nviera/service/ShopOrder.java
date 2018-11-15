package com.nviera.service;
import java.sql.ResultSet;
import java.util.Scanner;
import org.json.JSONObject;

import com.nviera.constants.QueryConstants;
import com.nviera.dao.DbConnection;
import com.nviera.utils.Utils;
/**
 * @author			: Brahmani
 * @created date	: 06 feb 2017
 * @modified by		: 
 * @modified date	: 
 */

public class ShopOrder {
	
	public JSONObject ItemValidation(String ItemId) throws Exception {
		StringBuilder itemValidSelectQuery = new StringBuilder();
		JSONObject isRecordExits= new JSONObject();
		DbConnection db = new DbConnection();
		itemValidSelectQuery.append(QueryConstants.SELECT_ITEMS_MASTER + " WHERE ITEMS_MASTER_STA ='A' AND ITEMS_MASTER_ID = '"+ItemId+"'");
		try {
			ResultSet rs = db.executeSelectQuery(itemValidSelectQuery.toString());
			System.err.println("itemValidSelectQuery : "+itemValidSelectQuery);
			if (rs.next()) {
				isRecordExits.put("itemExists", "Y");
				isRecordExits.put("itemName", (String) rs.getString("ITEMS_MASTER_NAME"));
				isRecordExits.put("itemRetailermrp", (String) rs.getString("ITEMS_MASTER_RETAILMRP"));
				isRecordExits.put("itemWarehousemrp", (String) rs.getString("ITEMS_MASTER_WAREHOUSEMRP"));
				
			}else{
				isRecordExits.put("recordExists", "N");
			}
		} catch(Exception e) {
			Utils.rakshaNidhiLogger(e.toString());
		}
		db.closeConnection();
		return isRecordExits;
	}
	public void itemsMasterSave(String strTitle, String strDescription, String strQuantity) throws Exception{
		
		DbConnection db = new DbConnection();
		String sqlquery = "insert into items_master(items_master_title,items_master_description,items_master_quantity) values('"+strTitle+"', '"+strDescription+"','"+strQuantity+"')";
		db.runPreparedStmt(sqlquery);
		System.out.println("sqlquery" +sqlquery);
		
}
	
	public void shopItemSave(String strShoppy,String strItemName,String strItemPrice,String strWarehousePrice,String strQuantity,String strRetailer,String strRemarks,String strPurchaseDate,String strTotalmrp,String strWarehouseTotalmrp,String strTotalPrice,String strTotalWarehousePrice,String strEnteredBy) throws Exception{
		DbConnection db = new DbConnection();
		String sqlquery = "insert into shop_purchase_items( shop_purchase_orders_itemsid, shop_purchase_orders_itemsquantity, shop_purchase_orders_shop_itemsprice, shop_purchase_orders_retailer_itemsPrice) values('"+strShoppy+"','"+strQuantity+"','"+strTotalmrp+"' ,'"+strWarehouseTotalmrp+"')";
		db.runPreparedStmt(sqlquery);
		System.out.println("sqlquery" +sqlquery);
		String SelectCustomerId = "select customer_details_id from customer_details where customer_details_name='"+strEnteredBy+"'";
		ResultSet rs= db.executeSelectQuery(SelectCustomerId);
		if(rs.next()){
			String strCustId = rs.getString("customer_details_id");
			
			String sqlquery1 = "insert into shop_purchase_orders( shop_purchase_orders_retailerid, shop_purchase_orders_shoppyid, shop_purchase_orders_remarks,shop_purchase_orders_expecteddate,shop_purchase_orders_shop_totalprice, shop_purchase_orders_retailer_totalprice) values ('"+strRetailer+"','"+strCustId+"','"+strRemarks+"','"+strPurchaseDate+"','"+strTotalPrice+"','"+strTotalWarehousePrice+"')";
			db.runPreparedStmt(sqlquery1);
			System.out.println("sqlquery1" +sqlquery1);
		}
		
		
	}
	
	}
	
	
