/**
 * Copyright(C) 2017  Luvina
 * TeacherDetailLogic.java, Sep 21, 2017  TranTheHong
 */
package manageuser.logic;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.Teacher;
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
	/**
	 * Sửa thông tin giáo viên
	 * @param teacherId mã giáo viên
	 * @return true: sửa thành công , false: sửa thất bại
	 */
	public boolean updateTeacherDetail(Teacher teacher);
	/**
	 * Lấy danh sách thông tin giáo viên.
	 * @return danh sách thông tin giáo viên
	 */
	public List<TeacherDetail> getAllTeacherDetail();
}
