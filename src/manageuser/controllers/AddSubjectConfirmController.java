package manageuser.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manageuser.entities.Subject;
import manageuser.logics.impl.SubjectLogicImpl;

/**
 * Controller xử lý cho màn hình listSubject.jsp
 * 
 * @author LA-PM
 *
 */
@WebServlet(urlPatterns = { "/addSubjectConfirm.do", "/editSubjectConfirm.do" })
public class AddSubjectConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String ssid = req.getParameter("ssid");
		Subject subject = (Subject) session.getAttribute(ssid);
		if (subject == null) {
			resp.sendRedirect(req.getContextPath() + "/error.do");
		} else {
			req.setAttribute("ssid", ssid);
			req.setAttribute("subject", subject);
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/confirmSubject.jsp");
			rd.forward(req, resp);
		}
	}

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
		String controller = "";
		String ssid = req.getParameter("ssid");
		Subject subject = (Subject) session.getAttribute(ssid);
		SubjectLogicImpl subjectLogicImpl = new SubjectLogicImpl();
		if (subject != null) {
			if ("add".equals(req.getParameter("type"))) {
				if (subjectLogicImpl.insertSubject(subject)) {
					controller = "/listSubject.do";
				} else {
					controller = "/error.do";
				}
			} else if ("edit".equals(req.getParameter("type"))) {
				if (subjectLogicImpl.editSubject(subject)) {
					controller = "/listSubject.do";
				} else {
					controller = "/error.do";
				}
			}
			session.removeAttribute(ssid);
		} else {
			controller = "/error.do";
		}
		resp.sendRedirect(req.getContextPath() + controller);
	}
}
