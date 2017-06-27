<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user_login.action" method="post">
		<table border="1" bordercolor="blue" width="300">
			<tr>
				<td colspan="2" align="center">欢迎登录</td>
			</tr>
			<tr>
				<s:textfield name="name" label="用户名"/>
			</tr>
			<tr>
				<s:password name="pass" label="密码 "/>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交" /> &nbsp;
					<input type="reset" value="重置" /> &nbsp;
					<a href="${pageContext.request.contextPath }/regist/regist.jsp">注册</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>