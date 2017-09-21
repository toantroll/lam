/**
 * Copyright(C) 2017 Luvina
 * BaseDaoImpl.java, Jul 10, 2017
 */
package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import manageuser.dao.BaseDao;
import manageuser.utils.DatabaseProperties;

/**
 * Chứa phương thức kết nối với csdl
 * @author DinhHop
 *
 */
public class BaseDaoImpl implements BaseDao{
	Connection conn = null;
	protected static Connection connTransaction = null; 
	
	/**
	 *  Khởi tạo contructor
	 */
	public BaseDaoImpl() {
		
	}


	/* (non-Javadoc)
	 * @see manageuser.dao.BaseDao#getConnection()
	 */
	@Override
	public Connection getConnection() {
		try {		
			String dirver = DatabaseProperties.getDatabase("DATABASE_DRIVER");
			String url = DatabaseProperties.getDatabase("DATABASE_URL");
			String user = DatabaseProperties.getDatabase("DATABASE_USER");
			String pass = DatabaseProperties.getDatabase("DATABASE_PASS");
			Class.forName(dirver);
			conn = DriverManager.getConnection(url, user, pass);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Có lỗi xảy ra ClassNotFoundException");
		} catch (SQLException e) {
			System.out.println("Có lỗi xảy ra SQLException");
		}
		return conn;
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.BaseDao#closeConnectionTrasaction(java.sql.Connection)
	 */
	@Override
	public void closeConnection(Connection conn) {
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Loi sql closeConnection" + e.getMessage());
			}
		}
	}


	/* (non-Javadoc)
	 * @see manageuser.dao.BaseDao#rollbackTrasaction(java.sql.Connection)
	 */
	@Override
	public void rollbackTrasaction() {
		if(connTransaction != null){
			try {
				connTransaction.rollback();
			} catch (SQLException e) {
				System.out.println("Loi sql rollbackTrasaction" + e.getMessage());
			}
		}
	}


	/* (non-Javadoc)
	 * @see manageuser.dao.BaseDao#getConnectionTransection()
	 */
	@Override
	public Connection getConnectionTransaction() throws SQLException {
		if(connTransaction == null) {			
			connTransaction = getConnection();
			connTransaction.setAutoCommit(false);
		}
		return connTransaction;
	}
}
