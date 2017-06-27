<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<script type="text/javascript">
		function reLogin(){
			window.location.href="${pageContext.request.contextPath }/login/login.jsp";
			window.open("","_self");
		}
		function closeWin(){
			window.self.close();
		}
	</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>返回页面</title>
</head>
<body>
	<h1>登录失败！！！</h1>
	<input type="button" value="重新登录" onclick="reLogin();"/> &nbsp;&nbsp;&nbsp;
	<input type="button" value="退出" onclick="closeWin();"/>
</body>
</html>