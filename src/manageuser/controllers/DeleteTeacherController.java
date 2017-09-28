package manageuser.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.logic.impl.TeacherDetailLogicImpl;
import manageuser.utils.Common;

/**
 * Servlet implementation class EditTeacherController
 */
@WebServlet("/deleteTeacher.do")
public class DeleteTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		TeacherDetailLogicImpl teacherDetailLogicImpl = new TeacherDetailLogicImpl();
		String url = "";
		if (Common.isNumBer(idStr) && teacherDetailLogicImpl.checkExistedTeacherDetailById(Integer.parseInt(idStr))) {
			if (teacherDetailLogicImpl.deleteTeacherDetail(Integer.parseInt(idStr))) {
				url = "?check=success";
			}
		}
		response.sendRedirect(request.getContextPath() + "/error.do" + url);
	}

}
