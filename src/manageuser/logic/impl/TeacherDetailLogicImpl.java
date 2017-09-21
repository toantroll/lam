/**
 * Copyright(C) 2017  Luvina
 * TeacherDetailLogicImpl.java, Sep 21, 2017  TranTheHong
 */
package manageuser.logic.impl;

import java.sql.SQLException;

import manageuser.dao.impl.TeacherDetailDaoImpl;
import manageuser.dao.impl.UserDaoImpl;
import manageuser.entities.Teacher;
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
		Users  users= new Users();
		Teacher teacher= new Teacher();
		try {
			userDaoImpl.insertUser(users);
			teacherDetailDaoImpl.insertTeacher(teacher);
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

}
