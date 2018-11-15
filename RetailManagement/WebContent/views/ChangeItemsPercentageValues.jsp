<%-- 
	@author						: Kiran 
 	@module name/description	: Change Customer Percentages View Page
 	@created date				: 26-12-2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>
<%@page import="com.nviera.dao.DbConnection"%>
<%@page import="com.nviera.constants.QueryConstants"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Items Percentage Values</title>
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
	function fnCustChangePercentages(){
		var foodItemsPer		=	document.getElementById("newFoodItemsPer").value;
		var nonFoodItemsPer		=	document.getElementById("newNonFoodItemsPer").value;
		
		if(document.getElementById("newFoodItemsPer").value == "" || document.getElementById("newFoodItemsPer").value == null){
			alert("Please enter Food Items Percentage");
			document.getElementById("newFoodItemsPer").focus();
			return;
		}else if(document.getElementById("newNonFoodItemsPer").value == "" || document.getElementById("newNonFoodItemsPer").value == null){
			alert("Please enter Non Food Items Percentage");
			document.getElementById("newNonFoodItemsPer").focus();
			return;
		}else{
			document.custPerChange.method = "post";
			document.custPerChange.action = "./ChangeItemsPercentageValuesSave.jsp?page_cmd=custChangeItemsPercentage";
			document.custPerChange.submit();
		}
	}
</script>
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat; background-size: 100% 100%;">
<div class="container">
	<form name="custPerChange">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-4 col-md-3 col-sm-12">
					<div align="center">
						<br>
						<img align="middle" height="150" width="150" alt="" src="../img/GrahakLogo.jpg">
					</div>
					<br>
					<div class="well">
						<div>
							<h3 align="center">Change Items Percentages</h3>
							<br>
							<%
								String CustId = session.getAttribute("CustSessionId").toString();
								String foodItems = "";
								String nonFoodItems = "";
								DbConnection db = new DbConnection();
								String strSql = QueryConstants.SELECT_CUSTOMER_DETAILS + " AND CUSTOMER_DETAILS_NAME = '"+CustId+"'";
								ResultSet rs = db.executeSelectQuery(strSql);
								while (rs.next()){
									foodItems = rs.getString("CUSTOMER_DETAILS_FOODITEMS");
									nonFoodItems = rs.getString("CUSTOMER_DETAILS_NONFOODITEMS");
								}
							
							%>
							<label>Customer Id </label> <input	class="form-control input-sm chat-input" type="text" id="txtCustId" name="txtCustId" value=<%=session.getAttribute("CustSessionId").toString()%> readonly="readonly" />
							<br> <label>Food Items</label> <input	class="form-control input-sm chat-input" type="text" id="newFoodItemsPer" name="newFoodItemsPer" value="<%= foodItems %>" maxlength="2" onkeyup="NumberValidation(event)"/>
							<br> <label>Non Food Items</label> <input	class="form-control input-sm chat-input" type="text" id="newNonFoodItemsPer" name="newNonFoodItemsPer" value="<%= nonFoodItems %>" maxlength="2" onkeyup="NumberValidation(event)"/>
							<br>
							<div class="wrapper" align="center">
								<input type="button" class="btn btn-success" id="btnPerChange" value="Change" onclick="fnCustChangePercentages()" />
								<input type="button" class="btn btn-link" id="" value="Go Back" onclick="window.location.href='../views/UserPoints.jsp'" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	</div>
</body>
</html>