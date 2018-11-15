package com.nviera.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;;

public class SmsApi {

	public static void sendSmsApi(String strPhoneNumber, double dblPurchaseAmt, int intEarnedPoints, String CustomerId) {
		try {
			String username = "grahak";
			String password = "Ppprrasad9*";
			String from = "TEAMGP";
			String to = strPhoneNumber;
			String msg = "Dear Customer thankyou for shopping at:"+CustomerId+". The Amount of Purchase is " + Math.round(dblPurchaseAmt)+ ",Points Earned is " + intEarnedPoints;
			String requestUrl = "http://182.18.165.185/API/sms.php?action=sendmessage&" + "username="
					+ URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8")
					+ "&from=" + URLEncoder.encode(from, "UTF-8") + "&to=" + URLEncoder.encode(to, "UTF-8") + "&msg="
					+ URLEncoder.encode(msg, "UTF-8") + "&type=1" + "&dnd_check=0";

			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			System.err.println("Status "+uc.getResponseMessage());
			uc.disconnect();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	/*public static void main (String args[]){
		sendSmsApi("9160326436",22.36,12,13);
	}*/
}
