/**
 * Copyright(C) 2017 Luvina
 * BaseDao.java, Jul 10, 2017 
 */
package manageuser.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Chứa phương thức kết nối với csdl
 * @author LA
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
	public void rollbackTrasaction();
	/**
	 * lấy kết nối sử dụng Transaction
	 * @return kết nối 
	 */
	public Connection getConnectionTransaction() throws SQLException ;
	/**
	 * lưu dữ liệu Transaction vào dataBase
	 * @throws SQLException ném ngoại lệ nếu commit lỗi 
	 */
	public void Commit() throws SQLException;
	
}
