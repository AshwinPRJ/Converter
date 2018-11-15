package com.nviera.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.nviera.dao.DbConnection;

/**
 * @author			: kiran
 * @created date	: 20 Jan 2017
 * @modified by		: 
 * @modified date	: 
 */
public class GrahakApiCall {
	
	public JSONArray getGrahakDetails(String grahakId,String strEnteredBy) throws Exception {
		DbConnection db = new DbConnection();
		JSONArray jsonArray = null;
		JSONObject jsonObject = null;
		
		/*StringBuffer response = new StringBuffer();*/
		try{
		Integer merchantId = 1004376749;
		String secretKey = "A345MK53453453SBSOPKSNU43FIDAHUSAINNW4554EQAND65JML55544ALAMWK3257989EMNSLAA232AKJWKQH";
		
		
		String requestUrl = "http://devapi.grahakpower.com/DeveloperApi/getProfile?MerchantID="+merchantId+"&secretKey="+secretKey+"&UserID="+grahakId+"&pass=N/A";
		
		URL url = new URL(requestUrl);
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.setRequestMethod("GET");
		uc.setRequestProperty("Content-type", "application/json");
		System.err.println("Status "+uc.getResponseCode());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
		String inputLine = in.readLine();
		jsonArray = new JSONArray(inputLine);
		for(int i = 0; i < jsonArray.length(); i++){
			String strUserID = jsonArray.getJSONObject(i).getString("UserID");
			String strFirstName = jsonArray.getJSONObject(i).getString("FirstName");
			String strLastName = jsonArray.getJSONObject(i).getString("LastName");
			String strFullName = strFirstName+strLastName;
			String strMobileNo = jsonArray.getJSONObject(i).getString("MobileNo");
			String strAddress = jsonArray.getJSONObject(i).getString("Address");
			String strCity = jsonArray.getJSONObject(i).getString("City");
			String strState = jsonArray.getJSONObject(i).getString("State");
			String strEmailID = jsonArray.getJSONObject(i).getString("EmailID");
			
			String strMerchantID = jsonArray.getJSONObject(i).getString("MerchantID");
			String strPinCode = jsonArray.getJSONObject(i).getString("PinCode");
			String strStatus = jsonArray.getJSONObject(i).getString("Status");
			String strCountry = jsonArray.getJSONObject(i).getString("Country");
			String strDistrict = jsonArray.getJSONObject(i).getString("District");
			
			String strSqlDelete = "delete from user_details where user_details_grahakid = '"+strUserID+"' ";
			db.runPreparedStmt(strSqlDelete);
			String strSqlInsert = "INSERT INTO user_details (user_details_grahakid,user_details_fullname,user_details_mobile,user_details_address,user_details_city,user_details_state,user_details_email,user_details_created_by,user_details_created_on,user_details_created_time) "
					+ "VALUES ('"+strUserID+"','"+strFullName+"','"+strMobileNo+"','"+strAddress+"','"+strCity+"','"+strState+"','"+strEmailID+"','"+strEnteredBy+"',current_date,to_char(now(),'HH24:MI:SS'))";
			db.runPreparedStmt(strSqlInsert);
		}
		}catch (Exception e) {
		}
		return jsonArray;
	}
	/*public static void main(String args[]) throws Exception{
		GrahakApiCall api = new GrahakApiCall();
		api.getGrahakDetails("GP704470","Test");
	}*/
}
