<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/admin/css/Style.css" type="text/css" rel="stylesheet">
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/public.js"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/check.js"></script>
	<script type="text/javascript">
		//设置用户类别的默认值
		function setUserRole(t) {
			var role = document.getElementById("role");
	
			var ops = role.options;
			for ( var i = 0; i < ops.length; i++) {
	
				if (ops[i].value == t) {
					ops[i].selected = true;
					return;
				}
			}
	
		};
		//设置状态码的默认值
		function setUserState(t) {
			var state = document.getElementById("state");
	
			var ops = state.options;
			for ( var i = 0; i < ops.length; i++) {
	
				if (ops[i].value == t) {
					ops[i].selected = true;
					return;
				}
			}
	
		};
		// 同时执行状态码和用户类别默认值函数
		function setValue(a,b) {
			setUserRole(a);
			setUserState(b);
		}
	</script>
</HEAD>

<body onload="setValue('${u.role}','${u.state }')">
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/manager/EditUserServlet" method="post">
		<input type="hidden" name="id" value="${u.id}" /> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26">
					<strong>编辑用户</strong>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">用户姓名：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="username" class="bg" value="${u.username }" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">密码：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="password" class="bg" value="${u.password }" />
				</td>
			</tr>
			<tr>	
				<td align="center" bgColor="#f5fafe" class="ta_01">性别：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="gender" class="bg" value="${u.gender }"/>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">活动码：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="activeCode" class="bg" value="${u.activeCode }" />
				</td>
			</tr>
			<tr>	
				<td align="center" bgColor="#f5fafe" class="ta_01">邮件：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="email" class="bg" value="${u.email }" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">联系方式：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="telephone" class="bg" value="${u.telephone }"  />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">用户类别：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="role" id="role">
						<option value="" selected="selected">--选择用户角色--</option>
						<option value="超级用户">超级用户</option>
						<option value="普通用户">普通用户</option>
					</select>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">注册时间：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="registTime" class="bg" value="${u.registTime }"/>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">状态码：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="state" id="state">
						<option value="" selected="selected">--选择状态码--</option>
						<option value="1">1</option>
						<option value="0">0</option>
					</select>
				</td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">介绍：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
					<textarea name="introduce" cols="30" rows="3" style="WIDTH: 96%">${u.introduce}</textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1">
					<img src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<input type="submit" class="button_ok" value="确定"> 
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置" class="button_cancel" /> 
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> 
					<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>