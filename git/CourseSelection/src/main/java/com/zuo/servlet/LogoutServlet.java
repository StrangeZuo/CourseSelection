package com.zuo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.zuo.dao.AdminDao;
import com.zuo.dao.DaoFactory;
import com.zuo.dao.StudentDao;
import com.zuo.dao.TeacherDao;
import com.zuo.entity.Admin;
import com.zuo.entity.Student;
import com.zuo.entity.Teacher;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect("login.jsp");
	}
}
	