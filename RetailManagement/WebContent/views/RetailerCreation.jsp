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
<title>Retailer Creation</title>
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
</head>
<%
int timeout = session.getMaxInactiveInterval();
response.setHeader("Refresh", timeout + "; URL = ../index.jsp");
%>
<body>
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
					<%-- <label><span class="btn-warning">Login Shoppy : <%=session.getAttribute("AdminSessionId").toString()%></span></label> --%>
					<label> <a href="../views/Logout.jsp"><button type="button" class="btn btn-default btn-sm" style="right: 10px;"><span class="glyphicon glyphicon-log-out"></span> Logout</button></a></label>
						<ul class="nav nav-tabs">
							
					
					
							<li class="active"><a href="#regRetailer" data-toggle="tab">Retailer Registration</a></li>
							<li ><a href="#modifyRetailer" data-toggle="tab">Modify Retailer</a></li>
							<li><a href="#deleteRetailer" data-toggle="tab">Delete Retailer</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade" id="modifyRetailer">
								<form class="form-horizontal" name="addNewRetailer" id="addNewRetailer">
									<fieldset>
										<h3 align="center">Modify Retailer</h3>
										<label class="control-label" for="addNewRetailer">Id</label><span class="glyphicon glyphicon-search" onclick="fnRetailerSearch()"></span><input class="form-control input-sm chat-input" type="text" id="addRetailerId" name="addRetailerId" placeholder="Please Enter Retailer Id" maxlength="10" onblur="fnRetailerValidation()" onkeyup="NumberValidation()"/>
										<br>
										<label class="control-label">Name</label><input class="form-control input-sm chat-input" type="text" id="addRetailerName" name="addRetailerName"placeholder="Please Enter Retailer Name"  />
										<br>
										<label class="control-label">Address</label><input class="form-control input-sm chat-input" type="text" id="addRetailerAddress" name="addRetailerAddress"placeholder="Please Enter Address"/>
										<input type="hidden" id="addNewRetailer" name="addNewRetailer"/>
										<input type="hidden" id="addNewRetailer1" name="addNewRetailer1"/>
										<br>
										<div class="wrapper" align="center">
											<input type="button" class="btn btn-success" id="btnSubmit"	value="Submit" onclick="modifyRetailer()"/>
											<input type="reset" class="btn btn-danger" value="Clear"/>
										</div>
									</fieldset>
								</form>
							</div>
							<div class="tab-pane active in"  id="regRetailer">
								<form class="form-horizontal" id="regRetailer" name="regRetailer">
										<h3 align="center">Retailer Registration</h3>
										<label class="control-label" for="regRetailerId">Retailer Name</label><input class="form-control input-xlarge chat-input" type="text" id="regRetailerId" name="regRetailerId" maxlength="30"	placeholder="Please Enter Retailer Name" onKeyUp="CheckAlphabetonly(event)" />
										<br>
										<label class="control-label" for="regRetailerpswd">Retailer Password</label><input class="form-control input-sm chat-input" type="password" id="regRetailerPswd" name="regRetailerPswd" maxlength="20"	placeholder="Please Enter Password" />
										<br>
										<label class="control-label" for="regRetailerAddress">Address</label><input class="form-control input-sm chat-input" type="text" id="regRetailerAddress" name="regRetailerAddress" maxlength="30"	placeholder="Please Enter Address" onKeyUp="CheckAlphabetonly(event)" />
										<br>
										<div class="wrapper" align="center">
											<input type="button" class="btn btn-success" id="btSave" value="Save" onclick="regRetailer1()"/>
											<input type="reset" class="btn btn-danger" id="" value="Clear"/>
										</div>
								</form>
							</div>
							
							<div class="tab-pane fade" id="deleteRetailer">
								<form class="form-horizontal" id="delRetailer1" name="delRetailer1">
									<fieldset>
										<h3 align="center">Delete Retailer</h3>
										<label class="control-label" for="delRetailerId">Id</label><span class="glyphicon glyphicon-search" onclick="fnRetailerDelSearch()"></span>
							<input class="form-control input-sm chat-input" type="text" id="delRetailerId" name="delRetailerId" placeholder="Please Enter Retailer Id " onblur="fnDelRetailerValid()" onKeyUp="NumberValidation(event)"/>
										
										<br>
										<label class="control-label">Name</label><input class="form-control input-sm chat-input" type="text" id="delRetailerName" name="delRetailerName"placeholder="Please Enter Retailer Name"/>
										<br>
										<div class="wrapper" align="center">
											<input type="button" class="btn btn-success" id="btDel"	value="Delete" onclick="delRetailer()"/>
											<input type="reset" class="btn btn-danger" value="Clear"/>
										</div>
										<br>
									</fieldset>
								</form>
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>