package myservlet.control;

import mybean.data.DataByPage;

import com.sun.rowset.*;

import java.sql.*;
import java.io.*;

import javax.servlet.*; 
import javax.servlet.http.*;
 
public class QueryAllRecord extends HttpServlet {
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
		String idNumber = request.getParameter("fenleiNumber");
		// System.out.println(idNumber);
		if (idNumber == null) {
			idNumber = "0";
		}
		int id = Integer.parseInt(idNumber);
		// System.out.println(id);
		HttpSession session = request.getSession(true);
		Connection con = null;
		DataByPage dataBean = null;
		try {
			dataBean = (DataByPage) session.getAttribute("dataBean");
			// System.out.println(dataBean);
			// System.out.println(id);
			if (dataBean == null) {
				dataBean = new DataByPage();
				session.setAttribute("dataBean", dataBean);
			}
			// System.out.println(id);
		} catch (Exception e) {
			dataBean = new DataByPage();
			session.setAttribute("dataBean", dataBean);
		}
		String uri = "jdbc:mysql://127.0.0.1/shop";
		// System.out.println(id);
		try {
			// System.out.println(id);
			con = DriverManager.getConnection(uri, "root", "zy159357");
			Statement sql = con
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sql
					.executeQuery("select * from cosmeticForm where id =" + id);
			/*if (rs.next()) {
				System.out.println("不为空");
			} else {
				System.out.println("空");
			}*/
			rowSet = new CachedRowSetImpl(); // 创建行集对象
			rowSet.populate(rs);
			dataBean.setRowSet(rowSet);// 行集数据存储在dataBean中
			con.close();// 关闭连接
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		response.sendRedirect("byPageShow.jsp");// 重定向到byPageShow.jsp
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
