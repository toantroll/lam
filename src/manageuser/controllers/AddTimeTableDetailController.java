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
import manageuser.entities.TimeTableDetail;
import manageuser.logic.impl.TimeTableDetailLogicImpl;
import manageuser.utils.Common;

/**
 * Servlet implementation class TestSubmit
 */
@WebServlet("/AddTimeTableDetailController")
public class AddTimeTableDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTimeTableDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lấy dữ liệu từ request
		String idDetail = request.getParameter("idDetail");
		String date = request.getParameter("date");
		String idTimeTable = request.getParameter("idTimeTable");
		String hoursPerDay = request.getParameter("hoursPerDay");
		String time = request.getParameter("time");
		String subject = request.getParameter("subject");
		String titleSubject = request.getParameter("titleSubject");
		String isTest = request.getParameter("isTest");

		// check hợp lệ
		ResponseData data = new ResponseData();
		List<String> listError = new ArrayList<String>();
		if (!Common.isDate(date, "dd/MM/yyyy")) {
			listError.add("Lỗi Date");
		}

		if (!Common.isNumBer(idDetail)) {
			listError.add("Lỗi idDetail");
		}

		if (!Common.isNumBer(idTimeTable)) {
			listError.add("Lỗi idTimeTable");
		}

		if (!Common.isNumBer(hoursPerDay)) {
			listError.add("Lỗi hoursPerDay");
		}

		if (!Common.isNumBer(subject)) {
			listError.add("Lỗi subject");
		}

		if (Common.isEmpty(titleSubject)) {
			listError.add("Lỗi titleSubject");
		}

		if (!Common.isTime(time)) {
			listError.add("Lỗi titleSubject");
		}

		if (listError.isEmpty()) {
			// convert to entity
			TimeTableDetail t = new TimeTableDetail();
			t.setId(Integer.valueOf(idDetail));
			t.setTimeTableInfoId(Integer.valueOf(idTimeTable));
			t.setStartDate(Common.convertStringToDate(date, "dd/MM/yyyy"));
			t.setHoursPerDay(Integer.valueOf(hoursPerDay));
			t.setSubjectId(Integer.valueOf(subject));
			t.setSubjectContent(titleSubject);
			t.setStartHours(time);
			t.setStatus(Common.isEmpty(isTest) ? 0 : 1);
			try {
				if (t.getId() == 0) {
					if(new TimeTableDetailLogicImpl().insertTimeTableDetail(t)){
						data.setData("Thêm mới thành công");
					} else {
						data.setData("Thêm mới thất bại");
					}
					
				} else {
					if(new TimeTableDetailLogicImpl().updateTimeTableDetail(t)){
						data.setData("Cập nhật thành công");
					} else {
						data.setData("Cập nhật thất bại");
					}
					
				}
				data.setCode(ResponseData.SUCCESS);
				
			} catch (SQLException e) {
				e.printStackTrace();
				data.setCode(ResponseData.FAIL);
				data.setData("ERROR");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
