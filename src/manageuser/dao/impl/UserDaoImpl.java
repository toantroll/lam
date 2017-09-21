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

/**
 * @author LA-PM
 *
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see manageuser.dao.UserDao#addUser(manageuser.entities.Users)
	 */
	@Override
	public void createUser(Users user) throws SQLException {
		String sql = "INSERT INTO Users (id, username, password, role_id) Values (?,?,?,?)";
		int count = 1;
		PreparedStatement preparedStatement = getConnectionTransaction().prepareStatement(sql);
		preparedStatement.setString(count++,user.getUserID());
		preparedStatement.setString(count++,user.getUserName());
		preparedStatement.setInt(count++, user.getRoleId());
		preparedStatement.executeUpdate(sql);
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.UserDao#editUser(manageuser.entities.Users)
	 */
	@Override
	public boolean editUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

}
