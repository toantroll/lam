/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * UserDaoImpl.java,Sep 20, 2017 HoangThai
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	 * @see manageuser.dao.UserDao#checkAccount(java.lang.String, java.lang.String)
	 */
	public boolean checkAccount(String userName, String password) {
		String sql = "select id from users where username=? and password=?";
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print("lỗi kiểm tra tài khoản");
			return false;
		} finally {
			closeConnection();
		}
		return false;

	}

	/* (non-Javadoc)
	 * @see manageuser.dao.UserDao#addUser(manageuser.entities.Users)
	 */
	@Override
	public void insertUser(Users user) throws SQLException {
		String sql = "INSERT INTO Users (username, password, role_id) Values (?,?,?)";
		int count = 1;
		PreparedStatement preparedStatement = getConnectionTransaction().prepareStatement(sql);
		preparedStatement.setString(count++,user.getUserName());
		preparedStatement.setString(count++, user.getPassword());
		preparedStatement.setInt(count++, user.getRoleId());
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.UserDao#editUser(manageuser.entities.Users)
	 */
	@Override
	public void editUser(Users user) throws SQLException {
		String sql = "Update Users Set password = ?, role_id = ? where id = ? ";
		PreparedStatement preparedStatement = getConnectionTransaction().prepareStatement(sql);
		int count = 1;
		preparedStatement.setString(count++ , user.getPassword());
		preparedStatement.setInt(count++ , user.getRoleId());
		preparedStatement.setInt(count++ , user.getUserID());
		preparedStatement.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.UserDao#deleteUser(int)
	 */
	@Override
	public void deleteUser(int studentId) throws SQLException {
		String sql = "Update Users set role_id = ? where id = ?";
		PreparedStatement preparedStatement = getConnectionTransaction().prepareStatement(sql);
		int count = 1;
		preparedStatement.setInt(count++, Constant.ROLE_UNACTIVE);
		preparedStatement.setInt(count++, studentId);
		preparedStatement.executeUpdate();
	}

	/**
	 * @param userName
	 * @return
	 */
	public Users getUsers(String userName) {
		Users users=null;
		String sql="select id,role_id from users where username = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				users=new Users();
				int i = 1;
				users.setUserID(resultSet.getInt(i++));
				users.setRoleId(resultSet.getInt(i++));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}

}
