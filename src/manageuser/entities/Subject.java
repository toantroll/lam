package manageuser.entities;

public class Subject {
	private String id;
	private String name;
	private String content;
	private int giaoVienId;
	private String giaoVienName;
	private String createTime;
	private String deleteTime;
	private String updateTime;
	private int flag;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the deleteTime
	 */
	public String getDeleteTime() {
		return deleteTime;
	}

	/**
	 * @param deleteTime
	 *            the deleteTime to set
	 */
	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * @param flag
	 *            the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}

	/**
	 * @return the giaoVienId
	 */
	public int getGiaoVienId() {
		return giaoVienId;
	}

	/**
	 * @param giaoVienId
	 *            the giaoVienId to set
	 */
	public void setGiaoVienId(int giaoVienId) {
		this.giaoVienId = giaoVienId;
	}

	/**
	 * @return the giaoVienName
	 */
	public String getGiaoVienName() {
		return giaoVienName;
	}

	/**
	 * @param giaoVienName
	 *            the giaoVienName to set
	 */
	public void setGiaoVienName(String giaoVienName) {
		this.giaoVienName = giaoVienName;
	}

}
