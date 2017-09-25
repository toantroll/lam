/**
 * Copyright(C) 2017  Luvina
 * ArticleDaoImpl.java, Sep 25, 2017  TranTheHong
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manageuser.dao.ArticleDao;
import manageuser.entities.Article;

/**
 * @author HongTT
 *
 */
public class ArticleDaoImpl extends BaseDaoImpl implements ArticleDao {

	/*
	 * @see manageuser.dao.ArticleDao#getAllTitle()
	 */
	@Override
	public List<Article> getAllTitle() throws SQLException {		
		List<Article> articleLst= new ArrayList<>();		
		String sql = "SELECT id,title FROM article ORDER BY created_at DESC";
		PreparedStatement pstm = getConnection().prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Article article= new Article();
			article.setId(rs.getInt(1));
			article.setTitle(rs.getString(2));
			articleLst.add(article);
		}
		return articleLst;
	}

	public static void main(String[] args) {
		ArticleDaoImpl articleDaoImpl = new ArticleDaoImpl();
		try {
			System.out.println(articleDaoImpl.getActicleById(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * @see manageuser.dao.ArticleDao#getActicleById(int)
	 */
	@Override
	public Article getActicleById(int acticleId) throws SQLException {
		Article article = new Article();
		String sql = "SELECT * FROM article  WHERE id=? ORDER BY created_at DESC";
		PreparedStatement pstm = getConnection().prepareStatement(sql);
		pstm.setInt(1, acticleId);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			article.setAuthor_id(rs.getInt("author_id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setImg_link(rs.getString("img_link"));
			article.setCreated_at(rs.getDate("created_at"));
			article.setDeleted_at(rs.getDate("deleted_at"));
			article.setDeleted_flag(rs.getInt("deleted_flag"));
		}
		return article;
	}
}
