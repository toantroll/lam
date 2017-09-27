package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import manageuser.dao.StudentDetailDao;
import manageuser.entities.StudentDetail;
import manageuser.utils.Constant;

public class StudentDetailDaoImpl extends BaseDaoImpl implements StudentDetailDao {

	@Override
	public void insertStudentInfor(StudentDetail studentInfor) throws SQLException{
			String sql = "INSERT INTO `student_detail` (`student_id`, `course_id`, `name`, `email`, `tel`, `id_card`, `address`, `school`, `major`, `graduated_year`, `gender`, `birthday`, `IQ`, `note`, `japan_level`, `interview`, `status`, `created_at`) VALUES (LAST_INSERT_ID(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now()) ";
			PreparedStatement pre;
			Connection con = this.getConnectionTransaction();
			int i = 1;
			pre = con.prepareStatement(sql);
			pre.setInt(i++, studentInfor.getCourseId());
			pre.setString(i++, studentInfor.getName());
			pre.setString(i++, studentInfor.getEmail());
			pre.setString(i++, studentInfor.getTel());
			pre.setString(i++, studentInfor.getIdCard());
			pre.setString(i++, studentInfor.getAdress());
			pre.setString(i++, studentInfor.getSchool());
			pre.setString(i++, studentInfor.getMajor());
			pre.setString(i++, studentInfor.getGraduatedYear());
			pre.setInt(i++, studentInfor.getGender());
			pre.setDate(i++, studentInfor.getBirthday());
			pre.setInt(i++, studentInfor.getScoreIQ());
			pre.setString(i++, studentInfor.getNote());
			pre.setString(i++, studentInfor.getJapanLevel());
			pre.setInt(i++, studentInfor.getScoreInterview());
			pre.setInt(i++, studentInfor.getStatus());
			pre.executeUpdate();
		}
	@Override
	public void editStudentInfor(StudentDetail studentInfor) throws SQLException {
		String sql = "UPDATE `student_detail` SET `course_id`=?, `name`=?, `email`=?, `tel`=?, `id_card`=?, `address`=?, `school`=?, `major`=?,`graduated_year`=? , `gender`=?, `birthday`=?, `IQ`=?, `note`=?, `japan_level`=?, `interview`=?, `status`=?, `updated_at`= now() WHERE `student_id`=?";
		PreparedStatement pre;
		Connection con = this.getConnection();
		int i = 1;
		pre = con.prepareStatement(sql);
		pre.setInt(i++, studentInfor.getCourseId());
		pre.setString(i++, studentInfor.getName());
		pre.setString(i++, studentInfor.getEmail());
		pre.setString(i++, studentInfor.getTel());
		pre.setString(i++, studentInfor.getIdCard());
		pre.setString(i++, studentInfor.getAdress());
		pre.setString(i++, studentInfor.getSchool());
		pre.setString(i++, studentInfor.getMajor());
		pre.setString(i++, studentInfor.getGraduatedYear());
		pre.setInt(i++, studentInfor.getGender());
		pre.setDate(i++, studentInfor.getBirthday());
		pre.setInt(i++, studentInfor.getScoreIQ());
		pre.setString(i++, studentInfor.getNote());
		pre.setString(i++, studentInfor.getJapanLevel());
		pre.setInt(i++, studentInfor.getScoreInterview());
		pre.setInt(i++, studentInfor.getStatus());
		pre.setInt(i++, studentInfor.getUserID());
		pre.executeUpdate();
		this.closeConnection();
	}
	@Override
	public void deleteStudentInfor(int userId) throws SQLException {
		String sql = "UPDATE `student_detail` SET `status`=? WHERE `student_id`= ?";
		PreparedStatement pre;
		Connection con = this.getConnectionTransaction();
		int i = 1;
		pre = con.prepareStatement(sql);
		pre.setInt(i++, Constant.STATUS_DELETE);
		pre.setInt(i++, userId);
		pre.executeUpdate();
	}
	/* (non-Javadoc)
	 * @see manageuser.dao.StudentDetailDao#existUser(java.lang.String)
	 */
	@Override
	public String existUser(String userName) {
		String sql = "Select username from users where username = ?";
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("username");
			}
		} catch (SQLException e) {
			System.out.println("lỗi kiểm tra tồn tại user");
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see manageuser.dao.StudentDetailDao#existEmail(java.lang.String)
	 */
	@Override
	public String existEmail(String email) {
		String sql = "Select email from users where email = ?";
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("email");
			}
		} catch (SQLException e) {
			System.out.println("lỗi kiểm tra tồn tại user");
		}
		return null;
	}
	


}
