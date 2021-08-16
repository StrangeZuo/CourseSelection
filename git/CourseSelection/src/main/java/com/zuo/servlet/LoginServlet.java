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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String type = req.getParameter("type");
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password) || StringUtils.isBlank(type)) {
			req.setAttribute("error", "录入信息不能为空！");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		HttpSession session = req.getSession();
		if(StringUtils.isNotBlank(type)) {
			try {
				if("0".equals(type)) {
					//学生登录验证
					Student student = DaoFactory.getInstance().getStudentDao().login(userName, password);
					if(student != null) {
						session.setAttribute("user", student);
						session.setAttribute("type", type);
						resp.sendRedirect("index.jsp");
					}else {
						req.setAttribute("error", "用户名或密码错误！");
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
				}else if("1".equals(type)) {
					//老师登录验证
					Teacher teacher = DaoFactory.getInstance().getTeacherDao().login(userName, password);
					if(teacher != null) {
						session.setAttribute("user", teacher);
						session.setAttribute("type", type);
						resp.sendRedirect("index.jsp");
					}else {
						req.setAttribute("error", "用户名或密码错误");
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
					
				}else {
					Admin admin = new Admin();
					admin.setUserName(userName);
					admin.setaPwd(password);
						Admin entity = DaoFactory.getInstance().getAdminDao().login(admin);
						if(entity != null) {
							session.setAttribute("user", admin);
							session.setAttribute("type", type);
							resp.sendRedirect("index.jsp");
						}else {
							req.setAttribute("error", "用户名或密码错误");
							req.getRequestDispatcher("login.jsp").forward(req, resp);
						}
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			}
}

