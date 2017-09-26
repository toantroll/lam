/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * CourseDao.java,Sep 25, 2017 HoangThai
 */
package manageuser.dao;

import java.util.ArrayList;

import manageuser.entities.Course;

/**
 * @author LA-PM
 *
 */
public interface CourseDao {
	/**
	 * lấy danh sách khóa học 
	 * @return danh sách khoa học. không thể null; 
	 */
		public ArrayList<Course> getListCourse();
}
