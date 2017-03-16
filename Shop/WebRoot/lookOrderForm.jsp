<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="loginBean" class="mybean.data.Login" scope="session"></jsp:useBean>
<%@ page import="java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>显示订单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@  include file="head.txt"%>
</head>
<body background="image/back.jpg">
	<div align="center">
		<%
			if (loginBean == null) {
				response.sendRedirect("login.jsp");
			} else {
				boolean b = loginBean.getLogname() == null
						|| loginBean.getLogname().length() == 0;
				if (b) {
					response.sendRedirect("login.jsp");
				}
			}
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
			}
			try {
				String uri = "jdbc:mysql://127.0.0.1/shop";
				String user = "root";
				String password = "zy159357";
				con = DriverManager.getConnection(uri, user, password);
				sql = con.createStatement();
				String cdn = "select id,mess,sum from orderform where logname='"
						+ loginBean.getLogname() + "'";
				rs = sql.executeQuery(cdn);
				out.print("<table border='2'>");
				out.print("<tr>");
				out.print("<th width='100px'>订单号</th>");
				out.print("<th width='100px'>信息</th>");
				out.print("<th width='100px'>价格</th>");
				out.print("</tr>");
				while (rs.next()) {
					out.print("<tr>");
					out.print("<td>" + rs.getString(1) + "</td>");
					out.print("<td>" + rs.getString(2) + "</td>");
					out.print("<td>" + rs.getString(3) + "</td>");
					out.print("</tr>");
				}
				out.print("</table>");
				con.close();
			} catch (SQLException e) {
				out.print(e);
			}
		%>
	</div>
</body>
</html>
