package com.lyh.test;

import java.sql.ResultSet;
import java.util.Scanner;
import java.util.List;

import com.lyh.bean.Admin;
import com.lyh.bean.Course;
import com.lyh.bean.Score;
import com.lyh.bean.Student;
import com.lyh.dao.StudentDao;
import com.lyh.dao.TeacherDao;

/**
 * 学生成绩管理系统主运行类
 */

public class GradeTest {
	public static void main(String[] args) {
		GradeTest gradetest = new GradeTest();
		System.out.println("欢迎进入学生成绩管理系统");
		System.out.println("	请选择身份进入系统");
		System.out.println("	1.教师身份");
		System.out.println("	2.学生身份");
		Scanner s = new Scanner(System.in);
		int user = s.nextInt();
		Admin admin = new Admin();
		TeacherDao td = new TeacherDao();
		if (user == 1) {
			System.out.println("请输入教师名称：	");
			admin.setAname(s.next());
			System.out.println("请输入密码：	");
			admin.setApwd(s.next());
			if (td.isLogin(admin)) {
				System.out.println("登录成功!");
				gradetest.teacherRole();
			}
		}
		if (user == 2) {
			Student student = new Student();
			StudentDao studao = new StudentDao();
			Score score = new Score();
			System.out.println("请输入学生名称：");
			student.setSname(s.next());
			System.out.println("请输入密码：");
			student.setSnumber(s.next());

			if (studao.isLogin(student)) {
				System.out.println("登陆成功！");
				System.out.println("您已进入学生成绩查询界面，下面是您所有的成绩");
				score.setSnumber(student.getSnumber());
				List list = studao.selectMyScore(score);
				studao.selectMyScore(score);
				for (int i = 0; i < list.size(); i++) {
					Score score1 = (Score) list.get(i);
					System.out.println("学号：" + score1.getSnumber() + "，学生姓名："
							+ score1.getStudent().getSname() + "，课程名称："
							+ score1.getCourse().getCname() + "，课程分数："
							+ score1.getScore() + "，课程学分："
							+ score1.getCourse().getCredit());
				}
			} else {
				System.out.println("用户名或密码错误，请重新登录！");
			}
		} else {
			System.out.println("输入无效信息，已退出系统！");
			System.exit(0);
		}

	}

	// 教师管理模块
	public void teacherRole() {
		System.out.println("您已进入教师管理窗口，请选择操作");
		System.out.println("1.学生管理");
		System.out.println("2.课程管理");
		System.out.println("3.成绩管理");
		Scanner s = new Scanner(System.in);
		int tr_number = s.nextInt();
		if (tr_number == 1) {
			studentManage();
		} else if (tr_number == 2) {
			courseManage();
		} else if (tr_number == 3) {
			gradeManage();
		} else {
			System.out.println("输入无效信息，请重新输入!");
			teacherRole();
		}
	}

