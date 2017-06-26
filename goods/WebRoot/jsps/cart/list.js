/**
 * 
 */
$(function() {

	// 总计
	$(".price_t").text(price.toFixed(2) + "¥");
	// 全选按钮
	$("#selectAll").click(function() {
		if ($("#selectAll").attr("checked")) {
			$(":checkbox[name=checkboxBtn]").attr("checked", true);
		} else {
			$(":checkbox[name=checkboxBtn]").attr("checked", false);
		}
	});
});

function deleteCarItem(deleteA) {
	return confirm("确定删除吗？");
}