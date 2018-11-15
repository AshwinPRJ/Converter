<%-- 
	@author						: kiran
 	@module name/description	: Admin Login Page
 	@created date				: 05 oct 2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page language="java" import="org.json.JSONObject"%>
<%@ page import="com.nviera.service.RetailerCreation"%>
<%
	/* String strEnteredBy=session.getAttribute("AdminSessionId").toString(); */
	String strEnteredBy="brahmani";
	String page_cmd = request.getParameter("page_cmd");
	String strRetailerId = request.getParameter("txtRetailerId"); 
	RetailerCreation retailerValid = new RetailerCreation();
	if ("getRetailerDetails".equalsIgnoreCase(page_cmd)) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter outs = response.getWriter();
		JSONObject retailerDetails = retailerValid.RetailerValidation(strRetailerId);
		outs.print(retailerDetails);
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retailer Creation Save</title>
</head>
<body>
	<%
		if("addNewRetailer".equalsIgnoreCase(page_cmd)){
			RetailerCreation retailerCreat = new RetailerCreation();
			strRetailerId = request.getParameter("addRetailerId");
			String strRetailerName = request.getParameter("addRetailerName");
			String strRetailerAddress = request.getParameter("addRetailerAddress");
			retailerCreat.ModifyRetailerList(strRetailerId,strRetailerName,strRetailerAddress,strEnteredBy);
			out.println("<script>alert('Modified Successfully...');parent.location.href='RetailerCreation.jsp'</script>");
		}else if("createNewRetailer".equalsIgnoreCase(page_cmd)){
			RetailerCreation retailerCreat = new RetailerCreation();
			strRetailerId = request.getParameter("regRetailerId");
			String strRetailerPswd = request.getParameter("regRetailerPswd");
			String strRetailerAddress = request.getParameter("regRetailerAddress");
			retailerCreat.RetailerAdd(strRetailerId,strRetailerPswd,strRetailerAddress,strEnteredBy);
			out.println("<script>alert('Retailer Created Successfully...');parent.location.href='RetailerCreation.jsp'</script>");
		}else if("delRetailer".equalsIgnoreCase(page_cmd)){
			RetailerCreation retailerDel = new RetailerCreation();
			String delRetailerId = request.getParameter("txtdelRetailerId");
			retailerDel.RetailerDeletion(delRetailerId,strEnteredBy);
			out.println("<script>alert('Deleted Successfully...');parent.location.href='RetailerCreation.jsp'</script>");
		}
	
	
	%>
</body>
</html>