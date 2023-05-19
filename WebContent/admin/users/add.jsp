<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/admin/css/Style.css" type="text/css" rel="stylesheet">
</HEAD>
<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/addUser" method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加用户</STRONG> </strong>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">用户姓名：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="username" class="bg" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">密码：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="password" class="bg" />
				</td>
			</tr>
			<tr>	
				<td align="center" bgColor="#f5fafe" class="ta_01">性别：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="gender" class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">活动码：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="activeCode" class="bg" />
				</td>
			</tr>	
			<tr>	
				<td align="center" bgColor="#f5fafe" class="ta_01">邮件：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="email" class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">联系方式：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="telephone" class="bg" />
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
					<input type="text" name="registTime" class="bg" />
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
					<textarea name="introduce" cols="30" rows="3" style="WIDTH: 96%"></textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<input type="submit" class="button_ok" value="确定">	
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置" class="button_cancel">					
					<FONT face="宋体">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</FONT> 
					<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>