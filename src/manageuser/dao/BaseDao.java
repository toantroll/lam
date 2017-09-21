/**
 * Copyright(C) 2017 Luvina
 * BaseDao.java, Jul 10, 2017 
 */
package manageuser.dao;

import java.sql.Connection;

/**
 * Chứa phương thức kết nối với csdl
 * @author DinhHop
 *
 */
public interface BaseDao {
	/**
	 * 
	 *Thực hiện kết nối cơ sở dữ liệu 
	 */
	public Connection getConnection();
	/**
	 * Thực hiện xóa connection
	 * @param conn tham số kiểu Connection
	 */
	public void closeConnection(Connection conn);
	
	/**
	 * Thực hiện rollback connection
	 * @param conn conn tham số kiểu Connection
	 */
	public void rollbackTrasaction(Connection conn);
}
