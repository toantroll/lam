/**
 * Copyright(C) 2017 Luvina Software Company
 *	TimeTableDetail.java 2017-09-22, toanvv
 */
package manageuser.entities;

import java.sql.Date;

/**
 * @author LA-PM
 *
 */
public class TimeTableDetail {
	private int id;
	private int timeTableInfoId;
	private int subjectId;
	private String subjectName;
	private int teacherId;
	private String teacherName;
	private String subjectContent;
	private Date startDate;
	private int hoursPerDay;
	private int status;
	private String startDateString;
	private String startHours;
	
	

	/**
	 * @return the startDateString
	 */
	public String getStartDateString() {
		return startDateString;
	}

	/**
	 * @param startDateString the startDateString to set
	 */
	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	/**
	 * @return the startHours
	 */
	public String getStartHours() {
		return startHours;
	}

	/**
	 * @param startHours the startHours to set
	 */
	public void setStartHours(String startHours) {
		this.startHours = startHours;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubjectContent() {
		return subjectContent;
	}

	public void setSubjectContent(String subjectContent) {
		this.subjectContent = subjectContent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTimeTableInfoId() {
		return timeTableInfoId;
	}
	public void setTimeTableInfoId(int timeTableInfoId) {
		this.timeTableInfoId = timeTableInfoId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getHoursPerDay() {
		return hoursPerDay;
	}
	public void setHoursPerDay(int hoursPerDay) {
		this.hoursPerDay = hoursPerDay;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
