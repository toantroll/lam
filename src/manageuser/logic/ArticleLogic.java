/**
 * Copyright(C) 2017  Luvina
 * ArticleLogic.java, Sep 25, 2017  TranTheHong
 */
package manageuser.logic;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.Article;

/**
 * @author HongTT
 *
 */
public interface ArticleLogic {
	/**
	 * Lấy tất cả tiêu đề bài viết
	 * @return
	 * @throws SQLException 
	 */
	public List<Article> getAllTitle() throws SQLException;
	/**
	 * Lấy thông tin bài viết theo id
	 * @param acticleId
	 * @return
	 * @throws SQLException 
	 */
	public Article getActicleById(int acticleId) throws SQLException;
}
