<%-- 
	@author						: Kiran 
 	@module name/description	: Mobile Number Search
 	@created date				: 14-12-2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>
<%@page import="com.nviera.dao.DbConnection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scheme Search Sub</title>
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
	function fnName(grahakId, grahakName, mobileNumber,pointsEarned) {
		window.opener.userMobile.value = mobileNumber;
		window.opener.userGrahakId.value = grahakId;
		window.opener.userName.value = grahakName;
		window.opener.exiEarnPoints.value = pointsEarned;
		window.opener.userFoodItemsAmount.focus();
		self.close();
	}
</script>
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat;">
	<div align="center">
		<br>
		<img align="middle" height="150" width="150" alt="" src="../img/GrahakLogo.jpg">
	</div>
	<form name="mobileSearch" method="post">
		<h2 align="center"><font color="black">Mobile Search</font></h2>
		<input id="page_cmd" name="page_cmd" type="hidden" value="" />
		<table align="Center" border="2" cellpadding="2" class="table table-hover">
			<%
				String strQuery = "";
				String strMobileNumber = request.getParameter("MobileNumber");
				try {
					DbConnection db = new DbConnection();
					strQuery = "SELECT USER_DETAILS_GRAHAKID,USER_DETAILS_FULLNAME,USER_DETAILS_MOBILE,USER_DETAILS_EARNED_POINTS  FROM USER_DETAILS WHERE USER_DETAILS_MOBILE='"+strMobileNumber+"' ORDER BY 1 ";
					ResultSet rs = db.executeSelectQuery(strQuery);
					if (rs != null) {
			%>
			<thead>
				<tr class="danger">
					<th>Grahak Id</th>
					<th>Name</th>
					<th>Mobile Number</th>
					<!-- <th>Existing points</th> -->
				</tr>
			</thead>
			<%
				while (rs.next()) {
			%>
			<tbody>
				<tr class="success">
					<td><a href="javascript:fnName('<%=rs.getString("USER_DETAILS_GRAHAKID")%>','<%=rs.getString("USER_DETAILS_FULLNAME")%>','<%=rs.getString("USER_DETAILS_MOBILE")%>','<%=rs.getString("USER_DETAILS_EARNED_POINTS")%>') "><%=rs.getString("USER_DETAILS_GRAHAKID")%></a></td>
					<td><a href="javascript:fnName('<%=rs.getString("USER_DETAILS_GRAHAKID")%>','<%=rs.getString("USER_DETAILS_FULLNAME")%>','<%=rs.getString("USER_DETAILS_MOBILE")%>','<%=rs.getString("USER_DETAILS_EARNED_POINTS")%>')"><%=rs.getString("USER_DETAILS_FULLNAME")%></a></td>
					<td><a href="javascript:fnName('<%=rs.getString("USER_DETAILS_GRAHAKID")%>','<%=rs.getString("USER_DETAILS_FULLNAME")%>','<%=rs.getString("USER_DETAILS_MOBILE")%>','<%=rs.getString("USER_DETAILS_EARNED_POINTS")%>') "><%=rs.getString("USER_DETAILS_MOBILE")%></a></td>
					<%-- <td><a href="javascript:fnName('<%=rs.getString("USER_DETAILS_GRAHAKID")%>','<%=rs.getString("USER_DETAILS_FULLNAME")%>','<%=rs.getString("USER_DETAILS_MOBILE")%>','<%=rs.getString("USER_DETAILS_EARNED_POINTS")%>') "><%=rs.getString("USER_DETAILS_EARNED_POINTS")%></a></td> --%>
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