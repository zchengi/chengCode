package com.cheng.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheng.dao.UserMapper;
import com.cheng.domain.User;

/**
 * 测试类
 */
// @Controller
public class test {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/test")
	public String test1() {
		User user = userMapper.selectByPrimaryKey("xxx");
		System.out.println(user);
		return "jsps/main";
	}

}
