package com.nviera.service;

import java.sql.ResultSet;

import org.json.JSONObject;

import com.nviera.constants.QueryConstants;
import com.nviera.dao.DbConnection;
import com.nviera.utils.Utils;
/**
 * @author			: kiran
 * @created date	: 05 oct 2016
 * @modified by		: kiran
 * @modified date	: 18 oct 2016
 */
public class ItemCreation {
	/**
	 * for Customer Id validation
	 * @param CustId
	 * @return isRecordExits
	 * @throws Exception
	 */
	public JSONObject ItemValidation(String ItemId) throws Exception {
		StringBuilder itemValidSelectQuery = new StringBuilder();
		JSONObject isRecordExits= new JSONObject();
		DbConnection db = new DbConnection();
		itemValidSelectQuery.append(QueryConstants.SELECT_ITEMS_MASTER + " WHERE ITEMS_MASTER_STA ='A' AND ITEMS_MASTER_ID = '"+ItemId+"'");
		try {
			ResultSet rs = db.executeSelectQuery(itemValidSelectQuery.toString());
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
	/**
	 * for adding wallet Amount to the Customer
	 * @param strCustId
	 * @param dblAddWalAmt
	 * @param dblCustBalWalAmt
	 * @param strEnteredBy
	 * @throws Exception
	 */
	public void ModifyItemList(String strItemId,double dbRetailmrp,double dbWarehousemrp,String strEnteredBy) throws Exception {
		StringBuilder itemUpdateQuery = new StringBuilder();
		/*StringBuilder itemTransInsertQuery = new StringBuilder();*/
		DbConnection db = new DbConnection();
		/*double dblTotalWalAmt=dbRetailmrp+dbWarehousemrp;*/
		itemUpdateQuery.append(QueryConstants.ITEMS_UPDATION + "ITEMS_MASTER_CREATED_ON=current_date,ITEMS_MASTER_UPDATED_BY='"+strEnteredBy+"',ITEMS_MASTER_UPDATED_ON=current_date,ITEMS_MASTER_RETAILMRP='"+dbRetailmrp+"',ITEMS_MASTER_WAREHOUSEMRP='"+dbWarehousemrp+"',ITEMS_MASTER_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE ITEMS_MASTER_ID = '"+strItemId+"' AND ITEMS_MASTER_STA='A'");
		/*db.runPreparedStmt(itemUpdateQuery.toString());*/
		/*itemTransInsertQuery.append(QueryConstants.ITEMS_UPDATION + "('"+strItemId+"','"+dbRetailmrp+"','"+dbWarehousemrp+"','"+strEnteredBy+"',current_date,to_char(now(),'HH24:MI:SS'))");*/
		db.runPreparedStmt(itemUpdateQuery.toString());
		db.closeConnection();
	}
	/**
	 * for Adding a New Customer
	 * @param strCustId
	 * @param strCustShopName
	 * @param strCustPlace
	 * @param strCustCity
	 * @param strwalletamt
	 * @param strEnteredBy
	 * @throws Exception
	 */
	public void ItemAdd(String strItemId,String strretailermrp, String strwarehousemrp,String strEnteredBy) throws Exception {
		StringBuilder addItemInsertQuery = new StringBuilder();
		StringBuilder addProductInsertQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		addItemInsertQuery.append(QueryConstants.ITEMS_CREATION + " ('" + strItemId + "','"+strretailermrp+"','"+strwarehousemrp+"','A','"+strEnteredBy+"',CURRENT_DATE,to_char(now(),'HH24:MI:SS'))");
		db.runPreparedStmt(addItemInsertQuery.toString());
		/*addProductInsertQuery.append("INSERT INTO ITEMS_MASTER (ITEMS_MASTER_NAME,ITEMS_MASTER_RETAILMRP,ITEMS_MASTER_WAREHOUSEMRP) SELECT ITEMS_MASTER_ID, '"+strItemId+"' FROM ITEMS_MASTER");*/
		db.runPreparedStmt(addProductInsertQuery.toString());
		db.closeConnection();
	}
	/**
	 * for Deleting a Existing Customer
	 * @param strCustId
	 * @param strEnteredBy
	 * @throws Exception
	 */
	public void ItemDeletion(String strItemId,String strEnteredBy) throws Exception {
		StringBuilder delItemUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		delItemUpdateQuery.append(QueryConstants.ITEMS_UPDATION + " ITEMS_MASTER_STA='I',ITEMS_MASTER_UPDATED_BY='"+strEnteredBy+"',ITEMS_MASTER_UPDATED_ON=current_date,ITEMS_MASTER_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE ITEMS_MASTER_ID = '"+strItemId+"' AND ITEMS_MASTER_STA='A'");
		db.runPreparedStmt(delItemUpdateQuery.toString());
		db.closeConnection();
	}
	/**
	 * 
	 * @param strCustId
	 * @param strNewPassword
	 * @throws Exception
	 */
	/*public void ChangeCustomerPassword(String strCustId,String strNewPassword) throws Exception {
		StringBuilder changeCustomerPasswordUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeCustomerPasswordUpdateQuery.append(QueryConstants.CUSTOMER_UPDATION + " CUSTOMER_DETAILS_PASSWORD='"+strNewPassword+"',CUSTOMER_DETAILS_UPDATED_BY='"+strCustId+"',CUSTOMER_DETAILS_UPDATED_ON=current_date,CUSTOMER_DETAILS_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE CUSTOMER_DETAILS_NAME = '"+strCustId+"'");
		db.runPreparedStmt(changeCustomerPasswordUpdateQuery.toString());
		db.closeConnection();
	}*/
	
	/**
	 * 
	 * @param strCustId
	 * @param strStatus
	 * @throws Exception
	 */
	public void ChangeItemsActDeact(String strItemId,String strStatus,String strEnteredBy) throws Exception {
		StringBuilder changeItemsUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeItemsUpdateQuery.append(QueryConstants.ITEMS_UPDATION + " ITEMS_MASTER_STA='"+strStatus+"',ITEMS_MASTER_UPDATED_BY='"+strEnteredBy+"',ITEMS_MASTER_UPDATED_ON=current_date,ITEMS_MASTER_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE ITEMS_MASTER_ID = '"+strItemId+"' ");
		db.runPreparedStmt(changeItemsUpdateQuery.toString());
		db.closeConnection();
	}
	
	/**
	 * 
	 * @param strCustId
	 * @param strStatus
	 * @throws Exception
	 */
	public void ChangProductActDeact(String strItemId,String strStatus,String strEnteredBy) throws Exception {
		StringBuilder changeItemsUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeItemsUpdateQuery.append(QueryConstants.ITEMS_UPDATION + " ITEMS_MASTER_STA='"+strStatus+"',ITEMS_MASTER_UPDATED_BY='"+strEnteredBy+"',ITEMS_MASTER_UPDATED_ON=current_date,ITEMS_MASTER_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE ITEMS_MASTER_ID = '"+strItemId+"'");
		db.runPreparedStmt(changeItemsUpdateQuery.toString());
		db.closeConnection();
	}
	
	/**
	 * 
	 * @param strCustId
	 * @param dblFoodItemsPercentage
	 * @param dblNonFoodItemsPercentage
	 * @throws Exception
	 */
	/*public void ChangeCustomerItemsPercentages(String strCustId,double dblFoodItemsPercentage,double dblNonFoodItemsPercentage) throws Exception {
		StringBuilder changeCustomerItemsPercentageUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeCustomerItemsPercentageUpdateQuery.append(QueryConstants.ITEMS_UPDATION + " CUSTOMER_DETAILS_FOODITEMS='"+dblFoodItemsPercentage+"',CUSTOMER_DETAILS_NONFOODITEMS = '"+dblNonFoodItemsPercentage+"',CUSTOMER_DETAILS_UPDATED_BY='"+strCustId+"',CUSTOMER_DETAILS_UPDATED_ON=current_date,CUSTOMER_DETAILS_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE CUSTOMER_DETAILS_NAME = '"+strCustId+"'");
		db.runPreparedStmt(changeCustomerItemsPercentageUpdateQuery.toString());
		db.closeConnection();}
*/	
	
	
}
