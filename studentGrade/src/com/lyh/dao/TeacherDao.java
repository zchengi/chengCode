package com.lyh.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lyh.bean.*;
import com.lyh.db.JDBCConnection;
import com.lyh.dao.TeacherDao;

/**
 * 教师权限操作类。包含教师身份登录验证，学生信息，课程信息及成绩信息的增、删、查
 */

public class TeacherDao {
	JDBCConnection conn = new JDBCConnection(); // 教师身份登录

	public Boolean isLogin(Admin admin) {
		conn.createConnection();
		String sql = "select*from tb_admin where a_name='" + admin.getAname()
				+ "'and a_pwd='" + admin.getApwd() + "'";
		ResultSet rs = conn.executeQuery(sql);
		try {
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 添加学生信息
	public boolean addStudent(Student stu) {
		conn.createConnection();
		String sql = "insert into tb_student values('" + stu.getSnumber()
				+ "','" + stu.getSname() + "','" + stu.getDepartment() + "','"
				+ stu.getSex() + "','" + stu.getPolity() + "')";
		return conn.executeUpdate(sql);
	}

	// 删除学生信息
	public boolean deleteStudent(String snumber) {
		conn.createConnection();
		String sql = "delete  from tb_student where s_number='" + snumber + "'";
		return conn.executeUpdate(sql);
	}

	// 查看全部学生信息
	public ResultSet selectAllResultSet() {
		conn.createConnection();
		String sql = "select * from tb_student";
		ResultSet rs = conn.executeQuery(sql);
		return rs;
	}

	// 添加课程
	public boolean addCourse(Course course) {
		conn.createConnection();
		String sql = "insert into tb_course values('" + course.getCnumber()
				+ "','" + course.getCname() + "','" + course.getCredit() + "')";
		return conn.executeUpdate(sql);
	}

	// 删除课程
	public boolean deleteCourse(String cnumber) {
		conn.createConnection();
		String sql = "delete from tb_course where c_number='" + cnumber + "'";
		return conn.executeUpdate(sql);
	}

	// 查看全部课程信息
	public ResultSet selectAllStudent() {
		conn.createConnection();
		String sql = "select * from tb_course";
		ResultSet rs = conn.executeQuery(sql);
		return rs;
	}

	// 添加分数
	public boolean addScore(Score score) {
		conn.createConnection();
		String sql = "insert into tb_score values('" + score.getSnumber()
				+ "','" + score.getCnumber() + "','" + score.getScore() + "','"
				+ score.getRemark() + "')";
		return conn.executeUpdate(sql);
	}

	// 删除分数
	public boolean deleteScore(String snumber, String cnumber) {
		conn.createConnection();
		String sql = "delete from tb_score where s_number='" + snumber
				+ "'and c_number='" + cnumber + "'";
		return conn.executeUpdate(sql);
	}

	// 查看全部学生分数
	public List selectAllScore() {
		conn.createConnection();
		List list = new ArrayList();
		String sql = "select s.s_number,s.s_name,c.c_name,score,credit from tb_student"
				+ " as s,tb_course as c,tb_score as r where s.s_number=r.s_number and "
				+ "c.c_number=r.c_number  order by s.s_number asc";
		ResultSet rs=conn.executeQuery(sql);
		try {
			while (rs.next()) {
				Score score=new Score();
				Student student=new Student();
				score.setSnumber(rs.getString("s_number"));
				student.setSname(rs.getString("s_name"));
				score.setStudent(student);
				Course course=new Course();
				course.setCname(rs.getString("c_name"));
				score.setScore(rs.getFloat("score"));
				course.setCredit(rs.getFloat("credit"));
				score.setCourse(course);
				
				list.add(score);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//学生根据学号查询学生成绩
	public List selectScoreBysnumber(Score score){
		conn.createConnection();
		List list=new ArrayList();
		String sql= "select s.s_number,s.s_name,c.c_name,score,credit from tb_student"
			+ " as s,tb_course as c,tb_score as r where s.s_number=r.s_number and "
			+ "c.c_number=r.c_number and s.s_number='"+score.getSnumber()+"' order by s.s_number asc";
		
		ResultSet rs=conn.executeQuery(sql);
		try {
			while (rs.next()) {
				score=new Score();
					Student student=new Student();
				score.setSnumber(rs.getString("s_number"));
				student.setSname(rs.getString("s_name"));
				score.setStudent(student);
				Course course=new Course();
				course.setCname(rs.getString("c_name"));
				score.setScore(rs.getFloat("score"));
				course.setCredit(rs.getFloat("credit"));
				score.setCourse(course);
			
			list.add(score);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}











