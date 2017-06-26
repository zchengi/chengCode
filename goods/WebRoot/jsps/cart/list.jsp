<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>cartlist.jsp</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script src="<c:url value='/js/round.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/jsps/cart/list.js' />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/jsps/css/cart/list.css'/>">

</head>
<body>
	<c:choose>
		<c:when test="${fn:length(cartItems) ==0}">
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right"><img align="top"
						src="<c:url value='/images/icon_empty.png'/>" /></td>
					<td><span class="spanEmpty">您的购物车中暂时没有商品</span></td>
				</tr>
			</table>
		</c:when>

		<c:otherwise>
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr align="center" bgcolor="#efeae5">
					<td align="left" width="50px"><input type="checkbox"
						id="selectAll" checked="checked" /><label for="selectAll">全选</label>
					</td>
					<td colspan="2">商品名称</td>
					<td>单价</td>
					<td>数量</td>
					<td>小计</td>
					<td>操作</td>
				</tr>
				<script>
					var price = 0;
				</script>
				<c:forEach items="${cartItems}" var="cartItem">
					<tr align="center">
						<td align="left"><input id="${cartItem.cartItem.cartitemid}"
							;
							value="${cartItem.cartItem.cartitemid}" type="checkbox"
							name="checkboxBtn" checked="checked" /></td>
						<td align="left" width="70px"><a class="linkImage"
							href="<c:url value='/book/selectbybid/${cartItem.bid}'/>"><img
								border="0" width="54" align="top"
								src="<c:url value='/${cartItem.imageB}'/>" /></a></td>
						<td align="left" width="400px"><a
							href="<c:url value='/book/selectbybid/${cartItem.bid}'/>"> <span>${cartItem.bname}</span>
						</a></td>
						<td><span>&yen;<span class="currPrice"
								id="${cartItem.currprice}">${cartItem.currprice}</span></span></td>
						<td><a class="jian"
							href="<c:url value='/cartitem/editcartitem?cartitemid=${cartItem.cartItem.cartitemid}&quantity=${cartItem.cartItem.quantity-1}'/>"></a><input
							class="quantity" readonly="readonly" type="text"
							value="${cartItem.cartItem.quantity}" /><a class="jia"
							href="<c:url value='/cartitem/editcartitem?cartitemid=${cartItem.cartItem.cartitemid}&quantity=${cartItem.cartItem.quantity+1}'/>"></a></td>
						<td width="100px"><span class="price_n">&yen;<span
								class="subTotal">${cartItem.subTotal}</span></span></td>
						<td><a
							href="<c:url value='/cartitem/removecartitem/${cartItem.cartItem.cartitemid}'/>"
							id="del${cartItem.cartItem.cartitemid}"
							onclick="return deleteCarItem(this);">删除</a></td>
					</tr>
					<script>
						price = price + ${cartItem.subTotal};
					</script>
				</c:forEach>
				</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="4" class="tdBatchDelete"><a
						href="javascript:alert('批量删除成功');">批量删除</a></td>
					<td colspan="3" align="right" class="tdTotal"><span>总计：</span><span
						class="price_t">&yen;</span></td>
				</tr>
				<tr>
					<td colspan="7" align="right"><a
						href="<c:url value='/jsps/cart/showitem.jsp'/>" id="jiesuan"
						class="jiesuan"></a></td>
				</tr>
			</table>
			<form id="form1" action="<c:url value='/jsps/cart/showitem.jsp'/>"
				method="post">
				<input type="hidden" name="cartItemIds" id="cartItemIds" /> <input
					type="hidden" name="method" value="loadCartItems" />
			</form>
</body>
</html>