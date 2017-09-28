package manageuser.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.entities.Subject;
import manageuser.entities.TimeTableInfo;
import manageuser.logic.impl.TimeTableInfoLogicImpl;
import manageuser.utils.Common;


/**
 * Servlet implementation class ListTimeTableInfoController
 */
@WebServlet("/ListTimeTableInfoController")
public class ListTimeTableInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTimeTableInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String startDate = request.getParameter("startDate");
		String page = request.getParameter("page");
		int limit = 2;
		int pageLimit = 3;
		int currentPage = 1;
	
		if(Common.isDate(startDate, "dd/MM/yyyy")){
			currentPage = session.getAttribute("currentPage") == null ? 1: (int)session.getAttribute("currentPage") ;
		} else if(!Common.isEmpty(page)){
			currentPage = Common.isNumBer(page) ? Integer.valueOf(page) : 1;
			startDate = (String)session.getAttribute("startDate");
		} else {
			currentPage = session.getAttribute("currentPage") == null ? 1: (int)session.getAttribute("currentPage") ;
			startDate = (String)session.getAttribute("startDate");
		}
		
		TimeTableInfoLogicImpl logic = new TimeTableInfoLogicImpl();
		try {
			Date date = Common.convertStringToDate(startDate, "dd/MM/yyyy");
			int totalRecord = logic.getCount(date, null);
			if(totalRecord == 0){
				request.setAttribute("message", "No record");
			} else {
				int totalPage = Common.getTotalPageSubject(totalRecord, limit);
				int offset = Common.getOffsetSubject(currentPage, limit);
				List<TimeTableInfo> listTimeTable = logic.getListTimeTableInfo(date, null, offset, limit);
				List<Integer> listPaging = Common.getListPagingSubject(totalRecord, limit, currentPage);
				request.setAttribute("listTimeTable", listTimeTable);
				request.setAttribute("listPaging", listPaging);
				request.setAttribute("totalPage", totalPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("pageLimit", pageLimit);
			}
		} catch (SQLException e) {
			request.setAttribute("message", "No record");
			e.printStackTrace();
		}
		request.setAttribute("startDate", startDate);
		
		session.setAttribute("startDate", startDate);
		session.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/WEB-INF/jsp/list-time-table-info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
