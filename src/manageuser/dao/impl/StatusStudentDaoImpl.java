/**
 * 
 */
package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manageuser.dao.StatusStudentDao;
import manageuser.entities.StatusStudent;

/**
 * @author LA-PM
 *
 */
public class StatusStudentDaoImpl extends BaseDaoImpl implements StatusStudentDao{

	/* (non-Javadoc)
	 * @see manageuser.dao.StatusStudentDao#getStatus()
	 */
	@Override
	public ArrayList<StatusStudent> getStatus() {
		Connection conn = getConnection();
		ResultSet rs = null;
		ArrayList<StatusStudent> listStatus = new ArrayList<>();
		String sql = "Select * from status_student";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				StatusStudent ss = new StatusStudent();
				ss.setId(rs.getInt("id"));
				ss.setNameStatus(rs.getString("name_status"));
				listStatus.add(ss);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("Lỗi sql statusStudent " + e.getMessage());
		}finally {
			closeConnection(conn);
		}
		return listStatus;
	}

}
