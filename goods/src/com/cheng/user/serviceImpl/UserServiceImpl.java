package com.cheng.user.serviceImpl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uuid.UUIDHelper;

import com.cheng.category.dao.CategoryDao;
import com.cheng.domain.User;
import com.cheng.user.dao.UserDao;
import com.cheng.user.service.UserService;
import com.cheng.user.vo.UserPwdVo;

/**
 * 用户相关的业务功能
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private CategoryDao categoryDao;

    /**
     * 用户注册
     */
    public void regUser(User user) {

        user.setUid(UUIDHelper.getUUID());
        user.setStatus(false);
        user.setActivationcode(UUIDHelper.getUUID() + UUIDHelper.getUUID());

        // 发送邮件激活
        // Get a Properties object
        Properties prop = new Properties();
        try {
            prop.load(this.getClass().getClassLoader()
                    .getResourceAsStream("163emailForaliyun.properties"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        // 邮箱帐号
        final String username = "zhangyigonnn";
        // 邮箱密码
        final String password = "testzhang";
        // 邮件内容
        String text = MessageFormat.format(prop.getProperty("content"),
                user.getActivationcode());
        // 发送方
        String from = prop.getProperty("from");
        // 接收方
        String to = user.getEmail();
        // 邮件头
        String subject = prop.getProperty("subject");

        // 邮箱会话
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // -- Create a new message --
        Message msg = new MimeMessage(session);
        // -- Set the FROM and TO fields --
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to, false));
            msg.setContent(text, "text/html;charset=utf-8");
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userDao.insert(user);
        System.out.println("Message sent.");
    }

    /**
     * 用户激活
     */
    public List<String> activation(String activationCode) {

        List<String> msg = new ArrayList<String>();

        List<User> users = userDao.selectByActivationCode(activationCode);
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
                userDao.updateByPrimaryKey(user);
            }
        }
        return msg;
    }

    /**
     * 用户登录
     */
    public User login(User user) {

        List<User> users = userDao.select(user);
        if (users.size() == 0) {
            return user;
        }
        return users.get(0);
    }

    /**
     * 用户修改密码
     */
    public boolean editPwd(UserPwdVo vo, String uid) {
        User user = userDao.selectByPrimaryKey(uid);
        if (user.getUid() == null) {
            return false;
        }
        if (!user.getLoginpass().equals(vo.getLoginpass())) {
            return false;
        }
        user.setLoginpass(vo.getNewpass());
        userDao.updateByPrimaryKey(user);
        return true;
    }
}
