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
import manageuser.logic.impl.TimeTableDetailLogicImpl;
import manageuser.utils.Common;

/**
 * Servlet implementation class DeleteTimeTableDetailController
 */
@WebServlet("/DeleteTimeTableDetailController")
public class DeleteTimeTableDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTimeTableDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idDetail = request.getParameter("idDetail");
		String idTimeTable = request.getParameter("idTimeTable");
		ResponseData data = new ResponseData();
		
		if(Common.isNumBer(idDetail)){	
			try {
				if(new TimeTableDetailLogicImpl().deleteTimeTableDetail(Integer.valueOf(idDetail))){
					data.setCode(ResponseData.SUCCESS);
					data.setData("Xóa thành công");
				} else {
					data.setCode(ResponseData.FAIL);
					data.setData("Xóa thất bại");
				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.setCode(ResponseData.FAIL);
				data.setData("ERROR");
			}
		} else {
			data.setCode(ResponseData.FAIL);
			data.setData("ERROR");
		}
		response.setContentType("application/json");
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
