package myservlet.control;

import mybean.data.Login;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PutGoodsToCar extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String goods = request.getParameter("java");
		//System.out.println(goods);
		Login loginBean = null;
		HttpSession session = request.getSession(true);
		try {
			loginBean = (Login) session.getAttribute("loginBean");
			boolean b = loginBean.getLogname() == null
					|| loginBean.getLogname().length() == 0;
			System.out.println(b);
			if (b) {
				response.sendRedirect("login.jsp");// 重定向到登录页面
			}
			LinkedList<String> car = loginBean.getCar();
			car.add(goods);
			speakSomeMess(request, response, goods);

		} catch (Exception e) {
			response.sendRedirect("login.jsp");// 重定向到登录页面
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void speakSomeMess(HttpServletRequest request,
			HttpServletResponse response, String goods) {
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<html><head>");
			out.print("<iframe  src='head.txt'></head>");
			out.println("<body>");
			out.println("<h2>" + goods + "放入购物车</h2>");
			out.println("查看购物车返回浏览化妆品<br />");
			out.println("<a href='lookShoppingCar.jsp'>查看购物车</a>");
			out.println("<br /><a href='byPageShow.jsp'>浏览化妆品</a>");
			out.println("</body></html>");
		} catch (IOException e) {
		}
	}
}
