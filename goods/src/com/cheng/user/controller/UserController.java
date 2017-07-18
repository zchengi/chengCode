package com.cheng.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cheng.domain.User;
import com.cheng.user.serviceImpl.UserServiceImpl;
import com.cheng.user.vo.UserPwdVo;

/**
 * 用户注册控制层
 */
@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	/**
	 * 用户注册
	 */
	@RequestMapping(value = "/reguser", method = RequestMethod.POST)
	public String regUser(User user, Model model) {
		userService.regUser(user);
		model.addAttribute("code", "success");
		model.addAttribute("msg", "注册成功，请前往邮箱激活！");
		return "jsps/msg";
	}

	/**
	 * 用户激活
	 */
	@RequestMapping(value = "/activation", method = RequestMethod.GET)
	public String activation(String activationCode, Model model) {
		List<String> msg = userService.activation(activationCode);
		model.addAttribute("code", msg.get(0));
		model.addAttribute("msg", msg.get(1));
		return "jsps/msg";
	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, Model model, HttpSession session) {
		User u = userService.login(user);
		if (u.getStatus() == null) {
			model.addAttribute("erruser", user);
			model.addAttribute("msg", "用户名或密码错误！");
			return "jsps/user/login";
		} else if (!u.getStatus()) {
			model.addAttribute("erruser", user);
			model.addAttribute("msg", "该用户尚未激活！");
			return "jsps/user/login";
		}
		session.setAttribute("user", u);
		return "redirect:/jsps/main.jsp";
	}

	/**
	 * 用户修改密码
	 */
	@RequestMapping(value = "/editpwd/{uid}", method = RequestMethod.PUT)
	public String editPwd(UserPwdVo vo, @PathVariable String uid, Model model,
			HttpSession session) {
		boolean flag = userService.editPwd(vo, uid);
		if (flag) {
			session.invalidate();
			model.addAttribute("msg", "密码修改成功！");
			model.addAttribute("code", "success");
		} else {
			model.addAttribute("msg", "密码修改失败！");
			model.addAttribute("code", "error");
		}
		return "jsps/msg";
	}

	/**
	 * 用户退出
	 */
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		// return "redirect:/jsps/user/login.jsp";
		return "redirect:/index.jsp";
	};
}
