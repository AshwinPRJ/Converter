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
<title>Shoppy Wallet Transactions Report</title>
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
<body style="background-image: url('../img/Supermarket.jpg;">
<div align="center">
	<br>
	<img align="middle" height="150" width="150" alt="" src="../img/GrahakLogo.jpg">
</div>
<br>
<%
	DbConnection db = new DbConnection();
	String strfromdate = request.getParameter("txtFromDate");
	String strtodate = request.getParameter("txtToDate");
	String strCustId = session.getAttribute("CustSessionId").toString();
	StringBuilder custTransSelectQuery = new StringBuilder();
	custTransSelectQuery.append("SELECT CUST_TRANSACTIONS_CUST_ID,CUSTOMER_DETAILS_NAME,CUSTOMER_DETAILS_SHOP_NAME,CUST_TRANSACTIONS_TOTAL_AMOUNT_PURCHASED,CUST_TRANSACTIONS_CREATED_BY,CUST_TRANSACTIONS_CREATED_ON,CUST_TRANSACTIONS_CREATED_TIME FROM CUST_TRANSACTIONS,CUSTOMER_DETAILS WHERE CUSTOMER_DETAILS_ID=CUST_TRANSACTIONS_CUST_ID and CUSTOMER_DETAILS_NAME='"+strCustId+"' AND CUST_TRANSACTIONS_CREATED_ON BETWEEN '"+strfromdate+"' AND '"+strtodate+"' ORDER BY 1");
	ResultSet rs = db.executeSelectQuery(custTransSelectQuery.toString());
%>
<div class="container col-sm-12">
	<h1 align="center"><font color="black">Shoppy Wallet Transaction Report</font></h1>
	<table align="center" border="1" class="table table-hover">
		<thead class="table table-hover">
			<tr class="danger">
				<th>Id</th>
				<th>Name</th>
				<th>Shop Name</th>
				<th>Wallet Amount Purchased</th>
				<th>Transaction By</th>
				<th>Transaction on</th>
				<th>Transaction time</th>
			</tr>
		</thead>
<%
	while(rs.next()){
%>
		<tbody>
			<tr class="success">
				<td><%=rs.getString("CUST_TRANSACTIONS_CUST_ID") %></td>
				<td><%=rs.getString("CUSTOMER_DETAILS_NAME") %></td>
				<td><%=rs.getString("CUSTOMER_DETAILS_SHOP_NAME") %></td>
				<td><%=rs.getString("CUST_TRANSACTIONS_TOTAL_AMOUNT_PURCHASED") %></td>
				<td><%=rs.getString("CUST_TRANSACTIONS_CREATED_BY") %></td>
				<td><%=rs.getString("CUST_TRANSACTIONS_CREATED_ON") %></td>
				<td><%=rs.getString("CUST_TRANSACTIONS_CREATED_TIME") %></td>
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