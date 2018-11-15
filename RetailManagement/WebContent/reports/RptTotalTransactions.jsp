<%-- 
	@author						: kiran
 	@module name/description	: All Users Transaction Report Page
 	@created date				: 20 Feb 2017
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total Users Transaction Report</title>
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
<script type="text/javascript">
	function showGeneratedUserReport(){
		var fromdate = document.CustWalletReport.txtfromdate.value;
		var todate = document.CustWalletReport.txttodate.value;
		if (fromdate=="" ||fromdate==null) {
			alert("Please Select From Date...");
			document.CustWalletReport.txtfromdate.focus();
			return;
		}
		if (todate=="" || todate==null) {
			alert("Please Select To Date...");
			document.CustWalletReport.txttodate.focus();
			return;
		}
		document.CustWalletReport.method = "POST";
		window.open("RptTotalTransactionsReport.jsp?&txtFromDate="+fromdate+"&txtToDate="+todate,'','resizable=yes,width=1000,height=570,scrollbars=yes,left=0,top=0');
	}
	/* calender function*/
	function y2k(number) {
		return (number < 1000) ? number + 1900 : number;
	}
	var today = new Date();
	var day = today.getDate();
	var month = today.getMonth();
	var year = y2k(today.getYear());

	function padout(number) {
		return (number < 10) ? '0' + number : number;
	}
	function CalnderWidnow(DateNumber, fieldvalue) {
		mywindow = open('../javaScript/cal.htm', DateNumber,'resizable=no,width=260,height=260');
		if (mywindow.opener == null)
			mywindow.opener = self;
	}
	function restart(DateNumber) {
		var arrMonth = new Array("Jan", "Feb", "Mar", "Apr", "May",	"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		var iD, iM, iY;
		iD = day;
		iM = month;
		iY = year;
		var a = month;
		var b = year;
		var c = day;
		var iDate = new Date(b, a, c);
		var iToday = new Date();
		if (DateNumber == 1) {
			iFrom = new Date(iY, iM, iD);
			if (iFrom > iToday) {
				alert("Date Can N't Be Greater Than Current Date ",	"img/help.jpg", "Ok", 3);
				document.pdc.txtfromdate.value = "";
				mywindow.close();
				return;
			}
			document.CustWalletReport.txtfromdate.value = padout(day) + ' '	+ arrMonth[month] + ' ' + year;
		}

		if (DateNumber == 2) {
			if (iDate < iFrom) {
				alert("Date Can N't Be Less Than From Date ",	"img/help.jpg", "Ok", 3);
				document.CustWalletReport.txttodate.value = "";
				mywindow.close();
				return;
			}else {
				document.CustWalletReport.txttodate.value = padout(day)	+ ' ' + arrMonth[month] + ' ' + year;
			}
		}
		mywindow.close();
	}
</script>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body style="background-image: url('../img/Supermarket.jpg;">
<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6 col-sm-12">
				<div align="center">
					<br>
						<img align="middle" height="110" width="150" alt="" src="../img/GrahakLogo.jpg">
				</div>
				<br>
				<div class="" id="loginModal">
					<div class="well">
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active in" id="addAmt">
								<form class="form-horizontal" name="CustWalletReport" id="CustWalletReport">
									<fieldset>
										<h3 align="center">Total Users Transaction Report</h3>
										<br>
										<table align="center">
											<tr>
												<td><label>From Date </label></td>
												<td><input class="input-xm chat-input" type="text" name="txtfromdate" id="txtfromdate" size="12" style="font-family: System bold; background: #E8E8F6; font-weight: bold; " readonly="readonly">
													<a href="javascript:CalnderWidnow('1')" title="Calendar" ><span class=bankaddress><img src="../img/calnder.gif" width="17" height="20" class="textBox"></span></a></td>
											</tr>
											<tr>
												<td><label>To Date </label></td>
												<td><input class="input-xm chat-input" type="text" name="txttodate" id="txttodate" size="12" style="font-family: System bold; background: #E8E8F6; font-weight: bold; " readonly="readonly">
													<a href="javascript:CalnderWidnow('2')" title="Calendar" ><span class=bankaddress><img src="../img/calnder.gif" width="17" height="20" class="textBox"></span></a></td>
											</tr>
										</table>
										<br>
										<div class="wrapper" align="center">
											<input type="button" class="btn btn-success" id="btnShowReport"	value="Show Report" onclick="showGeneratedUserReport()"/>
											<input type="reset" class="btn btn-danger" value="Clear"/>
											<input type="button" class="btn btn-link" id="" value="Go Back" onclick="window.location.href='../views/CustomerCreation.jsp'" />
										</div>
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