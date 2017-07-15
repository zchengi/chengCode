package com.cheng.user.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		/*Properties prop = new Properties();
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

		} catch (IOException e) {
			System.out.println(e);
		} catch (MessagingException e) {
			System.out.println(e);
		}*/
final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
		// Get a Properties object
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.163.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		final String username = "zhangyigonnn";
		final String password = "testzhang";
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		// -- Create a new message --
		Message msg = new MimeMessage(session);

		// -- Set the FROM and TO fields --
	
		try {
			msg.setFrom(new InternetAddress("zhangyigonnn@163.com"));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("792702352@qq.com", false));
			msg.setSubject("你好,这是来自本地1111asdasdasdasd1服务器");
			msg.setText("来自测试邮件");
			msg.setSentDate(new Date());
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Message sent.");
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
		} else {
			if (users.get(0).getStatus()) {
				msg.add(0, "error");
				msg.add(1, "不要重复激活！");
			} else {
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
