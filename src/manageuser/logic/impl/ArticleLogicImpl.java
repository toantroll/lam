/**
 * Copyright(C) 2017  Luvina
 * ArticleLogicImpl.java, Sep 25, 2017  TranTheHong
 */
package manageuser.logic.impl;

import java.sql.SQLException;
import java.util.List;

import manageuser.dao.impl.ArticleDaoImpl;
import manageuser.entities.Article;
import manageuser.logic.ArticleLogic;

/**
 * @author HongTT
 *
 */
public class ArticleLogicImpl implements ArticleLogic {
	ArticleDaoImpl articleDaoImpl = new  ArticleDaoImpl();
	/* (non-Javadoc)
	 * @see manageuser.logic.ArticleLogic#getAllTitle()
	 */
	@Override
	public List<Article> getAllTitle() throws SQLException {		
		return articleDaoImpl.getAllTitle();
	}
	/*
	 * @see manageuser.logic.ArticleLogic#getActicleById(int)
	 */
	@Override
	public Article getActicleById(int acticleId) throws SQLException {
		return articleDaoImpl.getActicleById(acticleId);
	}

}
