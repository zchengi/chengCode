<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>选择分类</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="head.txt"%>
</head>
<body background="image/back.jpg">
	<font size="2"><br /> <br />
		<div align="center">
			<%
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (Exception e) {
				}
				String uri = "jdbc:mysql://127.0.0.1/shop?user=root&password=zy159357&characterEncoding=utf-8";
				Connection con;
				Statement sql;
				ResultSet rs;
				try {
					con = DriverManager.getConnection(uri);
					sql = con.createStatement();
					//读取classify表，获得分类
					rs = sql.executeQuery("select * from classify ");
					out.print("<form action='queryServlet' method='post'>");
					out.print("<select name='fenleiNumber'>");
					//boolean b = rs.next();
					//System.out.print(b);
					while (rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						out.print("<option value=" + id + ">" + name + "</option>");
					}
					out.print("</select>");
					out.print("<input type='submit' value='提交'>");
					out.print("</form>");
					con.close();
				} catch (Exception e) {
					out.print(e);
				}
			%>
		</div> </font>
</body>
</html>
