<%-- 
	@author						: sushma
 	@module name/description	: Admin Login Page
 	@created date				: 17 oct 2016
 	@modified by				: kiran
 	@modified date				: 17 oct 2016
 --%>
<%@page import="com.nviera.service.CustomerLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@  page language="java" import="org.json.JSONObject"%>
<%@ page import="com.nviera.service.CustomerLogin"%>
<%
	CustomerLogin CustIdCheck = new CustomerLogin();
	String page_cmd = request.getParameter("page_cmd");
	String strCustValid = request.getParameter("txtcustId");
	if ("custIdValidate".equalsIgnoreCase(page_cmd)) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter outs = response.getWriter();
		JSONObject jsonCustValidate = CustIdCheck.CustIdValidate(strCustValid);
		outs.print(jsonCustValidate);
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Login Save</title>
</head>
<body>
	<%
		String strCustSessionId="";
		String strCustWalletSessionId="";
		String strCustFoodItemsSessionId="";
		String strCustNonFoodItemsSessionId="";
		String strCustChangePercentageSessionId="";
		String strCustChangeProductSessionId="";
		CustomerLogin CustloginPswdValidate = new CustomerLogin();
		
		String strCustId = request.getParameter("txtCustId");
		String strPswd = request.getParameter("custPswd");

		JSONObject CustSession = CustloginPswdValidate.CustPswdVadlidate(strCustId, strPswd);
		
		String strIsRecordExist    = CustSession.get("isRecordExists").toString();
		
		if("Y".contains(strIsRecordExist)){
			strCustSessionId    = CustSession.get("custId").toString();
			strCustWalletSessionId = CustSession.get("custWalletAmt").toString();
			strCustFoodItemsSessionId    = CustSession.get("custFoodItemsPer").toString();
			strCustNonFoodItemsSessionId = CustSession.get("custNonFoodItemsPer").toString();
			strCustChangePercentageSessionId = CustSession.get("custPercentageChange").toString();
			strCustChangeProductSessionId = CustSession.get("custProductChange").toString();
			out.println("<script>alert('Login Successfull...');parent.location.href='UserPoints.jsp'</script>");	
		}else{
			out.println("<script>alert('In Valid Password...');parent.location.href='CustomerLogin.jsp'</script>");
		}
		session.setAttribute("CustSessionId", strCustSessionId);
		session.setAttribute("CustWalletSessionId", strCustWalletSessionId);
		session.setAttribute("CustFoodItemsPerSessionId", strCustFoodItemsSessionId);
		session.setAttribute("CustNonFoodItemsPerSessionId", strCustNonFoodItemsSessionId);
		session.setAttribute("CustChangePercentageSessionId", strCustChangePercentageSessionId);
		session.setAttribute("CustChangeProductSessionId", strCustChangeProductSessionId);
	%>
</body>
</html>