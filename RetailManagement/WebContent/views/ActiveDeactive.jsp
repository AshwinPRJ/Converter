<%-- 
	@author						: kiran
 	@module name/description	: Customer List to Active & Deactive Food Items 
 	@created date				: 24 Dec 2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.nviera.dao.DbConnection"%>
<%@page import="com.nviera.constants.QueryConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoppy List</title>
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
	function fnActiveBtnPer(id){
		document.ActDAct.method = "post";
		document.ActDAct.action = "../views/CustomerCreationSave.jsp?page_cmd=active&actCustId="+id;
		document.ActDAct.submit();
	}
	
	function fnDeActiveBtnPer(id){
		document.ActDAct.method = "post";
		document.ActDAct.action = "../views/CustomerCreationSave.jsp?page_cmd=deactive&deActCustId="+id;
		document.ActDAct.submit();
	}
	function fnActiveBtnPro(id){
		document.ActDAct.method = "post";
		document.ActDAct.action = "../views/CustomerCreationSave.jsp?page_cmd=activeProduct&actProCustId="+id;
		document.ActDAct.submit();
	}
	
	function fnDeActiveBtnPro(id){
		document.ActDAct.method = "post";
		document.ActDAct.action = "../views/CustomerCreationSave.jsp?page_cmd=deactiveProduct&deActProCustId="+id;
		document.ActDAct.submit();
	}
</script>
</head>
<body style="background-image: url('../img/Supermarket.jpg;">
<form name="ActDAct">
<div class="container col-sm-12 ">
  <h2 align="center"><font color="black">Shoppy List</font></h2>
  <table class="table table-hover">
    <thead>
      <tr class="danger">
        <!-- <th></th> -->
        <th>Id</th>
        <th>Customer Name</th>
        <th>Shop Name</th>
        <th>Shop Place</th>
        <th>Shop City</th>
        <th>Wallet Amount</th>
        <th>% Y/N</th>
        <th>Product Y/N</th>
        <th>% Active/Deactive</th>
        <th>Product</th>
      </tr>
    </thead>
<%
	DbConnection db = new DbConnection();
	String customersListSelectQuery= QueryConstants.SELECT_CUSTOMER_DETAILS +" ORDER BY 1";
	ResultSet rs= db.executeSelectQuery(customersListSelectQuery);
	while (rs.next()) {
%>
    <tbody>
      <tr class="success">
        <!-- <td><input type="checkbox"></td> -->
        <td><%= rs.getString("customer_details_id") %></td>
        <td><%= rs.getString("customer_details_name") %></td>
        <td><%= rs.getString("customer_details_shop_name") %></td>
        <td><%= rs.getString("customer_details_place") %></td>
        <td><%= rs.getString("customer_details_city") %></td>
        <td><%= rs.getString("customer_details_wallet_amount") %></td>
        <td><%= rs.getString("customer_details_items_percent_change") %></td>
        <td><%= rs.getString("customer_details_product_change") %></td>
        <td><input type="button" class="btn-success" id="btnActive" name="btnActive" value="Active" onclick="fnActiveBtnPer(<%= rs.getString("customer_details_id") %>)">&nbsp&nbsp<input type="button" class="btn-danger" id="btnDeactive" name="btnDeactive" value="Deactive" onclick="fnDeActiveBtnPer(<%= rs.getString("customer_details_id") %>)"></td>
        <td><input type="button" class="btn-success" id="btnActive" name="btnActive" value="Active" onclick="fnActiveBtnPro(<%= rs.getString("customer_details_id") %>)">&nbsp&nbsp<input type="button" class="btn-danger" id="btnDeactive" name="btnDeactive" value="Deactive" onclick="fnDeActiveBtnPro(<%= rs.getString("customer_details_id") %>)"></td>
      </tr>
    </tbody>
<%
	}
%>
  </table>
  <center><input type="button" class="btn-primary" onclick="window.open('CustomerCreation.jsp','_self')" value="Go Back"/></center>
</div>

</form>
</body>
</html>