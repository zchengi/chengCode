/**
 * 
 */
$(function() {
	// 计算合计
	total();
	// 全选按钮
	$("#selectAll").click(function() {
		$(":checkbox[name=checkboxBtn]").each(function() {
			if ($("#selectAll").attr("checked")) {
				$(this).attr("checked", true);
			} else {
				$(this).attr("checked", false);
			}
		});
		total();
	});

	// 单选按钮
	$(":checkbox[name=checkboxBtn]").click(function() {
		if (!$(this).attr("checked")) {
			$("#selectAll").attr("checked", false);
		}
		total();
	});

	// 减一商品
	$(".jian").click(function() {
		var value = Number($(
				"#" + $(this).attr("jianid") + "quantity")
				.val());
		if (value == 1) {
			if (confirm("您确定删除该条目吗？")) {
				location.href = "/goods/cartitem/removecartitem/"
						+ $(this).attr("jianid");
			}
		} else {
			$("#" + $(this).attr("jianid") + "quantity").val(
					value - 1);
			var quantity = Number($(
					"#" + $(this).attr("jianid") + "quantity")
					.val());
			var currprice = Number($(
					"#" + $(this).attr("jianid") + "currprice")
					.text());
			var subtotal = round(quantity * currprice, 2);
			$("#" + $(this).attr("jianid") + "Total").text(
					subtotal);
			$.ajax({
				cache : false,
				async : false,
				type : "POST",
				dataType : "json",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify({
					'quantity' : quantity,
					'cartitemid' : $(this).attr("jianid")
				}),
				url : "/goods/cartitem/editcartitem/"
						+ $(this).attr("jianid"),
			});
		}
		total();
	});
	// 加一商品
	$(".jia").click(function() {
		var value = Number($("#" + $(this).attr("jianid") + "quantity")
				.val());
		$("#" + $(this).attr("jianid") + "quantity").val(value + 1);
		var quantity = Number($(
				"#" + $(this).attr("jianid") + "quantity").val());
		var currprice = Number($(
				"#" + $(this).attr("jianid") + "currprice").text());
		var subtotal = round(quantity * currprice, 2);
		$("#" + $(this).attr("jianid") + "Total").text(subtotal);
		$.ajax({
			cache : false,
			async : false,
			type : "POST",
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify({
				'quantity' : quantity,
				'cartitemid' : $(this).attr("jianid")
			}),
			url : "/goods/cartitem/editcartitem/"
					+ $(this).attr("jianid")
		});
		total();
	});
});

/**
 * 结算功能
 */
function accounts() {
	var ids = new Array();
	$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
		ids.push($(this).attr("id"));
	});
	// 数组转换为字符串
	// ids=ids.join(",");

	// 用form表单提交
	$("#ids").attr("value", ids);
	$("#form1").submit();

	// console.log(ids);
	// console.log(JSON.stringify(ids));
	/*
	 * $.ajax({ cache : false, async : false, type : "POST", dataType : "json",
	 * contentType : "application/json;charset=utf-8", data :
	 * JSON.stringify(ids), url : "/goods/cartitem/accounts2", });
	 */

}

/**
 * 批量删除
 */
function deleteAll(path) {
	if (confirm("您确定删除选中的条目吗？")) {
		var ids = new Array();
		$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
			ids.push($(this).attr("id"));
		});
		location.href = path + "/cartitem/deletecartitems?ids=" + ids;
		return true;
	} else {
		return false;
	}
}

/**
 * 删除按钮的单机事件
 */
function deleteCarItem() {
	return confirm("确定删除吗？");
}

/**
 * 计算总计
 */
function total() {
	var sum = 0;
	$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
		var value = Number($("#" + $(this).attr("id") + "Total").text());
		sum += value;
	});
	// $("#total").text(round(sum,2));
	$("#total").text(sum.toFixed(2));

}
