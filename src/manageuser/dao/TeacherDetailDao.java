/**
 * Copyright(C) 2017  Luvina
 * TeacherDao.java, Sep 20, 2017  TranTheHong
 */
package manageuser.dao;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.Teacher;
import manageuser.entities.TeacherDetail;

/**
 * @author HongTT
 *
 */
public interface TeacherDetailDao extends BaseDao {
	/**
	 * Lấy tất cả thông tin giáo viên trong cơ sở dữ liệu.
	 * @return danh sách thông tin giáo viên.
	 * @throws SQLException 
	 */
	public List<TeacherDetail> getAllTeacherDetail() throws SQLException;
	/**
	 * Thêm dữ liệu giáo viên vào cơ sơ dữ liệu.
	 * @param teacher đối tượng thông tin giáo viên
	 * @throws SQLException 
	 */
	public void insertTeacher(TeacherDetail teacherDetail) throws SQLException;
	/**
	 * Sửa thông tin giáo viên
	 * @param teacher đối tượng lưu thông tin giáo viên
	 * @throws SQLException 
	 */
	public void updateTeacher(Teacher teacher) throws SQLException;
	/**
	 * Xóa thông tin giáo viên
	 * @param teacherId
	 * @throws SQLException 
	 */
	public void deleteTeacher(int teacherId) throws SQLException;
}
