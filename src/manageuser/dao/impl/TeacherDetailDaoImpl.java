/**
 * Copyright(C) 2017  Luvina
 * TeacherDetailDaoImpl.java, Sep 20, 2017  TranTheHong
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.TeacherDetailDao;
import manageuser.entities.Teacher;
import manageuser.entities.TeacherDetail;

/**
 * @author HongTT
 *
 */
public class TeacherDetailDaoImpl extends BaseDaoImpl implements TeacherDetailDao {
	
	/* (non-Javadoc)
	 * @see manageuser.dao.TeacherDetailDao#getAllTeacherDetail()
	 */
	@Override
	public List<TeacherDetail> getAllTeacherDetail() throws SQLException {
		List<TeacherDetail> teacherDetailsLst= new ArrayList<TeacherDetail>();
		String sql="SELECT * FROM `teacher_detail` tcdt inner join users us ON tcdt.teacher_id=us.id";
		PreparedStatement pstm= getConnection().prepareStatement(sql);
		ResultSet rs= pstm.executeQuery();
		while(rs.next()){
			TeacherDetail teacherDetail= new TeacherDetail();
			teacherDetail.setUserID(rs.getInt("id"));
			teacherDetail.setUserName(rs.getString("username"));
			teacherDetail.setFullName(rs.getString("full_name"));
			teacherDetail.setEmail(rs.getString("email"));
			teacherDetail.setTel(rs.getString("tel"));
			teacherDetailsLst.add(teacherDetail);
		}		
		return teacherDetailsLst;
	}

	/*
	 * (non-Javadoc)
	 * @see manageuser.dao.TeacherDetailDao#insertTeacher(manageuser.entities.
	 * Teacher)
	 */
	@Override
	public void insertTeacher(Teacher teacher) throws SQLException {
		String sql ="INSERT INTO teacher_detail (teacher_id,full_name,email,tel,delete_flag) values (LAST_INSERT_ID(),?,?,?,?)";
		connTransaction = getConnectionTransaction();
		PreparedStatement pstm = null;
		pstm = connTransaction.prepareStatement(sql.toString());
		int i = 0;
		pstm.setString((++i), teacher.getFullName());
		pstm.setString((++i), teacher.getEmail());
		pstm.setString((++i), teacher.getTel());
		pstm.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.TeacherDetailDao#updateTeacher(manageuser.entities.Teacher)
	 */
	@Override
	public void updateTeacher(Teacher teacher) throws SQLException {
		String sql="UPDATE teacher_detail SET full_name=?,email=?,tel=? WHERE teacher_id= ?";
		connTransaction=getConnectionTransaction();
		PreparedStatement pstm= connTransaction.prepareStatement(sql);
		int i=0;
		pstm.setString(++i, teacher.getFullName());
		pstm.setString(++i, teacher.getEmail());
		pstm.setString(++i, teacher.getTel());
		pstm.setInt(++i,teacher.getTeacherId());
		pstm.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.TeacherDetailDao#deleteTeacher(int)
	 */
	@Override
	public void deleteTeacher(int teacherId) throws SQLException {
		String sql="UPDATE teacher_detail SET delete_flag= ? ";
		PreparedStatement pstm= getConnection().prepareStatement(sql);
		pstm.setInt(1,0);
		pstm.executeUpdate();
	}

}
