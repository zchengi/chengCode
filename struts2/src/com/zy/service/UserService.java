package com.zy.service;

import java.util.List;

import com.zy.dao.UserDAO;
import com.zy.pojo.User;

public class UserService {
	// 用户登录方法
	public User login(User user) {
		UserDAO userDAO = new UserDAO();
		return userDAO.findByNameAndPass(user);
	}

	// 用户添加方法
	public void add(User user) {
		UserDAO userDAO = new UserDAO();
		userDAO.save(user);
	}

	// 用户列表显示方法
	public List<User> list(User user) {
		UserDAO userDAO = new UserDAO();
		return userDAO.findAllUser(user);
	}

	// 用户删除方法
	public void delete(User user) {
		UserDAO userDAO = new UserDAO();
		userDAO.delete(user);
	}

	/**
	 * 根据id 查询
	 */
	public User findById(int id) {
		UserDAO userDAO = new UserDAO();
		return userDAO.findById(id);
	}

	/**
	 * 修改功能
	 */

	public void edit(User user) {
		UserDAO userDAO = new UserDAO();
		userDAO.update(user);
	}

}
