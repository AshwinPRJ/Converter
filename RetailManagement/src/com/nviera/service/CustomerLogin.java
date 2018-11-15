package com.nviera.service;

import java.sql.ResultSet;

import org.json.JSONObject;

import com.nviera.constants.QueryConstants;
import com.nviera.dao.DbConnection;
/**
 * @author			: kiran
 * @created date	: 17 oct 2016
 * @modified by		: kiran
 * @modified date	: 18 oct 2016
 */
public class CustomerLogin {
	/**
	 * for cCustomer Id Validation
	 * @param strCustId
	 * @return jsonCustIdValid
	 * @throws Exception
	 */
	public JSONObject CustIdValidate(String strCustId) throws Exception {
		/**
		 * Creating a JSONObject for jsonCustIdValid
		 */
		JSONObject jsonCustIdValid = new JSONObject();
		StringBuilder selectCustIdValid = new StringBuilder();

		DbConnection db = new DbConnection();

		selectCustIdValid.append(QueryConstants.SELECT_CUSTOMER_DETAILS + " AND TRIM(CUSTOMER_DETAILS_NAME)=TRIM('"+ strCustId + "')");
		ResultSet rs = db.executeSelectQuery(selectCustIdValid.toString());
		if (rs.next()) {
			jsonCustIdValid.put("isRecordExists", "Y");
		} else {
			jsonCustIdValid.put("isRecordExists", "N");
		}
		return jsonCustIdValid;
	}
	/**
	 * for Customer Password Validation
	 * @param strCustId
	 * @param strPswd
	 * @return jsonCustPswdValid
	 * @throws Exception
	 */
	public JSONObject CustPswdVadlidate(String strCustId, String strPswd) throws Exception {
		/**
		 * Creating a JSONObject for Customer Session for session Attribute
		 */
		JSONObject jsonCustPswdValid = new JSONObject();
		StringBuilder selectCustPswdValid = new StringBuilder();

		DbConnection db = new DbConnection();

		selectCustPswdValid.append(QueryConstants.SELECT_CUSTOMER_DETAILS + " AND TRIM(CUSTOMER_DETAILS_NAME)=TRIM('"+ strCustId + "') AND TRIM(CUSTOMER_DETAILS_PASSWORD)=TRIM('" + strPswd + "')");
		ResultSet rs = db.executeSelectQuery(selectCustPswdValid.toString());
		if (rs.next()) {
			jsonCustPswdValid.put("custId", rs.getString("CUSTOMER_DETAILS_NAME"));
			jsonCustPswdValid.put("custWalletAmt", rs.getString("CUSTOMER_DETAILS_WALLET_AMOUNT"));
			jsonCustPswdValid.put("custFoodItemsPer", rs.getString("CUSTOMER_DETAILS_FOODITEMS"));
			jsonCustPswdValid.put("custNonFoodItemsPer", rs.getString("CUSTOMER_DETAILS_NONFOODITEMS"));
			jsonCustPswdValid.put("custPercentageChange", rs.getString("CUSTOMER_DETAILS_ITEMS_PERCENT_CHANGE"));
			jsonCustPswdValid.put("custProductChange", rs.getString("CUSTOMER_DETAILS_PRODUCT_CHANGE"));
			jsonCustPswdValid.put("isRecordExists", "Y");
		} else {
			jsonCustPswdValid.put("isRecordExists", "N");
		}
		db.closeConnection();
		return jsonCustPswdValid;
	}
}
