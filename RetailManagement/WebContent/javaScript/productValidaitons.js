/**
 * 
 */

function fnAddProductOnClick(){
	var productName		=	document.getElementById("txtProductName").value;
	var productMRP		=	document.getElementById("txtMRP").value;
	var productGPPrice	=	document.getElementById("txtGPPrice").value;
	var productPoints	=	document.getElementById("txtPoints").value;
	
	if(productName == "" || productName == null){
		alert("Please Enter Product Name...");
		document.getElementById("txtProductName").focus();
		return;
	}
	
	if(productMRP == "" || productMRP == null){
		alert("Please Enter Product MRP...");
		document.getElementbyId("txtProductName").focus();
		return;
	}
	if(productGPPrice == "" || productGPPrice == null){
		alert("Please Enter Product GP Price...");
		document.getElementById("txtProductName").focus();
		return;
	}
	if(productPoints == "" || productPoints == null){
		alert("Please Enter Product Points...");
		document.getElementById("txtProductName").focus();
		return;
	}
	document.addProduct.method ="post";
	document.addProduct.action="ProductAddSave.jsp?page_cmd=addNewProduct";
	document.addProduct.submit();
}