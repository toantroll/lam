/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * Course.java,Sep 25, 2017 LA-PM
 */
package manageuser.entities;

import java.sql.Date;

/**
 * @author LA-PM
 *
 */
public class Course {
	private  int id;
	private String courser_name;
	private Date start_date;
	private Date endDate;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the courser_name
	 */
	public String getCourser_name() {
		return courser_name;
	}
	/**
	 * @param courser_name the courser_name to set
	 */
	public void setCourser_name(String courser_name) {
		this.courser_name = courser_name;
	}
	/**
	 * @return the start_date
	 */
	public Date getStart_date() {
		return start_date;
	}
	/**
	 * @param start_date the start_date to set
	 */
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
