/**
 * Copyright(C) 2017  Luvina
 * AddTeacherDetailController.java, Sep 26, 2017  TranTheHong
 */
package manageuser.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.entities.TeacherDetail;
import manageuser.logic.impl.TeacherDetailLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.validates.Validate;

/**
 * @author HongTT
 *
 */
@WebServlet(urlPatterns = { "/addTeacher.do", "/editTeacher.do" })
public class AddTeacherDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
/* (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("WEB-INF/jsp/add-teacher.jsp").forward(req, resp);
}
/* (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	TeacherDetail teacherDetail= new TeacherDetail();
	TeacherDetailLogicImpl teacherDetailLogicImpl= new TeacherDetailLogicImpl();
	String type="";
	type= req.getParameter("type");	
		teacherDetail.setUserName(req.getParameter("userName"));
		teacherDetail.setPassword(req.getParameter("password"));
		teacherDetail.setTel(req.getParameter("tel"));
		teacherDetail.setEmail(req.getParameter("email"));
		teacherDetail.setRoleId(3);		
		HashMap<String, String> listError = Validate.validateTeacherDetail(teacherDetail);		
		if (listError.size() != 0) {
			req.setAttribute("listError", listError);
			req.setAttribute("teacherDetail", teacherDetail);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/add-teacher.jsp");
			dispatcher.forward(req, resp);
		} else {			
			resp.sendRedirect(req.getContextPath() + "/SuccessController");
		}
	
}
}
