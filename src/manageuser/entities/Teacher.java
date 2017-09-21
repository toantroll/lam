/**
 * Copyright(C) 2017  Luvina
 * Teacher.java, Sep 20, 2017  TranTheHong
 */
package manageuser.entities;

/**
 * @author HongTT
 *
 */
public class Teacher {
	private String teacherId;
	private String fullName;
	private String email;
	private String tel;
	/**
	 * @return the teacherId
	 */
	public String getTeacherId() {
		return teacherId;
	}
	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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
	
}
