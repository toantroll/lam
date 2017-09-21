package manageuser.dao;
import manageuser.entities.StudentDetail;

public interface StudentDetailDao {
	/**
	 * Ghi du lieu thong tin Student vao DB
	 * @param studentInfor đối tượng lưu thông tin
	 * @return Ghi thành công trả về true nếu không trả về false
	 */
	public boolean createStudentInfor(StudentDetail studentInfor);
}
