/**
 * Copyright(C) 2017  Luvina
 * AddTeacherDetailController.java, Sep 26, 2017  TranTheHong
 */
package manageuser.controllers;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manageuser.entities.TeacherDetail;
import manageuser.logic.impl.TeacherDetailLogicImpl;
import manageuser.validates.Validate;

/**
 * @author HongTT
 *
 */
@WebServlet(urlPatterns = { "/addTeacher.do", "/editTeacher.do" })
public class AddTeacherDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		if ("edit".equals(type)) {
			int id = Integer.parseInt(req.getParameter("id"));
			TeacherDetailLogicImpl teacherDetailLogicImpl = new TeacherDetailLogicImpl();
			req.setAttribute("teacherDetail", teacherDetailLogicImpl.getTeacherDetailById(id));
		}
		req.getRequestDispatcher("WEB-INF/jsp/add-teacher.jsp").forward(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDetail teacherDetail = new TeacherDetail();
		TeacherDetailLogicImpl teacherDetailLogicImpl = new TeacherDetailLogicImpl();
		// type = req.getParameter("type");
		if (req.getParameter("id") != null) {
			teacherDetail.setUserID(Integer.parseInt(req.getParameter("id")));
		} else {
			teacherDetail.setUserID(0);
		}
		teacherDetail.setUserName(req.getParameter("username"));
		teacherDetail.setPassword(req.getParameter("password"));
		teacherDetail.setFullName(req.getParameter("full_name"));
		teacherDetail.setDeleteFlag(1);
		teacherDetail.setTel(req.getParameter("phone"));
		teacherDetail.setEmail(req.getParameter("email"));
		teacherDetail.setRoleId(3);		
		HashMap<String, String> listErr = Validate.validateTeacherDetail(teacherDetail);	
		System.out.println(listErr.size());
		if (listErr.size() != 0) {			
			req.setAttribute("listErr", listErr);
			req.setAttribute("teacherDetail", teacherDetail);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/add-teacher.jsp");
			dispatcher.forward(req, resp);
		} else {
			if (teacherDetail.getUserID() == 0) {			
				teacherDetailLogicImpl.createTeacherDetail(teacherDetail);
			} else if (teacherDetail.getUserID() > 0) {
				teacherDetailLogicImpl.updateTeacherDetail(teacherDetail);
			}

		}

	}

}
