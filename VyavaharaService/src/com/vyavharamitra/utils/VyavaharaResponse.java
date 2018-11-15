package com.vyavharamitra.utils;

/**
 * @author : Kittu Kiran
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */
public class VyavaharaResponse {
	private int statusCode;
	private String statusMessage;

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage
	 *            the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
