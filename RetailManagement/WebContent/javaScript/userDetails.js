/**
 * Invoice Number Validation
 */
function fnInvoiceNumberValidation(){
	var xhttp = new XMLHttpRequest();
	var invoiceNumber = document.getElementById("userTransNum").value;
	if (invoiceNumber == null) {
		alert("Please Enter Invoice Number...");
		/*document.getElementById("invoiceNumber").focus();*/
		return;
	}else if (invoiceNumber != null && invoiceNumber != "") {
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var invoiceDetails = JSON.parse(xhttp.responseText);
				if (invoiceDetails.invoiceExists == "N") {
					document.getElementById("userMobile").focus();
					return;
				}else {
					alert("Invoice Already Exists Please Enter Another Invoice Number...");
					document.getElementById("userTransNum").value = "";
					document.getElementById("userMobile").value = "";
					document.getElementById("userName").value = "";
					document.getElementById("userFoodItemsAmount").value = "0.00";
					document.getElementById("userNonFoodItemsAmount").value = "0.00";
					document.getElementById("userTotAmount").value = "0.00";
					document.getElementById("userTotalPointsEarn").value = "0";
					document.getElementById("userTransNum").focus();
					return;
				}
			}
		}
		xhttp.open("POST","./UserPointsSave.jsp?page_cmd=getInvoiceDetails&txtInvoiceNumber="+ invoiceNumber, true);
		xhttp.send();
	}
	
}

/**
 * User Mobile Validation
 */
function fnMobileValidation() {
	var xhttp = new XMLHttpRequest();
	var invoiceNumber = document.getElementById("userTransNum").value;
	var mobileNumber = document.getElementById("userMobile").value;
	if (invoiceNumber == null || invoiceNumber == "") {
		alert("Please Enter Invoice Number...");
		/*document.getElementById("invoiceNumber").focus();*/
		return;
	}if (mobileNumber == null) {
		alert("Please Enter Mobile Number...");
		/*document.getElementById("userMobile").focus();*/
		return;
	}else if (mobileNumber != null && mobileNumber != "" && invoiceNumber != null && invoiceNumber != "") {
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var mobileDetails = JSON.parse(xhttp.responseText);
				if (mobileDetails.userExists == "Y") {
					document.getElementById("userName").value = mobileDetails.name;
					document.getElementById("exiEarnPoints").value = mobileDetails.ExistingPoints;
					document.getElementById("userGrahakId").value = mobileDetails.grahakId;
					document.getElementById("userFoodItemsAmount").value = "0.00";
					document.getElementById("userNonFoodItemsAmount").value = "0.00";
					document.getElementById("userTotAmount").value = "0.00";
					document.getElementById("userTotalPointsEarn").value = "0";
					document.getElementById("userFoodItemsAmount").focus();
					return;
				}else {
					alert("Please Enter Correct Mobile Number...");
					document.getElementById("userMobile").value = "";
					document.getElementById("userName").value = "";
					document.getElementById("userFoodItemsAmount").value = "0.00";
					document.getElementById("userNonFoodItemsAmount").value = "0.00";
					document.getElementById("userTotAmount").value = "0.00";
					document.getElementById("userTotalPointsEarn").value = "0";
					document.getElementById("userMobile").focus();
					return;
				}
			}
		}
		xhttp.open("POST","./UserPointsSave.jsp?page_cmd=getMobieDetails&txtMobile="+ mobileNumber, true);
		xhttp.send();
	}
}
/**
 * Mobile Search For Multiple Customers
 * @returns
 */
function fnMobileSearch() {
	var invoiceNumber = document.getElementById("userTransNum").value;
	var mobileNumber = document.getElementById("userMobile").value;
	if(invoiceNumber == null || invoiceNumber == ""){
		alert("Please Enter InvoiceNumber")
	}else if(mobileNumber == null || mobileNumber==""){
		alert("please Enter Mobile Number")
	}else if(mobileNumber != null || mobileNumber!=""){
		window.open("MobileNumberSearch.jsp?MobileNumber=" + mobileNumber, "My popUp","resizeable=yes,width=600,height=400,scrollbar=yes,top=100,left=250");
		document.getElementById("userFoodItemsAmount").focus();
	}
}

/**
 * User Points Save
 * @returns
 */
