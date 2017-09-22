/**
 * 
 */
package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import manageuser.dao.RegisterDao;
import manageuser.entities.Register;

/**
 * @author LA-PM
 *
 */
public class RegisterDaoImpl extends BaseDaoImpl implements RegisterDao {

	private PreparedStatement pst;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * manageuser.dao.RegisterDao#insertRegister(manageuser.entities.Register)
	 */
	@Override
	public boolean addUserRegist(Register register) {
		Connection con = getConnection();
		if (con != null) {
			StringBuffer sql = new StringBuffer();
			int i = 0;
			sql.append(
					"insert into register (full_name,email,birthday,tel,school,graduated_year,major,status,created_date) ")
					.append("values (?,?,?,?,?,?,?,?,?)");
			System.out.println(sql.toString());
			try {
				pst = con.prepareStatement(sql.toString());
			
				pst.setString(++i, register.getFullName());
				pst.setString(++i, register.getEmail());
				pst.setDate(++i, register.getBirthday());
				pst.setString(++i, register.getTel());
				pst.setString(++i, register.getSchool());
				pst.setInt(++i, register.getGraduatedYear());
				pst.setString(++i, register.getMajor());
				pst.setInt(++i, register.getStatus());
				pst.setDate(++i, register.getCreatedDate());
				return (pst.executeUpdate() == 1);
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}

		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.RegisterDao#deleteUserRegist(int id)
	 */
	@Override
	public boolean deleteUserRegist(int id) {
		Connection con = getConnection();
		if (con != null) {
			StringBuffer sql = new StringBuffer();
			int i = 0;
			sql.append("delete from register where id =? ");
			try {
				pst = con.prepareStatement(sql.toString());
				pst.setInt(++i, id);
				return (pst.executeUpdate() == 1);
			} catch (SQLException e) {
				// logger.log(null, e.getMessage());
			} finally {
				closeConnection();
			}

		}

		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * manageuser.dao.RegisterDao#updateUserRegist(manageuser.entities.Register)
	 */
	@Override
	public boolean updateUserRegist(Register register) {
		Connection con = getConnection();
		if (con != null) {
			StringBuffer sql = new StringBuffer();
			int i = 0;
			sql.append(
					"update register set  full_name=? , email=? , birthday=?, tel=? , school=? , graduated_year=? ,major=?,status=?,created_date=?,iq=?")
					.append(" where id=? ");
			try {
				pst = con.prepareStatement(sql.toString());
				pst.setString(++i, register.getFullName());
				pst.setString(++i, register.getEmail());
				pst.setDate(++i, register.getBirthday());
				pst.setString(++i, register.getTel());
				pst.setString(++i, register.getSchool());
				pst.setInt(++i, register.getGraduatedYear());
				pst.setString(++i, register.getMajor());
				pst.setInt(++i, register.getStatus());
				pst.setDate(++i, register.getCreatedDate());
				pst.setInt(++i, register.getIq());
				pst.setInt(++i, register.getId());

				return (pst.executeUpdate() == 1);

			} catch (SQLException e) {
				e.printStackTrace();
				// logger.log(null, e.getMessage());
			} finally {
				closeConnection();
			}

		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.RegisterDao#addListUserRegist(List<Register>)
	 */
	@Override
	public boolean addListUserRegist(List<Register> listRegister) {
		Connection con = getConnection();
		if (getConnection() != null) {
			StringBuffer sql = new StringBuffer().append("Insert into register (full_name, email, birthday, tel, school, graduated_year,major,status,created_date,iq) values ");
			for (Register register : listRegister) {
				sql.append("(?,?,?,?,?,?,?,?,?,?),");
			}

			sql.deleteCharAt(sql.length()-1);
			System.out.println(sql.toString());
			int i = 0;
			try {
				pst = con.prepareStatement(sql.toString());
				for (Register register : listRegister) {

					pst.setString(++i, register.getFullName());
					pst.setString(++i, register.getEmail());
					pst.setDate(++i, register.getBirthday());
					pst.setString(++i, register.getTel());
					pst.setString(++i, register.getSchool());
					pst.setInt(++i, register.getGraduatedYear());
					pst.setString(++i, register.getMajor());
					pst.setInt(++i, register.getStatus());
					pst.setDate(++i, register.getCreatedDate());
					pst.setInt(++i, register.getIq());
				}
				
				return (pst.executeUpdate() > 0);

			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return false;
	}

	 
}



