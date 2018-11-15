<%-- 
	@author						: Babu Prakash
 	@module name/description	: Retail Login Page
 	@created date				: 11 feb 2017
 	@modified by				: Babu Prakash
 	@modified date				: 11 feb 2017
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@  page language="java" import="org.json.JSONObject"%>
<%@ page import="com.nviera.service.RetailLogin"%>
<%
	RetailLogin RetailIdCheck = new RetailLogin();
	String page_cmd = request.getParameter("page_cmd");
	String strRetailValid = request.getParameter("txtretailId");
	if ("retailIdValidate".equalsIgnoreCase(page_cmd)) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter outs = response.getWriter();
		JSONObject jsonRetailValidate = RetailIdCheck.RetailIdValidate(strRetailValid);
		outs.print(jsonRetailValidate);
		return;
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Login Save</title>
</head>
<body>
	<%
		String strRetailSessionId="";
	String strRetailSessionName="";
		RetailLogin RetailloginPswdValidate = new RetailLogin();
		String strRetailId = request.getParameter("txtRetailId");
		String strPswd = request.getParameter("retailPswd");
		JSONObject RetailSession = RetailloginPswdValidate.RetailPswdVadlidate(strRetailId, strPswd);
		String strIsRecordExist    = RetailSession.get("isRecordExists").toString();
		if("Y".contains(strIsRecordExist)){
			strRetailSessionId    = RetailSession.get("retailId").toString();
			strRetailSessionName  =RetailSession.get("retailName").toString();
			out.println("<script>alert('Login Successfull...');parent.location.href='RetailOrderDetails.jsp'</script>");
			}else{
			out.println("<script>alert('In Valid Password...');parent.location.href='RetailLogin.jsp'</script>");
		}
		session.setAttribute("RetailSessionId", strRetailSessionId);
		session.setAttribute("RetailSessionName", strRetailSessionName);
		
	%>
</body>
</html>