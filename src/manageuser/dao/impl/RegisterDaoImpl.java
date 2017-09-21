/**
 * 
 */
package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manageuser.dao.RegisterDao;
import manageuser.entities.Register;

/**
 * @author LA-PM
 *
 */
public class RegisterDaoImpl extends BaseDaoImpl implements RegisterDao{

	/* (non-Javadoc)
	 * @see manageuser.dao.RegisterDao#insertRegister(manageuser.entities.Register)
	 */
	@Override
	public boolean insertRegister(Register register) {
		Connection conn = getConnection();
		String sql = "INSERT INTO register (full_name, email, tel, graduated_year, school, major, birthday, status, created_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, register.getFullName());
			ps.setString(i++, register.getEmail());
			ps.setString(i++, register.getTel());
			ps.setInt(i++, register.getGraduatedYear());
			ps.setString(i++, register.getSchool());
			ps.setString(i++, register.getMajor());
			ps.setDate(i++, register.getBirthday());
			ps.setInt(i++, register.getStatus());
			ps.setDate(i++, register.getCreatedDate());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Lỗi câu lệnh sql " + e.getMessage());
			return false;
		}finally {
			closeConnection();
		}
	}

}
