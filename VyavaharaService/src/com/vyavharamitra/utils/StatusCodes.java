package com.vyavharamitra.utils;
/**
 * @author : Kittu Kiran
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */
public class StatusCodes {
	/**
	 * HTTP STATUS CODES OF SUCCESS
	 */
	/* The request is OK */
	public static final int OK = 200;
	/* The request is complete, and a new resource is created */
	public static final int CREATED = 201;
	/* The request is accepted for processing, but the processing is not complete */
	public static final int ACCEPTED = 202;

	public static final int NON_AUTHORITATIVE_INFORMATION = 203;

	public static final int NO_CONTENT = 204;

	public static final int RESET_CONTENT = 205;

	/**
	 * HTTP STATUS CODES OF CLIENT ERROR
	 */
	/* The server did not understand the request */
	public static final int BAD_REQUEST = 400;
	/* The requested page needs a username and a password */
	public static final int UN_AUTHORIZED = 401;
	/* You can not use this code yet */
	public static final int PAYMENT_REQUIRED = 402;
	/* Access is forbidden to the requested page */
	public static final int FOR_BIDDEN = 403;
	/* The server can not find the requested page. */
	public static final int NOT_FOUND = 404;
	/* The method specified in the request is not allowed. */
	public static final int METHOD_NOT_ALLOWED = 405;
	/* The server can only generate a response that is not accepted by the client */
	public static final int NOT_ACCEPTABLE = 406;

	public static final int MISMATCH = 111;

	/**
	 * HTTP STATUS CODES OF SERVER ERROR
	 */
	/* The request was not completed. The server met an unexpected condition */
	public static final int INTERNAL_SERVER_ERROR = 500;
	/* The request was not completed. The server did not support the functionality required */
	public static final int NOT_IMPLEMENTED = 501;
	/* The request was not completed. The server received an invalid response from the upstream server */
	public static final int BAD_GATEWAY = 502;
	/* The request was not completed. The server is temporarily overloading or down */
	public static final int SERVICE_UNAVAILABLE = 503;
	/* The gateway has timed out. */
	public static final int GATEWAY_TIMEOUT = 504;
	/* The server does not support the http protocol version. */
	public static final int HTTP_VERSION_NOT_SUPPORTED = 505;

}
