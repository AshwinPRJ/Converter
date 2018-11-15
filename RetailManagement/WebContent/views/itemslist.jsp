<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.nviera.dao.DbConnection"%>
<%
 DbConnection db = new DbConnection();   
 String sqlquery1 = "select * from shop_purchase_items "; 
 
  ResultSet rs =db.executeSelectQuery(sqlquery1);

System.out.println("sqlquery1" +sqlquery1);

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>
</head>
<body
	style="background-image: url('../img/Supermarket.jpg'); background-repeat: no-repeat;">
	<div align="center">
		<img align="middle" height="100" width="100" alt=""
			src="../img/GrahakLogo.jpg">
	</div>
	<h1 align="center">Item List</h1>

	<table class="table table-hover">
		<thead>
			<tr class="danger">
				<%
					DbConnection db1 = new DbConnection();
					String strShopOrderId = request.getParameter("shopOrderId");
					String itemListSelectQuery = ("select * from shop_purchase_items where shop_purchase_orders_id='"+strShopOrderId+"' ");
					System.out.println("itemListSelectQuery : "+itemListSelectQuery);
					ResultSet rs1 = db.executeSelectQuery(itemListSelectQuery);
				%>
				<th>Item_id</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
		</thead>
		<%
			    while (rs1.next()) {
			    %>
		<tr class="success">
			<td><%=rs1.getString("shop_purchase_orders_itemsid")%></td>
			<td><%=rs1.getString("shop_purchase_orders_itemsquantity")%></td>
			<td><%=rs1.getString("shop_purchase_orders_retailer_itemsprice")%></td>
		</tr>
		<%
} 
%>
	</table>
</body>
</html>
