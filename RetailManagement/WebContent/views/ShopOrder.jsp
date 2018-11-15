<%-- 
	@author						: kiran
 	@module name/description	: Admin Login Page
 	@created date				: 05 oct 2016
 	@modified by				: kiran
 	@modified date				: 05 oct 2016
 --%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.nviera.dao.DbConnection"%>
<%@page import="com.nviera.constants.QueryConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
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
<script type="text/javascript"
	src="../javaScript/FormFieldValidation.js"></script>
	<script type="text/javascript">
	$(function() {
		$('input:text:first').focus();
		var $inp = $('input:text');
		$inp.bind('keydown', function(e) {
			//var key = (e.keyCode ? e.keyCode : e.charCode);
			var key = e.which;
			if (key == 13) {
				e.preventDefault();
				var nxtIdx = $inp.index(this) + 1;
				$(":input:text:eq(" + nxtIdx + ")").focus();
			}
		});
	});
</script>
<script type="text/javascript" src="../javaScript/shopOrder.js"></script>

</head>
<%
String strShoppyId = session.getAttribute("CustSessionId").toString();

%>
<body>
	<form name="addItem" method="post">
		<div>
			<img align="right" height="200" width="200" alt="" src="../img/GrahakLogo.jpg"><br> 
			<label>Date of Purchase:</label>
			<script>
				var today = new Date();
				var dd = today.getDate();
				var mm = today.getMonth() + 1; //January is 0!
				var yyyy = today.getFullYear();

				if (dd < 10) {
					dd = '0' + dd
				}

				if (mm < 10) {
					mm = '0' + mm
				}

				today = mm + '/' + dd + '/' + yyyy;
				document.write(today);
			</script>


			<script language="javascript" id="time">
				var today = new Date();
				document.getElementById('time').innerHTML = today;
			</script>
		</div>
		<div class="container">

			<div class="row">
				<div class="col-md-offset-4 col-md-5 col-sm-12">
					<div align="center">
						<br>
					</div>
					<br>
					<div class="well">
						<label><span class="btn-warning">Login: <%=strShoppyId%></span></label>
						<div>
							<h3 align="center">Shop Order</h3>

							<br> <br> <label>Retailer Id</label><br> <select
								id="retailerName" name="retailerName">
								<option value="" selected="selected" disabled="disabled">Please
									Select Retailer</option>
								<%
									DbConnection db = new DbConnection();
									String retailerListSelectQuery = ("SELECT RETAILERS_MASTER_NAME,RETAILERS_MASTER_ID FROM RETAILERS_MASTER");
									ResultSet rs = db.executeSelectQuery(retailerListSelectQuery);
									while (rs.next()) {
								%>
								<option value="<%=rs.getString("RETAILERS_MASTER_ID")%>"><%=rs.getString("RETAILERS_MASTER_NAME")%></option>
								<%
									}
								%>
							</select> <br>  <label>Items List </label> <span
								class="glyphicon glyphicon-search" onclick="fnItemSearch()"></span><br>

							<input class="form-control input-sm chat-input" type="text"	id="addItemId" name="addItemId"	placeholder="Please Enter Item Id" maxlength="30" onblur="fnShopItemValidation()" onkeyup="NumberValidation()" />

							<br> <label class="control-label">Item Name</label>
							<input class="form-control input-sm chat-input" type="text" id="addItemName" name="addItemName" readonly="readonly" /> <br>

							<label class="control-label" for="addRetailermrp">Price</label>
							<input class="form-control input-sm chat-input" type="text"	id="addRetailermrp" name="addRetailermrp" maxlength="15" onkeyup="DecimalValidation()" readonly="readonly" /><br> 
						
							<!-- <label class="control-label" for="addWarehousemrp">WarehousePrice</label>  -->
							<input class="form-control input-sm chat-input" type="hidden"	id="addWarehousemrp" name="addWarehousemrp"  />
								<br> <label>Quantity</label>
							<input class="form-control input-sm chat-input" type="text"	id="txtQuantity" name="txtQuantity" maxlength="13" placeholder="Please Enter Quantity"	onblur="fnTotPriValidation()" onkeyup="NumberValidation()" />
							<br> <label>Individual Item Price</label> 
							<input class="form-control input-sm chat-input" type="text"	id="txtPrice" name="txtPrice" maxlength="13" placeholder="Please Enter Price" readonly="readonly" /> <br>
							
							<input class="form-control input-sm chat-input" type="hidden"	id="txtWarehousePrice" name="txtWarehousePrice"/> <br>
							<label>Expected date</label> <br> <input type="text" id="txtDate1" name="txtDate1" readonly="readonly"	placeholder="Please Enter Expected Date" /> 
							<a	href="javaScript:CalnderWidnow('1')" title="Calendar"> 
							<span class=bankaddress><img src="../img/calnder.gif" width="17" height="20" class="textBox"></span></a><br> <label>Remarks</label>
							<br> <input class="form-control input-sm chat-input" type="text" name="txtRemarks" id="txtRemarks" maxlength="13" placeholder="please Enter any remarks"><br> <br>

							<div class="wrapper" align="center">
								<input type="button" class="btn btn-success" id="btnAdd" value="Add" onclick=" fnitemValidation()" /> 
									<input type="button" class="btn btn-success" id="btnSave" value="Save" onclick="itemSaving()" />
									 <input type="reset" class="btn btn-danger" id="" value="Clear" />
							</div>
						</div>
						<br>
						<div class="well">
							<label>Total Items Price</label> <input	class="form-control input-sm chat-input" type="text" id="txtTotPrice" name="txtTotPrice" maxlength="13"
								 readonly="readonly" /> <br>
								<label>Total Items Price</label> <input	class="form-control input-sm chat-input" type="hidden" id="txtTotWarehousePrice" name="txtTotWarehousePrice" maxlength="13"
								placeholder="Please Enter Price" readonly="readonly" /> <br>
						</div>
					</div>
				</div>
			</div>
		</div>


		
<table id="Table" width="70%" border="1" cellpadding="0" cellspacing="6">
				<tr>
					<td class="TableHeaderRow" align="center">ITem Id</td>
					<td class="TableHeaderRow" align="center">name</td>
					<td class="TableHeaderRow" align="center">Quantity</td>
					<td class="TableHeaderRow" align="center">Price</td>
					
				</tr>
				<tr>
				<td><input type="hidden" name="hidCharRow" value="1"></td>
				</tr>
				</tr>
		</table>
	</form>
</body>
</html>