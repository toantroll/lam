/**
 * Copyright(C) 2017  Luvina
 * ViewListArticleController.java, Sep 25, 2017  TranTheHong
 */
package manageuser.controllers;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet(urlPatterns = "/ViewListArticle.do")
public class ViewListArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArticleLogicImpl articleLogicImpl= new ArticleLogicImpl();
		try {
			req.setAttribute("listArticle", articleLogicImpl.getAllTitle());
		} catch (SQLException e) {
			//Trang lỗi.
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/list-article.jsp");
		requestDispatcher.forward(req, resp);
	}

}
