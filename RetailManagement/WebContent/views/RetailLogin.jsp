<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<title>Retail Login Page</title>
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
<script type="text/javascript" src="../javaScript/retailLogin.js"></script>
<script type="text/javascript" src="../javaScript/FormFieldValidation.js"></script>
<script type="text/javascript" src="../javaScript/customerDetails.js"></script> 
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat;">
	<form name="retailLogin">
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
							<h3 align="center">Retail Login</h3>
							<br>
							<label>User name</label> <input class="form-control input-sm chat-input" type="text" id="txtRetailId" name="txtRetailId" maxlength="20" placeholder="Please Enter Username" onblur="fnRetailCheck()" autofocus />
							<br> <label>Password</label> <input	class="form-control input-sm chat-input" type="password" id="retailPswd" name="retailPswd" maxlength="20" placeholder="Please Enter the Password" />
							<br>
							<div class="wrapper" align="center">
								<input type="button" class="btn btn-success" id="btnRetailLogin" value="Login" onclick="fnRetailLoginOnClick()" />
								<input type="reset" class="btn btn-danger" id="" value="Clear" />
								<input type="button" class="btn btn-link" id="" value="Home" onclick="window.location.href='../index.jsp'" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>