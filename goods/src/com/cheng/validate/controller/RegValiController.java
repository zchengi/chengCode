package com.cheng.validate.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yanzhengma.Verify;

import com.cheng.validate.service.ValidateService;

/**
 * 用户注册验证控制层
 */
@RequestMapping("/validate")
@Controller
public class RegValiController {

	@Autowired
	private ValidateService validateService;

	/**
	 * 获取验证码
	 */
	@RequestMapping(value = "/getverify", method = RequestMethod.GET)
	public void getVerify(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Verify.getVirify(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 验证用户名
	 */
	@RequestMapping(value = "/valiloginname", method = RequestMethod.POST)
	public void valiLoginName(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String loginname)
			throws IOException {
		response.getWriter().print(validateService.valiLoginName(loginname));
	}

	/**
	 * 验证邮箱
	 */
	@RequestMapping(value = "/valiemail", method = RequestMethod.POST)
	public @ResponseBody Boolean valiemail(String email) {
		boolean b = validateService.valiemail(email);
		return b;
	}

	/**
	 * 验证验证码
	 */
	@RequestMapping(value = "/valiverifycode", method = RequestMethod.POST)
	public @ResponseBody Boolean valiverifyCode(HttpSession session,
			String verifyCode) {
		String vcode = (String) session.getAttribute("vCode");
		return vcode.equalsIgnoreCase(verifyCode);
	}

}
