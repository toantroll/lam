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
	/**
	 * kiểm tra tồn tại tên đăng nhập 
	 * @param studentName tên đăng nhập cần kiểm tra 
	 * @return
	 */
	public String existUser(String userName);
	/**
	 * kiểm tra tồn tại email
	 * @param email email cần tìm kiếm 
	 * @return tên email nếu đã tồn tại và null nếu chưa tồn tại
	 */
	public String existEmail(String email);
}
