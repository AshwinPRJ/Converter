<%-- 
	@author						: Kiran 
 	@module name/description	: Change Customer Percentages Save Page
 	@created date				: 26-12-2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page language="java" import="org.json.JSONObject"%>
<%@ page import="com.nviera.service.CustomerCreation"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Items Percentage Values Save</title>
</head>
<body>
<%
	String page_cmd = request.getParameter("page_cmd");
	String strCustId = request.getParameter("txtCustId"); 
	if("custChangeItemsPercentage".equalsIgnoreCase(page_cmd)){
		CustomerCreation custChangePercentage = new CustomerCreation();
		String changeCustId = request.getParameter("txtCustId");
		double changeNewFoodItemsPercent = Double.parseDouble(request.getParameter("newFoodItemsPer"));
		double changeNewNonFoodItemsPercent = Double.parseDouble(request.getParameter("newNonFoodItemsPer"));
		custChangePercentage.ChangeCustomerItemsPercentages(changeCustId,changeNewFoodItemsPercent,changeNewNonFoodItemsPercent);
		out.println("<script>alert('Updated Successfully...');parent.location.href = 'CustomerLogin.jsp'</script>"); 
	}

%>
</body>
</html>