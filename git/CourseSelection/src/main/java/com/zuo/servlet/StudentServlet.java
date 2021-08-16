package com.zuo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuo.dao.DaoFactory;
import com.zuo.entity.Student;


@WebServlet("/student")
public class StudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("list".equals(method)) {
			this.list(request, response);
		}else if("add".equals(method)) {
			this.add(request, response);
		}
	}
	private void add(HttpServletRequest request, HttpServletResponse response){
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		String stuPwd = request.getParameter("stuPwd");
		Student student = new Student();
		student.setStuName(stuName);
		student.setStuNo(stuNo);
		student.setStuPwd(stuPwd);
		try {
			DaoFactory.getInstance().getStudentDao().add(student);
			response.sendRedirect("student?method=list");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response){
		try { 
			List<Student> list= DaoFactory.getInstance().getStudentDao().list(null);
			request.setAttribute("list", list);
			request.getRequestDispatcher("page/student/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
