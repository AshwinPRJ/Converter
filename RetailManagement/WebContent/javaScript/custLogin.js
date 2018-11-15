/**
 * 
 * @returns
 */
function fnCustCheck() {
	var xhttp = new XMLHttpRequest();
	var custId = custLogin.txtCustId.value;
	if(custId == "null"){
		alert("Please Enter Customer Id");
		custLogin.txtCustId.focus();
		return;
	}
	if(custId != null && custId != ""){
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var custValid = JSON.parse(xhttp.responseText);
				if (custValid != null || custValid != "") {
					if(custValid.isRecordExists == "Y"){
						custLogin.custPswd.focus();
					}else{
						alert("Invalid Customer Id...");
						custLogin.txtCustId.value="";
						custLogin.txtCustId.focus();
					}
				}
			}
		}
		xhttp.open("POST","../views/CustomerLoginSave.jsp?page_cmd=custIdValidate&txtcustId=" + custId, true);
		xhttp.send();
	}

}
/**
 * 
 * @returns
 */
function fnCustLoginOnClick() {
	if (custLogin.txtCustId.value == "") {
		alert("Please Enter the Customer Id");
		custLogin.txtCustId.value = "";
		custLogin.txtCustId.focus();
	} else if (custLogin.custPswd.value == "") {
		alert("Please Enter the Password");
		custLogin.custPswd.value = "";
		custLogin.custPswd.focus();
	} else {
		document.custLogin.method = "post";
		document.custLogin.action = "../views/CustomerLoginSave.jsp";
		document.custLogin.submit();
	}
}

function fnForgotPswd(){
	var custId = document.getElementById("txtCustId").value;
	if(custId == null || custId == ""){
		alert("Please Enter UserId...");
		document.getElementById("txtCustId").focus();
		return;
	}else{
		document.custLogin.method = "post";
		document.custLogin.action = "../views/ForgotPassword.jsp";
		document.custLogin.submit();
	}
}

function fnCustChangePswd(){
	if(document.getElementById("txtCustId").value == null || document.getElementById("txtCustId").value == ""){
		alert("Please Enter UserId...");
		document.getElementById("txtCustId").focus();
		return;
	}else if(document.getElementById("newCustPswd").value == null || document.getElementById("newCustPswd").value == ""){
		alert("Please Enter Password...");
		document.getElementById("newCustPswd").focus();
		return;
	} else{
		document.custLogin.method = "post";
		document.custLogin.action = "../views/ForgotPasswordSave.jsp?page_cmd=custChangePswd";
		document.custLogin.submit();
	}
}
