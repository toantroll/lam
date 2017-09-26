/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * CourseLogicImpl.java,Sep 25, 2017 HoangThai
 */
package manageuser.logic.impl;

import java.util.ArrayList;

import manageuser.dao.impl.BaseDaoImpl;
import manageuser.dao.impl.CourseDaoImpl;
import manageuser.entities.Course;
import manageuser.logic.CourseLogic;

/**
 * @author LA-PM
 *
 */
public class CourseLogicImpl extends BaseDaoImpl implements CourseLogic {

	/* (non-Javadoc)
	 * @see manageuser.logic.CourseLogic#getListCourse()
	 */
	@Override
	public ArrayList<Course> getListCourse() {
		CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
		return courseDaoImpl.getListCourse();
	}
 
}
