package test;

import java.security.GeneralSecurityException;
import java.util.Date;
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

import org.junit.Test;

public class Test1 {
	@Test
	public void emailtest() throws AddressException, MessagingException,
			GeneralSecurityException {
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
		msg.setFrom(new InternetAddress("zhangyigonnn@163.com"));
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("792702352@qq.com", false));
		msg.setSubject("你好,这是来自本地11111服务器");
		msg.setText("来自测试邮件");
		msg.setSentDate(new Date());
		Transport.send(msg);

		System.out.println("Message sent.");
	}
}