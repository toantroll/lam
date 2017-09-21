/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * UserDao.java,Sep 20, 2017 HoangThai
 */
package manageuser.dao;

import java.sql.SQLException;

import manageuser.entities.Users;

/**
 * @author LA-PM
 *
 */
public interface UserDao {
	/**
	 * 
	 * @param user đối tượng đăng nhập
	 * @return true nếu thêm thành false nếu thêm không thành công
	 */
	public void insertUser(Users user) throws SQLException; 
	/**
	 * chỉnh sửa user 
	 * @param user đối tượng use cần thay đổi 
	 * @return
	 */
	public void editUser(Users user) throws SQLException;
	/**
	 * khóa khả năng đăng nhập
	 * @param studentId
	 * @throws SQLException ném ngoại lệ nếu update không thành công 
	 */
	public void deleteUser(int studentId) throws SQLException;
	
}
