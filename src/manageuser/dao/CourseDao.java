/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * CourseDao.java,Sep 25, 2017 HoangThai
 */
package manageuser.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import manageuser.entities.Course;

/**
 * @author LA-PM
 *
 */
public interface CourseDao {
	/**
	 * lấy danh sách khóa học
	 * 
	 * @return danh sách khoa học. không thể null;
	 */
	public ArrayList<Course> getListCourse();

	/**
	 * kiểm tra khóa học có tồn tại hay không
	 * 
	 * @param courseID
	 *            mã khóa học cần kiểm tra
	 * @return true nếu tồn tại khóa học và false nếu không tồn tại
	 */
	public boolean existCourse(int courseID);

	/**
	 * check exists
	 * 
	 * @param id
	 *            course id
	 * @return return true if exists
	 * @throws SQLException
	 *             SQLException
	 */
	public boolean isExistCourseById(int id) throws SQLException;

}
