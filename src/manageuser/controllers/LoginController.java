/**
 * Copyright(C) 2017 Luvina
 * LoginController.java, 22/9/2017 Vu Cao Long
 */
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

import manageuser.entities.Users;
import manageuser.logic.impl.UsersLogicImpl;
import manageuser.validates.Validate;

/**
 * Xử lý login
 * @author Vucaolong
 *
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		Validate validate=new Validate();
		String url="";
		List<String> errorMessage=new ArrayList<String>();
		errorMessage=validate.validateLogin(userName, password);
		if(errorMessage.size()!=0){
			request.setAttribute("errorMess",errorMessage);
			request.setAttribute("userName", userName);
			url="WEB-INF/jsp/login.jsp";
		}else{
			UsersLogicImpl usersLogicImpl=new UsersLogicImpl();
			Users users=usersLogicImpl.getUser(userName);
			if(users.getRoleId()==1){
				url="WEB-INF/jsp/la-dashboard.jsp";
			}else if(users.getRoleId()==2){
				url="WEB-INF/jsp/la-dashboard.jsp";
			}else if(users.getRoleId()==3){
				url="WEB-INF/jsp/main-teacher.jsp";
			}else if(users.getRoleId()==4){
				url="WEB-INF/jsp/main-user.jsp";
			}else {
				url="WEB-INF/jsp/login.jsp";
			}
			HttpSession session=request.getSession();
			session.setAttribute("userNameSession", userName);
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(url);
		requestDispatcher.forward(request,response);
	}

}
