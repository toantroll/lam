package manageuser.dao;

import manageuser.entities.Subject;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface chứa các phương thức thao tác với bảng subjects
 * 
 * @author LA-PM
 *
 */
public interface SubjectDao {
	/**
	 * Lấy môn học khi biết mã môn học
	 * 
	 * @param id
	 *            mã môn học
	 * @return môn học
	 */
	public Subject getSubjectById(String id);

	/**
	 * Thêm mới môn học vào bảng subjects
	 * 
	 * @param subject
	 *            môn học cần thêm
	 * @return true nếu insert thành công <br/>
	 *         flase nếu insert không thành công
	 */
	public boolean insertSubject(Subject subject);

	/**
	 * Xóa môn học khỏi khóa học
	 * 
	 * @param subject
	 *            môn học cần xóa
	 * @return true nếu insert thành công <br/>
	 *         flase nếu insert không thành công
	 */
	public boolean deleteSubject(Subject subject);

	/**
	 * Sửa môn học trong bảng subjects
	 * 
	 * @param subject
	 *            môn học cần sửa
	 * @return true nếu insert thành công <br/>
	 *         flase nếu insert không thành công
	 */
	public boolean editSubject(Subject subject);

	/**
	 * Lấy ra tổng số môn học dựa theo điều kiện tìm kiếm là mã môn học và tên môn
	 * học
	 * 
	 * @param id
	 *            mã môn học
	 * @param name
	 *            tên môn học
	 * @return tổng số môn học
	 */
	public int getTotalSubject(String id, String name);

	/**
	 * Lấy ra danh sách môn học dựa theo điều kiện tìm kiếm là mã môn học và tên môn
	 * 
	 * @param id
	 *            mã môn học
	 * @param name
	 *            tên môn học
	 * @param offset
	 *            vị trí lấy bản ghi
	 * @param limit
	 *            số bản ghi tối đa
	 * @return danh sách môn học
	 */
	public List<Subject> getListSubject(String id, String name, int offset, int limit);
	
	/**
	 * get all subject
	 * @return list subject
	 * @throws SQLException SQLException
	 */
	public List<Subject> getAllSubject() throws SQLException;
}
