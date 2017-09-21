package manageuser.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.entities.Register;
import manageuser.logic.impl.StatusStudentLogicImpl;
import manageuser.validates.Validate;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setDataLogic(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setDataLogic(request, response);
		Register register = new Register();
		String fullName = request.getParameter("full_name");
		register.setFullName(fullName);
		HashMap<String, String> listError = Validate.validateRegister(register);
		if(listError.size() != 0){
			request.setAttribute("listError", listError);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}
	private void setDataLogic(HttpServletRequest request, HttpServletResponse response){
    	StatusStudentLogicImpl statusStudentLogicImpl = new StatusStudentLogicImpl();
    	request.setAttribute("listStatus", statusStudentLogicImpl.getStatus());
    }

}
