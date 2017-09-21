/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * UserDaoImpl.java,Sep 20, 2017 HoangThai
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import manageuser.dao.UserDao;
import manageuser.entities.Users;
import manageuser.utils.Constant;

/**
 * @author LA-PM
 *
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see manageuser.dao.UserDao#addUser(manageuser.entities.Users)
	 */
	@Override
	public void insertUser(Users user) throws SQLException {
		String sql = "INSERT INTO Users (username, password, role_id) Values (?,?,?)";
		int count = 1;
		PreparedStatement preparedStatement = getConnectionTransaction().prepareStatement(sql);
		preparedStatement.setString(count++,user.getUserName());
		preparedStatement.setInt(count++, user.getRoleId());
		preparedStatement.executeUpdate(sql);
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.UserDao#editUser(manageuser.entities.Users)
	 */
	@Override
	public void editUser(Users user) throws SQLException {
		String sql = "Update Users Set password = ?, role_id = ? where id = ? ";
		PreparedStatement preparedStatement = getConnectionTransaction().prepareStatement(sql);
		preparedStatement.setString(1, user.getPassword());
		preparedStatement.setInt(2, user.getRoleId());
		preparedStatement.setInt(3, user.getUserID());
		preparedStatement.executeUpdate(sql);
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.UserDao#deleteUser(int)
	 */
	@Override
	public void deleteUser(int studentId) throws SQLException {
		String sql = "Update Users set role_id = ? where id = ?";
		PreparedStatement preparedStatement = getConnectionTransaction().prepareStatement(sql);
		preparedStatement.setInt(1, Constant.ROLE_UNACTIVE);
		preparedStatement.setInt(2, studentId);
		preparedStatement.executeUpdate(sql);
		
	}

}
