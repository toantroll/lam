package manageuser.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import manageuser.entities.ResponseData;
import manageuser.logic.impl.CourseLogicImpl;
import manageuser.logic.impl.SubjectLogicImpl;
import manageuser.logic.impl.TimeTableInfoLogicImpl;
import manageuser.utils.Common;

/**
 * Servlet implementation class TestAjax
 */
@WebServlet({"/Ajax/getTimeTable", "/Ajax/getSubject", "/Ajax/getTableInfo", "/Ajax/getCourses"})
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ResponseData data = new ResponseData();
		System.out.println(request.getRequestURL());
		System.out.println(request.getRequestURI());
		if(request.getRequestURI().endsWith("/Ajax/getTimeTable")){
			String id = request.getParameter("id");
			if(!Common.isNumBer(id)){
				data.setCode(ResponseData.FAIL);
				data.setData("ERROR");
			} else {
				TimeTableInfoLogicImpl infoLogicImpl = new TimeTableInfoLogicImpl();
				try {
					data.setData(infoLogicImpl.getTimeTableById(Integer.valueOf(id)));
					data.setCode(ResponseData.SUCCESS);
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					data.setCode(ResponseData.FAIL);
				}
			}
		} else if(request.getRequestURI().endsWith("/Ajax/getSubject")) {
			SubjectLogicImpl subjectLogic = new SubjectLogicImpl();
			try {
				data.setData(subjectLogic.getAllSubject());
				data.setCode(ResponseData.SUCCESS);
			} catch (SQLException e) {
				data.setCode(ResponseData.FAIL);
				data.setData("ERROR");
				e.printStackTrace();
			}
		} else if(request.getRequestURI().endsWith("/Ajax/getTableInfo")){
			String id = request.getParameter("id");
			if(!Common.isNumBer(id)){
				data.setCode(ResponseData.FAIL);
				data.setData("ERROR");
			} else {
				TimeTableInfoLogicImpl infoLogicImpl = new TimeTableInfoLogicImpl();
				try {
					data.setData(infoLogicImpl.getTimeTableInfoById(Integer.valueOf(id)));
					data.setCode(ResponseData.SUCCESS);
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					data.setCode(ResponseData.FAIL);
				}
			}
		}
		else if(request.getRequestURI().endsWith("/Ajax/getCourses")){
			 data.setData(new CourseLogicImpl().getListCourse());
			 data.setCode(ResponseData.SUCCESS);
		}
		
		response.getWriter().write(new JSONObject(data).toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
