/**
 * 
 */
package manageuser.entities;

/**
 * @author LA-PM
 *
 */
public class StatusStudent {
	private int id;
	private String nameStatus;
	/**
	 * 
	 */
	public StatusStudent() {
		super();
	}
	/**
	 * @param id
	 * @param nameStatus
	 */
	public StatusStudent(int id, String nameStatus) {
		super();
		this.id = id;
		this.nameStatus = nameStatus;
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
	 * @return the nameStatus
	 */
	public String getNameStatus() {
		return nameStatus;
	}
	/**
	 * @param nameStatus the nameStatus to set
	 */
	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

}
