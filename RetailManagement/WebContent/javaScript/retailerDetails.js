 /**
 * existing customer was valid or not
 * @returns
 */
function fnRetailerValidation() {
	var xhttp = new XMLHttpRequest();
	var retailerId = document.getElementById("addRetailerId").value;
	if (retailerId == null) {
		alert("Please Enter Retailer Id...");
		document.getElementById("addRetailerId").focus();
		return;
	}
	if (retailerId != null && retailerId != "") {
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var retailerDetails = JSON.parse(xhttp.responseText);
				if (retailerDetails.retailerExists == "Y") {
					document.getElementById("addRetailerName").value = retailerDetails.retailerName;
					document.getElementById("addRetailerAddress").value = retailerDetails.retailerAddress;
					document.getElementById("addNewRetailer").value = "";
					document.getElementById("addNewRetailer").focus();
					document.getElementById("addNewRetailer1").value = "";
					document.getElementById("addNewRetailer1").focus();
					return;
				}else {
					alert("Please Enter Correct Retailer...");
					document.getElementById("addRetailerId").value = "";
					document.getElementById("addRetailerName").value = "";
					document.getElementById("addRetailerAddress").value = "";
					document.getElementById("modifyRetailers").value = "";
					document.getElementById("modifyRetailers").focus();
					document.getElementById("modifyRetailers1").value = "";
					document.getElementById("modifyRetailers1").focus();
					return;
				}
			}
		}
		xhttp.open("POST","../views/RetailerCreationSave.jsp?page_cmd=getRetailerDetails&txtRetailerId="+ retailerId, true);
		xhttp.send();
	}
}
/**
 
 * creating new retailer validation
 * 
 * @returns
 */
function modifyRetailer(){
	
	if(document.addNewRetailer.addRetailerName.value == ""){
		alert("Please Enter the Retailer ID...");
		document.addNewRetailer.addRetailerName.focus();
		return;
	}
	if(document.addNewRetailer.addRetailerAddress.value==""){
		alert("Please Enter Address... ");
		document.addNewRetailer.addRetailerAddress.focus();
		return;
	}
	document.addNewRetailer.method ="post";
	document.addNewRetailer.action="RetailerCreationSave.jsp?page_cmd=addNewRetailer";
	document.addNewRetailer.submit();
}
/**
 * creating new customer validation
 * 
 * @returns
 */



function regRetailer1(){
	if(document.regRetailer.regRetailerId.value == ""){
		alert("Please Enter the Retailer Name...");
		document.regRetailer.regRetailer.focus();
		return;
	}
	if(document.regRetailer.regRetailerPswd.value == ""){
		alert("Please Enter the Password...");
		document.regRetailer.regRetailerPswd.focus();
		return;
	}
	if(document.regRetailer.regRetailerAddress.value == ""){
		alert("Please Enter the Address... ");
		document.regRetailer.regRetailerAddress.focus();
		return;
	}
	document.regRetailer.method ="post";
	document.regRetailer.action="RetailerCreationSave.jsp?page_cmd=createNewRetailer";
	document.regRetailer.submit();
}
/*
 * Retailer search
 */
function fnRetailerSearch() {
	window.open("RetailerSearch.jsp", "My popUp","resizeable=yes,width=600,height=400,scrollbars=yes,top=100,left=250");
	
}
function fnRetailerDelSearch()

{
	window.open("RetailerDelSearch.jsp", "My popUp","resizeable=yes,width=600,height=400,scrollbars=yes,top=100,left=250");
	
}
/**
 * delete customer details validation
 * 
 * @returns
 */
function fnDelRetailerValid() {
	var xhttp = new XMLHttpRequest();
	var retailerId = document.getElementById("delRetailerId").value;
	if (retailerId == null) {
		alert("Please Enter Retailer Id...");
		document.getElementById("delRetailerId").focus();
		return;
	}
	if (retailerId != null && retailerId != "") {
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var retailerDetails = JSON.parse(xhttp.responseText);
				if (retailerDetails.retailerExists == "Y") {
					document.getElementById("delRetailerName").value = retailerDetails.retailerName;
					document.getElementById("delRetailerAddress").value = retailerDetails.retailerAddress;
					document.getElementById("btDel").focus();
					return;
				}else {
					alert("Please Enter Correct Retailer...");
					document.getElementById("delRetailerId").value = "";
					document.getElementById("delRetailerName").value = "";
					document.getElementById("delRetailerAddress").value = "";
					document.getElementById("delRetailerId").focus();
					return;
				}
			}
		}
		xhttp.open("POST","./RetailerCreationSave.jsp?page_cmd=getRetailerDetails&txtRetailerId="+ retailerId, true);
		xhttp.send();
	}
}
/**
 * existing customer wallet amount adding validation
 * @returns
 */
function delRetailer(){
	if(document.delRetailer1.delRetailerId.value == ""){
		alert("Please Enter the Retailer Name...");
		document.delRetailer1.delRetailerId.focus();
		return;
	}
	alert(document.delRetailer1.delRetailerId.value);
	document.delRetailer1.method ="post";
	document.delRetailer1.action="RetailerCreationSave.jsp?page_cmd=delRetailer&txtdelRetailerId="+document.delRetailer1.delRetailerId.value;
	document.delRetailer1.submit();
}

function fnItemDetails(shopOrderId)
{
	alert("shopOrderId : "+shopOrderId);
	window.open("itemslist.jsp?shopOrderId="+shopOrderId, "My popUp","resizeable=yes,width=600,height=400,scrollbars=yes,top=100,left=250");
	
}