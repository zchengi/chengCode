package myservlet.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.data.Register;

public class HandleRegister extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
	}

	public String handleString(String s) {
		try {
			byte bb[] = s.getBytes("utf-8");
			s = new String(bb);
		} catch (Exception e) {
		}
		return s;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 设置接受参数的字符集
		String uri = "jdbc:mysql://127.0.0.1/shop?"
				+ "user=root&password=zy159357&characterEncoding=utf-8";
		Connection con;
		PreparedStatement sql;
		Register userBean = new Register(); // 创建javabean模型
		request.setAttribute("userBean", userBean);
		String logname = request.getParameter("logname").trim();
		String password = request.getParameter("password").trim();
		String again_password = request.getParameter("again_password").trim();
		String phone = request.getParameter("phone").trim();
		String address = request.getParameter("address").trim();
		String realname = request.getParameter("realname").trim();
		// System.out.println(realname);
		if (logname == null) {
			logname = "";
		}
		if (password == null) {
			password = "";
		}
		if (!password.equals(again_password)) {
			userBean.setBackNews("两次密码不同，注册失败");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("inputRegisterMess.jsp");
			dispatcher.forward(request, response);
			return;
		}
		boolean isLD = true;
		for (int i = 0; i < logname.length(); i++) {
			char c = logname.charAt(i);
			if (!((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0'))) {
				isLD = false;
			}
		}
		boolean boo = logname.length() >= 0 && password.length() >= 0 && isLD;
		String backNews = "";
		try {
			con = DriverManager.getConnection(uri);
			String insertCodition = "insert into user values (?,?,?,?,?)";
			sql = con.prepareStatement(insertCodition);
			if (boo) {
				sql.setString(1, handleString(logname));
				sql.setString(2, handleString(password));
				sql.setString(3, handleString(phone));
				sql.setString(4, handleString(address));
				sql.setString(5, handleString(realname));
				int m = sql.executeUpdate();
				if (m != 0) {
					backNews = "注册成功";
					userBean.setBackNews(backNews);
					userBean.setLogname(logname);
					userBean.setPhone(phone);
					userBean.setAddress(address);
					userBean.setRealname(realname);
				}
			} else {
				backNews = "信息填写不完整或名字中有非法字符";
				userBean.setBackNews(backNews);
			}
			con.close();
		} catch (SQLException e) {
			backNews = "该会员名已被使用，请您更换名字" + e;
			userBean.setBackNews(backNews);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("inputRegisterMess.jsp");
		dispatcher.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
