/**
 * 验证码换一张功能
 */
function _change() {
	$("#vCode").attr("src",
			"/goods/validate/getverify?" + new Date().getMilliseconds());
}
