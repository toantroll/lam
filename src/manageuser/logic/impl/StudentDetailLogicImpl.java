/**
 * Copyright(C) 2017 Luvina
 * StudentDetailLogicImpl.java, Jul 10, 2017
 */
package manageuser.logic.impl;
import java.sql.SQLException;

import manageuser.dao.impl.StudentDetailDaoImpl;
import manageuser.dao.impl.UserDaoImpl;
import manageuser.entities.StudentDetail;
import manageuser.entities.Users;
import manageuser.logic.StudentDetailLogic;
import manageuser.utils.Common;
public class StudentDetailLogicImpl implements StudentDetailLogic{

	/* (non-Javadoc)
	 * @see manageuser.logic.StudentDetailLogic#createStudent(manageuser.entities.StudentDetail)
	 */
	@Override
	public boolean createStudent(StudentDetail student) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		StudentDetailDaoImpl studentDetailDaoImpl = new StudentDetailDaoImpl();
		Users users = new Users();
		users.setUserID(student.getUserID());
		users.setPassword(Common.encodeText(student.getPassword()));
		users.setRoleId(student.getRoleId());
		users.setUserName(student.getUserName());
		try {
			userDaoImpl.insertUser(users);
			studentDetailDaoImpl.insertStudentInfor(student);
			userDaoImpl.commit();
			return true;
		} catch (SQLException e) {
			userDaoImpl.rollbackTrasaction();
			System.out.println("Lỗi thêm sinh viên " + e);
			return false;
		} finally {
			userDaoImpl.closeConnectionTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see manageuser.logic.StudentDetailLogic#updatePass(manageuser.entities.Users)
	 */
	@Override
	public boolean updatePass(Users user) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		user.setPassword(Common.encodeText(user.getPassword()));
		try {
			userDaoImpl.editUser(user);
			userDaoImpl.commit();
			return true;
		} catch (SQLException e) {
			System.out.println("Lỗi cập nhật mật khẩu");
			return false;
		} finally {
			userDaoImpl.closeConnectionTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see manageuser.logic.StudentDetailLogic#updateUserInfor(manageuser.entities.StudentDetail)
	 */
	@Override
	public boolean updateUserInfor(StudentDetail studentDetail) {
		StudentDetailDaoImpl studentDetailDaoImpl = new StudentDetailDaoImpl();
		try {
			studentDetailDaoImpl.editStudentInfor(studentDetail);
			return true;
		} catch (SQLException e) {
			System.out.println("Lỗi chỉnh sửa thông tin sinh viên");
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see manageuser.logic.StudentDetailLogic#deleteUser(int)
	 */
	@Override
	public boolean deleteUser(int studentID) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		StudentDetailDaoImpl studentDetailDaoImpl = new StudentDetailDaoImpl();
		try {
			studentDetailDaoImpl.deleteStudentInfor(studentID);
			userDaoImpl.deleteUser(studentID);
			userDaoImpl.commit();
			return true;
		} catch (SQLException e) {
			userDaoImpl.rollbackTrasaction();
			System.out.println("lỗi xóa sinh viên "+ e);
			return false;
		} finally {
			userDaoImpl.closeConnectionTransaction();
		}
		
	}
	// test
    public static void main(String[] args) {
		StudentDetailLogicImpl a = new StudentDetailLogicImpl();
		a.deleteUser(8);
	}

	/* (non-Javadoc)
	 * @see manageuser.logic.StudentDetailLogic#existUser(java.lang.String)
	 */
	@Override
	public String existUser(String userName) {
		StudentDetailDaoImpl studentDetailDaoImpl = new StudentDetailDaoImpl();
		return studentDetailDaoImpl.existUser(userName);
	}

	/* (non-Javadoc)
	 * @see manageuser.logic.StudentDetailLogic#existEmail(java.lang.String)
	 */
	@Override
	public String existEmail(String email) {
		StudentDetailDaoImpl studentDetailDaoImpl = new StudentDetailDaoImpl();
		return studentDetailDaoImpl.existEmail(email);
	}
	

}
