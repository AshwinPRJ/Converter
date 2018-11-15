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
<title>Product List</title>
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
	function fnActiveBtnProduct(id){
		document.ActDAct.method = "post";
		document.ActDAct.action = "../views/ProductAddSave.jsp?page_cmd=activePro&actProId="+id;
		document.ActDAct.submit();
	}
	
	function fnDeActiveBtnProduct(id){
		document.ActDAct.method = "post";
		document.ActDAct.action = "../views/ProductAddSave.jsp?page_cmd=deactivePro&deActProId="+id;
		document.ActDAct.submit();
	}
</script>
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat;">
<form name="ActDAct">
<div class="container col-sm-12 ">
  <h2 align="center"><font color="black">Product List</font></h2>
  <table class="table table-hover">
    <thead>
      <tr class="danger">
        <th>Id</th>
        <th>Product Name</th>
        <th>Product MRP</th>
        <th>Product GP Price</th>
        <th>Product Points</th>
        <th>Status</th>
        <th>Product Active/Deactive</th>
      </tr>
    </thead>
<%
	DbConnection db = new DbConnection();
	String productListSelectQuery= QueryConstants.PRODUCTS_SELECT +" ORDER BY 1";
	ResultSet rs= db.executeSelectQuery(productListSelectQuery);
	while (rs.next()) {
%>
    <tbody>
      <tr class="success">
        <!-- <td><input type="checkbox"></td> -->
        <td><%= rs.getString("products_slno") %></td>
        <td><%= rs.getString("products_name") %></td>
        <td><%= rs.getString("products_mrp") %></td>
        <td><%= rs.getString("products_gpprice") %></td>
        <td><%= rs.getString("products_points") %></td>
        <td><%= rs.getString("products_sta") %></td>
        <td><input type="button" class="btn-success" id="btnActive" name="btnActive" value="Active" onclick="fnActiveBtnProduct(<%= rs.getString("products_slno") %>)">&nbsp&nbsp<input type="button" class="btn-danger" id="btnDeactive" name="btnDeactive" value="Deactive" onclick="fnDeActiveBtnProduct(<%= rs.getString("products_slno") %>)"></td>
      </tr>
    </tbody>
<%
	}
%>
  </table>
  <center><input type="button" class="btn-primary" onclick="window.open('ProductAdd.jsp','_self')" value="Go Back"/></center>
</div>

</form>
</body>
</html>