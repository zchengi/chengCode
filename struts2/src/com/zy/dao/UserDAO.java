package com.zy.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zy.exception.MySQLException;
import com.zy.pojo.User;
import com.zy.utils.JDBCUtils;

/**
 * 登录查询
 * */
public class UserDAO {
	private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

	public User findByNameAndPass(User user) {
		String sql = "select * from tb_admin where name = ? and pass = ?";
		User user1;
		try {
			user1 = queryRunner.query(sql, new BeanHandler<User>(User.class),
					user.getName(), user.getPass());
			return user1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MySQLException(e);
		}
	}

	// 保存注册的新用户
	public void save(User user) {
		String sql = "insert into tb_admin values(null,null,?,?,?)";
		Object[] args = { user.getName(), user.getPass(), user.getRepass() };
		try {
			queryRunner.update(sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// 显示全部用户
	public List<User> findAllUser(User user) {
		String sql = "select * from tb_admin ";
		try {
			List<User> users = queryRunner.query(sql,
					new BeanListHandler<User>(User.class));
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MySQLException(e);
		}
	}

	// 删除用户，根据用户id删除
	public void delete(User user) {
		String sql = "delete from tb_admin where id=? ";
		try {
			queryRunner.update(sql, user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MySQLException(e);
		}
	}

	/**
	 * 根据id 查询
	 * 
	 * @param userID
	 * @return
	 */
	public User findById(int id) {
		String sql = "select * from tb_admin where id = ?";
		try {
			User user = queryRunner.query(sql,
					new BeanHandler<User>(User.class), id);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MySQLException(e);
		}
	}

	public void update(User user) {
		String sql = "update tb_admin set num= ? , name=? , pass =? where id = ?";
		Object[] args = { user.getNum(), user.getName(), user.getPass(),
				user.getId() };
		try {
			queryRunner.update(sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MySQLException(e);
		}
	}

}
