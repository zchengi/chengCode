<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/jquery-1.5.1.js"></script>
</head>
<body>
	<p class="p1">p1</p>
	<p class="p1">p2</p>
	<p class="p1">p3</p>
	<p class="p1">p4</p>
	<p class="p1">p5</p>
	<script type="text/javascript">
		$(function() {
			$(".p1").each(function() {
				alert($(this).html());
			});
		});
	</script>
</body>
</html>