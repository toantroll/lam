/**
 * Copyright(C) 2017  Luvina
 * TeacherDetailLogic.java, Sep 21, 2017  TranTheHong
 */
package manageuser.logic;

import java.sql.SQLException;

import manageuser.entities.TeacherDetail;

/**
 * @author HongTT
 *
 */
public interface TeacherDetailLogic {
	/**
	 * Thêm thông tin giáo viên vào DB
	 * @param teacherDetail chi tiết thông tin giáo viên
	 * @return true: thêm thành công , false: thêm thất bại
	 * @throws SQLException 
	 */
	public boolean createTeacherDetail(TeacherDetail teacherDetail) throws SQLException;
}
