<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表页面</title>
	<script type="text/javascript">
		function reLogin(){
			window.location.href="${pageContext.request.contextPath }/login/login.jsp";
			window.open("","_self");
		}
		function closeWin(){
			window.self.close();
		}
	</script>
</head>
<body>
	<table border="1" bordercolor="blue" width="400">
		<tr>
			<td colspan="5" align="center" style="FONT-WEIGHT: bold; FONT-SIZE: 14pt; HEIGHT: 30px; BACKGROUND-COLOR: #993300;"><span style="color:#ffff66;">用户列表</span></td>
		</tr>
		<tr	style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
			<td align="center" width="20%">学号</td>
			<td align="center" width="30%">姓名</td>
			<td align="center" width="30%">密码</td>
			<td align="center" width="10%">删除</td>
			<td align="center" width="10%">修改</td>
		</tr>
		
		<s:iterator value="users" var="user">
			<tr onmouseover="this.style.backgroundColor = 'gray'"
				onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20%">
					<!-- user会push到root 同时 保存contextMap -->
					<!-- 可通过root栈显示，如：<s:property value="id"/>；下边的是通过 map栈显示-->
					<s:property value="#user.num"/>
				</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="30%">
					<s:property value="#user.name"/>
				</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="30%">
					<s:property value="#user.pass"/>
				</td>
				<td align="center" style="HEIGHT: 22px">
					<s:a action="user_delete" namespace="/">
						<s:param name="id" value="#user.id" />
						删除
					</s:a>
				</td>
				<td align="center" style="HEIGHT: 22px">
					<s:a action="user_editview" namespace="/">
						<s:param name="id" value="#user.id" />
						修改
					</s:a>
				</td>
			</tr>
		</s:iterator>		
	</table>
	<br/>
	<input type="button" value="重新登录" onclick="reLogin();"/> &nbsp;&nbsp;&nbsp;
	<input type="button" value="退出" onclick="closeWin();"/>
</body>
</html>