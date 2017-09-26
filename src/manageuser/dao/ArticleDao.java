/**
 * Copyright(C) 2017  Luvina
 * ArticleDao.java, Sep 25, 2017  TranTheHong
 */
package manageuser.dao;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.Article;

/**
 * @author HongTT
 *
 */
public interface ArticleDao {
	/**
	 * Lấy tất cả tiêu đề bài viết .
	 * 
	 * @return danh sách tiêu đề bài viết .
	 * @throws SQLException
	 */
	public List<Article> getAllActicle() throws SQLException;

	/**
	 * Lấy thông tin bài viết theo id
	 * 
	 * @param acticleId
	 *            mã bài viết
	 * @return Đối tượng lưu thông tin bài viết .
	 * @throws SQLException
	 */
	public Article getActicleById(int acticleId) throws SQLException;
}
