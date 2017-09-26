/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * CouserDaoImpl.java,Sep 25, 2017 HoangThai
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manageuser.dao.CourseDao;
import manageuser.entities.Course;

/**
 * @author LA-PM
 *
 */
public class CourseDaoImpl extends BaseDaoImpl implements CourseDao {

	/* (non-Javadoc)
	 * @see manageuser.dao.CourseDao#getListCourse()
	 */
	@Override
	public ArrayList<Course> getListCourse() {
		ArrayList<Course> listCourse = new ArrayList<Course>();
		String sql = "select id, course_name, start_date, end_date from course";
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Course course = new Course();
				course.setId(resultSet.getInt("id"));
				course.setCourser_name(resultSet.getString("course_name"));
				course.setStart_date(resultSet.getDate("start_date"));
				course.setEndDate(resultSet.getDate("end_date"));
				listCourse.add(course);
			}
		} catch (SQLException e) {
			System.out.println("Lỗi get listCourse");
		} finally {
			closeConnection();
		}
		return listCourse;
	}

}
