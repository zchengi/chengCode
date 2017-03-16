package com.lyh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 连接数据库，并对数据库进行增、删、改、查。
 */

public class JDBCConnection {
	private final String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 连接sql数据库的方法
	private final String url = "jdbc:sqlserver://localhost:1433;DatabaseName=db_grade";
	private final String useName = "sa";
	private final String password = "159357"; // 访问sc数据库
	private Connection con = null;

	public JDBCConnection() {
		try {
			Class.forName(dbDriver).newInstance(); // 加载数据库驱动
		} catch (Exception ex) {
			System.out.println("数据库加载失败");
		}
	}

	// 创建数据库连接
	public boolean createConnection() {
		try {
			con = DriverManager.getConnection(url, useName, password);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("数据库连接失败");
		}
		return true;
	}

	// 对数据库的查询操作
	public ResultSet executeQuery(String sql) {
		ResultSet rs;
		try {
			if (con == null) {
				createConnection();
			}
			Statement stmt = con.createStatement();
			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("执行查询操作失败");
			return null;
		}
		return rs;
	}

	// 关闭数据库操作
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭连接失败");
			} finally {
				con = null;
			}
		}
	}

	// 对数据库的增加修改和删除
	public boolean executeUpdate(String sql) {
		if (con == null) {
			createConnection();
		}
		try {
			Statement stmt = con.createStatement();
			int iCount = stmt.executeUpdate(sql);
			System.out.println("操作成功，所影响的记录数为" + String.valueOf(iCount));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("执行修改操作失败！");
		}
		return true;
	}

}
