<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'mgs.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>
<style type="text/css">
body {
	background: rgb(254, 238, 189);
}

ul, li {
	list-style: none;
}
</style>
<body>
	<h2>${msg}</h2>
	<c:if test="${link!= null}">
		<ul>
			<li><a href="${link}">返回</a></li>
		</ul>
	</c:if>
</body>
</html>
