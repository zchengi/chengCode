package com.cheng.user.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

import mailhelper.Mail;
import mailhelper.MailUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uuid.UUIDHelper;

import com.cheng.dao.CategoryMapper;
import com.cheng.dao.UserMapper;
import com.cheng.domain.User;
import com.cheng.domain.UserExample;
import com.cheng.domain.UserExample.Criteria;
import com.cheng.vo.UserPwdVo;

/**
 * 用户相关的业务功能
 */
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CategoryMapper categoryMapper;

	/**
	 * 用户注册
	 */
	public void regUser(User user) {

		user.setUid(UUIDHelper.getUUID());
		user.setStatus(false);
		user.setActivationcode(UUIDHelper.getUUID() + UUIDHelper.getUUID());

		userMapper.insert(user);
		// 发送邮件激活
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream("163email.properties"));
			// 访问 邮件服务器
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String host = prop.getProperty("host");
			Session session = MailUtils.createSession(host, username, password);

			// 制作邮件
			String from = prop.getProperty("from");
			String to = user.getEmail();
			String subject = prop.getProperty("subject");
			String content = MessageFormat.format(prop.getProperty("content"),
					user.getActivationcode());

			Mail mail = new Mail(from, to, subject, content);

			// 发送
			MailUtils.send(session, mail);
			System.out.println(session + "---" + mail);

		} catch (IOException e) {
			System.out.println(e);
		} catch (MessagingException e) {
			System.out.println(e);
		}
	}

	/**
	 * 用户激活
	 */
	public List<String> activation(String activationCode) {

		List<String> msg = new ArrayList<String>();

		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andActivationcodeEqualTo(activationCode);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			msg.add(0, "error");
			msg.add(1, "你有问题。");
			System.out.println(1);
		} else {
			if (users.get(0).getStatus()) {
				msg.add(0, "error");
				msg.add(1, "不要重复激活！");
				System.out.println(2);
			} else {
				System.out.println(3);
				msg.add(0, "success");
				msg.add(1, "恭喜你，用户已经激活!");
				User user = users.get(0);
				user.setStatus(true);
				userMapper.updateByPrimaryKey(user);
			}
		}
		return msg;
	}

	/**
	 * 用户登录
	 */
	public User login(User user) {

		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andLoginnameEqualTo(user.getLoginname())
				.andLoginpassEqualTo(user.getLoginpass());
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			return user;
		}
		return users.get(0);
	}

	/**
	 * 用户修改密码
	 */
	public boolean editPwd(UserPwdVo vo, String uid) {
		System.out.println(vo + "-------" + uid);
		User user = userMapper.selectByPrimaryKey(uid);
		if (user.getUid() == null) {
			return false;
		}
		if (!user.getLoginpass().equals(vo.getLoginpass())) {
			return false;
		}
		user.setLoginpass(vo.getNewpass());
		userMapper.updateByPrimaryKey(user);
		return true;
	}
}
