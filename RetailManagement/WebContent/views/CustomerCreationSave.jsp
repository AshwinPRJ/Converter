<%-- 
	@author						: kiran
 	@module name/description	: Admin Login Page
 	@created date				: 05 oct 2016
 	@modified by				: 
 	@modified date				: 
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@  page language="java" import="org.json.JSONObject"%>
<%@ page import="com.nviera.service.CustomerCreation"%>
<%
	String strEnteredBy=session.getAttribute("AdminSessionId").toString();
	
	String page_cmd = request.getParameter("page_cmd");
	String strCustId = request.getParameter("txtCustId"); 
	CustomerCreation custValid = new CustomerCreation();
	if ("getCustDetails".equalsIgnoreCase(page_cmd)) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter outs = response.getWriter();
		JSONObject custDetails = custValid.CustValidation(strCustId);
		outs.print(custDetails);
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Creation Save</title>
</head>
<body>
	<%
		if("addWalletToCust".equalsIgnoreCase(page_cmd)){
			CustomerCreation custCreat = new CustomerCreation();
			strCustId = request.getParameter("addCustId");
			double dblAddWalAmt = Double.parseDouble(request.getParameter("addAmount"));
			double dblCustBalWalAmt = Double.parseDouble(request.getParameter("addCustBalWalAmount"));
			custCreat.CustomerWalletAdding(strCustId,dblAddWalAmt,dblCustBalWalAmt,strEnteredBy);
			out.println("<script>alert('Added Successfully...');parent.location.href='CustomerCreation.jsp'</script>");
		}else if("createNewCust".equalsIgnoreCase(page_cmd)){
			CustomerCreation custCreat = new CustomerCreation();
			strCustId = request.getParameter("regCustname");
			String strCustPswd = request.getParameter("regCustPswd");
			String strCustShopName = request.getParameter("regCustShopename");
			String strCustPlace = request.getParameter("regPlace");
			String strCustCity = request.getParameter("regCity");
			String strwalletamt = request.getParameter("regWalletamt");
			String strFoodItemsPer = request.getParameter("regFood");
			String strNonFoodItemsPer = request.getParameter("regNonFood");
			custCreat.CustomerAdd(strCustId,strCustPswd, strCustShopName,strCustPlace,strCustCity,strwalletamt,strFoodItemsPer,strNonFoodItemsPer,strEnteredBy);
			out.println("<script>alert('Customer Created Successfully...');parent.location.href='CustomerCreation.jsp'</script>");
		}else if("delCust".equalsIgnoreCase(page_cmd)){
			CustomerCreation custDel = new CustomerCreation();
			String delCustId = request.getParameter("txtdelCustId");
			custDel.CustomerDeletion(delCustId,strEnteredBy);
			out.println("<script>alert('Deleted Successfully...');parent.location.href='CustomerCreation.jsp'</script>");
		}else if("active".equalsIgnoreCase(page_cmd)){
			CustomerCreation custActiveDeactive = new CustomerCreation();
			String actCustId = request.getParameter("actCustId");
			custActiveDeactive.ChangeCustomerItemsActDeact(actCustId,"Y",strEnteredBy);
			out.println("<script>alert('Activated Successfully...');parent.location.href='ActiveDeactive.jsp'</script>");
		}else if("deactive".equalsIgnoreCase(page_cmd)){
			CustomerCreation custActiveDeactive = new CustomerCreation();
			String deactCustId = request.getParameter("deActCustId");
			custActiveDeactive.ChangeCustomerItemsActDeact(deactCustId,"N",strEnteredBy);
			out.println("<script>alert('Deactivated Successfully...');parent.location.href='ActiveDeactive.jsp'</script>");
		}else if("activeProduct".equalsIgnoreCase(page_cmd)){
			CustomerCreation custActiveDeactive = new CustomerCreation();
			String actCustId = request.getParameter("actProCustId");
			custActiveDeactive.ChangeCustomerProductActDeact(actCustId,"Y",strEnteredBy);
			out.println("<script>alert('Activated Successfully...');parent.location.href='ActiveDeactive.jsp'</script>");
		}else if("deactiveProduct".equalsIgnoreCase(page_cmd)){
			CustomerCreation custActiveDeactive = new CustomerCreation();
			String deactCustId = request.getParameter("deActProCustId");
			custActiveDeactive.ChangeCustomerProductActDeact(deactCustId,"N",strEnteredBy);
			out.println("<script>alert('Deactivated Successfully...');parent.location.href='ActiveDeactive.jsp'</script>");
		} else if("editShoppyDetails".equalsIgnoreCase(page_cmd)){
			CustomerCreation editCustomerDetails = new CustomerCreation();
			String editShopId = request.getParameter("editId");
			String editShopUserId = request.getParameter("editshopId");
			String editShopFullName = request.getParameter("editShopFullName");
			String editShopPlace = request.getParameter("editShopPlace");
			String editShopCity = request.getParameter("editShopCity");
			editCustomerDetails.EditShoppyDetails(editShopId,editShopUserId,editShopFullName,editShopPlace,editShopCity,strEnteredBy);
			out.println("<script>alert('Updated Successfully...');parent.location.href='EditShoppyDetails.jsp'</script>");
		}
	
	%>
</body>
</html>