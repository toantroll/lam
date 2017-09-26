/**
 * Copyright(C) 2017  Luvina
 * Article.java, Sep 25, 2017  TranTheHong
 */
package manageuser.entities;

import java.sql.Date;

/**
 * @author HongTT
 *
 */
public class Article {
	private int id;
	private int author_id;
	private String title;
	private String content;
	private String img_link;
	private Date created_at;
	private Date deleted_at;
	private String nameAuthor;

	/**
	 * @return the nameAuthor
	 */
	public String getNameAuthor() {
		return nameAuthor;
	}

	/**
	 * @param nameAuthor
	 *            the nameAuthor to set
	 */
	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	private int deleted_flag;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the author_id
	 */
	public int getAuthor_id() {
		return author_id;
	}

	/**
	 * @param author_id
	 *            the author_id to set
	 */
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the img_link
	 */
	public String getImg_link() {
		return img_link;
	}

	/**
	 * @param img_link
	 *            the img_link to set
	 */
	public void setImg_link(String img_link) {
		this.img_link = img_link;
	}

	/**
	 * @return the created_at
	 */
	public Date getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at
	 *            the created_at to set
	 */
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the deleted_at
	 */
	public Date getDeleted_at() {
		return deleted_at;
	}

	/**
	 * @param deleted_at
	 *            the deleted_at to set
	 */
	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	/**
	 * @return the deleted_flag
	 */
	public int getDeleted_flag() {
		return deleted_flag;
	}

	/**
	 * @param deleted_flag
	 *            the deleted_flag to set
	 */
	public void setDeleted_flag(int deleted_flag) {
		this.deleted_flag = deleted_flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [id=" + id + ", author_id=" + author_id + ", title=" + title + ", content=" + content
				+ ", img_link=" + img_link + ", created_at=" + created_at + ", deleted_at=" + deleted_at
				+ ", deleted_flag=" + deleted_flag + "]";
	}

}
