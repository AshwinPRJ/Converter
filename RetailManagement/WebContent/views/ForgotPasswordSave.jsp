<%-- 
	@author						: kiran
 	@module name/description	: Forgot Password Save Page
 	@created date				: 21 Dec 2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page language="java" import="org.json.JSONObject"%>
<%@ page import="com.nviera.service.CustomerCreation"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password Save Page</title>
</head>
<body>
<%
	String page_cmd = request.getParameter("page_cmd");
	String strCustId = request.getParameter("txtCustId"); 
	if("custChangePswd".equalsIgnoreCase(page_cmd)){
		CustomerCreation custChangePswd = new CustomerCreation();
		String changeCustId = request.getParameter("txtCustId"); String newPassword =
		request.getParameter("newCustPswd");
		custChangePswd.ChangeCustomerPassword(changeCustId,newPassword);
		out.println("<script>alert('Password Changed Successfully...');parent.location.href = 'CustomerLogin.jsp'</script>"); 
	}
%>
</body>
</html>