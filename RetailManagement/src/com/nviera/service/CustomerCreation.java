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
public class CustomerCreation {
	/**
	 * for Customer Id validation
	 * @param CustId
	 * @return isRecordExits
	 * @throws Exception
	 */
	public JSONObject CustValidation(String CustId) throws Exception {
		StringBuilder customerValidSelectQuery = new StringBuilder();
		JSONObject isRecordExits= new JSONObject();
		DbConnection db = new DbConnection();
		customerValidSelectQuery.append(QueryConstants.SELECT_CUSTOMER_DETAILS + " AND CUSTOMER_DETAILS_NAME = '"+CustId+"'");
		try {
			ResultSet rs = db.executeSelectQuery(customerValidSelectQuery.toString());
			if (rs.next()) {
				isRecordExits.put("custExists", "Y");
				isRecordExits.put("custName", (String) rs.getString("CUSTOMER_DETAILS_SHOP_NAME"));
				isRecordExits.put("custWalBal", (String) rs.getString("CUSTOMER_DETAILS_WALLET_AMOUNT"));
			}else{
				isRecordExits.put("recordExists", "N");
			}
		} catch (Exception e) {
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
	public void CustomerWalletAdding(String strCustId,double dblAddWalAmt,double dblCustBalWalAmt,String strEnteredBy) throws Exception {
		StringBuilder customerUpdateQuery = new StringBuilder();
		StringBuilder customerTransInsertQuery = new StringBuilder();
		StringBuilder customerSelectQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		double dblTotalWalAmt=dblAddWalAmt+dblCustBalWalAmt;
		
		customerUpdateQuery.append(QueryConstants.CUSTOMER_UPDATION + " CUSTOMER_DETAILS_WALLET_AMOUNT='"+dblTotalWalAmt+"',CUSTOMER_DETAILS_LAST_RECHARGE=current_date,CUSTOMER_DETAILS_UPDATED_BY='"+strEnteredBy+"',CUSTOMER_DETAILS_UPDATED_ON=current_date,CUSTOMER_DETAILS_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE CUSTOMER_DETAILS_NAME = '"+strCustId+"' AND CUSTOMER_DETAILS_STA='A'");
		db.runPreparedStmt(customerUpdateQuery.toString());
		
		customerSelectQuery.append(QueryConstants.SELECT_CUSTOMER_DETAILS + " AND CUSTOMER_DETAILS_NAME = '"+strCustId+"' ");
		ResultSet rs = db.executeSelectQuery(customerSelectQuery.toString());
		if(rs.next()){
			strCustId = rs.getString("CUSTOMER_DETAILS_ID");
			customerTransInsertQuery.append(QueryConstants.CUSTOMER_TRANS_INSERT + "('"+strCustId+"','"+dblAddWalAmt+"','"+strEnteredBy+"',current_date,to_char(now(),'HH24:MI:SS'))");
			db.runPreparedStmt(customerTransInsertQuery.toString());
		}
		
		
		
		
		
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
	public void CustomerAdd(String strCustId,String strCustPswd, String strCustShopName,String strCustPlace,String strCustCity,String strwalletamt,String strFoodItemsPer,String strNonFoodItemsPer,String strEnteredBy) throws Exception {
		StringBuilder addCustomerInsertQuery = new StringBuilder();
		StringBuilder addCustomerProductInsertQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		addCustomerInsertQuery.append(QueryConstants.CUSTOMER_CREATION + " ('" + strCustId + "','"+strCustPswd+"','"+strCustShopName+"','"+strCustPlace+"','"+strCustCity+"','"+strwalletamt+"','"+strFoodItemsPer+"','"+strNonFoodItemsPer+"',CURRENT_DATE,CURRENT_DATE,'A','"+strEnteredBy+"',CURRENT_DATE,to_char(now(),'HH24:MI:SS'))");
		db.runPreparedStmt(addCustomerInsertQuery.toString());
		addCustomerProductInsertQuery.append("INSERT INTO CUSTPRODUCTS (CUSTPRODUCTS_PRODUCTID,CUSTPRODUCTS_CUSTNAME) SELECT PRODUCTS_SLNO, '"+strCustId+"' FROM PRODUCTS");
		db.runPreparedStmt(addCustomerProductInsertQuery.toString());
		db.closeConnection();
	}
	/**
	 * for Deleting a Existing Customer
	 * @param strCustId
	 * @param strEnteredBy
	 * @throws Exception
	 */
	public void CustomerDeletion(String strCustId,String strEnteredBy) throws Exception {
		StringBuilder delCustomerUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		delCustomerUpdateQuery.append(QueryConstants.CUSTOMER_UPDATION + " CUSTOMER_DETAILS_STA='I',CUSTOMER_DETAILS_UPDATED_BY='"+strEnteredBy+"',CUSTOMER_DETAILS_UPDATED_ON=current_date,CUSTOMER_DETAILS_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE CUSTOMER_DETAILS_NAME = '"+strCustId+"' AND CUSTOMER_DETAILS_STA='A'");
		db.runPreparedStmt(delCustomerUpdateQuery.toString());
		db.closeConnection();
	}
	/**
	 * 
	 * @param strCustId
	 * @param strNewPassword
	 * @throws Exception
	 */
	public void ChangeCustomerPassword(String strCustId,String strNewPassword) throws Exception {
		StringBuilder changeCustomerPasswordUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeCustomerPasswordUpdateQuery.append(QueryConstants.CUSTOMER_UPDATION + " CUSTOMER_DETAILS_PASSWORD='"+strNewPassword+"',CUSTOMER_DETAILS_UPDATED_BY='"+strCustId+"',CUSTOMER_DETAILS_UPDATED_ON=current_date,CUSTOMER_DETAILS_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE CUSTOMER_DETAILS_NAME = '"+strCustId+"'");
		db.runPreparedStmt(changeCustomerPasswordUpdateQuery.toString());
		db.closeConnection();
	}
	
	/**
	 * 
	 * @param strCustId
	 * @param strStatus
	 * @throws Exception
	 */
	public void ChangeCustomerItemsActDeact(String strCustId,String strStatus,String strEnteredBy) throws Exception {
		StringBuilder changeCustomerItemsUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeCustomerItemsUpdateQuery.append(QueryConstants.CUSTOMER_UPDATION + " CUSTOMER_DETAILS_ITEMS_PERCENT_CHANGE='"+strStatus+"',CUSTOMER_DETAILS_UPDATED_BY='"+strEnteredBy+"',CUSTOMER_DETAILS_UPDATED_ON=current_date,CUSTOMER_DETAILS_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE CUSTOMER_DETAILS_ID = '"+strCustId+"'");
		db.runPreparedStmt(changeCustomerItemsUpdateQuery.toString());
		db.closeConnection();
	}
	
	/**
	 * 
	 * @param strCustId
	 * @param strStatus
	 * @throws Exception
	 */
	public void ChangeCustomerProductActDeact(String strCustId,String strStatus,String strEnteredBy) throws Exception {
		StringBuilder changeCustomerItemsUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeCustomerItemsUpdateQuery.append(QueryConstants.CUSTOMER_UPDATION + " CUSTOMER_DETAILS_PRODUCT_CHANGE='"+strStatus+"',CUSTOMER_DETAILS_UPDATED_BY='"+strEnteredBy+"',CUSTOMER_DETAILS_UPDATED_ON=current_date,CUSTOMER_DETAILS_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE CUSTOMER_DETAILS_ID = '"+strCustId+"'");
		db.runPreparedStmt(changeCustomerItemsUpdateQuery.toString());
		db.closeConnection();
	}
	
	/**
	 * 
	 * @param strCustId
	 * @param dblFoodItemsPercentage
	 * @param dblNonFoodItemsPercentage
	 * @throws Exception
	 */
	public void ChangeCustomerItemsPercentages(String strCustId,double dblFoodItemsPercentage,double dblNonFoodItemsPercentage) throws Exception {
		StringBuilder changeCustomerItemsPercentageUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeCustomerItemsPercentageUpdateQuery.append(QueryConstants.CUSTOMER_UPDATION + " CUSTOMER_DETAILS_FOODITEMS='"+dblFoodItemsPercentage+"',CUSTOMER_DETAILS_NONFOODITEMS = '"+dblNonFoodItemsPercentage+"',CUSTOMER_DETAILS_UPDATED_BY='"+strCustId+"',CUSTOMER_DETAILS_UPDATED_ON=current_date,CUSTOMER_DETAILS_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE CUSTOMER_DETAILS_NAME = '"+strCustId+"'");
		db.runPreparedStmt(changeCustomerItemsPercentageUpdateQuery.toString());
		db.closeConnection();
	}
	/**
	 * 
	 * @param editShopId
	 * @param editShopUserId
	 * @param editShopFullName
	 * @param editShopPlace
	 * @param editShopCity
	 * @param strEnteredBy
	 * @throws Exception
	 */
	public void EditShoppyDetails(String editShopId,String editShopUserId,String editShopFullName,String editShopPlace,String editShopCity,String strEnteredBy) throws Exception {
		StringBuilder EditShoppyDetailsQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		EditShoppyDetailsQuery.append(QueryConstants.CUSTOMER_UPDATION + " CUSTOMER_DETAILS_NAME='"+editShopUserId+"',customer_details_shop_name='"+editShopFullName+"',customer_details_place='"+editShopPlace+"',customer_details_city='"+editShopCity+"',CUSTOMER_DETAILS_UPDATED_BY='"+strEnteredBy+"',CUSTOMER_DETAILS_UPDATED_ON=current_date,CUSTOMER_DETAILS_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE CUSTOMER_DETAILS_ID = '"+editShopId+"'");
		db.runPreparedStmt(EditShoppyDetailsQuery.toString());
		db.closeConnection();
	}
	
}
