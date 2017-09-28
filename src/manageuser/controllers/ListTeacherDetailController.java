/**
 * Copyright(C) 2017  Luvina
 * ListTeacherDetailController.java, Sep 22, 2017  TranTheHong
 */
package manageuser.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.entities.TeacherDetail;
import manageuser.logic.impl.TeacherDetailLogicImpl;
import manageuser.utils.Common;

/**
 * @author HongTT
 *
 */
@WebServlet(urlPatterns = { "/ListTeacherDetail" })
public class ListTeacherDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TeacherDetail> listTeacherDetails = new ArrayList<TeacherDetail>();
		HttpSession session = req.getSession();
		TeacherDetailLogicImpl teacherDetailLogicImpl = new TeacherDetailLogicImpl();
		String nameSearch = "";
		int currentPage = 1;
		int pageLimit = 3;
		int limit = 3;
		System.out.println("listTeacher");
		try {
			String type = req.getParameter("type");
			if (type != null) {
				if ("search".equals(type)) {
					nameSearch = req.getParameter("nameSearch");
				} else if ("paging".equals(type)) {
					nameSearch = (String) session.getAttribute("nameSearch");
					currentPage = Integer.parseInt((req.getParameter("page")));
				}
			}
			System.out.println(nameSearch);
			int totalTeacher = teacherDetailLogicImpl.getTotalTeacher(nameSearch);
			System.out.println(totalTeacher);
			if (totalTeacher == 0) {
				req.setAttribute("checkNotFound", 0);
				req.setAttribute("messageNotFound", "Không tìm thấy giáo viên!");
			} else {
				int totalPage = Common.getTotalPageSubject(totalTeacher, limit);
				int offset = Common.getOffsetSubject(currentPage, limit);
				listTeacherDetails = teacherDetailLogicImpl.getAllTeacherDetail(nameSearch, offset, limit);
				List<Integer> listPaging = Common.getListPagingSubject(totalTeacher, limit, currentPage);
				System.out.println(totalPage);
				System.out.println(offset);
				for (int a : listPaging) {
					System.out.println(a);
				}
				req.setAttribute("listTeacherDetails", listTeacherDetails);
				req.setAttribute("listPaging", listPaging);
				req.setAttribute("totalPage", totalPage);
				req.setAttribute("currentPage", currentPage);
				req.setAttribute("pageLimit", pageLimit);
				req.setAttribute("messageDelete", "Xác nhận đồng ý xóa giáo viên?");
			}
		} catch (SQLException e) {
			// Trang lỗi
			e.printStackTrace();
		}
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("nameSearch", nameSearch);
		req.setAttribute("teacherDetailsLst", listTeacherDetails);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/list-teacher.jsp");
		requestDispatcher.forward(req, resp);

	}
}
