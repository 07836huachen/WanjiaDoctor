<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
/**
 * my_click和my_blur均是用于前台页面搜索框的函数
 */
//鼠标点击搜索框时执行
function my_click(obj, myid){
	//点击时，如果取得的值和搜索框默认value值相同，则将搜索框清空
	if (document.getElementById(myid).value == document.getElementById(myid).defaultValue){
	  document.getElementById(myid).value = '';
	  obj.style.color='#000';
	}
}
//鼠标不聚焦在搜索框时执行
function my_blur(obj, myid){
	//鼠标失焦时，如果搜索框没有输入值，则用搜索框的默认value值填充
	if (document.getElementById(myid).value == ''){
	 document.getElementById(myid).value = document.getElementById(myid).defaultValue;
	 obj.style.color='#999';
 }
}

/**
 * 点击搜索按钮执行的函数
 */
function search(){
	document.getElementById("searchform").submit();
}
</script>
<%!
public String convert(String data){
	String str="";
	for(int i=0;i<data.length();i++){
		str+="/u"+Integer.toHexString(data.charAt(i));
	}
	String context="http://localhost:8080/itcaststore";
	String address=context+"/showProductByPage?category="+str;
	return address;
}
%>
<div id="divmenu">
		<a href="<%=convert("内科") %>">内科</a> 
		<a href="<%=convert("外科") %>">外科</a> 
		<a href="<%=convert("全科") %>">全科</a> 
		<a href="<%=convert("眼科") %>">眼科</a> 
		<a href="<%=convert("儿科") %>">儿科</a>
		<a href="<%=convert("急诊科") %>">急诊科</a> 
		<a href="<%=convert("皮肤科") %>">皮肤科</a> 
		<a href="<%=convert("麻醉科") %>">麻醉科</a> 
		<a href="<%=convert("病理科") %>">病理科</a>
		<a href="<%=convert("康复科") %>">康复科</a> 
		<a href="<%=convert("妇产科") %>">妇产科</a> 
		<a href="<%=convert("神经内科") %>">神经内科</a> 
		<a href="<%=convert("耳鼻喉科") %>">耳鼻喉科</a>
		<a href="<%=convert("其它") %>">其它</a> 
		<a href="<%=convert("全部商品") %>" style="color:#b4d76d">全部可签约医生目录</a>
</div>
<div id="divsearch">
<form action="${pageContext.request.contextPath }/MenuSearchServlet" id="searchform">
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td style="text-align:right; padding-right:220px">
				Search 
				<input type="text" name="textfield" class="inputtable" id="textfield" value="请输入姓名"
				onmouseover="this.focus();"
				onclick="my_click(this, 'textfield');"
				onBlur="my_blur(this, 'textfield');"/> 
				<a href="#">
					<img src="${pageContext.request.contextPath}/client/images/serchbutton.gif" border="0" style="margin-bottom:-4px" onclick="search()"/> 
				</a>
			</td>
		</tr>
	</table>
</form>
</div>