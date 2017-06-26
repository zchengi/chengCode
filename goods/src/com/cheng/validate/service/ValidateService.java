package com.cheng.validate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.dao.UserMapper;
import com.cheng.domain.User;
import com.cheng.domain.UserExample;
import com.cheng.domain.UserExample.Criteria;

/**
 * 与验证相关的控制层
 */
@Service
public class ValidateService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 验证用户名是否有重复
	 * 
	 * @return 重复返回1 否则返回0
	 */
	public int valiLoginName(String loginname) {
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andLoginnameEqualTo(loginname);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			return 0;
		}
		return 1;
	}

	public Boolean valiemail(String email) {
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andEmailEqualTo(email);
		List<User> emails = userMapper.selectByExample(userExample);
		if (emails.size() == 0) {
			return true;
		}
		return false;
	}
}
