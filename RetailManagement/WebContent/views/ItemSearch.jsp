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
<title>Item Search</title>
<script type="text/javascript" src="../js/angular.js"></script>
<script type="text/javascript" src="../js/angular.min.js"></script>
<script type="text/javascript" src="../js/angular-cookies.js"></script>
<script type="text/javascript" src="../js/angular-resource.js"></script>
<script type="text/javascript" src="../js/angular-route.js"></script>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../javaScript/FormFieldValidation.js"></script>
<script type="text/javascript" src="../javaScript/itemDetails.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript">
	function fnItemName(itemId, itemName,retailerMRP,warehouseMRP) {
		window.opener.addItemId.value=itemId;
		window.opener.addItemId.focus();
		window.opener.addItemName.value=itemName;
		window.opener.addItemName.focus();
		window.opener.addRetailermrp.value=retailerMRP;
		window.opener.addRetailermrp.focus();
		window.opener.addWarehousemrp.value=warehouseMRP;
		window.opener.addWarehousemrp.focus();
		self.close();
	}
</script>
</head>
<body>
	<div align="center">
		<br>
		<img align="middle" height="150" width="150" alt="" src="../img/GrahakLogo.jpg">
	</div>
	<form name="itemSearch" method="post">
		<h2 align="center"><font color="black">Item Search</font></h2>
		<input id="page_cmd" name="page_cmd" type="hidden" value="" />
		<table align="Center" border="2" cellpadding="2" class="table table-hover">
			<%
				/* String ItemId = session.getAttribute("ItemSessionId").toString(); */
				String strQuery;
		
				try {
					DbConnection db = new DbConnection();
					strQuery = "SELECT * FROM ITEMS_MASTER WHERE ITEMS_MASTER_STA='A'";
					ResultSet rs = db.executeSelectQuery(strQuery);
					if (rs != null) {
			%>
			<thead>
				<tr class="danger">
					<th>Item Id</th>
					<th>Item Name</th>
					<th>Retailer MRP</th>
					<th>Warehouse MRP</th>
					
				</tr>
			</thead>
			<%
				while (rs.next()) {
			%>
			<tbody>
				<tr class="success">
					<td><a href="javascript:fnItemName('<%=rs.getString("ITEMS_MASTER_ID")%>','<%=rs.getString("ITEMS_MASTER_NAME")%>','<%=rs.getString("ITEMS_MASTER_RETAILMRP")%>','<%=rs.getString("ITEMS_MASTER_WAREHOUSEMRP")%>') "><%=rs.getString("ITEMS_MASTER_ID")%></a></td>
					<td><a href="javascript:fnItemName('<%=rs.getString("ITEMS_MASTER_ID")%>','<%=rs.getString("ITEMS_MASTER_NAME")%>','<%=rs.getString("ITEMS_MASTER_RETAILMRP")%>','<%=rs.getString("ITEMS_MASTER_WAREHOUSEMRP")%>')"><%=rs.getString("ITEMS_MASTER_NAME")%></a></td>
					<td><a href="javascript:fnItemName('<%=rs.getString("ITEMS_MASTER_ID")%>','<%=rs.getString("ITEMS_MASTER_NAME")%>','<%=rs.getString("ITEMS_MASTER_RETAILMRP")%>','<%=rs.getString("ITEMS_MASTER_WAREHOUSEMRP")%>')"><%=rs.getString("ITEMS_MASTER_RETAILMRP")%></a></td>
					<td><a href="javascript:fnItemName('<%=rs.getString("ITEMS_MASTER_ID")%>','<%=rs.getString("ITEMS_MASTER_NAME")%>','<%=rs.getString("ITEMS_MASTER_RETAILMRP")%>','<%=rs.getString("ITEMS_MASTER_WAREHOUSEMRP")%>') "><%=rs.getString("ITEMS_MASTER_WAREHOUSEMRP")%></a></td>
					
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