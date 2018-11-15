function y2k(number) {
	return (number < 1000) ? number + 1900 : number;
}
var today = new Date();
var day = today.getDate();
var month = today.getMonth();
var year = y2k(today.getYear());
// added code

var txtPrice = 0;
var totalprice1 = 0;
var totalprice = 0;
var itemId;
//
var RCnt = 0;

function padout(number) {
	return (number < 10) ? '0' + number : number;
}
function CalnderWidnow(DateNumber, fieldvalue) {
	mywindow = open('../javaScript/cal.htm', DateNumber,
			'resizable=no,width=260,height=260');
	if (mywindow.opener == null)
		mywindow.opener = self;
}
function restart(DateNumber) {
	var arrMonth = new Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
			"Aug", "Sep", "Oct", "Nov", "Dec");
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
		if (iFrom <= iToday) {
			alert("Date Can N't Be Less Than Current Date ", "img/help.jpg",
					"Ok", 3);
			document.addItem.txtDate1.value = "";
			mywindow.close();
			return;
		}
		document.addItem.txtDate1.value = padout(day) + ' ' + arrMonth[month]
				+ ' ' + year;
	}

	if (DateNumber == 2) {
		if (iDate <= iFrom) {
			alert("Date Can N't Be Less Than From Date ", "img/help.jpg", "Ok",
					3);
			document.addItem.txtDate1.value = "";
			mywindow.close();
			return;
		} else {
			document.addItem.txtDate1.value = padout(day) + ' '
					+ arrMonth[month] + ' ' + year;
		}
	}
	mywindow.close();
}

/*
 * item search
 */
function fnItemSearch() {
	window
			.open("ShopItemSearch.jsp", "My popUp",
					"resizeable=yes,width=600,height=400,scrollbars=yes,top=100,left=250");
	/* document.getElementById("itemDetails").focus(); */
}
/*
 * item validation
 */
function fnitemValidation() {
	var retailer = document.addItem.retailerName.value;
	var itemsList = document.addItem.addItemId.value;
	var dateofpurchase = document.addItem.txtDate1.value;
	var quantity = document.addItem.txtQuantity.value;
	var price = document.addItem.txtPrice.value;
	var remarks = document.addItem.txtRemarks.value;
	var retailerMrp = document.addItem.addRetailermrp.value;
	var warehouseMrp = document.addItem.addWarehousemrp.value;

	if (retailer == null || retailer == "") {
		alert("Please Enter retailer");
		document.addItem.retailerName.focus();
		return;
	}
	if (itemsList == null || itemsList == "") {
		alert("Please Enter item ID");
		document.addItem.addItemId.focus();
		return;
	}

	if (quantity == null || quantity == "") {
		alert("Please Enter totla purchase quantity");
		document.addItem.txtQuantity.focus();
		return;
	}
	if (dateofpurchase == null || dateofpurchase == "") {
		alert("Please Enter dateof purchase");
		document.addItem.txtDate1.focus();
		return;
	}
	if (remarks == null || remarks == "") {
		alert("Please Enter remarks");
		document.addItem.txtRemarks.focus();
		return;
	} else {
		window.addItem.btnSave.disabled = false;
		var addRetailermrp = null;
		var addWarehousemrp = null;
		
		document.getElementById("addRetailermrp").value = addRetailermrp;
		document.getElementById("addWarehousemrp").value = addWarehousemrp;
		// added total price code
		console.log("this is total prize before adding new value" + totalprice);
		totalprice = parseFloat(document.getElementById("txtPrice").value)+ totalprice;
		totalprice1 = parseFloat(document.getElementById("txtWarehousePrice").value)+ totalprice1;
		console.log("this is total prize after adding new value" + totalprice);
		document.getElementById("txtTotPrice").value = totalprice;
		document.getElementById("txtTotWarehousePrice").value = totalprice1;
		
		// add items
		
		var remarks = null;
		document.getElementById("txtRemarks").value=remarks;
		AddRowOutward();
	}

}

function RemoveRow(ad) {
	var oRow = ad.parentNode.parentNode;//parent node of row-remove row

	var b = oRow.children[3].children[0].value;//storing the value of price of row value
	console.log(b);//prints b value in console
	totalprice = totalprice - b;//substract the removed value from totalprice
	document.getElementById("txtTotPrice").value = totalprice;//the result value after removed value passing into totalprice
	
	var c = oRow.children[4].children[0].value;
	console.log(c);
	totalprice1 = totalprice1 - c;//substract the removed value from totalprice
	document.getElementById("txtTotWarehousePrice").value = totalprice1;
	
	alert("Item removed successfully");
	document.getElementById("Table").deleteRow(oRow.rowIndex);//check the index value of row

}

