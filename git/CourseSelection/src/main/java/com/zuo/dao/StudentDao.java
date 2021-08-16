package com.zuo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zuo.entity.Student;
import com.zuo.utils.PropertiesUtils;

public class StudentDao {
	public void add(Student student) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into student(stuName, stuNo, stuPwd, ) value(?,?,?)";
		queryrunner.update(sql, student.getStuName(), student.getStuNo(), student.getStuPwd());
	}
	public void delete(Integer stuId) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from student where studId = ?";
		queryrunner.update(sql, stuId);
	}
	public void update(Student student) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update student set stuName = ?, stuPwd = ? where stuId = ?";
		queryrunner.update(sql, student.getStuName(), student.getStuPwd(), student.getStuId());
	}
	public List<Student> list(Student student) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from student";
		List<Student> list = queryrunner.query(sql, new BeanListHandler<>(Student.class));
		return list;
		
	}
	public Student findById(Integer stuId) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from Student where stuId = ?";
		Student student = queryrunner.query(sql, new BeanHandler<>(Student.class), stuId);
		return student;
}
	public Student login(String stuNo, String stuPwd) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from Student where stuNo = ? and stuPwd = ?";
		Student student = queryrunner.query(sql, new BeanHandler<>(Student.class), stuNo, stuPwd);
		return student;
}
}
