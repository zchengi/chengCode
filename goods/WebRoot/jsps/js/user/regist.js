/**
 * 与用户注册相关的
 */

$(function() {

	/**
	 * 注册提交按钮的图片切换
	 */
	$("#submitBtn").hover(function() {
		// 鼠标移入5
		$(this).attr("src", "/goods/images/regist2.jpg");
	}, function() {
		// 鼠标移除
		$(this).attr("src", "/goods/images/regist1.jpg");
	});

	/**
	 * 提示信息的隐藏和显示
	 */
	$(".errorClass").each(function() {
		showError($(this));
	});

	/**
	 * 获取焦点后 自动隐藏提示信息
	 */
	$(".inputClass").focus(function() {
		var labelId = $(this).attr("id") + "Error";
		// 强制删除label中的text
		$("#" + labelId).text("");
		showError($("#" + labelId));
	});

	/**
	 * 失去焦点后验证
	 */
	$(".inputClass").blur(function() {
		eval("yanzheng" + $(this).attr("id") + "();");
	});

	/**
	 * 用户注册提交表单
	 */
	$("#submitBtn").click(
			function() {
				var flag = yanzhengloginname() && yanzhengloginpass
						&& yanzhengreloginpass() && yanzhengemail()
						&& yanzhengverifyCode();
				if (flag) {
					return true;
				}
				alert("输入信息有误，请重新输入！");
				return false;
			});
});

/**
 * 验证码换一张功能
 */
function _hyz() {
	$("#imgVerifyCode").attr("src",
			"/goods/validate/getverify?" + new Date().getMilliseconds());
}

/**
 * 显示错误信息
 */
function showError(element) {
	var value = element.text();
	element.removeClass("successClass").addClass("errorClass");
	// console.log(value);
	if (!value) {
		element.css("display", "none");
	} else {
		element.css("display", "");
	}
}
/**
 * 显示输入正确
 */
function showSuccess(element) {
	var value = element.text();
	element.removeClass("errorClass").addClass("successClass").css("display",
			"");
}

/**
 * 验证用户名
 */
function yanzhengloginname() {
	var res = false;
	// 1.是否为空
	var loginname = $("#loginname").val();
	if (!loginname) {
		$("#loginnameError").text("用户名不能为空！");
		showError($("#loginnameError"));
		return false;
	}
	// 2.数据长度
	if (loginname.length < 2 || loginname.length > 13) {
		$("#loginnameError").text("用户名必须是2-13位！");
		showError($("#loginnameError"));
		return false;
	}

	// 3.前后台用ajax异步交互
	$.ajax({
		data : "loginname=" + loginname,
		dataType : "text",
		// 是否缓存
		cache : false,
		type : "post",
		async : false,
		url : "/goods/validate/valiloginname",
		success : function(flag) {
			if (flag == 1) {
				$("#loginnameError").text("用户名已存在！");
				showError($("#loginnameError"));
				res = false;
			} else {
				showSuccess($("#loginnameError"));
				res = true;
			}
		}
	});
	return res;
}

/**
 * 验证密码
 */
function yanzhengloginpass() {
	// 1.是否为空
	var loginpass = $("#loginpass").val();
	if (!loginpass) {
		$("#loginpassError").text("密码不能为空！");
		showError($("#loginpassError"));
		return false;
	}
	// 2.是否为6-12位
	if (loginpass.length < 2 || loginpass.length > 12) {
		$("#loginpassError").text("密码必须为6-12位！");
		showError($("#loginpassError"));
		return false;
	}
	showSuccess($("#loginpassError"));
	return true;
}
/**
 * 验证确认密码
 */
function yanzhengreloginpass() {
	// 1.是否为空
	var reloginpass = $("#reloginpass").val();
	if (!reloginpass) {
		$("#reloginpassError").text("密码不能为空！");
		showError($("#reloginpassError"));
		return false;
	}
	// 2.验证两次密码是否相同
	if (reloginpass != $("#loginpass").val()) {
		$("#reloginpassError").text("两次密码不一致，请重新输入！");
		showError($("#reloginpassError"));
		return false;
	}
	showSuccess($("#reloginpassError"));
	return true;
}
/**
 * 验证邮箱
 */
function yanzhengemail() {
	var res = false;
	// 1.验证邮箱是否为空
	var email = $("#email").val();
	if (!email) {
		$("#emailError").text("邮箱不能为空！");
		showError($("#emailError"));
		return false;
	}
	// 2.验证邮箱格式
	var reg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
	if (!reg.test(email)) {
		$("#emailError").text("请输入正确的邮箱格式！");
		showError($("#emailError"));
		return false;
	}alert(email);
	// 3.验证邮箱是否唯一
	$.ajax({
		async : false,
		cache : false,
		data : {
			"email" : email
		},
		dataType : "json",
		type : "post",
		url : "/goods/validate/valiemail",
		success : function(flag) {
			if (flag) {
				showSuccess($("#emailError"));
				res = true;
			} else {
				$("#emailError").text("邮箱已存在,请输入其他邮箱！");
				showError($("#emailError"));
				res = false;
			}
		}
	});
	return res;
}
/**
 * 验证验证码
 */
function yanzhengverifyCode() {
	// 1.验证验证码是否为空且是否为4位
	var res = false;
	var verifyCode = $("#verifyCode").val();
	if (!verifyCode || verifyCode.length != 4) {
		$("#verifyCodeError").text("验证码不能为空且必须是4位！");
		showError($("#verifyCodeError"));
		return false;
	}
	// 2.验证验证码是否正确
	$.ajax({
		data : "verifyCode=" + verifyCode,
		dataType : "text",
		cache : false,
		type : "post",
		async : false,
		url : "/goods/validate/valiverifycode",
		success : function(flag) {
			if (flag == "true") {
				showSuccess($("#verifyCodeError"));
				res = true;
			} else {
				$("#verifyCodeError").text("验证码错误,请重新输入！");
				showError($("#verifyCodeError"));
				res = false;
			}
		}
	});
	return res;
}
