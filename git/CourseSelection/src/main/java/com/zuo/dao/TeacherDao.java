package com.zuo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zuo.entity.Teacher;
import com.zuo.utils.PropertiesUtils;

public class TeacherDao {
	public void add(Teacher teacher) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into teacher(tName, userName, tPwd, ) value(?,?,?)";
		queryrunner.update(sql, teacher.gettName(), teacher.getUserName(), teacher.gettPwd());
	}
	public void delete(Integer tId) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from teacher where tId = ?";
		queryrunner.update(sql, tId);
	}
	public void update(Teacher teacher) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update teacher set tName = ?, tpwd = ? where tId = ?";
		queryrunner.update(sql, teacher.gettName(), teacher.gettPwd(), teacher.gettId());
	}
	public List<Teacher> list(Teacher teacher) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from teacher";
		List<Teacher> list = queryrunner.query(sql, new BeanListHandler<>(Teacher.class));
		return list;
		
	}
	public Teacher findById(Integer tId) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from Teacher where tId = ?";
		Teacher teacher = queryrunner.query(sql, new BeanHandler<>(Teacher.class), tId);
		return teacher;
}
	public Teacher login(String userName, String tPwd) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from Teacher where userName = ? and tPwd = ?";
		Teacher teacher = queryrunner.query(sql, new BeanHandler<>(Teacher.class), userName, tPwd);
		return teacher;
}
}
