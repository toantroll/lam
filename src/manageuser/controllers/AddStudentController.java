package manageuser.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
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
import manageuser.utils.Constant;
import manageuser.validates.Validate;

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
		// để test man hình do chưa có màn hình đến 
		request.getRequestDispatcher("WEB-INF/jsp/AddStudent.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDetail studentDetail = setDefaultValue(request, response);
		JapanDetailLogicImpl japanDetailLogicImpl = new JapanDetailLogicImpl();
		StatusStudentLogicImpl statusStudentLogicImpl = new StatusStudentLogicImpl();
		CourseLogicImpl courseLogicImpl = new CourseLogicImpl();
		StudentDetailLogicImpl studentDetailLogicImpl = new StudentDetailLogicImpl();
		HashMap<String, String> listErr = Validate.validateStudent(studentDetail);
		if(listErr.size() != 0){
			setDataLogic(request, response);
			request.setAttribute("listErr", listErr);
			listErr.clear();
			request.setAttribute("studentDetail", studentDetail);
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADDSTUDENT);
			dispatcher.forward(request, response);
		} else {
			StringBuilder url = new StringBuilder();
			url.append(request.getContextPath()+"/error.do");
			String japanLevel = studentDetail.getJapanLevel();
			if(japanLevel != null && japanDetailLogicImpl.existJapanLevel(japanLevel)== null) {
				url.append("?check=err&iderr=");
				url.append(Constant.ERRJAPANLEVEL);
			} else if(!courseLogicImpl.existCourse(studentDetail.getCourseId())) {
				url.append("?check=err&iderr=");
				url.append(Constant.ERRCOURSEID);
			} else if(!statusStudentLogicImpl.existStatus(studentDetail.getStatus())) {
				url.append("?check=err&iderr=");
				url.append(Constant.ERRSTATUS);
			} else if(!studentDetailLogicImpl.createStudent(studentDetail)) {
				url.append("?check=err&iderr=");
				url.append(Constant.ERR);
			} else {
				url.append("?check=success&idInfor=INF_01");
			}
			response.sendRedirect(url.toString());
		}
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
	private StudentDetail setDefaultValue(HttpServletRequest request, HttpServletResponse response) {
		StudentDetail studentDetail = new StudentDetail();
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
		studentDetail.setNote(request.getParameter("note"));
		studentDetail.setRoleId(4);
		if(Common.isNumBer(IQScore)) {
		studentDetail.setScoreIQ( Integer.parseInt(IQScore));
		}
		String japanlevel = request.getParameter("japanese_level");
		if(!"".equals(japanlevel))
			studentDetail.setJapanLevel(japanlevel);
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
		return studentDetail;
	}

}
