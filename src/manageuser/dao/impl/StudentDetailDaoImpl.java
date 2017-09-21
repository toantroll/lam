package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manageuser.dao.StudentDetailDao;
import manageuser.entities.StudentDetail;

public class StudentDetailDaoImpl extends BaseDaoImpl implements StudentDetailDao {

	@Override
	public void createStudentInfor(StudentDetail studentInfor) throws SQLException{
			String sql = "INSERT INTO `student_detail` (`student_id`, `course_id`, `name`, `email`, `tel`, `id_card`, `address`, `school`, `major`, `graduated_year`, `gender`, `birthday`, `IQ`, `note`, `japan_level`, `interview`, `status`, `created_at`, `updated_at`) VALUES (LAST_INSERT_ID(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
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
			pre.setString(i++, studentInfor.getGender());
			pre.setDate(i++, studentInfor.getBirthday());
			pre.setInt(i++, studentInfor.getScoreIQ());
			pre.setString(i++, studentInfor.getNote());
			pre.setString(i++, studentInfor.getJapanLevel());
			pre.setInt(i++, studentInfor.getScoreInterview());
			pre.setString(i++, studentInfor.getStatus());
			pre.setDate(i++, studentInfor.getCreatedDate());
			pre.setDate(i++, studentInfor.getUpdatedDate());
			pre.executeUpdate();
		}
	@Override
	public void updateStudentInfor(StudentDetail studentInfor) throws SQLException {
		String sql = "UPDATE `student_detail` SET `course_id`=?, `name`=?, `email`=?, `tel`=?, `id_card`=?, `address`=?, `school`=?, `gender`=?, `birthday`=?, `major`=?, `graduated_year`=?, `IQ`=?, `note`=?, `japan_level`=?, `interview`=?, `status`=?, `created_at`=?, `updated_at`=? WHERE `student_id`=?";
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
		pre.setString(i++, studentInfor.getGender());
		pre.setDate(i++, studentInfor.getBirthday());
		pre.setInt(i++, studentInfor.getScoreIQ());
		pre.setString(i++, studentInfor.getNote());
		pre.setString(i++, studentInfor.getJapanLevel());
		pre.setInt(i++, studentInfor.getScoreInterview());
		pre.setString(i++, studentInfor.getStatus());
		pre.setDate(i++, studentInfor.getCreatedDate());
		pre.setDate(i++, studentInfor.getUpdatedDate());
	}
	
}
