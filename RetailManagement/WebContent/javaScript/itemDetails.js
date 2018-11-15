/**
 * existing customer was valid or not
 * @returns
 */
function fnItemValidation() {
	var xhttp = new XMLHttpRequest();
	var itemId = document.getElementById("addItemId").value;
	if (itemId == null) {
		alert("Please Enter Item Id...");
		document.getElementById("addItemId").focus();
		return;
	}
	if (itemId != null && itemId != "") {
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var itemDetails = JSON.parse(xhttp.responseText);
				if (itemDetails.itemExists == "Y") {
					document.getElementById("addItemName").value = itemDetails.itemName;
					document.getElementById("addRetailermrp").value = itemDetails.itemRetailermrp;
					document.getElementById("addWarehousemrp").value = itemDetails.itemWarehousemrp;
					document.getElementById("addNewItem").value = "";
					document.getElementById("addNewItem1").value="";
					document.getElementById("addNewItem").focus();
					document.getElementById("addNewItem1").focus();
					return;
				}else {
					alert("Please Enter Correct Item...");
					document.getElementById("addItemId").value = "";
					document.getElementById("addItemName").value = "";
					document.getElementById("addRetailermrp").value = "";
					document.getElementById("addWarehousemrp").value = "";
					document.getElementById("addNewItem").value = "";
					document.getElementById("addNewItem1").value="";
					document.getElementById("addItemId").focus();
					return;
				}
			}
		}
		xhttp.open("POST","../views/ItemCreationSave.jsp?page_cmd=getItemDetails&txtItemId="+ itemId, true);
		xhttp.send();
	}
}
/*
 * item search
 */
function fnItemSearch() {
	window.open("ItemSearch.jsp", "My popUp","resizeable=yes,width=600,height=400,scrollbars=yes,top=100,left=250");
	/*document.getElementById("itemDetails").focus();*/
}
/*
 * del search
 */
function fnItemDelSearch() {
	window.open("ItemDelSearch.jsp", "My popUp","resizeable=yes,width=600,height=400,scrollbars=yes,top=100,left=250");
	/*document.getElementById("itemDetails").focus();*/
}
/**
 * existing customer wallet amount adding validation
 * @returns
 */
function modifyItem(){
	if(document.addNewItem.addItemId.value == ""){
		alert("Please Enter the Item Number...");
		document.addNewItem.addItemId.focus();
		return;
	}
	if(document.addNewItem.addRetailermrp.value==""){
		alert("Please Enter Amount... ");
		document.addNewItem.addRetailermrp.focus();
		return;
	}
	if(document.addNewItem.addWarehousemrp.value==""){
		alert("Please Enter Amount... ");
		document.addNewItem.addWarehousemrp.focus();
		return;
	}
	document.addNewItem.method ="post";
	document.addNewItem.action="ItemCreationSave.jsp?page_cmd=addNewItem";
	document.addNewItem.submit();
}

/*
 * creation of item.
 */
function regItem(){
	if(document.regItem1.regItemname.value == ""){
		alert("Please Enter the Item Name...");
		document.regItem1.regItemname.focus();
		return;
	}
	if(document.regItem1.regRetailermrp.value == ""){
		alert("Please Enter the Retailer price...");
		document.regItem1.regRetailermrp.focus();
		return;
	}
	if(document.regItem1.regWarehousemrp.value == ""){
		alert("Please Enter the Shop Name... ");
		document.regItem1.regWarehousemrp.focus();
		return;
	}
	
	document.regItem1.method ="post";
	document.regItem1.action="ItemCreationSave.jsp?page_cmd=createNewItem";
	document.regItem1.submit();
}

function fnDelItemValid() {
	var xhttp = new XMLHttpRequest();
	var itemId = document.getElementById("delItemId").value;
	if (itemId == null) {
		alert("Please Enter Item Id...");
		document.getElementById("addItemId").focus();
		return;
	}
	if (itemId != null && itemId != "") {
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var itemDetails = JSON.parse(xhttp.responseText);
				if (itemDetails.itemExists == "Y") {
					document.getElementById("delItemName").value = itemDetails.itemName;
					document.getElementById("delRetailmrp").value = itemDetails.itemRetailermrp;
					document.getElementById("delWarehousemrp").value = itemDetails.itemWarehousemrp;
					document.getElementById("btDel").focus();
					return;
				}else {
					alert("Please Enter Correct item");
					document.getElementById("delItemId").value = "";
					document.getElementById("delItemName").value = "";
					document.getElementById("delRetailmrp").value = "";
					document.getElementById("delWarehousemrp").value = "";
					document.getElementById("delItemId").focus();
					return;
				}
			}
		}
		xhttp.open("POST","./ItemCreationSave.jsp?page_cmd=getItemDetails&txtItemId="+ itemId, true);
		xhttp.send();
	}
}
/**
 * existing customer wallet amount adding validation
 * @returns
 */

function delItem(){
	if(document.delItem1.delItemId.value == ""){
		alert("Please Enter the Item Number...");
		document.delItem1.delItemId.focus();
		return;
	}
	alert(document.delItem1.delItemId.value);
	document.delItem1.method ="post";
	document.delItem1.action="ItemCreationSave.jsp?page_cmd=delItem&txtdelItemId="+document.delItem1.delItemId.value;
	document.delItem1.submit();
}