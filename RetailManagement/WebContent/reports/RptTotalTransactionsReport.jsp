<%-- 
	@author						: kiran
 	@module name/description	: All Users Transactions Reports Login Page
 	@created date				: 20 Feb 2017
 	@modified by				: 
 	@modified date				: 
 --%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.nviera.dao.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total Users Transaction Report</title>
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
<%
	DbConnection db = new DbConnection();
	String strfromdate = request.getParameter("txtFromDate");
	String strtodate = request.getParameter("txtToDate");

	StringBuilder userDetailsTransactionSelectQuery = new StringBuilder();
	userDetailsTransactionSelectQuery.append("SELECT USER_TRANSACTIONS_GRAHAKID,USER_DETAILS_FULLNAME,USER_TRANSACTIONS_USER_NUMBER,USER_TRANSACTIONS_FOOD_PURCHASED,USER_TRANSACTIONS_NONFOOD_PURCHASED,USER_TRANSACTIONS_TOTAL_AMOUNT_PURCHASED,USER_TRANSACTIONS_EARNED_POINTS,USER_TRANSACTIONS_CREATED_BY,USER_TRANSACTIONS_CREATED_ON FROM USER_TRANSACTIONS,USER_DETAILS WHERE USER_TRANSACTIONS_GRAHAKID= USER_DETAILS_GRAHAKID AND USER_TRANSACTIONS_CREATED_ON BETWEEN '"+strfromdate+"' AND '"+strtodate+"'  ORDER BY 1");
	System.out.println("userDetailsTransactionSelectQuery  " +userDetailsTransactionSelectQuery);
	ResultSet rs = db.executeSelectQuery(userDetailsTransactionSelectQuery.toString());
%>
	<div class="container col-sm-12">
	<h1 align="center"><font color="black">Total Users Transactions Details Report</font></h1>
	<table align="center" border="1" class="table table-hover">
		<thead class="table table-hover">
			<tr class="danger">
				<th>Id</th>
				<th>Name</th>
				<th>Invoice Number</th>
				<th>Food Items Purchased</th>
				<th>Non Food Items Purchased</th>
				<th>Total Amount</th>
				<th>Earned Points</th>
				<th>Created By </th>
				<th>Created On</th>
			</tr>
		</thead>
<%
	while(rs.next()){
%>
		<tbody>
			<tr class="success">
				<td><%=rs.getString("USER_TRANSACTIONS_GRAHAKID") %></td>
				<td><%=rs.getString("USER_DETAILS_FULLNAME") %></td>
				<td><%=rs.getString("USER_TRANSACTIONS_USER_NUMBER") %></td>
				<td><%=rs.getString("USER_TRANSACTIONS_FOOD_PURCHASED") %></td>
				<td><%=rs.getString("USER_TRANSACTIONS_NONFOOD_PURCHASED") %></td>
				<td><%=rs.getString("USER_TRANSACTIONS_TOTAL_AMOUNT_PURCHASED") %></td>
				<td><%=rs.getString("USER_TRANSACTIONS_EARNED_POINTS") %></td>
				<td><%=rs.getString("USER_TRANSACTIONS_CREATED_BY") %></td>
				<td><%=rs.getString("USER_TRANSACTIONS_CREATED_ON") %></td>
			</tr>
		</tbody>
<%
	}
%>
	</table>
	<table align="center" id='PrintButton'>
		<tr>
			<td><input class="btn btn-success" id=button1 name=button1 type=button value="Print" onclick="Print_Report()"></td>
			<td><input class="btn btn-danger" id=button1 name=button1 type=button value="Close" onclick="close_window()"></td>
		</tr>
	</table>
	</div>
</body>
</html>