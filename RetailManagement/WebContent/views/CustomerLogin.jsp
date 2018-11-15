<%-- 
	@author						: kiran
 	@module name/description	: Admin Login Page
 	@created date				: 17 oct 2016
 	@modified by				: kiran
 	@modified date				: 17 oct 2016
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoppy Login Page</title>
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
<script type="text/javascript" src="../javaScript/custLogin.js"></script>
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat;">
	<div class="container">
		<form name="custLogin">
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
								<h3 align="center">Shoppy Login</h3>
								<br>
								<label>Shoppy Id </label> <input	class="form-control input-sm chat-input" type="text" id="txtCustId" name="txtCustId" maxlength="30"	placeholder="Please Enter CustomerId" onblur="fnCustCheck()" />
								<br> <label>Password</label> <input	class="form-control input-sm chat-input" type="password" id="custPswd" name="custPswd" placeholder="Please Enter the Password" maxlength="20" />
								<br>
								<div class="wrapper" align="center">
									<input type="button" class="btn btn-success" id="btnCustLogin" value="Login" onclick="fnCustLoginOnClick()" />
									<input type="reset" class="btn btn-danger" id="" value="Clear" />
									<input type="button" class="btn btn-link" id="" value="Home" onclick="window.location.href='../index.jsp'" />
									<input type="button" class="btn btn-link" id="" value="Forgot Password" onclick="fnForgotPswd()" />
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