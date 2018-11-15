package com.nviera.service;

import java.sql.ResultSet;

import org.json.JSONObject;

import com.nviera.constants.QueryConstants;
import com.nviera.dao.DbConnection;

/**
 * @author			: kiran
 * @created date	: 05 oct 2016
 * @modified by		: kiran
 * @modified date	: 18 oct 2016
 */
public class AdminLogin {
	/**
	 * for admin Id validation
	 * @param strAdminId
	 * @return jsonStatus
	 * @throws Exception
	 */
	public JSONObject AdminIdValidate(String strAdminId) throws Exception {
		/**
		 * Creating a JSONObject for jsonAdminIdValid
		 */
		JSONObject jsonAdminIdValid = new JSONObject();
		StringBuilder selectAdminIdValid = new StringBuilder();

		DbConnection db = new DbConnection();

		selectAdminIdValid.append(QueryConstants.SELECT_ADMIN_ID_DETAILS + " WHERE TRIM(ADMIN_DETAILS_USERID)=TRIM('"+ strAdminId + "')");
		ResultSet rs = db.executeSelectQuery(selectAdminIdValid.toString());
		if (rs.next()) {
			jsonAdminIdValid.put("isRecordExists", "Y");
		} else {
			jsonAdminIdValid.put("isRecordExists", "N");
		}
		return jsonAdminIdValid;
	}
	/**
	 * for admin Password validation
	 * @param strAdminId
	 * @param strPswd
	 * @return jsonAdminPswdValid
	 * @throws Exception
	 */
	public JSONObject AdminPswdVadlidate(String strAdminId, String strPswd) throws Exception {
		/**
		 * Creating a JSONObject for Admin Session for session Attribute
		 */
		JSONObject jsonAdminPswdValid = new JSONObject();
		StringBuilder selectAdminPswdValid = new StringBuilder();

		DbConnection db = new DbConnection();

		selectAdminPswdValid.append(QueryConstants.SELECT_ADMIN_ID_DETAILS + " WHERE TRIM(ADMIN_DETAILS_USERID)=TRIM('"+ strAdminId + "') AND TRIM(ADMIN_DETAILS_PASSWORD)=TRIM('" + strPswd + "')");
		ResultSet rs = db.executeSelectQuery(selectAdminPswdValid.toString());
		if (rs.next()) {
			jsonAdminPswdValid.put("adminId", rs.getString("ADMIN_DETAILS_USERID"));
			jsonAdminPswdValid.put("isRecordExists", "Y");
		} else {
			jsonAdminPswdValid.put("isRecordExists", "N");
		}
		db.closeConnection();
		return jsonAdminPswdValid;
	}
}