package com.nviera.service;

import java.sql.ResultSet;

import org.json.JSONObject;

import com.nviera.constants.QueryConstants;
import com.nviera.dao.DbConnection;

/**
 * @author			: Babu
 * @created date	: 22 feb 2017
 * @modified by		: Babu
 * @modified date	: 22 feb 2017
 */
public class RetailLogin {
	/** 
	 * for retail Id validation
	 * @param strAdminId
	 * @return jsonStatus
	 * @throws Exception
	 */
	public JSONObject RetailIdValidate(String strRetailId) throws Exception {
		/**
		 * Creating a JSONObject for jsonAdminIdValid
		 */
		JSONObject jsonRetailIdValid = new JSONObject();
		StringBuilder selectRetailIdValid = new StringBuilder();

		DbConnection db = new DbConnection();

		selectRetailIdValid.append(QueryConstants.SELECT_RETAILERS_DETAILS + " WHERE TRIM(RETAILERS_MASTER_NAME)=TRIM('"+strRetailId+ "')");
		ResultSet rs = db.executeSelectQuery(selectRetailIdValid.toString());
		if (rs.next()) {
			jsonRetailIdValid.put("isRecordExists", "Y");
		} else {
			jsonRetailIdValid.put("isRecordExists", "N");
		}
		return jsonRetailIdValid;
	}
	/**
	 * for retail Password validation
	 * @param strAdminId
	 * @param strPswd
	 * @return jsonAdminPswdValid
	 * @throws Exception
	 */
	public JSONObject RetailPswdVadlidate(String strRetailId, String strPswd) throws Exception {
		/**
		 * Creating a JSONObject for Retail Session for session Attribute
		 */
		JSONObject jsonRetailPswdValid = new JSONObject();
		StringBuilder selectRetailPswdValid = new StringBuilder();

		DbConnection db = new DbConnection();
		selectRetailPswdValid.append(QueryConstants.SELECT_RETAILERS_DETAILS + " WHERE TRIM(RETAILERS_MASTER_NAME)=TRIM('"+ strRetailId + "') AND TRIM(RETAILERS_MASTER_PASSWORD)=TRIM('" + strPswd + "')");
		
		ResultSet rs = db.executeSelectQuery(selectRetailPswdValid.toString());
		if (rs.next()) {
			jsonRetailPswdValid.put("retailId", rs.getString("RETAILERS_MASTER_ID"));
			jsonRetailPswdValid.put("retailName", rs.getString("RETAILERS_MASTER_NAME"));
			jsonRetailPswdValid.put("isRecordExists", "Y");
		} else {
			jsonRetailPswdValid.put("isRecordExists", "N");
		}
		db.closeConnection();
		return jsonRetailPswdValid;
	}
}