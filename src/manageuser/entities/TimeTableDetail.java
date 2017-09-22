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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int timeTableInfoId;
	private int subjectId;
	private int teacherId;
	private Date startDate;
	private int hoursPerDay;
	private int status;
	
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
