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
			closeConnection();
		}
		return listStatus;
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.StatusStudentDao#existStatus(int)
	 */
	@Override
	public boolean existStatus(int statusID) {
		String sql = "select id from status_student where id = ?";
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, statusID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("lỗi kiểm tra tồn tại trạng thái " +e);
		} finally {
			closeConnection();
		}
		return false;
	}

}
