<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户编辑页面</title>
	<script type="text/javascript">
		function reLogin(){
			window.location.href="${pageContext.request.contextPath }/login/login.jsp";
			window.open("","_self");
		}
		function closeWin(){
			window.self.close();
		}
		function backward(){
			window.location.href="${pageContext.request.contextPath }/user_list.action";
			window.open("","_self");
		}
	</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user_edit.action" method="post">
		<table border="1" bordercolor="blue" width="300">
			<tr>
				<td colspan="2" align="center">修改个人信息</td>
			</tr>
			<tr>
				<!-- 隐藏员工id -->
				<s:hidden name="id" value="%{model.id}"></s:hidden>
				<s:textfield name="num" value="%{model.num}" label="学号"/>
			</tr>
			<tr>
				<s:textfield name="name" value="%{model.name}" label="姓名 "/>
			</tr>
			<tr>
				<s:password name="pass" value="%{model.pass}" showPassword="true" label="密码 "/>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交" /> &nbsp;&nbsp;
					<input type="reset" value="重置" /> 
				</td>
			</tr>
		</table>
	</form>
	<br/>
   <input type="button" value="返回上一级" onclick="backward();"/> &nbsp;&nbsp;
   <input type="button" value="返回登录" onclick="reLogin();"/> &nbsp;&nbsp;
   <input type="button" value="退出" onclick="closeWin();"/>
</body>
</html>