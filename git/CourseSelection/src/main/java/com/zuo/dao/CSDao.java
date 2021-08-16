package com.zuo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zuo.entity.CS;
import com.zuo.utils.PropertiesUtils;

public class CSDao {
	public void add(CS cs) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into cs(stuId, cId) value(?,?)";
		queryrunner.update(sql, cs.getStuId(), cs.getcId());
	}
	public void delete(Integer csId) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from cs where csId = ?";
		queryrunner.update(sql, csId);
	}
	public void update(CS cs) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update cs setstuId = ?, cId = ? where scId = ?";
		queryrunner.update(sql, cs.getStuId(), cs.getcId());
	}
	public List<CS> list(CS cs) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from cs";
		List<CS> list = queryrunner.query(sql, new BeanListHandler<>(CS.class));
		return list;
		
	}
	public CS findById(Integer csId) throws SQLException{
		QueryRunner queryrunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from CS where csId = ?";
		CS cs = queryrunner.query(sql, new BeanHandler<>(CS.class), csId);
		return cs;
	}

}
