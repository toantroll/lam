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
import manageuser.entities.TeacherDetail;

/**
 * @author HongTT
 *
 */
public class TeacherDetailDaoImpl extends BaseDaoImpl implements TeacherDetailDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TeacherDetailDao#getAllTeacherDetail()
	 */
	@Override
	public List<TeacherDetail> getListTeacherDetail( String name, int offset, int limit) throws SQLException {
		List<TeacherDetail> teacherDetailsLst = new ArrayList<TeacherDetail>();
		String sql = "SELECT * FROM `teacher_detail` tcdt inner join users us ON tcdt.teacher_id=us.id WHERE tcdt.full_name like ? AND delete_flag = 1 LIMIT ? OFFSET ? ";
		PreparedStatement pstm = getConnection().prepareStatement(sql);
		int i = 0;
		pstm.setString(++i, "%" + name + "%");
		pstm.setInt(++i, limit);
		pstm.setInt(++i, offset);
		ResultSet rs = pstm.executeQuery();
		try {
			while (rs.next()) {
				TeacherDetail teacherDetail = new TeacherDetail();
				teacherDetail.setUserID(rs.getInt("id"));
				teacherDetail.setUserName(rs.getString("username"));
				teacherDetail.setFullName(rs.getString("full_name"));
				teacherDetail.setEmail(rs.getString("email"));
				teacherDetail.setTel(rs.getString("tel"));
				teacherDetailsLst.add(teacherDetail);
			}
		} finally {
			closeConnection();
		}
		return teacherDetailsLst;
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.TeacherDetailDao#getAllTeacherDetail()
	 */
	@Override
	public List<TeacherDetail> getAllTeacherDetail() throws SQLException {
		List<TeacherDetail> teacherDetailsLst = new ArrayList<TeacherDetail>();
		String sql = "SELECT * FROM `teacher_detail` tcdt inner join users us ON tcdt.teacher_id=us.id WHERE delete_flag = 1";
		PreparedStatement pstm = getConnection().prepareStatement(sql);		
		ResultSet rs = pstm.executeQuery();
		try {
			while (rs.next()) {
				TeacherDetail teacherDetail = new TeacherDetail();
				teacherDetail.setUserID(rs.getInt("id"));
				teacherDetail.setUserName(rs.getString("username"));
				teacherDetail.setFullName(rs.getString("full_name"));
				teacherDetail.setEmail(rs.getString("email"));
				teacherDetail.setTel(rs.getString("tel"));
				teacherDetailsLst.add(teacherDetail);
			}
		} finally {
			closeConnection();
		}
		return teacherDetailsLst;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TeacherDetailDao#insertTeacher(manageuser.entities.
	 * Teacher)
	 */
	@Override
	public void insertTeacher(TeacherDetail teacherDetail) throws SQLException {
		String sql = "INSERT INTO teacher_detail (teacher_id,full_name,email,tel,delete_flag) values (LAST_INSERT_ID(),?,?,?,?)";
		connTransaction = getConnectionTransaction();
		PreparedStatement pstm = null;
		pstm = connTransaction.prepareStatement(sql.toString());
		int i = 0;
		pstm.setString((++i), teacherDetail.getFullName());
		pstm.setString((++i), teacherDetail.getEmail());
		pstm.setString((++i), teacherDetail.getTel());
		pstm.setInt((++i), teacherDetail.getDeleteFlag());
		pstm.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TeacherDetailDao#updateTeacher(manageuser.entities.
	 * Teacher)
	 */
	@Override
	public void updateTeacher(TeacherDetail teacherDetail) throws SQLException {
		String sql = "UPDATE teacher_detail SET full_name=?,email=?,tel=? WHERE teacher_id= ? ";
		connTransaction = getConnectionTransaction();
		PreparedStatement pstm = connTransaction.prepareStatement(sql);
		int i = 0;
		pstm.setString(++i, teacherDetail.getFullName());
		pstm.setString(++i, teacherDetail.getEmail());
		pstm.setString(++i, teacherDetail.getTel());
		pstm.setInt(++i, teacherDetail.getTeacherId());
		pstm.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TeacherDetailDao#deleteTeacher(int)
	 */
	@Override
	public void deleteTeacher(int teacherId) throws SQLException {
		String sql = "UPDATE teacher_detail SET delete_flag= ? WHERE teacher_id=? ";
		connTransaction = getConnectionTransaction();
		PreparedStatement pstm = connTransaction.prepareStatement(sql);
		pstm.setInt(1, 0);
		pstm.setInt(2, teacherId);
		pstm.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TeacherDetailDao#getTeacherDetailById(int)
	 */
	@Override
	public TeacherDetail getTeacherDetailById(int teacherId) throws SQLException {
		TeacherDetail teacherDetail = null;
		String sql = "SELECT * FROM `teacher_detail` tcdt inner join users us ON tcdt.teacher_id=us.id WHERE teacher_id=? AND delete_flag = 1";
		PreparedStatement pstm = getConnection().prepareStatement(sql);
		pstm.setInt(1, teacherId);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			teacherDetail = new TeacherDetail();
			teacherDetail.setUserID(rs.getInt("id"));
			teacherDetail.setUserName(rs.getString("username"));
			teacherDetail.setFullName(rs.getString("full_name"));
			teacherDetail.setEmail(rs.getString("email"));
			teacherDetail.setTel(rs.getString("tel"));
		}
		return teacherDetail;
	}
	/* (non-Javadoc)
	 * @see manageuser.dao.TeacherDetailDao#getTotalTeacher(java.lang.String)
	 */
	@Override
	public int getTotalTeacher(String name) throws SQLException {
		name= name.trim();
		int total=0;		
		String sql = "SELECT COUNT(id) FROM `teacher_detail` tcdt inner join users us ON tcdt.teacher_id=us.id WHERE tcdt.full_name like ? AND delete_flag = 1";
		PreparedStatement pstm = getConnection().prepareStatement(sql);
		int i = 0;
		pstm.setString(++i, "%" + name + "%");
		ResultSet rs = pstm.executeQuery();
		try {
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} finally {
			closeConnection();
		}
		return total;
	}

}
