<%-- 
	@author						: kiran
 	@module name/description	: Admin Login Page
 	@created date				: 21 Dec 2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.nviera.dao.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoppy Wallet Report</title>
<script type="text/javascript" src="../js/angular.js"></script>
<script type="text/javascript" src="../js/angular.min.js"></script>
<script type="text/javascript" src="../js/angular-cookies.js"></script>
<script type="text/javascript" src="../js/angular-resource.js"></script>
<script type="text/javascript" src="../js/angular-route.js"></script>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript" src="../javaScript/FormFieldValidation.js"></script>
<script type="text/javascript" src="../javaScript/customerDetails.js"></script>
<script type="text/javascript">
function close_window() {
	window.close();
}

function Print_Report() {
	PrintButton.style.visibility = "hidden";
	window.print();
	PrintButton.style.visibility = "visible";
}
</script>
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat; background-size: 100% 100%;">
	<div align="center">
		<br>
		<img align="middle" height="150" width="150" alt="" src="../img/GrahakLogo.jpg">
	</div>
<%
	DbConnection db = new DbConnection();
	String strfromdate = request.getParameter("txtFromDate");
	String strtodate = request.getParameter("txtToDate");
	
	
	StringBuilder custDetailsSelectQuery = new StringBuilder();
	custDetailsSelectQuery.append("SELECT CUSTOMER_DETAILS_ID,CUSTOMER_DETAILS_NAME,CUSTOMER_DETAILS_SHOP_NAME,CUSTOMER_DETAILS_PLACE,CUSTOMER_DETAILS_CITY,CUSTOMER_DETAILS_WALLET_AMOUNT,CUSTOMER_DETAILS_FOODITEMS,CUSTOMER_DETAILS_NONFOODITEMS,CUSTOMER_DETAILS_SINCE,CUSTOMER_DETAILS_LAST_RECHARGE,CUSTOMER_DETAILS_STA,CUSTOMER_DETAILS_CREATED_BY,CUSTOMER_DETAILS_CREATED_ON,CUSTOMER_DETAILS_CREATED_TIME FROM CUSTOMER_DETAILS WHERE CUSTOMER_DETAILS_CREATED_ON BETWEEN '"+strfromdate+"' AND '"+strtodate+"' ORDER BY 1");
	ResultSet rs = db.executeSelectQuery(custDetailsSelectQuery.toString());
%>
	<div class="container col-sm-12">
	<h1 align="center" ><font color="black">Shoppy Wallet Details Report</font></h1>
	<table align="center" border="1" class="table table-hover">
		<thead>
			<tr class="danger">
				<th>Id</th>
				<th>Name</th>
				<th>Shop Name</th>
				<th>Place</th>
				<th>City</th>
				<th>Wallet Amount</th>
				<th>Food Items %</th>
				<th>Non Food Items %</th>
				<th>Customer Since</th>
				<th>Last Re-charge On</th>
				<th>Status</th>
				<th>Created By</th>
				<th>Created on</th>
				<th>Created Time</th>
			</tr>
		</thead>
<%
	while(rs.next()){
%>
		<tbody>
			<tr class="success">
				<td><%=rs.getString("customer_details_id") %></td>
				<td><%=rs.getString("customer_details_name") %></td>
				<td><%=rs.getString("customer_details_shop_name") %></td>
				<td><%=rs.getString("customer_details_place") %></td>
				<td><%=rs.getString("customer_details_city") %></td>
				<td><%=rs.getString("customer_details_wallet_amount") %></td>
				<td><%=rs.getString("customer_details_fooditems") %></td>
				<td><%=rs.getString("customer_details_nonfooditems") %></td>
				<td><%=rs.getString("customer_details_since") %></td>
				<td><%=rs.getString("customer_details_last_recharge") %></td>
				<td><%=rs.getString("customer_details_sta") %></td>
				<td><%=rs.getString("customer_details_created_by") %></td>
				<td><%=rs.getString("customer_details_created_on") %></td>
				<td><%=rs.getString("customer_details_created_time") %></td>
			</tr>
		</tbody>
<%
	}
%>
	</table>
	<table align="center" id='PrintButton'>
		<tr>
			<td><input class="btn btn-success" id=button1 name=button1 type=button value="Print" onClick="Print_Report()"></td>
			<td><input class="btn btn-danger" id=button1 name=button1 type=button value="Close" onClick="close_window()"></td>
		</tr>
	</table>
	</div>
</body>
</html>