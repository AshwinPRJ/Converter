package com.nviera.service;

import java.sql.ResultSet;

import org.json.JSONObject;

import com.nviera.constants.QueryConstants;
import com.nviera.dao.DbConnection;
import com.nviera.utils.Utils;

public class UserDetails {
	
	/**
	 * Validation From Mobile
	 * @param strMobileNumber
	 */
	public JSONObject getInvoiceValidate(String strInvoiceNumber) throws Exception {
		StringBuilder invoiceValidQuery = new StringBuilder();
		JSONObject isInvoiceRecordExits= new JSONObject();
		DbConnection db = new DbConnection();
		invoiceValidQuery.append(" select user_transactions_user_number from user_transactions WHERE user_transactions_user_number='" + strInvoiceNumber+ "' ");
		try {
			ResultSet rs = db.executeSelectQuery(invoiceValidQuery.toString());
			if (rs.next()) {
				isInvoiceRecordExits.put("invoiceExists", "Y");
			}else{
				isInvoiceRecordExits.put("invoiceExists", "N");
			}
		} catch (Exception e) {
			Utils.rakshaNidhiLogger(e.toString());
		}
		db.closeConnection();
		return isInvoiceRecordExits;
	}
	
	/**
	 * Validation From Mobile
	 * @param strMobileNumber
	 */
	public JSONObject getMobileValidate(String strMobileNumber) throws Exception {
		StringBuilder mobileValidQuery = new StringBuilder();
		JSONObject isRecordExits= new JSONObject();
		DbConnection db = new DbConnection();
		mobileValidQuery.append(QueryConstants.MOBILE_VALIDATE+" WHERE USER_DETAILS_MOBILE='" + strMobileNumber+ "' ");
		try {
			ResultSet rs = db.executeSelectQuery(mobileValidQuery.toString());
			if (rs.next()) {
				isRecordExits.put("userExists", "Y");
				isRecordExits.put("grahakId",(String) rs.getString("USER_DETAILS_GRAHAKID"));
				isRecordExits.put("name", (String) rs.getString("USER_DETAILS_FULLNAME"));
				isRecordExits.put("ExistingPoints", (String) rs.getString("USER_DETAILS_EARNED_POINTS"));
			}else{
				isRecordExits.put("userExists", "N");
			}
		} catch (Exception e) {
			Utils.rakshaNidhiLogger(e.toString());
		}
		db.closeConnection();
		return isRecordExits;
	}
	public void getPointsSave(String strMobileNumber,String strTransNumber, double dblFoodItemsAmt, double dblNotFoodItemsAmt,double dblTotAmount,int intPoints,int intProductId,String strCustId) throws Exception {
		StringBuilder mobileValidSelectQuery = new StringBuilder();
		StringBuilder pointsSaveDetailsInsertQuery = new StringBuilder();
		StringBuilder custDetailsSelectQuery = new StringBuilder();
		StringBuilder custDetailsUpdateQuery = new StringBuilder();
		StringBuilder userIdPointsSelectQuery = new StringBuilder();
		StringBuilder userPointsUpdateQuery = new StringBuilder();
		StringBuilder userPointsInsertQuery = new StringBuilder();
		StringBuilder custProductUpdateQuery = new StringBuilder();
		
		String strUserId="";
		String strGrahakId="";
		int intTotalPoints=0;
		
		DbConnection db = new DbConnection();
		try {
			/**
			 * fetching user id through mobile number
			 */
			mobileValidSelectQuery.append(QueryConstants.MOBILE_VALIDATE+" WHERE USER_DETAILS_MOBILE='" + strMobileNumber+ "' ");
			ResultSet rs = db.executeSelectQuery(mobileValidSelectQuery.toString());
			while (rs.next()) {
				strUserId= rs.getString("USER_DETAILS_ID");
				strGrahakId = rs.getString("USER_DETAILS_GRAHAKID");
			}
			rs.close();
			/**
			 * user transaction
			 */
			pointsSaveDetailsInsertQuery.append(QueryConstants.USER_TRANSACTON_INSERT + " ('"+strGrahakId+"','"+strTransNumber+"','"+dblFoodItemsAmt+"','"+dblNotFoodItemsAmt+"','"+dblTotAmount+"','"+intPoints+"','"+strCustId+"',CURRENT_DATE,to_char(now(),'HH24:MI:SS'))");
			db.runPreparedStmt(pointsSaveDetailsInsertQuery.toString());
			/**
			 * customer wallet update after transaction of user
			 */
			custDetailsSelectQuery.append(QueryConstants.SELECT_CUSTOMER_DETAILS + " AND CUSTOMER_DETAILS_NAME = '"+strCustId+"'");
			ResultSet rs1 = db.executeSelectQuery(custDetailsSelectQuery.toString());
			while (rs1.next()){
				if(dblFoodItemsAmt != 0 || dblNotFoodItemsAmt != 0 ){
					custDetailsUpdateQuery.append(QueryConstants.CUSTOMER_UPDATION + " CUSTOMER_DETAILS_WALLET_AMOUNT= CUSTOMER_DETAILS_WALLET_AMOUNT-('"+intPoints+"') WHERE CUSTOMER_DETAILS_NAME = '"+strCustId+"'");
					db.runPreparedStmt(custDetailsUpdateQuery.toString());
				} else {
					custProductUpdateQuery.append(QueryConstants.CUST_PRODUCTS_UPDATION + " custproducts_quantity = custproducts_quantity - 1 where custproducts_productid = '"+intProductId+"' and custproducts_custname= '"+strCustId+"' ");
					db.runPreparedStmt(custProductUpdateQuery.toString());
				}
			}
			rs1.close();
			/**
			 * if user exists in points table update have to do else insertion have to do
			 */
			userIdPointsSelectQuery.append(QueryConstants.USER_SELECT_POINTS + " USER_POINTS_GRAHAKID='"+strGrahakId+"'");
			ResultSet rs2= db.executeSelectQuery(userIdPointsSelectQuery.toString());
			if(rs2.next()){
				userPointsUpdateQuery.append(QueryConstants.USER_UPDATE_POINTS + "USER_POINTS_USER_POINTS= USER_POINTS_USER_POINTS + '"+intPoints+"',USER_POINTS_UPDATE_BY='"+strCustId+"',USER_POINTS_UPDATED_ON=CURRENT_DATE,USER_POINTS_UPDATE_TIME=to_char(now(),'HH24:MI:SS') WHERE USER_POINTS_GRAHAKID='"+strGrahakId+"'");
				db.runPreparedStmt(userPointsUpdateQuery.toString());
			}else{
				userPointsInsertQuery.append(QueryConstants.USER_INSERT_POINTS + "('"+strGrahakId+"','"+intPoints+"','"+strCustId+"',CURRENT_DATE,to_char(now(),'HH24:MI:SS'))");
				db.runPreparedStmt(userPointsInsertQuery.toString());
			}
			ResultSet rs3=db.executeSelectQuery(userIdPointsSelectQuery.toString());
			while(rs3.next()){
				intTotalPoints = rs3.getInt("USER_POINTS_USER_POINTS");
			}
			db.closeConnection();
		} catch (Exception e) {
			Utils.rakshaNidhiLogger(e.toString());
		}
		/*SmsApi.sendSmsApi(strMobileNumber,dblTotAmount,intPoints,strCustId);
		APICall.userAuth(strTransNumber,strGrahakId,strMobileNumber,dblTotAmount,intPoints);*/
	}
}