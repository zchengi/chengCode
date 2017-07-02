package test;

import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import com.sun.mail.util.MailSSLSocketFactory;

public class Test1 {
	public void emailtest() throws AddressException, MessagingException,
			GeneralSecurityException {
		Properties props = new Properties();

		// 开启debug调试
		props.setProperty("mail.debug", "true");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.qq.com");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");

		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);

		Session session = Session.getInstance(props);

		Message msg = new MimeMessage(session);
		msg.setSubject("seenews 错误");
		StringBuilder builder = new StringBuilder();
		builder.append("url = "
				+ "http://blog.csdn.net/never_cxb/article/details/50524571");
		builder.append("\n页面爬虫错误");
		msg.setText(builder.toString());
		msg.setFrom(new InternetAddress("792702352@qq.com"));

		Transport transport = session.getTransport();
		transport
				.connect("smtp.qq.com", "792702352@qq.com", "krkuksrkdhnxbccj");

		transport.sendMessage(msg, new Address[] { new InternetAddress(
				"2245090465@qq.com") });
		transport.close();
	}

	public void emailtest2() {
		try {
			// 需要认证
			Properties props = new Properties();
			// 开启debug调试
			props.setProperty("mail.debug", "true");
			props.put("mail.smtp.host", "smtp.163.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.from", "zhangyigonnn@163.com");

			//

		} catch (Exception e) {
		}
	}

	@Test
	public void test3() {
		BigDecimal bigDecimal = new BigDecimal(1);
		BigDecimal multiply = bigDecimal.divide(new BigDecimal(10));
		System.out.println(multiply);
	}
}
