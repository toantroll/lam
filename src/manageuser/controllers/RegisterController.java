package manageuser.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.entities.Register;
import manageuser.entities.RegisterInfo;
import manageuser.logic.impl.RegisterLogicImpl;
import manageuser.logic.impl.StatusStudentLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;
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
		RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.SIGNUP);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setDataLogic(request, response);
		RegisterInfo registerInfo = new RegisterInfo();
		RegisterLogicImpl registerLogicImpl = new RegisterLogicImpl();
		Register register = new Register();
		String fullName = request.getParameter("full_name");
		String email = request.getParameter("email");
		String tel = request.getParameter("phone");
		String date = request.getParameter("txtNgaydangky");
		int status = Integer.parseInt(request.getParameter("selectStatus"));
		String school = request.getParameter("school");
		String major = request.getParameter("major");
		String graduatedYear = "";
		if(request.getParameter("graduated_year") != null){
			graduatedYear = request.getParameter("graduated_year");
		}
		registerInfo.setEmail(email);
		registerInfo.setMajor(major);
		registerInfo.setSchool(school);
		registerInfo.setTel(tel);
		registerInfo.setFullName(fullName);
		registerInfo.setBirthday(date);
		registerInfo.setStatus(status);
		registerInfo.setGraduatedYear(graduatedYear);
		HashMap<String, String> listError = Validate.validateRegister(registerInfo);
		if(listError.size() != 0){
			request.setAttribute("listError", listError);
			request.setAttribute("registerInfo", registerInfo);
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.SIGNUP);
			dispatcher.forward(request, response);
		}else{
			register.setBirthday(Common.convertStringToDate(date));
			register.setEmail(email);
			register.setFullName(fullName);
			register.setGraduatedYear(Integer.parseInt(graduatedYear));
			register.setMajor(major);
			register.setSchool(school);
			register.setStatus(status);
			register.setTel(tel);
			register.setStatus(status);
			Date today = new Date(System.currentTimeMillis());
			register.setCreatedDate(today);
			registerLogicImpl.addUserRegist(register);
			response.sendRedirect(request.getContextPath() + "/SuccessRegisterController");
		}
	}
	private void setDataLogic(HttpServletRequest request, HttpServletResponse response){
    	StatusStudentLogicImpl statusStudentLogicImpl = new StatusStudentLogicImpl();
    	request.setAttribute("listStatus", statusStudentLogicImpl.getStatus());
    }

}
