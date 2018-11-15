/**
 * 
 * @returns
 */
function fnAdminCheck() {
	var xhttp = new XMLHttpRequest();
	var adminId = adminLogin.txtAdminId.value;
	if(adminId == "null"){
		alert("Please Enter Admin Id");
		adminLogin.txtAdminId.focus();
		return;
	}
	if(adminId != null && adminId != ""){
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var adminValid = JSON.parse(xhttp.responseText);
				if (adminValid != null || adminValid != "") {
					if(adminValid.isRecordExists == "Y"){
						adminLogin.adminPswd.focus();
					}else{
						alert("Invalid User");
						adminLogin.txtAdminId.value="";
						adminLogin.txtAdminId.focus();
					}
				}
			}
		}
		xhttp.open("POST","AdminLoginSave.jsp?page_cmd=adminIdValidate&txtadminId=" + adminId, true);
		xhttp.send();
	}
}
/**
 * 
 * @returns
 */
function fnAdminLoginOnClick() {
	if (adminLogin.txtAdminId.value == "") {
		alert("Please Enter the Admin Id");
		adminLogin.txtAdminId.value = "";
		adminLogin.txtAdminId.focus();
	} else if (adminLogin.adminPswd.value == "") {
		alert("Please Enter the Password");
		adminLogin.adminPswd.value = "";
		adminLogin.adminPswd.focus();
	} else {
		document.adminLogin.method = "post";
		document.adminLogin.action = "AdminLoginSave.jsp";
		document.adminLogin.submit();
	}
}