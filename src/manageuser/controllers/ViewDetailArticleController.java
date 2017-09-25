/**
 * Copyright(C) 2017  Luvina
 * ViewDetailArticleController.java, Sep 25, 2017  TranTheHong
 */
package manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.logic.impl.ArticleLogicImpl;

/**
 * @author HongTT
 *
 */
@WebServlet(urlPatterns = "/ViewDetailArticle.do")
public class ViewDetailArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		// Kiểm tra parameter.
		ArticleLogicImpl articleLogicImpl = new ArticleLogicImpl();
		try {
			req.setAttribute("detaiArticle", articleLogicImpl.getActicleById(Integer.parseInt(idStr)));
		} catch (Exception e) {
			// Màn hình lỗi
		}
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/detail-article.jsp");
		requestDispatcher.forward(req, resp);
	}
}
