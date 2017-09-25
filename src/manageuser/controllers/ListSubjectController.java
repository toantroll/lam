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
import manageuser.logic.impl.SubjectLogicImpl;
import manageuser.utils.Common;
import java.util.List;

@WebServlet(urlPatterns = "/listSubject.do")
public class ListSubjectController extends HttpServlet {
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
		SubjectLogicImpl subjectLogicImpl = new SubjectLogicImpl();
		String subjectId = "";
		String subjectName = "";
		String type = req.getParameter("type");
		int currentPage = 1;
		int pageLimit = 3;
		int limit = 5;
		if (type != null) {
			if ("search".equals(type)) {
				subjectId = req.getParameter("subjectId") == null ? "" : req.getParameter("subjectId");
				subjectName = req.getParameter("subjectName") == null ? "" : req.getParameter("subjectName");
				session.setAttribute("subjectId", subjectId);
				session.setAttribute("subjectName", subjectName);
			} else if ("paging".equals(type)) {
				subjectId = session.getAttribute("subjectId") == null ? "" : (String) session.getAttribute("subjectId");
				subjectName = session.getAttribute("subjectName") == null ? ""
						: (String) session.getAttribute("subjectName");
				currentPage = req.getParameter("page") == null ? 1 : Integer.parseInt((req.getParameter("page")));
				session.setAttribute("currentPage", currentPage);
			}
		}
		int totalSubject = subjectLogicImpl.getTotalSubject(subjectId, subjectName);
		if (totalSubject == 0) {
			req.setAttribute("checkNotFound", 0);
			req.setAttribute("messageNotFound", "Không tìm thấy môn học!");
		} else {
			int totalPage = Common.getTotalPageSubject(totalSubject, limit);
			int offset = Common.getOffsetSubject(currentPage, limit);
			List<Subject> listSubject = subjectLogicImpl.getListSubject(subjectId, subjectName, offset, limit);
			List<Integer> listPaging = Common.getListPagingSubject(totalSubject, limit, currentPage);
			req.setAttribute("listSubject", listSubject);
			req.setAttribute("listPaging", listPaging);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("pageLimit", pageLimit);
			req.setAttribute("messageDelete", "Xác nhận đồng ý xóa môn học?");
		}
		req.setAttribute("subjectId", subjectId);
		req.setAttribute("subjectName", subjectName);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/listSubject.jsp");
		requestDispatcher.forward(req, resp);
	}
}
