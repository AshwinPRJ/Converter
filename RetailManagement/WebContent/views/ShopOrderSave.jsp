<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@  page language="java" import="org.json.JSONObject"%>
<%@ page import="com.nviera.service.ShopOrder"%>


	<%
	ShopOrder shopOrder = new ShopOrder();
	String strItemName = request.getParameter("addItemName");
	System.out.println("strItemName : "+strItemName);
	String strItemPrice = request.getParameter("addRetailermrp");
	System.out.println("strItemPrice : "+strItemPrice);
	String strWarehousePrice = request.getParameter("addWarehousemrp");
	System.out.println("strWarehousePrice : "+strWarehousePrice);
	String strRetailer = request.getParameter("retailerName");
	System.out.println("strRetailer : "+strRetailer);
	String strRemarks = request.getParameter("txtRemarks");
	System.out.println("strRemarks : " + strRemarks);
	String strPurchaseDate = request.getParameter("txtDate1");
	System.out.println("strPurchaseDate : " + strPurchaseDate);
	
	String strTotalPrice = request.getParameter("txtTotPrice");
	System.out.println("strTotalPrice : " + strTotalPrice);
	
	String strTotalWarehousePrice = request.getParameter("txtTotWarehousePrice");
	System.out.println("strTotalWarehousePrice : " + strTotalWarehousePrice);
	
	String strEnteredBy=session.getAttribute("CustSessionId").toString();
	int count = Integer.parseInt(request.getParameter("hidCharRow"));
	for(int i=0 ; i< count ; i++)
	{
		String strShoppy = request.getParameter("txtItemId"+i);
		System.out.println("item id insave:====> : "+strShoppy);
		String strQuantity = request.getParameter("txtQuantity"+i);
		System.out.println("strQuantity insave===> : " + strQuantity);	
		String strTotalmrp = request.getParameter("txtPirce"+i);
		System.out.println("strTotalmrp insave ===> : " + strTotalmrp);
		String strWarehouseTotalmrp = request.getParameter("txtWarehousePirce"+i);
		System.out.println("strTotalWarehousePrice insave ===> : " + strWarehouseTotalmrp);
		
	shopOrder.shopItemSave(strShoppy, strItemName, strItemPrice, strWarehousePrice, strQuantity, strRetailer, strRemarks, strPurchaseDate, strTotalmrp, strWarehouseTotalmrp, strTotalPrice, strTotalWarehousePrice, strEnteredBy);
	}
	out.println("<script>alert('Data Inserted Successfull...');parent.location.href='ShopOrder.jsp'</script>");
	%>
	