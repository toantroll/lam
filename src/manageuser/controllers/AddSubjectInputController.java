package manageuser.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manageuser.entities.Subject;
import manageuser.logics.impl.SubjectLogicImpl;
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
		List<String> listError = new ArrayList<>();
		Subject subject = new Subject();
		subject = setValueSubject(req, resp);
		listError = ValidateSubject.validateSubject(subject);
		if (listError.size() > 0) {
			req.setAttribute("subject", subject);
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
			req.setAttribute("subject", subject);
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/addSubject.jsp");
			rd.forward(req, resp);
		}
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
		String type = req.getParameter("type");
		if (type == null) {
			subject.setId("");
			subject.setName("");
			subject.setContent("");
		} else {
			if ("add".equals(type)) {
				subject.setId(req.getParameter("subjectId"));
				subject.setName(req.getParameter("subjectName"));
				subject.setContent(req.getParameter("subjectContent"));
				subject.setFlag(0);
			} else if ("edit".equals(type)) {
				subject = subjectLogicImpl.getSubjectById(req.getParameter("subjectId"));
				if ("true".equals(req.getParameter("validate"))) {
					subject.setId(req.getParameter("subjectId"));
					subject.setName(req.getParameter("subjectName"));
					subject.setContent(req.getParameter("subjectContent"));
				}
			} else if ("back".equals(type)) {
				subject = (Subject) session.getAttribute(req.getParameter("ssid"));
			}
		}
		return subject;
	}
}
