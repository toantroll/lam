package manageuser.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import manageuser.dao.StudentDetailDao;
import manageuser.entities.StudentDetail;

public class StudentDetailDaoImpl extends BaseDaoImpl implements StudentDetailDao {


	/* (non-Javadoc)
	 * @see manageuser.dao.StudentDetailDao#createStudentInfor(manageuser.entities.StudentDetail)
	 */
	public boolean createStudentInfor(StudentDetail studentInfor) {
		String sql = "INSERT INTO `student_detail` (`student_id`, `course_id`, `name`, `email`, `tel`, `id_card`, `address`, `school`, `major`, `graduated_year`, `gender`, `birthday`, `IQ`, `note`, `japan_level`, `interview`, `status`, `created_at`, `updated_at`) VALUES (LAST_INSERT_ID(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		PreparedStatement pre;
		
		int rs;
		int i = 1;
		try {
			Connection con = this.getConnectionTransaction();
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
			rs = pre.executeUpdate();
			if(rs != 0 ) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi createStudentInfor" + e);
		}
		return false;

	}
}
