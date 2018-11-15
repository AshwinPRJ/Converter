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

<%@ page import="com.nviera.service.ItemCreation"%>
<%
	/* String strEnteredBy=session.getAttribute("AdminSessionId").toString(); */
	String strEnteredBy = "Brahmani";
	String page_cmd = request.getParameter("page_cmd");
	String strItemId = request.getParameter("txtItemId"); 
	ItemCreation itemValid = new ItemCreation();
	if ("getItemDetails".equalsIgnoreCase(page_cmd)) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter outs = response.getWriter();
		JSONObject itemDetails = itemValid.ItemValidation(strItemId);
		outs.print(itemDetails);
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Creation Save</title>
</head>
<body>
	<%
		if("addNewItem".equalsIgnoreCase(page_cmd)){
			ItemCreation itemCreat = new ItemCreation();
			strItemId = request.getParameter("addItemId");
			double dbRetailmrp = Double.parseDouble(request.getParameter("addRetailermrp"));
			double dbWarehousemrp = Double.parseDouble(request.getParameter("addWarehousemrp"));
			itemCreat.ModifyItemList(strItemId,dbRetailmrp,dbWarehousemrp,strEnteredBy);
			out.println("<script>alert('Modified Successfully...');parent.location.href='ItemCreation.jsp'</script>");
		}else if("createNewItem".equalsIgnoreCase(page_cmd)){
			ItemCreation addItem = new ItemCreation();
			strItemId = request.getParameter("regItemname");
			String strretailermrp = request.getParameter("regRetailermrp");
			String strwarehousemrp = request.getParameter("regWarehousemrp");
			addItem.ItemAdd(strItemId,strretailermrp,strwarehousemrp,strEnteredBy);
			out.println("<script>alert('Item added Successfully...');parent.location.href='ItemCreation.jsp'</script>");
		}else if("delItem".equalsIgnoreCase(page_cmd)){
			ItemCreation itemDel = new ItemCreation();
			String delItemId = request.getParameter("txtdelItemId");			
			itemDel.ItemDeletion(delItemId,strEnteredBy);
			out.println("<script>alert('Deleted Successfully...');parent.location.href='ItemCreation.jsp'</script>");
		}else if("active".equalsIgnoreCase(page_cmd)){
			ItemCreation itemActiveDeactive = new ItemCreation();
			String actItemId = request.getParameter("actItemId");
			itemActiveDeactive.ChangeItemsActDeact(strItemId,"Y",strEnteredBy);
			out.println("<script>alert('Activated Successfully...');parent.location.href='ActiveDeactive.jsp'</script>");
		}else if("deactive".equalsIgnoreCase(page_cmd)){
			ItemCreation itemActiveDeactive = new ItemCreation();
			String deactItemId = request.getParameter("deActItemId");
			itemActiveDeactive.ChangeItemsActDeact(strItemId,"N",strEnteredBy);
			out.println("<script>alert('Deactivated Successfully...');parent.location.href='ActiveDeactive.jsp'</script>");
		}else if("activeProduct".equalsIgnoreCase(page_cmd)){
			ItemCreation itemActiveDeactive = new ItemCreation();
			String actItemId = request.getParameter("actProItemId");
			itemActiveDeactive.ChangProductActDeact(strItemId,"Y",strEnteredBy);
			out.println("<script>alert('Activated Successfully...');parent.location.href='ActiveDeactive.jsp'</script>");
		}else if("deactiveProduct".equalsIgnoreCase(page_cmd)){
			ItemCreation itemActiveDeactive = new ItemCreation();
			String deactItemId = request.getParameter("deActProItemId");
			itemActiveDeactive.ChangProductActDeact(strItemId,"N",strEnteredBy);
			out.println("<script>alert('Deactivated Successfully...');parent.location.href='ActiveDeactive.jsp'</script>");
		}
	
	%>
</body>
</html>