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
<script type="text/javascript" src="../javaScript/retailerDetails.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript">
	
	function fnRetailerSearch(retailerId, retailerName,retailerAddress){
		window.opener.addRetailerId.value=retailerId;
		window.opener.addRetailerId.focus();
		window.opener.addRetailerName.value=retailerName;
		window.opener.addRetailerName.focus();
		window.opener.addRetailerAddress.value=retailerAddress;
		window.opener.addRetailerAddress.focus();
		
		self.close();	
	} 
</script>
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat;">
	<div align="center">
		<br>
		<img align="middle" height="150" width="150" alt="" src="../img/GrahakLogo.jpg">
	</div>
	<form name="retailerSearch" method="post">
		<h2 align="center"><font color="black">Retailer Search</font></h2>
		<input id="page_cmd" name="page_cmd" type="hidden" value="" />
		<table align="Center" border="2" cellpadding="2" class="table table-hover">
			<%
				/* String ItemId = session.getAttribute("ItemSessionId").toString(); */
				String strQuery;
		
				try {
					DbConnection db = new DbConnection();
					strQuery = "SELECT * FROM RETAILERS_MASTER WHERE RETAILERS_MASTER_STA='A'";
					ResultSet rs = db.executeSelectQuery(strQuery);
					if (rs != null) {
			%>
			<thead>
				<tr class="danger">
					<th>Retailer Id</th>
					<th>Retailer Name</th>
					<th>Retailer Address</th>
					
					
					
				</tr>
			</thead>
			<%
				while (rs.next()) {
			%>
			<tbody>
				<tr class="success">
					<td><a href="javascript:fnRetailerSearch('<%=rs.getString("RETAILERS_MASTER_ID")%>','<%=rs.getString("RETAILERS_MASTER_NAME")%>','<%=rs.getString("RETAILERS_MASTER_DESCRIPTION")%>') "><%=rs.getString("RETAILERS_MASTER_ID")%></a></td>
					<td><a href="javascript:fnRetailerSearch('<%=rs.getString("RETAILERS_MASTER_ID")%>','<%=rs.getString("RETAILERS_MASTER_NAME")%>','<%=rs.getString("RETAILERS_MASTER_DESCRIPTION")%>')"><%=rs.getString("RETAILERS_MASTER_NAME")%></a></td>
					<td><a href="javascript:fnRetailerSearch('<%=rs.getString("RETAILERS_MASTER_ID")%>','<%=rs.getString("RETAILERS_MASTER_NAME")%>','<%=rs.getString("RETAILERS_MASTER_DESCRIPTION")%>')"><%=rs.getString("RETAILERS_MASTER_DESCRIPTION")%></a></td>
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