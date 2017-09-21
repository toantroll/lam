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
	public void createUser(Users user) throws SQLException; 
	/**
	 * chỉnh sửa user 
	 * @param user đối tượng use cần thay đổi 
	 * @return
	 */
	public boolean editUser(Users user);
}
