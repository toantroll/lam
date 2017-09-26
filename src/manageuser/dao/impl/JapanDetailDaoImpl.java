/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * JapanDetailDaoImpl.java,Sep 25, 2017 HoangThai
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manageuser.dao.JapanDetailDao;
import manageuser.entities.JapanDetail;

/**
 * @author LA-PM
 *
 */
public class JapanDetailDaoImpl extends BaseDaoImpl implements JapanDetailDao{

	/* (non-Javadoc)
	 * @see manageuser.dao.JapanDetailDao#getListJapanDetail()
	 */
	@Override
	public ArrayList<JapanDetail> getListJapanDetail() {
		ArrayList<JapanDetail> listJapan = new ArrayList<JapanDetail>();
		String sql = "Select code_level, name_level from japan_detail";
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				JapanDetail japanDetail = new JapanDetail();
				japanDetail.setCodeLevel(resultSet.getString("code_level"));
				japanDetail.setNameLevel(resultSet.getString("Name_level"));
				listJapan.add(japanDetail);
			}
		} catch (SQLException e) {
			System.out.println("Lỗi tiếng nhật");
		} finally {
			closeConnection();
		}
		return listJapan;
	}

}
