<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册页面</title>
	<script type="text/javascript">
	function reRegist(){
		window.location.href="${pageContext.request.contextPath }/regist/regist.jsp";
		window.open("","_self");
	}
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
<s:fielderror/>
	<form action="${pageContext.request.contextPath }/user_regist.action" method="post">
		<table border="1" bordercolor="blue" width="300">
			<tr>
				<td colspan="2" align="center">欢迎注册</td>
			</tr>
			<tr>
				<s:textfield name="name" label="用户名"/>
			</tr>
			<tr>
				<s:password name="pass" label="密码 "/>
			</tr>
			<tr>
				<s:password name="repass" label="确认密码 "/>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交" /> &nbsp; &nbsp;
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
	<br/>
   <input type="button" value="重新注册" onclick="reRegist();"/> &nbsp;&nbsp;
   <input type="button" value="返回登录" onclick="reLogin();"/> &nbsp;&nbsp;
   <input type="button" value="退出" onclick="closeWin();"/>
</body>
</html>