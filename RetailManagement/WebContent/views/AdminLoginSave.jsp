<%-- 
	@author						: sushma
 	@module name/description	: Admin Login Page
 	@created date				: 05 oct 2016
 	@modified by				: kiran
 	@modified date				: 05 oct 2016
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@  page language="java" import="org.json.JSONObject"%>
<%@ page import="com.nviera.service.AdminLogin"%>
<%
	AdminLogin AdminIdCheck = new AdminLogin();
	String page_cmd = request.getParameter("page_cmd");
	String strAdminValid = request.getParameter("txtadminId");
	if ("adminIdValidate".equalsIgnoreCase(page_cmd)) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter outs = response.getWriter();
		JSONObject jsonAdminValidate = AdminIdCheck.AdminIdValidate(strAdminValid);
		outs.print(jsonAdminValidate);
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login Save</title>
</head>
<body>
	<%
		String strAdminSessionId="";
		
		AdminLogin AdminloginPswdValidate = new AdminLogin();
		
		String strAdminId = request.getParameter("txtAdminId");
		String strPswd = request.getParameter("adminPswd");

		JSONObject AdminSession = AdminloginPswdValidate.AdminPswdVadlidate(strAdminId, strPswd);
		
		String strIsRecordExist    = AdminSession.get("isRecordExists").toString();
		
		if("Y".contains(strIsRecordExist)){
			strAdminSessionId    = AdminSession.get("adminId").toString();
			out.println("<script>alert('Login Successfull...');parent.location.href='CustomerCreation.jsp'</script>");	
		}else{
			out.println("<script>alert('In Valid Password...');parent.location.href='AdminLogin.jsp'</script>");
		}
		session.setAttribute("AdminSessionId", strAdminSessionId);
	%>
</body>
</html>