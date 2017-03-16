package myservlet.control;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import mybean.data.DataByPage;

import com.sun.rowset.CachedRowSetImpl;

public class SearchByCondition extends HttpServlet {
	CachedRowSetImpl rowSet = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchMess = request.getParameter("searchMess");
		String radioMess = request.getParameter("radio");
		if (searchMess == null || searchMess.length() == 0) {
			fail(request, response, "没有查询信息，无法查询");
			return;
		}
		String condition = "";
		if (radioMess.equals("cosmetic_number")) {
			condition = "select * from cosmeticForm where cosmetic_number='"
					+ searchMess + "'";
		} else if (radioMess.equals("cosmetic_name")) {
			condition = "select * from cosmeticForm where cosmetic_name LIKE '%"
					+ searchMess + "%'";
		} else if (radioMess.equals("cosmetic_price")) {
			double max = 0, min = 0;
			String regex = "[^0123456789.]";
			String[] priceMess = searchMess.split(regex);
			if (priceMess.length == 1) {
				max = min = Double.parseDouble(priceMess[0]);
			} else if (priceMess.length == 2) {
				max = Double.parseDouble(priceMess[0]);
				min = Double.parseDouble(priceMess[1]);
				if (max < min) {
					double t = max;
					max = min;
					min = t;
				}
			} else {
				fail(request, response, "输入的价格格式有误，请重新输入");
				return;
			}
			condition = "select * from cosmeticForm where"
					+ " cosmetic_price<=" + max + " AND cosmetic_price>= "
					+ min;
		}
		HttpSession session = request.getSession(true);
		Connection con = null;
		DataByPage dataBean = null;
		try {
			dataBean = (DataByPage) session.getAttribute("dataBean");
			if (dataBean == null) {
				dataBean = new DataByPage();
				session.setAttribute("dataBean", dataBean);
			}
		} catch (Exception e) {
			dataBean = new DataByPage();
			session.setAttribute("dataBean", dataBean);
		}
		String uri = "jdbc:mysql://127.0.0.1/shop?user=root&password=zy159357&charsetacterEncoding=utf-8";
		try {
			con = DriverManager.getConnection(uri);
			Statement sql = con
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = sql.executeQuery(condition);
			rowSet = new CachedRowSetImpl(); // 创建行集对象
			rowSet.populate(rs);
			dataBean.setRowSet(rowSet);// 行集数据存储到dataBean中
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		response.sendRedirect("byPageShow.jsp");// 重定向
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void fail(HttpServletRequest request, HttpServletResponse response,
			String backNews) {
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			out.print("<h2>" + backNews + "</h2>");
			out.print("返回：");
			out.print("<a href='searchCosmetic.jsp'>查询化妆品</a>");
			out.print("</body></html>");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
