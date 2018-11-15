<%-- 
	@author						: Kiran 
 	@module name/description	: product lIST
 	@created date				: 15-02-2017
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>
<%@page import="com.nviera.dao.DbConnection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List Display</title>
<script type="text/javascript" src="../js/angular.js"></script>
<script type="text/javascript" src="../js/angular.min.js"></script>
<script type="text/javascript" src="../js/angular-cookies.js"></script>
<script type="text/javascript" src="../js/angular-resource.js"></script>
<script type="text/javascript" src="../js/angular-route.js"></script>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../javaScript/FormFieldValidation.js"></script>
<script type="text/javascript" src="../javaScript/customerDetails.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat;">
	<div align="center">
		<br>
		<img align="middle" height="150" width="150" alt="" src="../img/GrahakLogo.jpg">
	</div>
	<form name="mobileSearch" method="post">
		<h2 align="center"><font color="black">Product Search</font></h2>
		<input id="page_cmd" name="page_cmd" type="hidden" value="" />
		<table align="Center" border="2" cellpadding="2" class="table table-hover">
			<%
				/* String CustId = session.getAttribute("CustSessionId").toString(); */
				String strQuery = "";
				/* String strMobileNumber = request.getParameter("MobileNumber"); */
				try {
					DbConnection db = new DbConnection();
					strQuery = "SELECT * FROM PRODUCTS ORDER BY 1";
					ResultSet rs = db.executeSelectQuery(strQuery);
					if (rs != null) {
			%>
			<thead>
				<tr class="danger">
					<th>Slno</th>
					<th>Product Name</th>
					<th>Product MRP</th>
					<th>GP Price</th>
					<th>Points</th>
				</tr>
			</thead>
			<%
				while (rs.next()) {
			%>
			<tbody>
				<tr class="success">
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>') "><%=rs.getString("products_slno")%></a></td>
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>')"><%=rs.getString("products_name")%></a></td>
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>')"><%=rs.getString("products_mrp")%></a></td>
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>') "><%=rs.getString("products_gpprice")%></a></td>
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>') "><%=rs.getString("products_points")%></a></td>
				</tr>
			
			<%
				}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			%>
				
			</tbody>
		</table>
		<h1 align="center"><input type="button" class="btn btn-success" id="" value="Go Back" onclick="window.location.href='../index.jsp'" /></h1>
	</form>
</body>
</html>