package manageuser.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manageuser.entities.Subject;
import manageuser.entities.TeacherDetail;
import manageuser.logic.impl.SubjectLogicImpl;
import manageuser.logic.impl.TeacherDetailLogicImpl;
import manageuser.validates.ValidateSubject;

/**
 * Controller xử lý cho màn hình addSubject.jsp
 * 
 * @author LA-PM
 *
 */
@WebServlet(urlPatterns = { "/addSubject.do", "/editSubject.do" })
public class AddSubjectInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		HashMap<String, String> listError = new HashMap<String, String>();
		Subject subject = new Subject();
		setTeacher(req, resp);
		subject = setValueSubject(req, resp);
		req.setAttribute("teacherSelect", subject.getGiaoVienId());
		req.setAttribute("subject", subject);
		listError = ValidateSubject.validateSubject(subject);
		if (listError.size() > 0) {
			req.setAttribute("listError", listError);
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/addSubject.jsp");
			rd.forward(req, resp);
		} else {
			String ssid = System.currentTimeMillis() + "";
			session.setAttribute(ssid, subject);
			if ("add".equals(req.getParameter("type"))) {
				resp.sendRedirect(req.getContextPath() + "/addSubjectConfirm.do?ssid=" + ssid + "&type=add");
			} else if ("edit".equals(req.getParameter("type"))) {
				resp.sendRedirect(req.getContextPath() + "/editSubjectConfirm.do?ssid=" + ssid + "&type=edit");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Subject subject = setValueSubject(req, resp);
		if (subject == null) {
			resp.sendRedirect(req.getContextPath() + "/error.do");
		} else {
			if ("back".equals(req.getParameter("type"))) {
				session.removeAttribute(req.getParameter("ssid"));
			}
			setTeacher(req, resp);
			req.setAttribute("teacherSelect", subject.getGiaoVienId());
			req.setAttribute("subject", subject);
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/addSubject.jsp");
			rd.forward(req, resp);
		}
	}

	private void setTeacher(HttpServletRequest req, HttpServletResponse resp) {
		List<TeacherDetail> listTeacher = new ArrayList<>();
		TeacherDetailLogicImpl teacherDetailLogicImpl = new TeacherDetailLogicImpl();
		try {
			listTeacher = teacherDetailLogicImpl.getAllTeacherDetail();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setTeacherId(0);
		teacherDetail.setFullName("LỰA CHỌN GIẢNG VIÊN:");
		listTeacher.add(0, teacherDetail);
		req.setAttribute("listTeacher", listTeacher);
	}

	/**
	 * Gán giá trị cho đối tượng subject
	 * 
	 * @param req
	 *            HttpServletRequest
	 * @param resp
	 *            HttpServletResponse
	 * @return đối tượng subject
	 */
	private Subject setValueSubject(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		Subject subject = new Subject();
		SubjectLogicImpl subjectLogicImpl = new SubjectLogicImpl();
		TeacherDetailLogicImpl teacherDetailLogicImpl = new TeacherDetailLogicImpl();
		String type = req.getParameter("type");
		if (type == null) {
			subject.setId("");
			subject.setName("");
			subject.setContent("");
			subject.setGiaoVienId(0);
		} else {
			if ("add".equals(type)) {
				subject.setId(req.getParameter("subjectId"));
				subject.setName(req.getParameter("subjectName"));
				subject.setContent(req.getParameter("subjectContent"));
				subject.setGiaoVienId(Integer.parseInt(req.getParameter("listTeacher")));
				subject.setGiaoVienName(teacherDetailLogicImpl
						.getTeacherDetailById(Integer.parseInt(req.getParameter("listTeacher"))).getFullName());
				subject.setFlag(0);
			} else if ("edit".equals(type)) {
				subject = subjectLogicImpl.getSubjectById(req.getParameter("subjectId"));
				if ("true".equals(req.getParameter("validate"))) {
					subject.setId(req.getParameter("subjectId"));
					subject.setName(req.getParameter("subjectName"));
					subject.setContent(req.getParameter("subjectContent"));
					subject.setGiaoVienId(Integer.parseInt(req.getParameter("listTeacher")));
					subject.setGiaoVienName(teacherDetailLogicImpl
							.getTeacherDetailById(Integer.parseInt(req.getParameter("listTeacher"))).getFullName());
				}
			} else if ("back".equals(type)) {
				subject = (Subject) session.getAttribute(req.getParameter("ssid"));
			}
		}
		return subject;
	}
}
