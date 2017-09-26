/**
 * Copyright(C) 2017 Jul 7, 2017 Luvina
 * ErrorController.java, Jul 7, 2017, CTA
 */
package manageuser.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class xử lý các trường hợp lỗi bất thường của dự án.
 * 
 * @author CTA
 *
 */
@WebServlet(urlPatterns = "/error.do")
public class ErrorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String check = req.getParameter("check");
		String message = "";
		if ("success".equals(check) && check != null) {
			message = "Thao tác thành công với hệ thống";
		} else {
			message = "Hệ thống đang có lỗi";
		}
		req.setAttribute("message", message);
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/error.jsp");
		dispatcher.forward(req, resp);
	}
}
