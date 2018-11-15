<%-- 
	@author						: kiran
 	@module name/description	: Forgot Password Page
 	@created date				: 21 Dec 2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
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
							<h3 align="center">Forgot Password</h3>
							<br>
							<label>Shoppy Id </label> <input	class="form-control input-sm chat-input" type="text" id="txtCustId" name="txtCustId" value=<%= request.getParameter("txtCustId") %> readonly="readonly" />
							<br> <label>New Password</label> <input	class="form-control input-sm chat-input" type="password" id="newCustPswd" name="newCustPswd"/>
							<br>
							<div class="wrapper" align="center">
								<input type="button" class="btn btn-success" id="btnCustChanagePswd" value="Change" onclick="fnCustChangePswd()" />
								<input type="reset" class="btn btn-danger" id="" value="Clear" />
								<input type="button" class="btn btn-link" id="" value="Go Back" onclick="window.location.href='../views/CustomerLogin.jsp'" />
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