function AddRowOutward() {
	var itemId = document.addItem.addItemId.value;
	var itemname = document.addItem.addItemName.value;
	var quantity = document.addItem.txtQuantity.value;
	var price = document.addItem.txtPrice.value;
	var warehousePrice = document.addItem.txtWarehousePrice.value;

	var newRow = document.getElementById("Table").insertRow(Table.rows.length);
	newRow.className = "even";
	
	oCell = newRow.insertCell(0);
	oCell.innerHTML = "<input class='txt' type=text readonly size=15 style='text-align:right' name=txtItemId"
			+ RCnt + "     value='" + itemId + "'>";
		
	oCell = newRow.insertCell(1);
	oCell.innerHTML = "<input class='txt' type=text size=15 style='text-align:right' name=txtItemName"
			+ RCnt + " value='" + itemname + "' >";

	oCell = newRow.insertCell(2);
	oCell.innerHTML = "<input class='txt' type=text size=15 readonly style='text-align:right' name=txtQuantity"
			+ RCnt + " value='" + quantity + "'>"

	oCell = newRow.insertCell(3);
	oCell.innerHTML = "<input class='txt' type=text size=15 readonly style='text-align:right' name=txtPirce"
			+ RCnt + " value='" + price + "'>"
			
	oCell = newRow.insertCell(4);
	oCell.innerHTML = "<input class='hidden' type=text size=15 readonly style='text-align:right' name=txtWarehousePirce"
					+ RCnt + " value='" + warehousePrice + "'>"
			

	oCell = newRow.insertCell(5);
	oCell.innerHTML = "<input type='image' src='../img/delete.gif' alt='Delete' size=5 onclick='RemoveRow(this);'>";
	
	
	RCnt++;
	addItem.hidCharRow.value = RCnt;

	alert("Item added successfully" + addItem.hidCharRow.value);

	document.addItem.addItemId.value = "";
	document.addItem.addItemName.value = "";
	document.addItem.txtQuantity.value = "";
	document.addItem.txtPrice.value = "";
	document.addItem.txtWarehousePrice.value = "";

}

/**
 * existing customer was valid or not
 * 
 * @returns
 */
function fnShopItemValidation() {
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
					return;
				} else {
					alert("Please Enter Correct Item...");
					document.getElementById("addItemId").value = "";
					document.getElementById("addItemName").value = "";
					document.getElementById("addRetailermrp").value = "";
					document.getElementById("addWarehousemrp").value = "";
					return;
				}
			}
		}
		xhttp.open("POST",
				"../views/ItemCreationSave.jsp?page_cmd=getItemDetails&txtItemId="
						+ itemId, true);
		xhttp.send();
	}
}
function fnTotPriValidation() {

	var shopPrice = parseFloat(document.getElementById("addRetailermrp").value);
	var retailerPrice = parseFloat(document.getElementById("addWarehousemrp").value);
	var totQuantity = parseFloat(document.getElementById("txtQuantity").value);
	
	var totalItemPrice = shopPrice * totQuantity;
	var tatalWarehouseItemPrice = retailerPrice * totQuantity;
	
	document.getElementById("txtPrice").value = totalItemPrice;
	document.getElementById("txtWarehousePrice").value = tatalWarehouseItemPrice;
	
	var totalItemPrice = parseFloat(document.getElementById("txtPrice").value);
	var tatalWarehouseItemPrice = parseFloat(document.getElementById("txtWarehousePrice").value);
	
	var totalPrice = totalItemPrice;
	var totalPrice1 = tatalWarehouseItemPrice;
	
	for (totalPrice = 0; totalPrice > totalItemPrice; totalPrice++) {
		document.getElementById("txtPrice").value = totalItemPrice;
	}
	for (totalPrice1 = 0; totalPrice1 > tatalWarehouseItemPrice; totalPrice1++) {
		document.getElementById("txtWarehousePrice").value = tatalWarehouseItemPrice;
	}
}

//Saving items

function itemSaving() {
	document.addItem.method = "post";
	document.addItem.action = "../views/ShopOrderSave.jsp";
	document.addItem.submit();
}