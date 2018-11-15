<%-- 
	@author						: kiran
 	@module name/description	: Customer List to Active & Deactive Products 
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
<title>Customer Product List</title>
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
	function fnCustActiveBtnProduct(id,shoppyName,quantity) {
		document.custActDAct.method = "post";
		document.custActDAct.action = "../views/ProductAddSave.jsp?page_cmd=custActivePro&custActProId="+id+"&shoppyName="+shoppyName+"&quantity="+quantity;
		document.custActDAct.submit();
	}
	
	function fnCustDeActiveBtnProduct(id,shoppyName,quantity) {
		document.custActDAct.method = "post";
		document.custActDAct.action = "../views/ProductAddSave.jsp?page_cmd=custDeactivePro&custDeActProId="+id+"&shoppyName="+shoppyName+"&quantity="+quantity;
		document.custActDAct.submit();
	}
	
	function fnShowDetails() {
		var shoppyId = document.getElementById("selShoppy").value;
		if(shoppyId == ""){
			alert("Please select Shoppy Name...");
			document.getElementById("selShoppy").focus();
			return;
		} else{
			document.custActDAct.method= "post";
			document.custActDAct.action = "CustomerProductsActiveDeactive.jsp?page_cmd=show_details&shoppyId="+shoppyId;
			document.custActDAct.submit();
		}
	}
	
</script>
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat;">
<form name="custActDAct">
<h2 align="center"><font color="black">Individual Customers Product List</font></h2>
<div class="container col-sm-12 ">
	<center><strong style="color: black; font-size: 20px;" >Please Select Shoppy User</strong>     
		<select id="selShoppy" name="selShoppy">
		<option value="" selected="selected" disabled="disabled" >Please Select Shoppy</option>
	<%
  		DbConnection db = new DbConnection();
  		String custUsersList = ("SELECT CUSTOMER_DETAILS_NAME FROM CUSTOMER_DETAILS where CUSTOMER_DETAILS_sta='A'");
  		ResultSet rs = db.executeSelectQuery(custUsersList);
  		while (rs.next()){
  	%>
  		
  		<option value="<%= rs.getString("CUSTOMER_DETAILS_NAME") %>"><%= rs.getString("CUSTOMER_DETAILS_NAME") %></option>
  	<%
  		}
  
  %>
  	</select>
  </center>
  <br>
  <center>
	  <input type="button" class="btn-primary" value="Show Details" onclick="fnShowDetails()"/>&nbsp&nbsp&nbsp
	  <input type="button" class="btn-primary" onclick="window.open('CustomerCreation.jsp','_self')" value="Go Back"/></center>
  <br>
  <%
  	String page_cmd = request.getParameter("page_cmd");
  	String strShoppyId = request.getParameter("shoppyId");
  	if("show_details".equalsIgnoreCase(page_cmd)){
  %>
  <table class="table table-hover">
    <thead>
      <tr class="danger">
        <th>Id</th>
        <th>Shoppy Name</th>
        <th>Product Name</th>
        <th>Product MRP</th>
        <th>Product GP Price</th>
        <th>Product Points</th>
        <th>Status</th>
        <th>Quantity</th>
        <th>Product Active/Deactive</th>
      </tr>
    </thead>
<%
	String productListSelectQuery= "SELECT * FROM CUSTPRODUCTS,PRODUCTS WHERE CUSTPRODUCTS_PRODUCTID = PRODUCTS_SLNO AND CUSTPRODUCTS_CUSTNAME='"+strShoppyId+"' ORDER BY 1";
	ResultSet rs1= db.executeSelectQuery(productListSelectQuery);
	while (rs1.next()) {
%>
    <tbody>
      <tr class="success">
        <!-- <td><input type="checkbox"></td> -->
        <td><%= rs1.getString("CUSTPRODUCTS_PRODUCTID") %></td>
        <td><%= rs1.getString("CUSTPRODUCTS_CUSTNAME") %></td>
		<td><%= rs1.getString("PRODUCTS_NAME") %></td>
        <td><%= rs1.getString("PRODUCTS_MRP") %></td>
        <td><%= rs1.getString("PRODUCTS_GPPRICE") %></td>
        <td><%= rs1.getString("PRODUCTS_POINTS") %></td>
 		<td><%= rs1.getString("CUSTPRODUCTS_STA") %></td>
 		<td><input type="text" id="<%= rs1.getString("CUSTPRODUCTS_PRODUCTID") %>" name="<%= rs1.getString("CUSTPRODUCTS_PRODUCTID") %>" value = "<%=rs1.getString("CUSTPRODUCTS_QUANTITY") %>" size="10" maxlength="3" onKeyUp="NumberValidation(event)"></td>
        <td><input type="button" class="btn-success" id="btnActive" name="btnActive" value="Active" onclick="fnCustActiveBtnProduct('<%= rs1.getString("CUSTPRODUCTS_PRODUCTID")%>','<%= rs1.getString("CUSTPRODUCTS_CUSTNAME")%>',document.getElementById('<%= rs1.getString("CUSTPRODUCTS_PRODUCTID") %>').value)">&nbsp&nbsp<input type="button" class="btn-danger" id="btnDeactive" name="btnDeactive" value="Deactive" onclick="fnCustDeActiveBtnProduct('<%= rs1.getString("CUSTPRODUCTS_PRODUCTID")%>','<%= rs1.getString("CUSTPRODUCTS_CUSTNAME")%>',document.getElementById('<%= rs1.getString("CUSTPRODUCTS_PRODUCTID") %>').value)"></td>
      </tr>
    </tbody>
<%
	}
%>
  </table>
<%
}
%>
</div>

</form>
</body>
</html>