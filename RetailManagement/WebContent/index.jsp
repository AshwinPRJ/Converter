<%-- 
	@author						: kiran
 	@module name/description	: Home Page
 	@created date				: 05 oct 2016
 	@modified by				: kiran
 	@modified date				: 18 oct 2016
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<script type="text/javascript" src="js/angular.js"></script>
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/angular-cookies.js"></script>
<script type="text/javascript" src="js/angular-resource.js"></script>
<script type="text/javascript" src="js/angular-route.js"></script>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="javaScript/FormFieldValidation.js"></script>
<script type="text/javascript" src="javaScript/customerDetails.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body style="background-image: url('img/Supermarket.jpg');  background-repeat: no-repeat;">
<div align="center">
	<br>
	<img align="middle" height="150" width="150" alt="" src="img/GrahakLogo.jpg">
</div>
<div class="container" align="center">
  <ul class="pagination">
    <li class="active"><a href="">Home</a></li>
    <li class ="btn btn-link"><a href="views/AdminLogin.jsp">Admin Login</a></li>
    <li><a href="views/CustomerLogin.jsp">Shopy Login</a></li>
    <li><a href="views/ProductListDisplay.jsp">Product List</a></li>
    <!-- <li><a href="reports/RptUserTransaction.jsp">Users Transaction Report</a></li> -->
  </ul>
</div>
</body>
</html>