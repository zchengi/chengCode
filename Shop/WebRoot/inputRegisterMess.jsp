<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="userBean" class="mybean.data.Register" scope="request"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="head.txt"%>
<title>注册页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body background="image/back.jpg">
	<font size="2">
		<div align="center">
			<form action="registerServlet" method="post" name="form">
				<table>
					用户名由字母、数字、下划线构成，*注释的项必须填写
					<tr>
						<td>*用户名称：</td>
						<td><input type="text" name="logname"></td>
						<td>*用户密码：</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>*重复密码：</td>
						<td><input type="password" name="again_password"></td>
						<td>联系电话：</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td>邮寄地址：</td>
						<td><input type="text" name="address"></td>
						<td>真实姓名：</td>
						<td><input type="text" name="realname"></td>
						<td><input type="submit" name="g" value="提交"></td>
					</tr>
				</table>
			</form>
		</div>
		<div align="center">
			<p>
				注册反馈
				<jsp:getProperty property="backNews" name="userBean" /></p>
			<table border="2px">
				<tr>
					<td>会员名称：</td>
					<td><jsp:getProperty property="logname" name="userBean" /></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><jsp:getProperty property="realname" name="userBean" /></td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><jsp:getProperty property="address" name="userBean" /></td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><jsp:getProperty property="phone" name="userBean" /></td>
				</tr>
			</table>
		</div>
	</font>
</body>
</html>
