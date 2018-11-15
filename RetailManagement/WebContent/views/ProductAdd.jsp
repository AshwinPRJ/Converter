<%-- 
	@author						: kiran
 	@module name/description	: Admin Login Page
 	@created date				: 05 oct 2016
 	@modified by				: kiran
 	@modified date				: 05 oct 2016
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<title>Add Products</title>
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
<script type="text/javascript" src="../javaScript/FormFieldValidation.js"></script>
<script type="text/javascript" src="../javaScript/productValidaitons.js"></script>
</head>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat;">
	<form name="addProduct">
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
							<h3 align="center">Add Products</h3>
							<br>
							<label>Product Name</label> <input class="form-control input-sm chat-input" type="text" id="txtProductName" name="txtProductName" maxlength="50" placeholder="Please Enter Product Name" onKeyUp="CheckAlphabetonly(event)"/>
							<br> <label>Product MRP</label> <input	class="form-control input-sm chat-input" type="text" id="txtMRP" name="txtMRP" maxlength="13" placeholder="Please Enter MRP" onkeyup="DecimalValidation(event)"/>
							<br> <label>GP Price</label> <input	class="form-control input-sm chat-input" type="text" id="txtGPPrice" name="txtGPPrice" maxlength="13" placeholder="Please Enter GP Price" onkeyup="DecimalValidation(event)"/>
							<br> <label>Points</label> <input	class="form-control input-sm chat-input" type="text" id="txtPoints" name="txtPoints" maxlength="20" placeholder="Please Enter Points" onKeyUp="NumberValidation(event)"/>
							<br>
							<div class="wrapper" align="center">
								<input type="button" class="btn btn-success" id="btnAdd" value="Add" onclick="fnAddProductOnClick()" />
								<input type="reset" class="btn btn-danger" id="" value="Clear" />
								<input type="button" class="btn btn-link" id="btnAdd" value="Product Active/DeActive" onclick="window.location.href='ProductActiveDeactive.jsp'" />
								<input type="button" class="btn btn-link" id="" value="Go Back" onclick="window.location.href='CustomerCreation.jsp'" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>