	// 学生信息管理
	public void studentManage() {
		GradeTest gradetest = new GradeTest();
		TeacherDao td = new TeacherDao();
		Student stu = new Student();
		System.out.println("您已进入学生管理系统，请操作");
		System.out.println("1.添加学生信息");
		System.out.println("2.删除学生信息");
		System.out.println("3.查看学生信息");
		Scanner s = new Scanner(System.in);
		int sm_number = s.nextInt();
		if (sm_number == 1) {
			System.out.println("请输入学生学号：	");
			stu.setSnumber(s.next());
			System.out.println("请输入学生姓名：	");
			stu.setSname(s.next());
			System.out.println("请输入学生专业：	");
			stu.setDepartment(s.next());
			System.out.println("请输入学生性别：	");
			stu.setSex(s.next());
			System.out.println("请输入学生成份：	");
			stu.setPolity(s.next());
			td.addStudent(stu);
			System.out.println("返回上一界面请按1，返回主界面请按2");
			int flag = s.nextInt();
			if (flag == 1)
				gradetest.studentManage();
			if (flag == 2)
				gradetest.teacherRole();
			else
				System.exit(0); // 关闭虚拟机运行
		} else if (sm_number == 2) {
			try {
				System.out.println("请输入要删除的学生学号");
				td.deleteStudent(s.next());
				System.out.println("返回上一界面请按1，返回主界面请按2");
				int flag = s.nextInt();
				if (flag == 1)
					gradetest.studentManage();
				if (flag == 2)
					gradetest.teacherRole();
				else
					System.exit(0);
			} catch (Exception e) {
				System.out.println("输入学号有误，请重新输入！");
				studentManage();
			}
		} else if (sm_number == 3) {
			ResultSet rsl = td.selectAllResultSet();
			try {
				while (rsl.next()) {
					System.out.println("学号：" + rsl.getString(1) + "，姓名："
							+ rsl.getString(2) + "，专业：" + rsl.getString(3)
							+ "，性别：" + rsl.getString(4) + "，政治面貌："
							+ rsl.getString(5));
				}
				System.out.println("返回上一界面请按1，返回主界面请按2");
				int flag = s.nextInt();
				if (flag == 1)
					gradetest.studentManage();
				if (flag == 2)
					gradetest.teacherRole();
				else
					System.exit(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("输入无效信息，请重新输入！");
			studentManage();
		}
	}

	// 课程信息管理
	public void courseManage() {
		GradeTest gradetest = new GradeTest();
		Course course = new Course();
		TeacherDao td = new TeacherDao();
		System.out.println("您已进入课程管理窗口，请选择操作");
		System.out.println("1.添加课程信息");
		System.out.println("2.删除课程信息");
		System.out.println("3.查看课程信息");
		Scanner s = new Scanner(System.in);
		int cm_number = s.nextInt();

		if (cm_number == 1) {
			System.out.println("请输入课程编号：");
			course.setCnumber(s.next());
			System.out.println("请输入课程名称：");
			course.setCname(s.next());
			System.out.println("请输入课程学分：");
			course.setCredit(s.nextFloat());
			td.addCourse(course);
			System.out.println("返回上一界面请按1，返回主界面请按2");
			int flag = s.nextInt();
			if (flag == 1)
				gradetest.courseManage();
			if (flag == 2)
				gradetest.teacherRole();
			else
				System.exit(0);
		} else if (cm_number == 2) {
			try {
				System.out.println("请输入要删除的学科编号");
				td.deleteCourse(s.next());
				System.out.println("返回上一界面请按1，返回主界面请按2");
				int flag = s.nextInt();
				if (flag == 1)
					gradetest.courseManage();
				if (flag == 2)
					gradetest.teacherRole();
				else
					System.exit(0);
			} catch (Exception e) {
				System.out.println("输入学科编号有误或无此编号，请重新输入！");
				courseManage();
			}
		} else if (cm_number == 3) {
			ResultSet cm_rs = td.selectAllStudent();
			try {
				while (cm_rs.next()) {
					System.out.println("学科编号：" + cm_rs.getString(1) + "，学科名称："
							+ cm_rs.getString(2) + "学科学分：" + cm_rs.getShort(3));
				}
				System.out.println("返回上一界面请按1，返回主界面请按2");
				int flag = s.nextInt();
				if (flag == 1)
					gradetest.courseManage();
				if (flag == 2)
					gradetest.teacherRole();
				else
					System.exit(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("输入无效信息，请重新输入！");
			courseManage();
		}
	}

	// 成绩信息管理
	public void gradeManage() {
		GradeTest gradetest = new GradeTest();
		Score score = new Score();
		TeacherDao td = new TeacherDao();
		System.out.println("您已进入成绩管理窗口，请选择操作");
		System.out.println("1.添加课程成绩");
		System.out.println("2.删除课程成绩");
		System.out.println("3.查询课程成绩");
		Scanner s = new Scanner(System.in);
		int gm_number = s.nextInt();
		if (gm_number == 1) {
			System.out.println("请输入学生学号：");
			score.setSnumber(s.next());
			System.out.println("请输入学科编号：");
			score.setCnumber(s.next());
			System.out.println("请输入此科目成绩:");
			score.setScore(s.nextFloat());
			System.out.println("请输入备注信息:");
			score.setRemark(s.next());
			td.addScore(score);
			System.out.println("返回上一界面请按1，返回主界面请按2");
			int flag = s.nextInt();
			if (flag == 1)
				gradetest.gradeManage();
			if (flag == 2)
				gradetest.teacherRole();
			else
				System.exit(0);
		}
		if (gm_number == 2) {
			try {
				System.out.println("请输入要删除成绩的学生学号");
				String str1 = s.next();
				System.out.println("请输入要删除成绩的学科学号");
				String str2 = s.next();
				td.deleteScore(str1, str2);
				System.out.println("返回上一界面请按1，返回主界面请按2");
				int flag = s.nextInt();
				if (flag == 1)
					gradetest.gradeManage();
				if (flag == 2)
					gradetest.teacherRole();
				else
					System.exit(0);

			} catch (Exception e) {
				System.out.println("信息输入有误，请查询后输入！");
				gradeManage();
			}
		}
		if (gm_number == 3) {
			System.out.println("您已进入学生成绩查询窗口，请选择操作");
			System.out.println("1.查询所有学生成绩");
			System.out.println("2.按学号查询学生成绩");
			int sc_number = s.nextInt();

			// 查询所有成绩
			if (sc_number == 1) {
				List list = td.selectAllScore();
				for (int i = 0; i < list.size(); i++) {
					Score score1 = (Score) list.get(i);
					System.out.println("学号：" + score1.getSnumber() + "，学生姓名："
							+ score1.getStudent().getSname() + "，课程名称："
							+ score1.getCourse().getCname() + "，课程分数："
							+ score1.getScore() + "，课程学分："
							+ score1.getCourse().getCredit());
				}
				td.selectAllScore();
				System.out.println("返回上一界面请按1，返回主界面请按2");
				int flag = s.nextInt();
				if (flag == 1)
					gradetest.gradeManage();
				if (flag == 2)
					gradetest.teacherRole();
				else
					System.exit(0);
			}

			// 按学号查询成绩
			if (sc_number == 2) {
				System.out.println("请输入要查询成绩的学生学号");
				score.setSnumber(s.next());

				List list = td.selectScoreBysnumber(score);

				td.selectScoreBysnumber(score);
				for (int i = 0; i < list.size(); i++) {
					Score score1 = (Score) list.get(i);
					System.out.println("学号：" + score1.getSnumber() + "，学生姓名："
							+ score1.getStudent().getSname() + "，课程名称："
							+ score1.getCourse().getCname() + "，课程分数："
							+ score1.getScore() + "，课程学分："
							+ score1.getCourse().getCredit());
				}
				System.out.println("返回上一界面请按1，返回主界面请按2");
				int flag = s.nextInt();
				if (flag == 1)
					gradetest.gradeManage();
				if (flag == 2)
					gradetest.teacherRole();
				else
					System.exit(0);
			}

		}
	}
}