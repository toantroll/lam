package manageuser.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import manageuser.entities.ResponseData;
import manageuser.entities.TimeTableInfo;
import manageuser.logic.impl.TimeTableInfoLogicImpl;
import manageuser.utils.Common;

/**
 * Servlet implementation class AddTimeTableInfoController
 */
@WebServlet("/AddTimeTableInfoController")
public class AddTimeTableInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTimeTableInfoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResponseData data = new ResponseData();
		String id = request.getParameter("id");
		String courseId = request.getParameter("courseId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int course = 0;

		List<String> listError = new ArrayList<String>();
		if (!Common.isNumBer(id)) {
			listError.add("Lỗi id");
		}
		if (!Common.isNumBer(courseId)) {
			listError.add("Lỗi courseId");
		} else {
			if((course = Integer.valueOf(courseId)) < 1){
				listError.add("Lỗi courseId");
			}
		}
		if (!Common.isDate(startDate, "dd/MM/yyyy")) {
			listError.add("Lỗi startDate");
		}
		if (!Common.isDate(startDate, "dd/MM/yyyy")) {
			listError.add("Lỗi endDate");
		}

		if (listError.isEmpty()) {
			TimeTableInfoLogicImpl logic = new TimeTableInfoLogicImpl();
			TimeTableInfo e = new TimeTableInfo();
			int infoId = Integer.valueOf(id);
			e.setId(infoId);
			e.setCourseId(course);
			e.setStartDate(Common.convertStringToDate(startDate, "dd/MM/yyyy"));
			e.setEndDate(Common.convertStringToDate(endDate, "dd/MM/yyyy"));
			try {
				if (infoId == 0) {
					int lastId = logic.insertTimeTableInfo(e);
					if(lastId > 0){
						String msg = request.getContextPath() + "/TimeTableController?id="+lastId;
						data.setData(msg);
						data.setCode(ResponseData.INSERT_SUCCESS);
					} else {
						String msg = "Thêm mới thất bại";
						data.setData(msg);
						data.setCode(ResponseData.FAIL);
					}
					
				} else {
					boolean isUpdate =  logic.updateTimeTableInfo(e);
					if(isUpdate){
						data.setData("cập nhật thành công");
						data.setCode(ResponseData.SUCCESS);
					} else {
						data.setData("cập nhật thất bại");
						data.setCode(ResponseData.FAIL);
					}
					
				}	
			} catch (SQLException e1) {
				data.setCode(ResponseData.FAIL);
				data.setData("ERROR");
				e1.printStackTrace();
			}

		} else {
			data.setCode(ResponseData.FAIL);
			data.setData(listError);
		} 
		response.setContentType("application/json");
		response.getWriter().write(new JSONObject(data).toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