function fnSubmit() {
	var transId = document.getElementById("userTransNum").value;
	var mobileNumber = document.getElementById("userMobile").value;
	var productName = document.getElementById("productName").value;
	var foodItemsAmt = document.getElementById("userFoodItemsAmount").value;
	var nonFoodItemsAmt = document.getElementById("userNonFoodItemsAmount").value;
	var shoppyWallentAmt = parseFloat(document.getElementById("shoppeWallentAmount").value);
	var totalPoints = parseFloat(document.getElementById("userTotalPointsEarn").value);
	
	if (transId == null || transId == "") {
		alert("Please Enter Transaction Number...");
		document.getElementById("userTransNum").focus();
		return;
	}
	if (mobileNumber == null || mobileNumber == "") {
		alert("Please Enter Mobile Number...");
		document.getElementById("userMobile").focus();
		return;
	}
	if (foodItemsAmt == null || foodItemsAmt == "") {
		alert("Please Enter Food Items Amount...");
		document.getElementById("userFoodItemsAmount").focus();
		return;
	}
	if (nonFoodItemsAmt == null || nonFoodItemsAmt == "") {
		alert("Please Enter Non Food Items Amount...");
		document.getElementById("userNonFoodItemsAmount").focus();
		return;
	}
	
	if(productName != null && productName != ""){
		document.userPoints.method = "post";
		document.userPoints.action = "./UserPointsSave.jsp?page_cmd=savePoints";
		document.userPoints.submit();
	} else if(parseFloat(foodItemsAmt) != 0 || parseFloat(nonFoodItemsAmt) != 0 ){
		if(totalPoints > shoppyWallentAmt){
			alert("Total Points is Greaterthan Bal Amount")
			document.getElementById("userFoodItemsAmount").value = 0.00;
			document.getElementById("userNonFoodItemsAmount").value = 0.00;
			document.getElementById("userTotAmount").value = 0.00;
			document.getElementById("userTotalPointsEarn").value = 0.00;
			document.getElementById("btsubmit").focus();
		}else{
			document.userPoints.method = "post";
			document.userPoints.action = "./UserPointsSave.jsp?page_cmd=savePoints";
			document.userPoints.submit();
		}
	}
}
/**
 *
 *
 */
function fnCalcPoints(){
	var custWalletAmount = parseFloat(document.getElementById("custWalletAmount").value);
	var mobileNumber = document.getElementById("userMobile").value;
	var foodItemsAmt = parseFloat(document.getElementById("userFoodItemsAmount").value);
	var nonFoodItemsAmt = parseFloat(document.getElementById("userNonFoodItemsAmount").value);
	var foodItemsPer = parseFloat(document.getElementById("FoodItemsPercentage").value);
	var nonFoodItemsPer = parseFloat(document.getElementById("NonFoodItemsPercentage").value);
	if(mobileNumber == null){
		alert("Please Enter Mobile Number...");
		document.getElementById("userMobile").focus();
		return;
	}
	if(mobileNumber != null && foodItemsAmt != null && nonFoodItemsAmt != null){
		var FoodItemsPoints = (parseFloat(foodItemsAmt) * parseFloat(foodItemsPer))/100;
		var NonFoodItemsPoints = (parseFloat(nonFoodItemsAmt)* parseFloat(nonFoodItemsPer))/100;
		var totalAmt = parseFloat(foodItemsAmt+nonFoodItemsAmt);
		var totPoints = Math.round(FoodItemsPoints+NonFoodItemsPoints);
		if(totPoints > custWalletAmount){
			alert("Total Points is Greaterthan Bal Amount")
			document.getElementById("userFoodItemsAmount").value = 0.00;
			document.getElementById("userNonFoodItemsAmount").value = 0.00;
			document.getElementById("userTotAmount").value = 0.00;
			document.getElementById("userTotalPointsEarn").value = 0.00;
			document.getElementById("userFoodItemsAmount").focus();
		}else{
			document.getElementById("userTotAmount").value = totalAmt;
			/*var totPoints = Math.round(FoodItemsPoints+NonFoodItemsPoints);*/ 
			document.getElementById("userTotalPointsEarn").value = totPoints;
		}
	}
}

function fnProductSearch() {
	window.open("ProductSearch.jsp", "My popUp","resizeable=yes,width=600,height=400,scrollbars=yes,top=100,left=250");
	document.getElementById("userFoodItemsAmount").focus();
}


function fnGrahakDetails(){
	var xhttp = new XMLHttpRequest();
	var grahakId = document.getElementById("userGrahakId").value;
	if (grahakId == null) {
		alert("Please Enter Grahak Id...");
		return;
	}else if(grahakId != null || grahakId != ""){
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var grahakDetails = JSON.parse(xhttp.responseText);
				for (var i = 0; i < grahakDetails.length; i++) {
				    var jsonGrahakDetails = grahakDetails[i];
				    document.getElementById("userMobile").value = jsonGrahakDetails.MobileNo;
				    document.getElementById("userName").value = jsonGrahakDetails.FirstName+jsonGrahakDetails.LastName;
				}
			}
		}
		xhttp.open("POST","./UserPointsSave.jsp?page_cmd=getGrahakDetails&txtGrahak="+ grahakId, true);
		xhttp.send();
	}
}
