<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Add Product Save</title>
<%@ page import="com.nviera.service.ProductsOptions" %>
</head>
<body>
	<%
		String strEnteredBy = session.getAttribute("AdminSessionId").toString();
		String page_cmd			= request.getParameter("page_cmd"); 
		
		if ("addNewProduct".equalsIgnoreCase(page_cmd)) {
			ProductsOptions productAdding = new ProductsOptions();
			String productName		= request.getParameter("txtProductName"); 
			double productMRP		= Double.parseDouble(request.getParameter("txtMRP")); 
			double productGPPRice	= Double.parseDouble(request.getParameter("txtGPPrice")); 
			int productPoints		= Integer.parseInt(request.getParameter("txtPoints"));
			productAdding.ProductsAdding(productName, productMRP, productGPPRice,productPoints, strEnteredBy);
			out.println("<script>alert('Added Successfully...');parent.location.href = 'ProductAdd.jsp'</script>");
		}else if("activePro".equalsIgnoreCase(page_cmd)){
			ProductsOptions productActive = new ProductsOptions();
			String actProductId = request.getParameter("actProId");
			productActive.ChangeProductsActDeact(actProductId,"A",strEnteredBy);
			out.println("<script>alert('Activated Successfully...');parent.location.href='ProductActiveDeactive.jsp'</script>");
		}else if("deactivePro".equalsIgnoreCase(page_cmd)){
			ProductsOptions productDeactive = new ProductsOptions();
			String deactProductId = request.getParameter("deActProId");
			productDeactive.ChangeProductsActDeact(deactProductId,"I",strEnteredBy);
			out.println("<script>alert('Deactivated Successfully...');parent.location.href='ProductActiveDeactive.jsp'</script>");
		}else if("custActivePro".equalsIgnoreCase(page_cmd)){
			ProductsOptions productActive = new ProductsOptions();
			String actProductId = request.getParameter("custActProId");
			String strShoppyName = request.getParameter("shoppyName");
			int intQuantity = Integer.parseInt(request.getParameter("quantity"));
			productActive.ChangeCustProductsActDeact(strShoppyName,actProductId,"A",intQuantity,strEnteredBy);
			out.println("<script>alert('Activated Successfully...');parent.location.href='CustomerProductsActiveDeactive.jsp'</script>");
		}else if("custDeactivePro".equalsIgnoreCase(page_cmd)){
			ProductsOptions productDeactive = new ProductsOptions();
			String deactProductId = request.getParameter("custDeActProId");
			String strShoppyName = request.getParameter("shoppyName");
			int intQuantity = Integer.parseInt(request.getParameter("quantity"));
			productDeactive.ChangeCustProductsActDeact(strShoppyName,deactProductId,"I",intQuantity,strEnteredBy);
			out.println("<script>alert('Deactivated Successfully...');parent.location.href='CustomerProductsActiveDeactive.jsp'</script>");
		}
	%>
</body>
</html>