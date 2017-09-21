package manageuser.dao.impl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import manageuser.dao.StudentDetailDao;
import manageuser.entities.StudentDetail;

public class StudentDetailDaoImpl extends BaseDaoImpl implements StudentDetailDao {


	/* (non-Javadoc)
	 * @see manageuser.dao.StudentDetailDao#createStudentInfor(manageuser.entities.StudentDetail)
	 */
	public boolean createStudentInfor(StudentDetail studentInfor) {
		String sql = "INSERT INTO `student_detail` (`student_id`, `course_id`, `name`, `email`, `tel`, `id_card`, `address`, `school`, `major`, `graduated_year`, `gender`, `birthday`, `IQ`, `note`, `japan_level`, `interview`, `status`, `created_at`, `updated_at`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		PreparedStatement pre;

	}
}
