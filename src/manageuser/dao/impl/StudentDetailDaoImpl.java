package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manageuser.dao.StudentDetailDao;
import manageuser.entities.StudentDetail;
import manageuser.logic.impl.StudentDetailLogicImpl;
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
			pre.setString(i++, studentInfor.getStatus());
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
		pre.setString(i++, studentInfor.getStatus());
		pre.setInt(i++, studentInfor.getUserID());
		System.out.println(pre.toString());
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
	
	public static void main(String[] args) {
		Date date = new Date(2017, 2, 7);
		StudentDetail detail = new StudentDetail();
		detail.setUserID(14);
		detail.setCourseId(16);
		detail.setName("thai dui1");
		detail.setTel("123456");
		detail.setIdCard("12345678");
		detail.setAdress("12345678");
		detail.setSchool("12345678");
		detail.setMajor("12345678");
		detail.setGraduatedYear("1994");
		detail.setScoreIQ(12);
		detail.setNote("12345678");
		detail.setJapanLevel("N3");
		detail.setScoreInterview(12);
		detail.setStatus("3");
		detail.setEmail("12345678");
		detail.setBirthday(date);
		detail.setGender(0);
		detail.setUserName("hunghb9x");
		detail.setPassword("123456");
		detail.setRoleId(4);
		StudentDetailLogicImpl studentDetailLogicImpl = new StudentDetailLogicImpl();
		//System.out.println(studentDetailLogicImpl.createStudent(detail));
		System.out.println(studentDetailLogicImpl.deleteUser(14));
	}

}
