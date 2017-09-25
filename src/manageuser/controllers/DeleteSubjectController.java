package manageuser.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manageuser.entities.Subject;
import manageuser.logics.impl.SubjectLogicImpl;

/**
 * Controller xử lý xóa môn học
 * 
 * @author LA-PM
 *
 */
@WebServlet(urlPatterns = "/deleteSubject.do")
public class DeleteSubjectController extends HttpServlet {
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
		SubjectLogicImpl subjectLogicImpl = new SubjectLogicImpl();
		Subject subject = subjectLogicImpl.getSubjectById(req.getParameter("subjectId"));
		if (subject == null) {
			resp.sendRedirect(req.getContextPath() + "/error.do");
		} else {
			if (subjectLogicImpl.deleteSubject(subject)) {
				resp.sendRedirect(req.getContextPath() + "/listSubject.do");
			} else {
				resp.sendRedirect(req.getContextPath() + "/error.do");
			}
		}
	}
}
