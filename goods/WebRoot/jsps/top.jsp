<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>top</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/css.css'/>">
<script type="text/javascript"
	src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<style type="text/css">
body {
	background: #15B69A;
	margin: 0px;
	color: #ffffff;
}

a {
	text-transform: none;
	text-decoration: none;
	color: #ffffff;
	font-weight: 900;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>

<body>
	<h1 style="text-align: center;">网上书城系统</h1>
	<div style="font-size: 10pt; line-height: 10px;">

		&nbsp;&nbsp;&nbsp;&nbsp;<a
			href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">会员登录</a>
		|&nbsp; <a href="<c:url value='/jsps/user/regist.jsp'/>"
			target="_parent">注册会员</a>&nbsp;
		<c:if test="${sessionScope.user.loginname!=null}">会员：${sessionScope.user.loginname},欢迎登录！&nbsp;&nbsp;|&nbsp;&nbsp; <a
				href="<c:url value='/cartitem/getcartitems/${sessionScope.user.uid}'/>" target="body"> 我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a
				href="<c:url value='/jsps/order/list.jsp'/>" target="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/jsps/user/pwd.jsp'/>" target="body">修改密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent"
				id="exit">退出</a>
		</c:if>

	</div>
	<script type="text/javascript">
		//用户退出
		$("#exit").click(function() {
			var flag = confirm("是否确认退出");
			if (!flag) {
				return false;
			}
			$(this).attr("href", "<c:url value='/user/exit'/>");
		});
	</script>
</body>
</html>
