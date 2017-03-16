<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.Login"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="loginBean" class="mybean.data.Login" scope="session"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>查看产品细节</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="head.txt"%>
</head>

<body background="image/back.jpg">
	<center>
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
			String numberID = request.getParameter("xijie");
			out.print("<th>产品号" + numberID);
			if (numberID == null) {
				out.print("没有产品号，无法产看细节");
				return;
			}
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
			}
			String uri = "jdbc:mysql://127.0.0.1/shop";
			try {
				con = DriverManager.getConnection(uri, "root", "zy159357");
				sql = con.createStatement();
				String cdn = "select * from cosmeticForm where cosmetic_number='"
						+ numberID + "'";
				rs = sql.executeQuery(cdn);
				out.print("<table border=2>");
				out.print("<tr>");
				out.print("<th>产品号</th>");
				out.print("<th>名称</th>");
				out.print("<th>制造商</th>");
				out.print("<th>价格</th>");
				out.print("<th><font color=blue>放入购物车</font></th>");
				out.print("</tr>");
				String picture = "welcome.jpg";
				String detailMess = "";
				while (rs.next()) {
					String number = rs.getString(1);
					String name = rs.getString(2);
					String maker = rs.getString(3);
					String price = rs.getString(4);
					detailMess = rs.getString(5);
					picture = rs.getString(6);
					//便于购物车计算价格,尾缀上"#价格值"
					String goods = "(" + number + "," + maker + "," + price
							+ ")#" + price;
					goods = goods.replaceAll("\\p{Blank}", "");
					String button = "<form action='putGoodsServlet' method='post'>"
							+ "<input type='hidden' name='java' value= "
							+ goods
							+ ">"
							+ "<input type='submit' value='放入购物车'></form>";
					out.print("<tr>");
					out.print("<td>" + number + "</td>");
					out.print("<td>" + name + "</td>");
					out.print("<td>" + maker + "</td>");
					out.print("<td>" + price + "</td>");
					out.print("<td>" + button + "</td>");
					out.print("</tr>");
				}
				out.print("</table>");
				out.print("<br />产品详情：");
				out.print("<div align='center'>" + detailMess + "</div>");
				String pic = "<img src='image/" + picture
						+ "' width=260px height=200px />";
				out.print(pic);
				con.close();
			} catch (SQLException e) {
			}
		%>
	</center>
</body>
</html>
