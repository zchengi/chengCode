<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>输入信息查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="head.txt"%>
</head>
<body background="image/back.jpg">
	<font size="2">
		<div align="center">
			<br>查询时可以输入化妆品的版本号或化妆品名称及价格。<br> 化妆品名称支持模糊查询。 <br>输入价格是在2个值之间的价格，格式是价格1-价格2<br>
			例如 258-689
			<form action="searchByConditionServlet" method="post">
				<br>输入查询信息<input type="text" name="searchMess"><br>
				<input type="radio" name="radio" value="cosmetic_number">化妆品版本号
				<input type="radio" name="radio" value="cosmetic_name" checked="checked">化妆品名称
				<input type="radio" name="radio" value="cosmetic_price">化妆品价格
				<br>
				<input type="submit" value="提交" name="sb">
			</form>
		</div>
	</font>
</body>
</html>
