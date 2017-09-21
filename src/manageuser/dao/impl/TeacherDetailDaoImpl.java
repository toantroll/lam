/**
 * Copyright(C) 2017  Luvina
 * TeacherDetailDaoImpl.java, Sep 20, 2017  TranTheHong
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import manageuser.dao.TeacherDetailDao;
import manageuser.entities.Teacher;

/**
 * @author HongTT
 *
 */
public class TeacherDetailDaoImpl extends BaseDaoImpl implements TeacherDetailDao {
	/*
	 * (non-Javadoc)
	 * @see manageuser.dao.TeacherDetailDao#insertTeacher(manageuser.entities.
	 * Teacher)
	 */
	@Override
	public void insertTeacher(Teacher teacher) throws SQLException {
		StringBuilder sql = new StringBuilder();
		// Chuỗi sql
		sql.append("INSERT INTO teacher_detail ");
		sql.append("(teacher_id,full_name,email,tel)");
		sql.append(" values (LAST_INSERT_ID(),?,?,?)");
		connTransaction = getConnectionTransaction();
		PreparedStatement pstm = null;
		pstm = connTransaction.prepareStatement(sql.toString());
		int i = 0;
		pstm.setString((++i), teacher.getFullName());
		pstm.setString((++i), teacher.getEmail());
		pstm.setString((++i), teacher.getTel());
		pstm.executeUpdate();
	}

}
