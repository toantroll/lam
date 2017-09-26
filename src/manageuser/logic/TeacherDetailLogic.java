/**
 * Copyright(C) 2017  Luvina
 * TeacherDetailLogic.java, Sep 21, 2017  TranTheHong
 */
package manageuser.logic;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.TeacherDetail;

/**
 * @author HongTT
 *
 */
public interface TeacherDetailLogic {
	/**
	 * Lấy danh sách thông tin giáo viên .
	 * @return danh sách thông tin giáo viên
	 * @throws SQLException
	 */
	public List<TeacherDetail> getAllTeacherDetail() throws SQLException;

	/**
	 * Thêm thông tin giáo viên vào DB
	 * @param teacherDetail  chi tiết thông tin giáo viên
	 * @return true: thêm thành công , false: thêm thất bại
	 * @throws SQLException
	 */
	public boolean createTeacherDetail(TeacherDetail teacherDetail) throws SQLException;

	/**
	 * Sửa thông tin giáo viên
	 * @param teacherId  mã giáo viên
	 * @return true: sửa thành công , false: sửa thất bại
	 */
	public boolean updateTeacherDetail(TeacherDetail teacherDetail);

	/**
	 * Ẩn thông tin giáo viên và thay đổi  quyền truy cập
	 * @param teacherId mã giáo viên
	 * @return true : delete thành công , false: không thành c
	 */
	public boolean deleteTeacherDetail(int teacherId);
	/**
	 * Kiểm tra giáo viên có tồn tại trong DB không .
	 * @param teacherId mã giáo viên	
	 * @return true : có trong DB , false: không có trong DB
	 */
	public boolean checkExistedTeacherDetailById(int teacherId);

}
