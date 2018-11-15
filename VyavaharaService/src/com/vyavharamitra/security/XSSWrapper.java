package com.vyavharamitra.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSWrapper extends HttpServletRequestWrapper {

	public XSSWrapper(HttpServletRequest httpServletRequest) {
		super(httpServletRequest);

	}

}
