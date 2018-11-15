<%-- 
	@author						: kiran
 	@module name/description	: user Points Page
 	@created date				: 05 oct 2016
 	@modified by				: kiran
 	@modified date				: 18 oct 2016
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.nviera.dao.DbConnection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Points To User</title>
<script type="text/javascript" src="../js/angular.js"></script>
<script type="text/javascript" src="../js/angular.min.js"></script>
<script type="text/javascript" src="../js/angular-cookies.js"></script>
<script type="text/javascript" src="../js/angular-resource.js"></script>
<script type="text/javascript" src="../js/angular-route.js"></script>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../javaScript/FormFieldValidation.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript" src="../javaScript/userDetails.js"></script>
</head>
<%
int timeout = session.getMaxInactiveInterval();
response.setHeader("Refresh", timeout + "; URL = ../index.jsp");
%>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat; background-size: 100% 100%;">
	<form name="userPoints">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-4 col-md-4 col-sm-12">
				<div align="center">
					<br>
						<img align="middle" height="150" width="150" alt="" src="../img/GrahakLogo.jpg">
				</div>
				<br>
				<%
					String CustId = session.getAttribute("CustSessionId").toString();
					double CustWalletAmt = 0.00;
					DbConnection db = new DbConnection();
					String CustomerWalletSelectQuery = "SELECT CUSTOMER_DETAILS_WALLET_AMOUNT FROM CUSTOMER_DETAILS WHERE CUSTOMER_DETAILS_NAME = '"+CustId+"' ";
					ResultSet rs = db.executeSelectQuery(CustomerWalletSelectQuery);
					while(rs.next()){
						CustWalletAmt = Double.parseDouble(rs.getString("CUSTOMER_DETAILS_WALLET_AMOUNT"));
					}
				%>
				<div class="well">
				<label><span class="btn-warning">Login: <%=CustId%></span> 
				<span class="btn-danger" > Shoppy Wallet <%= CustWalletAmt %></span></label>
				<input type="hidden" id = "shoppeWallentAmount" name="shoppeWallentAmount" value=<%=CustWalletAmt%>>
				<label> <a href="../views/Logout.jsp"><button type="button" class="btn btn-default btn-sm" style="right: 10px;"><span class="glyphicon glyphicon-log-out"></span> Logout</button></a></label>
					<div>
						<h4 align="center">Add Points</h4>
						<label for="userTransNum">Enter Invoice Number</label>
						<input class="form-control input-sm chat-input" type="text" id="userTransNum" name="userTransNum" maxlength="10" placeholder="Enter Invoice Number" onKeyUp="NumberValidation(event)" onblur= "fnInvoiceNumberValidation()" />
						<br>
						<label for="userMobile">Enter Mobile</label>&nbsp&nbsp&nbsp <span class="glyphicon glyphicon-search" onclick="fnMobileSearch()" ></span>
						<input class="form-control input-sm chat-input" type="text" id="userMobile" name="userMobile" maxlength="10" placeholder="Enter Mobile Number" onblur="fnMobileValidation()" onKeyUp="NumberValidation(event)">
						<br>
						<label for="userGrahakId">Grahak Id</label>
						<input class="form-control input-sm chat-input" type="text" id="userGrahakId" name="userGrahakId" maxlength="10"  onblur="fnGrahakDetails()" />
						<br>
						<label for="userName">User Name</label>
						<input class="form-control input-sm chat-input" type="text" id="userName" name="userName" readonly="readonly" />
						<input class="form-control input-sm chat-input" type="hidden" id="exiEarnPoints" name="exiEarnPoints" readonly="readonly"/>
						<br>
						<%
							String changeProStatus = session.getAttribute("CustChangeProductSessionId").toString();
							if("Y".equalsIgnoreCase(changeProStatus)){
						%>
								<label for="productName">Products Search</label>&nbsp&nbsp&nbsp <span class="glyphicon glyphicon-search" onclick="fnProductSearch()"></span>
								<input class="form-control input-sm chat-input" type="text" id="productName" name="productName" value="0" readonly="readonly"/>
								<br>
						<%
							} else{
						%>
								<input class="form-control input-sm chat-input" type="hidden" id="productName" name="productName" value="0" readonly="readonly"/>
						<%
							}
						%>
						<label for="userFoodItemsAmount">Food items Amount Purchased</label>
						<input class="form-control input-sm chat-input" type="text" id="userFoodItemsAmount" name="userFoodItemsAmount" value="0.00" onblur="fnCalcPoints()" onkeyup="DecimalValidation(event)"/>
						<br>
						<label for="userNonFoodItemsAmount">Non Food Items Amount Purchased</label>
						<input class="form-control input-sm chat-input" type="text" id="userNonFoodItemsAmount" name="userNonFoodItemsAmount" value="0.00" onblur="fnCalcPoints()" onkeyup="DecimalValidation(event)"/>
						<br>
						<label for="userAmount">Total Amount Purchased</label>
						<input class="form-control input-sm chat-input" type="text" id="userTotAmount" name="userTotAmount" readonly="readonly"/>
						<br>
						<label for="userTotalPointsEarn">Total Points Earned </label>
						<input class="form-control input-sm chat-input" type="text" id="userTotalPointsEarn" name="userTotalPointsEarn" readonly="readonly"/>
						<br>
						<div id="hideVariables" style="display: none;">
							<input class="form-control input-sm chat-input" type="hidden" id="custWalletAmount" name="custWalletAmount" value="<%=session.getAttribute("CustWalletSessionId").toString()%>" readonly="readonly"/>
							<input class="form-control input-sm chat-input" type="hidden" id="FoodItemsPercentage" name="FoodItemsPercentage" value="<%=session.getAttribute("CustFoodItemsPerSessionId").toString()%>" readonly="readonly"/>
							<input class="form-control input-sm chat-input" type="hidden" id="NonFoodItemsPercentage" name="NonFoodItemsPercentage" value="<%=session.getAttribute("CustNonFoodItemsPerSessionId").toString()%>" readonly="readonly"/>
							<input class="form-control input-sm chat-input" type="hidden" id="productId" name="productId" readonly="readonly" value = "0"/>
							<input class="form-control input-sm chat-input" type="hidden" id="productQuantity" name="productQuantity" readonly="readonly" value = "0"/>
						</div>
						<div class="wrapper" align="center">
							<input type="button" class="btn btn-success" id="btsubmit" value="Submit" onclick="fnSubmit()"/>
							<input type="reset" class="btn btn-danger" id="" value="Clear"/>
							<%
								String changeStatus =   session.getAttribute("CustChangePercentageSessionId").toString();
								if("Y".equalsIgnoreCase(changeStatus)){
							%>
									<input type="button" class="btn btn-warning" id="" value="Change %" onclick="window.open('./ChangeItemsPercentageValues.jsp','_self')" />
							<%
								}
							%>
							<input type="button" class="btn btn-link" id="" value="Shoppy Wallet Report" onclick="window.open('../reports/RptCustomerWalletTransaction.jsp','_self')" />
							<input type="button" class="btn btn-link" id="" value="Users Transaction Report" onclick="window.open('../reports/RptUserTransaction.jsp','_self')" />
						</div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>