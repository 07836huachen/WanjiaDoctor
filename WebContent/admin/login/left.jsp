<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>菜单</title>
	<link href="${pageContext.request.contextPath}/admin/css/left.css" rel="stylesheet" type="text/css">
</head>
	<body>
		<table width="100" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td height="12"></td>
		  </tr>
		</table>
		<table width="100%" border="0">
			  <tr>
			  	<td><a href="${pageContext.request.contextPath}/listProduct" target="mainFrame" class="left_list">家庭医生管理</a></td>
			  </tr>
			  <tr>
			  	<td><a href="${pageContext.request.contextPath}/admin/products/download.jsp" target="mainFrame" class="left_list">签约榜单</a></td>
			  </tr>
			  <tr>
			  	<td><a href="${pageContext.request.contextPath}/findOrders" target="mainFrame" class="left_list">签约管理</a></td>
			  </tr>
			  <tr>
			  	<td><a href="${pageContext.request.contextPath}/manager/ListUserServlet" target="mainFrame" class="left_list">家庭用户管理</a></td>
			  </tr>
			  <tr>
			  	<td><a href="${pageContext.request.contextPath}/manager/ListNoticeServlet" target="mainFrame" class="left_list">系统公告管理</a></td>
			  </tr>
		</table>
	</body>
</html>
