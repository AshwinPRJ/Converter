<%-- 
	@author						: kiran
 	@module name/description	: Edit Shoppy Details
 	@created date				: 20 Mar 2017
 	@modified by				: 
 	@modified date				: 
 --%>
 <%@page import="java.sql.ResultSet"%>
<%@page import="com.nviera.dao.DbConnection"%>
<%@page import="com.nviera.constants.QueryConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Shop Details</title>
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
<script type="text/javascript">
	function fnEditBtn(id,shopId,shopFullName,shopPlace,shopCity){
		document.editShoppy.method = "post";
		document.editShoppy.action = "../views/CustomerCreationSave.jsp?page_cmd=editShoppyDetails&editId="+id+"&editshopId="+shopId+"&editShopFullName="+shopFullName+"&editShopPlace="+shopPlace+"&editShopCity="+shopCity;
 		document.editShoppy.submit();
	}
</script>
</head>
<body style="background-image: url('../img/Supermarket.jpg;">
<form name="editShoppy">
<div class="container col-sm-12 ">
  <h2 align="center"><font color="black">Shoppy Users Details List</font></h2>
  <table class="table table-hover">
    <thead>
      <tr class="danger">
        <!-- <th></th> -->
        <th>Shop Id</th>
        <th>Shoppy User Id</th>
        <th>Shoppy User Password</th>
        <th>Shop Full Name</th>
        <th>Shop Place</th>
        <th>Shop City</th>
        <th>Wallet Amount</th>
        <th></th>
      </tr>
    </thead>
<%
	DbConnection db = new DbConnection();
	String customersListSelectQuery= QueryConstants.SELECT_CUSTOMER_DETAILS +" ORDER BY 1";
	ResultSet rs= db.executeSelectQuery(customersListSelectQuery);
	while (rs.next()) {
		int rowCount = 0;
%>
    <tbody>
      <tr class="success">
        <!-- <td><input type="checkbox"></td> -->
        <td><%= rs.getString("customer_details_id") %></td>
        <td><input type = "text" id="shopUserId<%= rs.getString("customer_details_name")+rowCount%>" name="shopUserId<%= rs.getString("customer_details_name")+rowCount%>" value="<%= rs.getString("customer_details_name") %>" maxlength="30"></td>
        <td><%= rs.getString("customer_details_password") %></td>
        <td><input type = "text" id="shopUserFullName<%= rs.getString("customer_details_shop_name")+rowCount%>" name="shopUserFullName<%= rs.getString("customer_details_shop_name")+rowCount%>" value="<%= rs.getString("customer_details_shop_name")%>" maxlength="30"></td>
        <td><input type = "text" id="shopPlace<%= rs.getString("customer_details_place")+rowCount %>" name="shopPlace<%= rs.getString("customer_details_place")+rowCount %>" value="<%= rs.getString("customer_details_place") %>" maxlength="30"></td>
        <td><input type = "text" id="shopCity<%= rs.getString("customer_details_city")+rowCount %>" name="shopCity<%= rs.getString("customer_details_city")+rowCount %>" value="<%= rs.getString("customer_details_city") %>" maxlength="30"></td>
        <td><%= rs.getString("customer_details_wallet_amount") %></td>
        <td><input type="button" class="btn-success" id="btnEdit" name="btnEdit" value="Edit" onclick="fnEditBtn('<%= rs.getString("customer_details_id") %>',document.getElementById('shopUserId<%= rs.getString("customer_details_name")+rowCount%>').value,document.getElementById('shopUserFullName<%= rs.getString("customer_details_shop_name")+rowCount%>').value,document.getElementById('shopPlace<%= rs.getString("customer_details_place")+rowCount %>').value,document.getElementById('shopCity<%= rs.getString("customer_details_city")+rowCount %>').value)"></td>
      </tr>
    </tbody>
<%
		rowCount++;
	}
%>
  </table>
  <center><input type="button" class="btn-primary" onclick="window.open('CustomerCreation.jsp','_self')" value="Go Back"/></center>
</div>

</form>
</body>
</html>