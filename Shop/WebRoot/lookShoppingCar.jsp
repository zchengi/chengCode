<%@page import="sun.text.normalizer.UTF16"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.Login"%>
<<jsp:useBean id="loginBean" class="mybean.data.Login" scope="session"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>管理购物车</title>

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
			<%
				if (loginBean == null) {
					response.sendRedirect("login.jsp");//重定向到登录页面
				} else {
					boolean b = loginBean.getLogname() == null
							|| loginBean.getLogname().length() == 0;

					if (b) {
						response.sendRedirect("login.jsp");//重定向到登录页面
					}
				}
				LinkedList car = loginBean.getCar();
				if (car == null) {
					out.print("<h2>购物车没有物品。<h2>");
				} else {
					Iterator<String> iterator = car.iterator();
					StringBuffer buyGoods = new StringBuffer();
					int n = 0;
					double priceSum = 0;
					out.print("购物车中的物品：<table border=2>");
					while (iterator.hasNext()) {
						String goods = iterator.next();
						String showGoods = "";
						n++;
						//购物车后缀是"#价格数字"，比如"化妆品价格3390#3390"
						int index = goods.lastIndexOf("#");
						if (index != -1) {
							priceSum += Double.parseDouble(goods
									.substring(index + 1));
							showGoods = goods.substring(0, index);
						}
						buyGoods.append(n + "：" + showGoods);
						String del = "<form action='deleteServlet' method='post'>"
								+ "<input type='hidden' name='delete' value='"
								+ goods
								+ "'>"
								+ "<input type='submit' name='sub' value='删除'></form>";
						out.print("<tr><td>" + showGoods + "</td>");
						out.print("<td>" + del + "</td></tr>");
					}
					out.print("</table>");
					String orderForm = "<form action='buyServlet' method='post'>"
							+ "<input type='hidden' name='buy' value='" + buyGoods
							+ "'>" + "<input type='hidden' name='price' value='"
							+ priceSum + "'>"
							+ "<input type='submit' value='生成订单'></form>";
					out.print(orderForm);
					out.print(buyGoods);
				}
			%>

		</div>
	</font>
</body>
</html>
