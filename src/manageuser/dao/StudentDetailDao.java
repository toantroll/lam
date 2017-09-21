package manageuser.dao;
import java.sql.SQLException;

import manageuser.entities.StudentDetail;

public interface StudentDetailDao {
	/**
	 * Ghi du lieu thong tin Student vao DB
	 * @param studentInfor đối tượng lưu thông tin
	 * @throws SQLException
	 */
	public void insertStudentInfor(StudentDetail studentInfor) throws SQLException;
	/**
	 * Update dữ liệu thông tin StudentInfor vào Db
	 * @param studentDetail
	 * @throws SQLException
	 */
	public void editStudentInfor(StudentDetail studentDetail) throws SQLException ;
	
	/**
	 * Ẩn thông tin sinh viên
	 * @param userId
	 * @throws SQLException
	 */
	public void deleteStudentInfor(int userId) throws SQLException;
}
