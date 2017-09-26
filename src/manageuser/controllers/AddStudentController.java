package manageuser.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.entities.StudentDetail;
import manageuser.logic.impl.CourseLogicImpl;
import manageuser.logic.impl.JapanDetailLogicImpl;
import manageuser.logic.impl.StatusStudentLogicImpl;
import manageuser.logic.impl.StudentDetailLogicImpl;
import manageuser.utils.Common;

/**
 * Servlet implementation class AddStudentController
 */
@WebServlet("/AddStudentController")
public class AddStudentController extends HttpServlet {

	private static final long serialVersionUID = -525206711271750237L;
	/**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setDataLogic(request, response);
		request.getRequestDispatcher("WEB-INF/jsp/AddStudent.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDetail studentDetail = new StudentDetail();
		StudentDetailLogicImpl studentDetailLogicImpl = new StudentDetailLogicImpl();
		String IQScore = request.getParameter("iq");
		String status = request.getParameter("status");
		String scoreInterview = request.getParameter("interview");
		String gender = request.getParameter("gender");
		String courseId = request.getParameter("course");
		studentDetail.setUserName(request.getParameter("username"));
		studentDetail.setName(request.getParameter("full_name"));
		studentDetail.setPassword(request.getParameter("password"));
		studentDetail.setTel(request.getParameter("phone"));
		
		studentDetail.setIdCard(request.getParameter("idCard"));
		studentDetail.setAdress(request.getParameter("address"));
		studentDetail.setSchool(request.getParameter("school"));
		studentDetail.setMajor(request.getParameter("major"));
		studentDetail.setGraduatedYear(request.getParameter("gra_year"));
		if(Common.isNumBer(IQScore)) {
		studentDetail.setScoreIQ( Integer.parseInt(IQScore));
		}
		studentDetail.setNote(request.getParameter(request.getParameter("note")));
		studentDetail.setJapanLevel(request.getParameter("japanese_level"));
		if(Common.isNumBer(scoreInterview)) {
			studentDetail.setScoreInterview(Integer.parseInt(scoreInterview));
		}
		if(Common.isNumBer(status)) {
			studentDetail.setStatus(Integer.parseInt(status));
		}
		studentDetail.setEmail(request.getParameter("email"));
		if(Common.isNumBer(gender)) {
			studentDetail.setGender(Integer.parseInt(gender));
		}
		if(Common.isNumBer(courseId)) {
			studentDetail.setCourseId(Integer.parseInt(courseId));
		}
		studentDetail.setBirthday(Common.convertStringToDate(request.getParameter("birthday")));
		studentDetailLogicImpl.createStudent(studentDetail);
	}
	
	/**
	 * lấy và đẩy dữ liệu cho combobox
	 * @param request
	 * @param response
	 */
	private void setDataLogic(HttpServletRequest request, HttpServletResponse response) {
		CourseLogicImpl courseLogicImpl = new CourseLogicImpl();
		StatusStudentLogicImpl statusStudentLogicImpl = new StatusStudentLogicImpl();
		JapanDetailLogicImpl japanDetailLogicImpl = new JapanDetailLogicImpl();
		request.setAttribute("listJapan", japanDetailLogicImpl.getListJapanDetail());
		request.setAttribute("listCourse", courseLogicImpl.getListCourse());
		request.setAttribute("listStatus", statusStudentLogicImpl.getStatus());
	}

}
