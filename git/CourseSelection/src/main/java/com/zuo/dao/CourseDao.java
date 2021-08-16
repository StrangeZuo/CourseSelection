package com.zuo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zuo.entity.Course;
import com.zuo.utils.PropertiesUtils;

public class CourseDao {
	public void add(Course course) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into course(cName, tId) value(?,?)";
		queryrunner.update(sql, course.getcName(), course.gettId());
	}
	public void delete(Integer cId) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from course where cId = ?";
		queryrunner.update(sql, cId);
	}
	public void update(Course course) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update course set cName = ?, tId = ?, where cId = ?";
		queryrunner.update(sql, course.getcName(), course.gettId(), course.getcId());
	}
	public List<Course> list(Course course) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from course";
		List<Course> list = queryrunner.query(sql, new BeanListHandler<>(Course.class));
		return list;
		
	}
	public Course findById(Integer cId) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from Course where cId = ?";
		Course course = queryrunner.query(sql, new BeanHandler<>(Course.class), cId);
		return course;
	}
}
