/**
 * existing customer was valid or not
 * @returns
 */
function fnCustValidation() {
	var xhttp = new XMLHttpRequest();
	var custId = document.getElementById("addCustId").value;
	if (custId == null) {
		alert("Please Enter Customer Id...");
		document.getElementById("addCustId").focus();
		return;
	}
	if (custId != null && custId != "") {
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var custDetails = JSON.parse(xhttp.responseText);
				if (custDetails.custExists == "Y") {
					document.getElementById("addCustName").value = custDetails.custName;
					document.getElementById("addCustBalWalAmount").value = custDetails.custWalBal;
					document.getElementById("addAmount").value = "";
					document.getElementById("addAmount").focus();
					return;
				}else {
					alert("Please Enter Correct Customer...");
					document.getElementById("addCustId").value = "";
					document.getElementById("addCustName").value = "";
					document.getElementById("addAmount").value = "";
					document.getElementById("addCustBalWalAmount").value = "";
					document.getElementById("addCustId").focus();
					return;
				}
			}
		}
		xhttp.open("POST","../views/CustomerCreationSave.jsp?page_cmd=getCustDetails&txtCustId="+ custId, true);
		xhttp.send();
	}
}
/**
 * existing customer wallet amount adding validation
 * @returns
 */
function addWallet(){
	if(document.addCustWallet.addCustId.value == ""){
		alert("Please Enter the Customer Name...");
		document.addCustWallet.addCustId.focus();
		return;
	}
	if(document.addCustWallet.addAmount.value==""){
		alert("Please Enter Amount... ");
		document.addCustWallet.addAmount.focus();
		return;
	}
	document.addCustWallet.method ="post";
	document.addCustWallet.action="CustomerCreationSave.jsp?page_cmd=addWalletToCust";
	document.addCustWallet.submit();
}
/**
 * creating new customer validation
 * 
 * @returns
 */
function regCust(){
	if(document.regCustomer.regCustname.value == ""){
		alert("Please Enter the Customer Name...");
		document.regCustomer.regCustname.focus();
		return;
	}
	if(document.regCustomer.regCustPswd.value == ""){
		alert("Please Enter the Password...");
		document.regCustomer.regCustPswd.focus();
		return;
	}
	if(document.regCustomer.regCustShopename.value == ""){
		alert("Please Enter the Shop Name... ");
		document.regCustomer.regCustShopename.focus();
		return;
	}
	if(document.regCustomer.regPlace.value == ""){
		alert("Please Enter Place... ");
		document.regCustomer.regPlace.focus();
		return;
	}
	if(document.regCustomer.regCity.value == ""){
		alert("Please Enter City... ");
		document.regCustomer.regCity.focus();
		return;
	}
	if(document.regCustomer.regWalletamt.value==""){
		alert("Please Enter Wallet Amount... ");
		document.regCustomer.regWalletamt.focus();
		return;
	}
	document.regCustomer.method ="post";
	document.regCustomer.action="CustomerCreationSave.jsp?page_cmd=createNewCust";
	document.regCustomer.submit();
}
/**
 * delete customer details validation
 * 
 * @returns
 */
function fnDelCustValid() {
	var xhttp = new XMLHttpRequest();
	var custId = document.getElementById("delCustId").value;
	if (custId == null) {
		alert("Please Enter Customer Id...");
		document.getElementById("addCustId").focus();
		return;
	}
	if (custId != null && custId != "") {
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var custDetails = JSON.parse(xhttp.responseText);
				if (custDetails.custExists == "Y") {
					document.getElementById("delCustName").value = custDetails.custName;
					document.getElementById("delAmount").value = custDetails.custWalBal;
					document.getElementById("btDel").focus();
					return;
				}else {
					alert("Please Enter Correct Customer...");
					document.getElementById("delCustId").value = "";
					document.getElementById("delCustName").value = "";
					document.getElementById("delAmount").value = "";
					document.getElementById("delCustId").focus();
					return;
				}
			}
		}
		xhttp.open("POST","./CustomerCreationSave.jsp?page_cmd=getCustDetails&txtCustId="+ custId, true);
		xhttp.send();
	}
}
/**
 * existing customer wallet amount adding validation
 * @returns
 */
function delCust(){
	if(document.delCustomer.delCustId.value == ""){
		alert("Please Enter the Customer Name...");
		document.delCustomer.delCustId.focus();
		return;
	}
	document.addCustWallet.method ="post";
	document.addCustWallet.action="CustomerCreationSave.jsp?page_cmd=delCust&txtdelCustId="+document.delCustomer.delCustId.value;
	document.addCustWallet.submit();
}