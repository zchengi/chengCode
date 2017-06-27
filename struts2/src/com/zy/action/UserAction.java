package com.zy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.zy.pojo.User;
import com.zy.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();

	@Override
	public User getModel() {
		
		return user;
	}

	// 员工登陆
	// 修改workflow拦截器的跳转视图，使用@InputConfig(resultName = "loginINPUT")
	@InputConfig(resultName = "loginINPUT")
	public String login() {
		// 登陆数据 已经在 user中，传递业务层，查询
		UserService userService = new UserService();
		User logonUser = userService.login(user);
		// 判断是否登陆成功
		if (logonUser == null) {
			// 登陆失败
			return "loginINPUT";
		} else {
			// 登陆成功
			ServletActionContext.getRequest().getSession()
					.setAttribute("user", logonUser);
			return "loginSUCCESS";
		}
	}

	// 员工注册
	@InputConfig(resultName = "registINPUT")
	public String regist() {
		// 获取浏览器传过来的请求数据
		String username = ServletActionContext.getRequest()
				.getParameter("name");
		ServletActionContext.getRequest().getSession()
				.setAttribute("username", username);

		// 添加用户
		UserService userService = new UserService();
		userService.add(user);

		return "registSUCCESS";
	}

	// 员工显示
	public String list() {
		// 所有添加参数都被封装 model对象
		UserService userService = new UserService();

		// 获得查询结果，将结果传递给jsp (值栈)
		users = userService.list(user);

		return "listSUCCESS";
	}

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	// 员工删除
	public String delete() {
		// 所有添加参数都被封装 model对象
		UserService userService = new UserService();
		userService.delete(user);
		return "deleteSUCCESS";
	}

	// 编辑员工，查询员工信息回显到form表单
	public String editview() {
		// 根据id查询，将结果数据 保存 getModel引用中
		UserService userService = new UserService();
		user = userService.findById(user.getId());
		return "editviewSUCCESS";
	}

	// 员工修改
	public String edit() {
		// 所有添加参数都被封装 model对象
		UserService userService = new UserService();
		userService.edit(user);
		return "editSUCCESS";
	}

}
