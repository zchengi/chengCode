<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>">
<script type="text/javascript">
	function _go() {
		var pc = $("#pageCode").val();//获取文本框中的当前页码
		if (!/^[1-9]\d*$/.test(pc)) {//对当前页码进行整数校验
			alert('请输入正确的页码！');
			return;
		}
		if (pc > ${page.pages}) {//判断当前页码是否大于最大页
			alert('页码超出范围！');
			return;
		}
		location = "<c:url value='/book/pagehelper?page=" + pc
				+ "&cid=${books[0].cid}'/>";
	}
</script>

<div class="divBody">
	<%--上一页 --%>
	<div class="divContent">
		<c:choose>
			<c:when test="${page.isFirstPage}">
				<span class="spanBtnDisabled">上一页</span>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/book/pagehelper?page=${page.prePage}&cid=${books[0].cid}'/>" class="aBtn">上一页</a>
			</c:otherwise>
		</c:choose>
		
		<%-- 显示页码列表，共显示6页 --%>
		<c:choose>
			<c:when test="${page.pages <= 6 }">
				<c:set var="begin" value="1" />
				<c:set var="end" value="${page.pages}" />
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${page.pageNum-2 }" />
				<c:set var="end" value="${page.pageNum + 3}" />
				<c:if test="${begin < 1 }">
					<c:set var="begin" value="1" />
					<c:set var="end" value="6" />
				</c:if>
				<c:if test="${end > page.pages }">
					<c:set var="begin" value="${page.pages-5 }" />
					<c:set var="end" value="${page.pages }" />
				</c:if>
			</c:otherwise>
		</c:choose>
		
		<c:forEach begin="${begin}" end="${end}" var="i">
			<c:choose>
				<c:when test="${i eq page.pageNum}">
					<span class="spanBtnSelect">${i}</span>
				</c:when>
				<c:otherwise>
					<a href="<c:url value='/book/pagehelper?page=${i}&cid=${books[0].cid}'/>" class="aBtn">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<%-- 
			<span class="spanBtnSelect">1</span> <a href="" class="aBtn">2</a> 
			<a href="" class="aBtn">3</a> <a href="" class="aBtn">4</a>
			<span class="spanApostrophe">...</span>
			<a href="" class="aBtn">${page.pages}</a>
		--%>
		<%--下一页 --%>
		<c:choose>
			<c:when test="${page.isLastPage}">
				<span class="spanBtnDisabled">下一页</span>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/book/pagehelper?page=${page.nextPage}&cid=${books[0].cid}'/>" class="aBtn">下一页</a>
			</c:otherwise>
		</c:choose>
		&nbsp;&nbsp;&nbsp;&nbsp;

		<%-- 共N页 到M页 --%>
		<span>共 ${page.pages} 页</span> <span>跳至</span>
		<input type="text" class="inputPageCode" id="pageCode" value="1" /> 
		<span>页</span>
		<a href="javascript:_go();" class="aSubmit">确定</a>
	</div>
</div>