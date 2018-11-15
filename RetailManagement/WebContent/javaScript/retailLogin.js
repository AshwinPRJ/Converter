/**
 * 
 * @returns
 */
function fnRetailCheck() {
	var xhttp = new XMLHttpRequest();
	var retailId = retailLogin.txtRetailId.value;
	if(retailId == "null"){
		alert("Please Enter retail Id");
		retailLogin.txtRetailId.focus();
		return;
	}
	if(retailId != null && retailId != ""){
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var retailValid = JSON.parse(xhttp.responseText);
				if (retailValid != null || retailValid != "") {
					if(retailValid.isRecordExists == "Y"){
						retailLogin.retailPswd.focus();
					}else{
						alert("Invalid User");
						retailLogin.txtRetailId.value="";
						retailLogin.txtRetailId.focus();
					}
				}
			}
		}
		xhttp.open("POST","RetailLoginSave.jsp?page_cmd=retailIdValidate&txtretailId=" + retailId, true);
		xhttp.send();
	}
}
/**
 * 
 * @returns
 */
function fnRetailLoginOnClick() {
	if (retailLogin.txtRetailId.value == "") {
		alert("Please Enter the retail Id");
		retailLogin.txtRetailId.value = "";
		retailLogin.txtRetailId.focus();
	} else if (retailLogin.retailPswd.value == "") {
		alert("Please Enter the Password");
		retailLogin.retailPswd.value = "";
		retailLogin.retailPswd.focus();
	} else {
		document.retailLogin.method = "post";
		document.retailLogin.action = "RetailLoginSave.jsp";
		document.retailLogin.submit();
	}
}