/**
 * Copyright(C) 2017  Luvina
 * TeacherDetailLogicImpl.java, Sep 21, 2017  TranTheHong
 */
package manageuser.logic.impl;

import java.sql.SQLException;
import java.util.List;

import manageuser.dao.impl.TeacherDetailDaoImpl;
import manageuser.dao.impl.UserDaoImpl;
import manageuser.entities.TeacherDetail;
import manageuser.entities.Users;
import manageuser.logic.TeacherDetailLogic;
/**
 * @author HongTT
 *
 */
public class TeacherDetailLogicImpl implements TeacherDetailLogic {
	TeacherDetailDaoImpl teacherDetailDaoImpl = new TeacherDetailDaoImpl();
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.logic.TeacherDetailLogic#createTeacherDetail(manageuser.
	 * entities.TeacherDetail)
	 */
	@Override
	public boolean createTeacherDetail(TeacherDetail teacherDetail){
		boolean ketQua= true;
		Users users = new Users();
		users.setUserID(teacherDetail.getUserID());
		users.setPassword(teacherDetail.getPassword());
		users.setRoleId(teacherDetail.getRoleId());
		users.setUserName(teacherDetail.getUserName());
		try {
			userDaoImpl.insertUser(users);
			teacherDetailDaoImpl.insertTeacher(teacherDetail);
			userDaoImpl.commit();
		} catch (SQLException e) {			
			e.printStackTrace();
			userDaoImpl.rollbackTrasaction();
			ketQua= false;			
		}finally {
			userDaoImpl.closeConnectionTransaction();
		}		
		return ketQua;
	}
	/* (non-Javadoc)
	 * @see manageuser.logic.TeacherDetailLogic#updateTeacherDetail(int)
	 */
	@Override
	public boolean updateTeacherDetail(TeacherDetail teacherDetail) {
		boolean ketQua= true;
		try {
			teacherDetailDaoImpl.updateTeacher(teacherDetail);
		} catch (SQLException e) {
			ketQua=false;
			e.printStackTrace();
		}
		return ketQua;
	}
	/* (non-Javadoc)
	 * @see manageuser.logic.TeacherDetailLogic#getAllTeacherDetail()
	 */
	@Override
	public List<TeacherDetail> getAllTeacherDetail() throws SQLException {	
		return teacherDetailDaoImpl.getAllTeacherDetail();
	}
	/* (non-Javadoc)
	 * @see manageuser.logic.TeacherDetailLogic#deleteTeacherDetail(int)
	 */
	@Override
	public boolean deleteTeacherDetail(int teacherId) {
		boolean ketQua= false;
		try {
			teacherDetailDaoImpl.deleteTeacher(teacherId);
			userDaoImpl.deleteUser(teacherId);
			userDaoImpl.commit();
			ketQua= true;
		} catch (SQLException e) {
			userDaoImpl.rollbackTrasaction();
			ketQua=false;
			System.out.println("Lỗi xóa thông tin giáo viên");
		}
		return ketQua;
	}

}
