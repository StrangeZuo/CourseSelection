package com.zuo.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zuo.entity.Admin;
import com.zuo.utils.PropertiesUtils;

public class AdminDao {
	
	public void add(Admin admin) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into admin(userName, aName, aPwd) value(?,?,?)";
		queryrunner.update(sql, admin.getUserName(), admin.getaId(), admin.getaName(), admin.getaPwd());
	}
	public void delete(Integer id) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from admin where id = ?";
		queryrunner.update(sql, id);
		
	}
	public void update(Admin admin) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update admin set userName = ?, aName = ?, aPwd = ? where id = ?";
		queryrunner.update(sql, admin.getUserName(), admin.getaId(), admin.getaName(), admin.getaPwd(), admin.getaId());
	}
	public List<Admin> list(Admin admin) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from admin";
		List<Admin> list = queryrunner.query(sql, new BeanListHandler<>(Admin.class));
		return list;
		
	}
	public Admin findById(Integer id) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from admin";
		Admin admin = queryrunner.query(sql, new BeanHandler<>(Admin.class));
		return admin;
	}
	public Admin login(Admin admin) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from admin where username = ? and apwd = ?";
		Admin entity = queryrunner.query(sql, new BeanHandler<>(Admin.class), admin.getUserName(), admin.getaPwd());
		return entity;
	}

}
