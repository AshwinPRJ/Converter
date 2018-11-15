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
public class RetailerCreation {
	/**
	 * for Customer Id validation
	 * @param CustId
	 * @return isRecordExits
	 * @throws Exception
	 */
	public JSONObject RetailerValidation(String RetailerId) throws Exception {
		StringBuilder retailerValidSelectQuery = new StringBuilder();
		JSONObject isRecordExits= new JSONObject();
		DbConnection db = new DbConnection();
		retailerValidSelectQuery.append(QueryConstants.SELECT_RETAILERS_DETAILS + " WHERE  RETAILERS_MASTER_STA='A' AND RETAILERS_MASTER_ID = '"+RetailerId+"' ");
		try {
			ResultSet rs = db.executeSelectQuery(retailerValidSelectQuery.toString());
			if (rs.next()) {  
				isRecordExits.put("retailerExists", "Y");
				isRecordExits.put("retailerName", (String) rs.getString("RETAILERS_MASTER_NAME"));
				isRecordExits.put("retailerAddress", (String) rs.getString("RETAILERS_MASTER_DESCRIPTION"));
			
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
	public void ModifyRetailerList(String strRetailerId,String strRetailerName,String strRetailerAddress,String strEnteredBy) throws Exception {
		StringBuilder retailerUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		retailerUpdateQuery.append(QueryConstants.RETAILERS_UPDATION + " RETAILERS_MASTER_NAME='"+strRetailerName+"', RETAILERS_MASTER_DESCRIPTION='"+strRetailerAddress+"',RETAILERS_MASTER_CREATED_BY='"+strEnteredBy+"',RETAILERS_MASTER_UPDATED_ON=current_date,RETAILERS_MASTER_CREATED_TIME=to_char(now(),'HH24:MI:SS') WHERE RETAILERS_MASTER_ID='"+strRetailerId+"'");
		db.runPreparedStmt(retailerUpdateQuery.toString());
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
	public void RetailerAdd(String strRetailerId, String strRetailerPswd, String strRetailerAddress , String strEnteredBy ) throws Exception {
		StringBuilder addRetailerInsertQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		addRetailerInsertQuery.append(QueryConstants.RETAILERS_CREATION + " ('" + strRetailerId + "','"+strRetailerPswd+"','"+strRetailerAddress+"','"+strEnteredBy+"',CURRENT_DATE,to_char(now(),'HH24:MI:SS'))");
		db.runPreparedStmt(addRetailerInsertQuery.toString());
		db.closeConnection();
	}
	/**
	 * for Deleting a Existing Customer
	 * @param strCustId
	 * @param strEnteredBy
	 * @throws Exception
	 */
	public void RetailerDeletion(String strRetailerId,String strEnteredBy) throws Exception {
		StringBuilder delRetailerUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		delRetailerUpdateQuery.append(QueryConstants.RETAILERS_UPDATION + " RETAILERS_MASTER_STA='I',RETAILERS_MASTER_UPDATED_BY='"+strEnteredBy+"',RETAILERS_MASTER_UPDATED_ON=current_date,RETAILERS_MASTER_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE RETAILERS_MASTER_ID = '"+strRetailerId+"' AND RETAILERS_MASTER_STA='A'");
		db.runPreparedStmt(delRetailerUpdateQuery.toString());
		db.closeConnection();
	}
	/**
	 * 
	 * @param strCustId
	 * @param strNewPassword
	 * @throws Exception
	 */
	public void ChangeRetailerPassword(String strRetailerId,String strNewPassword) throws Exception {
		StringBuilder changeRetailerPasswordUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeRetailerPasswordUpdateQuery.append(QueryConstants.RETAILERS_UPDATION + " RETAILERS_MASTER_PASSWORD='"+strNewPassword+"',RETAILERS_MASTER_UPDATED_BY='"+strRetailerId+"',RETAILERS_MASTER_UPDATED_ON=current_date,RETAILERS_MASTER_UPDATED_TIME=to_char(now(),'HH24:MI:SS') WHERE RETAILERS_MASTER = '"+strRetailerId+"'");
		db.runPreparedStmt(changeRetailerPasswordUpdateQuery.toString());
		db.closeConnection();
	}
	
}
