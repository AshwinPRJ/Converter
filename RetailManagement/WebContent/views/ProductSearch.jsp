<%-- 
	@author						: Kiran 
 	@module name/description	: product Search
 	@created date				: 26-12-2016
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
<title>Product Search</title>
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
<script type="text/javascript">
	function fnProName(slno, productName,productMRP,productAmount,points,quantity) {
		if(quantity == "0"){
			alert("No quantity");
		} else{
			window.opener.userFoodItemsAmount.value = "0.00";
			window.opener.userFoodItemsAmount.readOnly  = true;
			window.opener.userNonFoodItemsAmount.value = "0.00";
			window.opener.userNonFoodItemsAmount.readOnly  = true;
			window.opener.productName.value = productName;
			window.opener.userTotAmount.value = productAmount;
			window.opener.userTotalPointsEarn.value = points;
			window.opener.productId.value = slno;
			window.opener.productQuantity.value = quantity;
			window.opener.btsubmit.focus();
			self.close();
		}
	}
</script>
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
				String CustId = session.getAttribute("CustSessionId").toString();
				String strQuery = "";
				/* String strMobileNumber = request.getParameter("MobileNumber"); */
				try {
					DbConnection db = new DbConnection();
					strQuery = "SELECT * FROM CUSTPRODUCTS,PRODUCTS WHERE CUSTPRODUCTS_PRODUCTID = PRODUCTS_SLNO AND custproducts_custname='"+CustId+"' and CUSTPRODUCTS_STA='A' ORDER BY 1";
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
					<th>Quantity</th>
				</tr>
			</thead>
			<%
				while (rs.next()) {
			%>
			<tbody>
				<tr class="success">
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>','<%=rs.getString("custproducts_quantity")%>') "><%=rs.getString("products_slno")%></a></td>
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>','<%=rs.getString("custproducts_quantity")%>') "><%=rs.getString("products_name")%></a></td>
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>','<%=rs.getString("custproducts_quantity")%>')"><%=rs.getString("products_mrp")%></a></td>
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>','<%=rs.getString("custproducts_quantity")%>') "><%=rs.getString("products_gpprice")%></a></td>
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>','<%=rs.getString("custproducts_quantity")%>') "><%=rs.getString("products_points")%></a></td>
					<td><a href="javascript:fnProName('<%=rs.getString("products_slno")%>','<%=rs.getString("products_name")%>','<%=rs.getString("products_mrp")%>','<%=rs.getString("products_gpprice")%>','<%=rs.getString("products_points")%>','<%=rs.getString("custproducts_quantity")%>') "><%=rs.getString("custproducts_quantity")%></a></td>
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
	</form>

</body>
</html>