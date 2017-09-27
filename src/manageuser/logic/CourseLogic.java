/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * CourseLogic.java,Sep 25, 2017 HoangThai
 */
package manageuser.logic;

import java.util.ArrayList;

import manageuser.entities.Course;

/**
 * @author LA-PM
 *
 */
public interface CourseLogic  {
	/**
	 * logic lấy danh sách khóa học
	 * @return danh sách các khóa học. không có khóa học trả về danh sách có size = 0;
	 */
	public ArrayList<Course> getListCourse();
	/**
	 * kiểm tra khóa học có tồn tại hay không 
	 * @param courseID mã khóa học cần kiểm tra 
	 * @return true nếu tồn tại khóa học và false nếu không tồn tại   
	 */
	public boolean existCourse(int courseID);
}
