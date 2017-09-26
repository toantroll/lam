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
import manageuser.entities.TimeTableDetail;
import manageuser.logic.impl.TimeTableInfoLogicImpl;
import manageuser.utils.Common;

/**
 * Servlet implementation class TestAjax
 */
@WebServlet("/TestAjax")
public class TestAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		response.setContentType("application/json");
		if(!Common.isNumBer(id)){
			ResponseData data = new ResponseData();
			data.setCode(ResponseData.FAIL);
			response.getWriter().write(new JSONObject(data).toString());
		} else {
			TimeTableInfoLogicImpl infoLogicImpl = new TimeTableInfoLogicImpl();
			try {
				ResponseData data = infoLogicImpl.getTimeTableById(Integer.valueOf(id));
				data.setCode(ResponseData.SUCCESS);
				response.getWriter().write(new JSONObject(data).toString());
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
