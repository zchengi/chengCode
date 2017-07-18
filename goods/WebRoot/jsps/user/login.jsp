<%@page import="com.cheng.domain.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    
<title>登录</title>
    
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/user/login.css'/>">

<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"  src="/goods/jsps/js/user/login.js"></script>
</head>
<%
	User user=(User) session.getAttribute("user");
	if(user!=null){
		response.sendRedirect("/goods/index.jsp");
		return  ;
 	}
 %>
<body>
<div class="main">
  <div><%-- <img src="<c:url value='/images/logo.gif'/>" /></div> --%>
  <div>
    <div class="imageDiv"><img class="img" src="<c:url value='/images/zj.png'/>"/></div>
       <div class="login1">
      <div class="login2">
           <div class="loginTopDiv">
             <span class="loginTop">会员登录</span>
             <span>
               <a href="<c:url value='/jsps/user/regist.jsp'/>" class="registBtn"></a>
             </span>
           </div>
           <div>
             <form target="_top" action="<c:url value='/user/login'/>" method="post" id="loginForm">
               <input type="hidden" name="method" value="" />
                 <table>
                   <tr>
                     <td width="50"></td>
                     <td><label class="error" id="msg">${msg}</label></td>
                   </tr>
                   <tr>
                     <td width="50">用户名</td>
                     <td><input class="input" type="text" name="loginname" id="loginname" value="${erruser.loginname}"/></td>
                   </tr>
                   <tr>
                     <td height="20">&nbsp;</td>
                     <td><label id="loginnameError" class="error"></label></td>
                   </tr>
                   <tr>
                     <td>密　码</td>
                     <td><input class="input" type="password" name="loginpass" id="loginpass" value="${erruser.loginpass}"/></td>
                   </tr>
                   <tr>
                     <td height="20">&nbsp;</td>
                     <td><label id="loginpassError" class="error"></label></td>
                   </tr>
                   <tr>
                     <td>验证码</td>
                     <td>
                       <input class="input yzm" type="text" name="verifyCode" id="verifyCode" value=""/>
                       <img id="vCode" src="<c:url value ='/validate/getverify'/>"/>
                       <a href="javascript:_hyz();">换张图</a>
                     </td>
                   </tr>
                   <tr>
                     <td height="20px">&nbsp;</td>
                     <td><label id="verifyCodeError" class="error"></label></td>
                   </tr>
                   <tr>
                     <td>&nbsp;</td>
                     <td align="left">
                       <input type="image" id="submit" src="<c:url value='/images/login1.jpg'/>" class="loginBtn"/>
                     </td>
                   </tr>																				
                </table>
             </form>
           </div>
         </div>
       </div>
     </div>
</div>
</body>
</html>
	