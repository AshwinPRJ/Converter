<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.nviera.dao.DbConnection"%> 
<%
 DbConnection db = new DbConnection();
String strRetailid=session.getAttribute("RetailSessionId").toString();
 String sqlquery1 = "select * from shop_purchase_orders where shop_purchase_orders_retailerid = '"+strRetailid+"' "; 
 
  ResultSet rs =db.executeSelectQuery(sqlquery1);

System.out.println("sqlquery1 : " +sqlquery1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail orders</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<script type="text/javascript" src="../javaScript/retailerDetails.js"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>
</head>
<%
int timeout = session.getMaxInactiveInterval();
response.setHeader("Refresh", timeout + "; URL = ../index.jsp");

%>
<body>
<div class="container">
<div align="center">
<img align="middle" height="100" width="100" alt="" src="../img/GrahakLogo.jpg"></div>
<h1 align="center" >Retailer Order Details</h1>
<label> <a href="../views/RetailLogin.jsp"><button type="button" class="btn btn-default btn-sm" style="right: 10px;"><span class="glyphicon glyphicon-log-out"></span> Logout</button></a></label>
<label><span class="btn-warning">Retailer ID : <%=session.getAttribute("RetailSessionId").toString()%>
</span><br>
<span class="btn-warning">Retailer Name: <%=session.getAttribute("RetailSessionName").toString()%></span></label>
<table class="table table-hover">
<thead>
<tr class="danger">

				<th>ID</th>
				<th>ShoppyId</th>
				<th>TotalPrice</th>
				<th>Expected date</th>
				<th>Remarks</th>
				<th>Status</th>
				 </tr></thead>
				<%
				while (rs.next()) {
				%>
				<tr class="success">
			    <td><%=rs.getString("shop_purchase_orders_id")%></td>
			    <td><%=rs.getString("shop_purchase_orders_shoppyid")%></td>
			    <td><%=rs.getString("shop_purchase_orders_retailer_totalprice")%></td>
			    <td><%=rs.getString("shop_purchase_orders_expecteddate")%></td>
			    <td><%=rs.getString("shop_purchase_orders_remarks")%></td>
			    <td><%=rs.getString("shop_purchase_orders_sta")%></td>
				<td><input type="button" class="btn-success" id="btnActive" name="btnActive" value="items list" onclick="fnItemDetails('<%=rs.getString("shop_purchase_orders_shoppyid")%>')"></td>
			   </tr></div>
<%
} 
%>

</table>
</body>
</html>				