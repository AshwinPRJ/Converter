<%-- 
	@author						: kiran
 	@module name/description	: user Points Page
 	@created date				: 05 oct 2016
 	@modified by				: kiran
 	@modified date				: 18 oct 2016
 --%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Redirect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@  page language="java" import ="org.json.JSONObject"%>
<%@  page language="java" import ="org.json.JSONArray"%>
<%@ page import="com.nviera.service.UserDetails" %>
<%@ page import="com.nviera.service.GrahakApiCall" %>
<%
	GrahakApiCall grahakApiCall = new GrahakApiCall();
	String strCustId=session.getAttribute("CustSessionId").toString();
	String strEnteredBy=session.getAttribute("CustSessionId").toString();

	UserDetails userDetail = new UserDetails();
	String page_cmd = request.getParameter("page_cmd");
	String strMobileNumber = request.getParameter("txtMobile");
	String strInvoiceNumber = request.getParameter("txtInvoiceNumber");
	
	if ("getInvoiceDetails".equalsIgnoreCase(page_cmd)) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter outs = response.getWriter();
		JSONObject strInvoiceValid = userDetail.getInvoiceValidate(strInvoiceNumber);
		outs.print(strInvoiceValid);
		return;
	} else if ("getMobieDetails".equalsIgnoreCase(page_cmd)) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter outs = response.getWriter();
		JSONObject strMobileValid = userDetail.getMobileValidate(strMobileNumber);
		outs.print(strMobileValid);
		return;
	}else if("getGrahakDetails".equalsIgnoreCase(page_cmd)){
		String grahakId = request.getParameter("txtGrahak");
		System.out.println("JSP GrahakId : "+grahakId);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter outs = response.getWriter();
		JSONArray strUserDetails = grahakApiCall.getGrahakDetails(grahakId,strEnteredBy);
		outs.print(strUserDetails);
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Points To User Save</title>
</head>
<body>
	<%
		if("savePoints".equalsIgnoreCase(page_cmd)){
			String strTransNumber = request.getParameter("userTransNum");
			String strMobileNum=request.getParameter("userMobile");
			double dblFoodItemsAmt = Double.parseDouble(request.getParameter("userFoodItemsAmount"));
			double dblNotFoodItemsAmt = Double.parseDouble(request.getParameter("userNonFoodItemsAmount"));
			double dblTotAmount=Double.parseDouble(request.getParameter("userTotAmount"));
			int intPoints=Integer.parseInt(request.getParameter("userTotalPointsEarn"));
			int intProductId = Integer.parseInt(request.getParameter("productId"));
			System.out.println("intProductId : "+intProductId);
			int intProductQuantity = Integer.parseInt(request.getParameter("productQuantity"));
			System.out.println("intProductQuantity : "+intProductQuantity);
			userDetail.getPointsSave(strMobileNum,strTransNumber,dblFoodItemsAmt,dblNotFoodItemsAmt,dblTotAmount,intPoints,intProductId,strCustId);
			out.println("<script>alert(' Data Saved Sucessfully ');parent.location.href='UserPoints.jsp'</script>");
		}
	%>
</body>
</html>