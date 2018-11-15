package com.nviera.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class APICall {
	
	public static void userAuth(String strTransNumber,String strGrahakId,String strMobileNumber,double dblTotAmount,int intPoints) {
		JSONArray jsonArr = new JSONArray();
		intPoints = intPoints*70/100;
		try {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("OrderNo", strTransNumber);
			jsonObj.put("Invno", strTransNumber);
			jsonObj.put("Invdate", "01/01/2014");
			jsonObj.put("LoginId", strGrahakId);
			jsonObj.put("shipCharge", "0");
			jsonObj.put("CompanyDiscount", "0");
			jsonObj.put("discountPer", "0");
			jsonObj.put("payMode", "Online Banking");
			jsonObj.put("refNo", "0");
			jsonObj.put("bankName", "State Banhk of India");
			jsonObj.put("paymentStatus", "1");
			jsonObj.put("totalMRP", dblTotAmount);
			jsonObj.put("totalPaidAmount", dblTotAmount);
			jsonObj.put("totalquantity", "0");
			jsonObj.put("TotalME", intPoints);
			jsonObj.put("Discount", "0");
			jsonObj.put("shipName", "0");
			jsonObj.put("shipEmail", "0");
			jsonObj.put("Shipphone", strMobileNumber);
			jsonObj.put("shipaddress", "0");
			jsonObj.put("Shipstate", "0");
			jsonObj.put("Shipcity", "0");
			jsonObj.put("shippincode", "0");
			jsonObj.put("billName", "0");
			jsonObj.put("billEmail", "0");
			jsonObj.put("billPhone", "0");
			jsonObj.put("billAddress", "0");
			jsonObj.put("billPinCode", "0");
			jsonArr.put(jsonObj);
			
			Integer merchantId = 1003522907;
			String secretKey = "ZP93435BUI3AM34534M53AOPR54B7W567S56U32A7fK79OQBT646440oyehKKP39CS";
			String relationCode = "GEO7321386245GRAH098";

			String requestUrl = "http://geoapi.grahakpower.com/Order/Insert/"+merchantId+"/"+secretKey+"/"+relationCode+"/Data";
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			uc.setDoOutput(true);
			uc.setDoInput(true);
			uc.setRequestMethod("POST");
			uc.setRequestProperty("Content-Length","100000");
			uc.setRequestProperty("Content-type", "application/json");
			OutputStream wr = uc.getOutputStream();
			    wr.write(jsonArr.toString().getBytes());
			    wr.flush();
			    wr.close();
			System.err.println("Status "+uc.getResponseCode());
			
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
		    String inputLine;
		    StringBuffer response = new StringBuffer();

		    while ((inputLine = in.readLine()) != null) {
		        response.append(inputLine);
		    }
		    in.close();
		    System.err.println("Response : "+response.toString());
			uc.disconnect();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	/*public static void main(String args[]){
		APICall api = new APICall();
		api.userAuth("121211","GP704470","9866847661",1,1);
	}*/
}
