/**
 * 
 */
package manageuser.entities;

import java.sql.Date;

/**
 * @author LA-PM
 *
 */
public class Register {
	private int id;
	private String fullName;
	private String email;
	private Date birthday;
	private String tel;
	private String school;
	private int graduatedYear;
	private String major;
	private int status;
	private Date createdDate;
	private int iq;
	/**
	 * 
	 */
	public Register() {
		super();
	}
	/**
	 * @param id
	 * @param fullName
	 * @param email
	 * @param birthday
	 * @param tel
	 * @param school
	 * @param graduatedYear
	 * @param major
	 * @param status
	 * @param createdDate
	 * @param iq
	 */
	public Register(int id, String fullName, String email, Date birthday, String tel, String school, int graduatedYear,
			String major, int status, Date createdDate, int iq) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.birthday = birthday;
		this.tel = tel;
		this.school = school;
		this.graduatedYear = graduatedYear;
		this.major = major;
		this.status = status;
		this.createdDate = createdDate;
		this.iq = iq;
	}
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
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * @return the graduatedYear
	 */
	public int getGraduatedYear() {
		return graduatedYear;
	}
	/**
	 * @param graduatedYear the graduatedYear to set
	 */
	public void setGraduatedYear(int graduatedYear) {
		this.graduatedYear = graduatedYear;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the iq
	 */
	public int getIq() {
		return iq;
	}
	/**
	 * @param iq the iq to set
	 */
	public void setIq(int iq) {
		this.iq = iq;
	}
 }
