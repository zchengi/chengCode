<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>订单详细</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/order/desc.css'/>">
</head>
<body>
<div class="divOrder">
	<span>
		订单号：${dingdan.oid}
		<c:choose>
			<c:when test="${dingdan.status eq  1 }">(等待付款)</c:when>
			<c:when test="${dingdan.status eq  2 }">(准备发货)</c:when>
			<c:when test="${dingdan.status eq  3 }">(等待确认)</c:when>
			<c:when test="${dingdan.status eq  4 }">(交易成功)</c:when>
			<c:when test="${dingdan.status eq  5 }">(已取消)</c:when>
		</c:choose>
		下单时间：${dingdan.ordertime}
	</span>
</div>
<div class="divRow">
	<div class="divContent">
		<dl>
			<dt>收货人信息</dt>
			<dd>${orderitem.address}</dd>
		</dl>
	</div>
	<div class="divContent">
		<dl>
			<dt>商品清单</dt>
			<dd>
				<table cellpadding="0" cellspacing="0">
					<tr>
						<th class="tt">商品名称</th>
						<th class="tt" align="left">单价</th>
						<th class="tt" align="left">数量</th>
						<th class="tt" align="left">小计</th>
					</tr>

					<c:forEach items="${dingdan.orderitems}" var="orderitem">
						<tr style="padding-top: 20px; padding-bottom: 20px;">
							<td class="td" width="400px">
								<div class="bookname">
									<img align="middle" width="70" src="<c:url value='/${orderitem.imageB}'/>" />
									<a href="<c:url value='/book/selectbybid/${orderitem.bid}'/>">${orderitem.bname}</a>
								</div>
							</td>
							<td class="td"><span>&yen;${orderitem.currprice}</span></td>
							<td class="td"><span>${orderitem.quantity}</span></td>
							<td class="td"><span>&yen;${orderitem.subtotal}</span></td>
						</tr>
					</c:forEach>
					
				</table>
			</dd>
		</dl>
	</div>
	<div class="divBtn">
		<span class="spanTotal">合 计：</span>
		<span class="price_t">&yen;${dingdan.total}</span><br />
		<c:if test="${dingdan.status eq 2  }">
			<a id="deliver" href="<c:url value='/ordermanage/deliver/${dingdan.oid }'/>">发　　货</a>
		</c:if>
		<c:if test="${dingdan.status eq 1  }">
			<a id="cancel" href="<c:url value='/ordermanage/cancel/${dingdan.oid }'/>">取　　消</a>
		</c:if>
	</div>
</div>
</body>
</html>

