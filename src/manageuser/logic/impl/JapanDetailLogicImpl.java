/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * JapanDetailLogicImpl.java,Sep 26, 2017 HoangThai
 */
package manageuser.logic.impl;

import java.util.ArrayList;

import manageuser.dao.impl.JapanDetailDaoImpl;
import manageuser.entities.JapanDetail;
import manageuser.logic.JanpanDetailLogic;

/**
 * @author LA-PM
 *
 */
public class JapanDetailLogicImpl implements JanpanDetailLogic {

	/* (non-Javadoc)
	 * @see manageuser.logic.JanpanDetailLogic#getListJapanDetail()
	 */
	@Override
	public ArrayList<JapanDetail> getListJapanDetail() {
		JapanDetailDaoImpl japanDetailDaoImpl = new JapanDetailDaoImpl();
		return japanDetailDaoImpl.getListJapanDetail();
	}

	/* (non-Javadoc)
	 * @see manageuser.logic.JanpanDetailLogic#existJapanLevel(java.lang.String)
	 */
	@Override
	public String existJapanLevel(String japanlevel) {
		JapanDetailDaoImpl japanDetailDaoImpl = new JapanDetailDaoImpl();
		return japanDetailDaoImpl.existJapanLevel(japanlevel);
	}
	
}
