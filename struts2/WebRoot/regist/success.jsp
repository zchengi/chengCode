<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功页面</title>
	<script type="text/javascript">
		function reLogin(){
			window.location.href="${pageContext.request.contextPath }/login/login.jsp";
			window.open("","_self");
		}
		function closeWin(){
			window.self.close();
		}
	</script>
</head>
<body>
    <h1>用户：${sessionScope.username }，您添加成功了！!!</h1>
    <h2><a href="${pageContext.request.contextPath }/user_list.action">显示用户</a></h2>
	<input type="button" value="返回登录" onclick="reLogin();"/> &nbsp;&nbsp;&nbsp;
	<input type="button" value="退出" onclick="closeWin();"/>
</body>
</html>