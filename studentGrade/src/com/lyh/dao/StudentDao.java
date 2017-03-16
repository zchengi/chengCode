package com.lyh.dao;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lyh.bean.Course;
import com.lyh.bean.Score;
import com.lyh.bean.Student;
import com.lyh.db.JDBCConnection;

public class StudentDao {
	JDBCConnection conn = new JDBCConnection();

	// 学生身份登录
	public boolean isLogin(Student stu) {
		conn.createConnection();
		String sql = "select * from tb_student where s_name='" + stu.getSname()
				+ "'and s_number='" + stu.getSnumber() + "'";
		ResultSet rs=conn.executeQuery(sql);
		try {
			if (rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//学生根据学号查询自己成绩
	public List selectMyScore(Score score){
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
