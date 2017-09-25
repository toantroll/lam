/**
 * Copyright(C) 2017  Luvina
 * ListTeacherDetailController.java, Sep 22, 2017  TranTheHong
 */
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

import manageuser.entities.TeacherDetail;
import manageuser.logic.impl.TeacherDetailLogicImpl;
import manageuser.utils.Constant;

/**
 * @author HongTT
 *
 */
@WebServlet(urlPatterns = { "/ListTeacherDetail" })
public class ListTeacherDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<TeacherDetail> listTeacherDetails= new ArrayList<TeacherDetail>();
			TeacherDetailLogicImpl teacherDetailLogicImpl = new TeacherDetailLogicImpl();
			TeacherDetail teacherDetail= new TeacherDetail();
			teacherDetail.setFullName("Hồng");
			teacherDetail.setUserName("ewrwerwer");
			teacherDetail.setPassword("123425434");
			teacherDetail.setRoleId(4);
			teacherDetail.setDeleteFlag(1);
			teacherDetail.setEmail("hong@gmail.com");
			teacherDetail.setTel("398475893354");
			//Thêm mới giáo viên:
			if(teacherDetailLogicImpl.createTeacherDetail(teacherDetail)){
				System.out.println("Thêm mới thành công");
			}else{
				System.out.println("Không thành công");
			}
			
			
			
			//Lấy ra danh sách thông tin giáo viên.
			listTeacherDetails=teacherDetailLogicImpl.getAllTeacherDetail();
			for (TeacherDetail teacher : listTeacherDetails) {
				System.out.println(teacher.getFullName());
			}
			//Xét dữ liệu lên request
			req.setAttribute("teacherDetailsLst", listTeacherDetails);
		} catch (SQLException e) {
			// Chuyển sang trang lỗi.
			e.printStackTrace();
		}
	}

}
