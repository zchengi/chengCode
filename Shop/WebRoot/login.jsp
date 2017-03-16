<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="loginBean" class="mybean.data.Login" scope="session"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="head.txt"%>
</head>

<body background="image/back.jpg">
	<div align="center">
		<form action="loginServlet" method="post">
			<table border="2px">
				<tr>
					<th colspan="2">登录</th>
				</tr>
				<tr>
					<td>登录名称：</td>
					<td><input type="text" name="logname"></td>
				</tr>
				<tr>
					<td>输入密码：</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<input type="submit" value="提交">
		</form>
	</div>
	<div align="center">
		登录反馈信息：<jsp:getProperty property="backNews" name="loginBean" />
		<br />登录名称：<jsp:getProperty property="logname" name="loginBean" />
	</div>
</body>
</html>
