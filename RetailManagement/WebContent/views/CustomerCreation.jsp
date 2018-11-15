<%-- 
	@author						: kiran
 	@module name/description	: Admin Login Page
 	@created date				: 05 oct 2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoppy Creation</title>
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
</head>
<%
int timeout = session.getMaxInactiveInterval();
response.setHeader("Refresh", timeout + "; URL = ../index.jsp");
%>
<body style="background-image: url('../img/Supermarket.jpg');  background-repeat: no-repeat; background-size: 100% 100%;">
	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6 col-sm-12">
				<div align="center">
					<br>
						<img align="middle" height="150" width="150" alt="" src="../img/GrahakLogo.jpg">
				</div>
				<br>
				<div id="loginModal">
					<div class="well">
					<label><span class="btn-warning">Login Shoppy : <%=session.getAttribute("AdminSessionId").toString()%></span></label>
					<label> <a href="../views/Logout.jsp"><button type="button" class="btn btn-default btn-sm" style="right: 10px;"><span class="glyphicon glyphicon-log-out"></span> Logout</button></a></label>
						<ul class="nav nav-tabs">
							<li class="active"><a href="#addAmt" data-toggle="tab">Add Wallet</a></li>
							<li><a href="#createCust" data-toggle="tab">Register Customer</a></li>
							<li><a href="#deleteCust" data-toggle="tab">Delete Customer</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active in" id="addAmt">
								<form class="form-horizontal" name="addCustWallet" id="addCustWallet">
									<fieldset>
										<h3 align="center">Add Wallet</h3>
										<label class="control-label" for="addCustId">Shoppy Id</label><input class="form-control input-sm chat-input" type="text" id="addCustId" name="addCustId" placeholder="Please Enter Shoppy Id" maxlength="30" onblur="fnCustValidation()"/>
										<br>
										<label class="control-label">Shoppy Name</label><input class="form-control input-sm chat-input" type="text" id="addCustName" name="addCustName" readonly="readonly"/>
										<br>
										<label class="control-label" for="addAmount">Amount</label><input class="form-control input-sm chat-input" type="text" id="addAmount" name="addAmount" maxlength="15" placeholder="Please Enter Amount" onkeyup="DecimalValidation(event)"/>
										<input type="hidden" id="addCustBalWalAmount" name="addCustBalWalAmount"/>
										<br>
										<div class="wrapper" align="center">
											<input type="button" class="btn btn-success" id="btAdd"	value="Add" onclick="addWallet()"/>
											<input type="reset" class="btn btn-danger" value="Clear"/>
										</div>
									</fieldset>
								</form>
							</div>
							<div class="tab-pane fade" id="createCust">
								<form class="form-horizontal" id="regCustomer" name="regCustomer">
										<h3 align="center">Customer Creation</h3>
										<label class="control-label" for="regCustname">Shoppy Name</label><input class="form-control input-xlarge chat-input" type="text" id="regCustname" name="regCustname" maxlength="30"	placeholder="Please Enter Customer Name" onKeyUp="CheckAlphabetonly(event)" />
										<br>
										<label class="control-label" for="regCustShopename">Shoppy Password</label><input class="form-control input-sm chat-input" type="password" id="regCustPswd" name="regCustPswd" maxlength="20"	placeholder="Please Enter Password" />
										<br>
										<label class="control-label" for="regCustShopename">Shop Name</label><input class="form-control input-sm chat-input" type="text" id="regCustShopename" name="regCustShopename" maxlength="30"	placeholder="Please Enter Customer Name" onKeyUp="CheckAlphabetonly(event)" />
										<br>
										<label class="control-label" for="regPlace">Shop Place</label><input class="form-control input-sm chat-input" type="text" id="regPlace" name="regPlace" placeholder="Please Enter Place" maxlength="30" onKeyUp="CheckAlphabetonly(event)"/>
										<br>
										<label class="control-label" for="regCity">Shop City</label><input class="form-control input-sm chat-input" type="text" id="regCity" name="regCity" placeholder="Please Enter City" maxlength="30" onKeyUp="CheckAlphabetonly(event)"/>
										<br>
										<label class="control-label" for="regWalletamt">Wallet Amount</label><input class="form-control input-sm chat-input" type="text" id="regWalletamt" name="regWalletamt" value="0" maxlength="13" onKeyUp="DecimalValidation(event)" />
										<br>
										<label class="control-label" for="regFood">Food Items</label><input class="form-control input-sm chat-input" type="text" id="regFood" name="regFood" value="0" maxlength="2" onKeyUp="NumberValidation(event)" />
										<br>
										<label class="control-label" for="regNonFood">Non Food Items</label><input class="form-control input-sm chat-input" type="text" id="regNonFood" name="regNonFood" value="0" maxlength="2" onKeyUp="NumberValidation(event)" />
										<br>
										<div class="wrapper" align="center">
											<input type="button" class="btn btn-success" id="btSave" value="Save" onclick="regCust()"/>
											<input type="reset" class="btn btn-danger" id="" value="Clear"/>
										</div>
								</form>
							</div>
							<div class="tab-pane fade" id="deleteCust">
								<form class="form-horizontal" id="delCustomer" name="delCustomer">
									<fieldset>
										<h3 align="center">Delete Shoppy</h3>
										<label class="control-label" for="delCustId">Shoppy Id</label><input class="form-control input-sm chat-input" type="text" id="delCustId" name="delCustId" placeholder="Please Enter Place" onblur="fnDelCustValid()"/>
										<br>
										<label class="control-label">Shoppy Name</label><input class="form-control input-sm chat-input" type="text" id="delCustName" name="delCustName" readonly="readonly"/>
										<br>
										<label class="control-label">Amount</label><input class="form-control input-sm chat-input" type="text" id="delAmount" name="delAmount" readonly="readonly"/>
										<br>
										<div class="wrapper" align="center">
											<input type="button" class="btn btn-success" id="btDel"	value="Delete" onclick="delCust()"/>
											<input type="reset" class="btn btn-danger" value="Clear"/>
										</div>
										<br>
									</fieldset>
								</form>
							</div>
							<input type="button" class="btn btn-link" id="" value="Edit Shoppy Details" onclick="window.open('../views/EditShoppyDetails.jsp','_self')" />
							<input type="button" class="btn btn-link" id="" value="Add Product" onclick="window.open('../views/ProductAdd.jsp','_self')" />
							<input type="button" class="btn btn-link" id="" value="Options Active/Deactive" onclick="window.open('../views/ActiveDeactive.jsp','_self')" />
							<input type="button" class="btn btn-link" id="" value="CustomerProductsActiveDeactive" onclick="window.open('../views/CustomerProductsActiveDeactive.jsp','_self')" />
							<input type="button" class="btn btn-link" id="" value="Shopy Wallet Report" onclick="window.open('../reports/RptCustomerWallet.jsp','_self')" />
							<input type="button" class="btn btn-link" id="" value="Total Users Transaction Report" onclick="window.open('../reports/RptTotalTransactions.jsp','_self')" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>