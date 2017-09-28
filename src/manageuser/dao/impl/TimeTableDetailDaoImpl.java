/**
 * Copyright(C) 2017 Luvina Software Company
 *	TimeTableDetailDaoImpl.java 2017-09-22, toanvv
 */
package manageuser.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.TimeTableDetailDao;
import manageuser.entities.TimeTableDetail;

/**
 * time table detail dao
 * 
 * @author LA-PM
 *
 */
public class TimeTableDetailDaoImpl extends BaseDaoImpl implements TimeTableDetailDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableDetailDao#insertTimeTableDetail(manageuser.
	 * entities.TimeTableDetail)
	 */
	@Override
	public void insertTimeTableDetail(TimeTableDetail e) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO `timetables_detail`")
				.append("(`timetable_id`,`subject_id`, `subject_content`, `start_date`, `start_hours`, `hours_per_day`,`status`)")
				.append("VALUES	(?,?,?,?,?,?,?)");

		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, e.getTimeTableInfoId());
		ps.setInt(i++, e.getSubjectId());
		ps.setString(i++, e.getSubjectContent());
		ps.setDate(i++, e.getStartDate());
		ps.setString(i++, e.getStartHours());
		ps.setInt(i++, e.getHoursPerDay());
		ps.setInt(i++, e.getStatus());

		ps.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableDetailDao#updateTimeTableDetail(manageuser.
	 * entities.TimeTableDetail)
	 */
	@Override
	public void updateTimeTableDetail(TimeTableDetail e) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE `timetables_detail`").append("SET").append("`subject_id` = ?,").append("`subject_content` = ?,")
				.append("`start_date` = ?,").append("`start_hours` = ?,").append("`hours_per_day` = ?,")
				.append("`status` = ? ").append(" WHERE `id` = ?");

		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, e.getSubjectId());
		ps.setString(i++, e.getSubjectContent());
		ps.setDate(i++, e.getStartDate());
		ps.setString(i++, e.getStartHours());
		ps.setInt(i++, e.getHoursPerDay());
		ps.setInt(i++, e.getStatus());
		ps.setInt(i++, e.getId());

		ps.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableDetailDao#deleteTimeTableDetail(int)
	 */
	@Override
	public void deleteTimeTableDetail(int id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM `timetables_detail`").append("WHERE `id` = ?");

		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);

		ps.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * manageuser.dao.TimeTableDetailDao#deleteTimeTableDetailByTimeTableInfoId(
	 * int)
	 */
	@Override
	public void deleteTimeTableDetailByTimeTableInfoId(int id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM `timetables_detail`").append("WHERE `timetable_id` = ?");

		PreparedStatement ps = getConnectionTransaction().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);

		ps.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableDetailDao#getTimeTableDetailById(int)
	 */
	@Override
	public TimeTableDetail getTimeTableDetailById(int id) throws SQLException {
		TimeTableDetail detail = new TimeTableDetail();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT t.id, t.timetable_id, s.id, s.name, t.subject_content, tc.teacher_id, tc.full_name, t.start_date, t.start_hours, t.hours_per_day, t.status ")
				.append("FROM timetables_detail t ").append("INNER JOIN subjects s ").append("ON s.id = t.subject_id ")
				.append("INNER JOIN teacher_detail tc ").append("ON tc.teacher_id = t.teacher_id ")
				.append("WHERE t.id = ? ");

		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		ResultSet rs = ps.executeQuery();
		if (rs != null && rs.next()) {
			i = 1;
			detail.setId(rs.getInt(i++));
			detail.setTimeTableInfoId(rs.getInt(i++));
			detail.setSubjectId(rs.getInt(i++));
			detail.setSubjectName(rs.getString(i++));
			detail.setSubjectContent(rs.getString(i++));
			detail.setTeacherId(rs.getInt(i++));
			detail.setTeacherName(rs.getString(i++));
			detail.setStartDate(rs.getDate(i++));
			detail.setStartHours(rs.getString(i++));
			detail.setHoursPerDay(rs.getInt(i++));
			detail.setStatus(rs.getInt(i++));
		}

		return detail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableDetailDao#getAllDetailByTimeTableInfoId(int)
	 */
	@Override
	public List<TimeTableDetail> getAllDetailByTimeTableInfoId(int id) throws SQLException {
		List<TimeTableDetail> listTimeTableDetail = new ArrayList<TimeTableDetail>();
		TimeTableDetail detail;
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT t.id, t.timetable_id, s.id, s.name, t.subject_content, tc.teacher_id, tc.full_name, t.start_date, t.start_hours, t.hours_per_day, t.status ")
				.append("FROM timetables_detail t ").append("INNER JOIN subjects s ").append("ON s.id = t.subject_id ")
				.append("INNER JOIN teacher_detail tc ").append("ON tc.teacher_id = s.teacher_id ")
				.append("WHERE t.timetable_id = ? ORDER BY t.start_date ASC");

		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				i = 1;
				detail = new TimeTableDetail();
				detail.setId(rs.getInt(i++));
				detail.setTimeTableInfoId(rs.getInt(i++));
				detail.setSubjectId(rs.getInt(i++));
				detail.setSubjectName(rs.getString(i++));
				detail.setSubjectContent(rs.getString(i++));
				detail.setTeacherId(rs.getInt(i++));
				detail.setTeacherName(rs.getString(i++));
				detail.setStartDate(rs.getDate(i++));
				detail.setStartHours(rs.getString(i++));
				detail.setHoursPerDay(rs.getInt(i++));
				detail.setStatus(rs.getInt(i++));
				listTimeTableDetail.add(detail);
			}
		}

		return listTimeTableDetail;
	}

	@Override
	public boolean isExistDetail(int id) throws SQLException {
		int count = 0;
		StringBuilder sql = new StringBuilder("select count(id) from timetables_detail WHERE id = ?");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()){
			count = rs.getInt(1);
		}
		return count > 0 ? true : false;
	}

	@Override
	public boolean isExistDetail(int id, int idTimeTableInfo) throws SQLException {
		int count = 0;
		StringBuilder sql = new StringBuilder("select count(id) from timetables_detail WHERE id = ?, timetable_id = ?");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		ps.setInt(i++, idTimeTableInfo);
		
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()){
			count = rs.getInt(1);
		}
		return count > 0 ? true : false;
	}

	@Override
	public boolean isExistDetail(int id, Date startDate) throws SQLException {
		int count = 0;
		StringBuilder sql = new StringBuilder("select count(id) from timetables_detail WHERE timetable_id = ? AND start_date = ?");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		ps.setDate(i++, startDate);
		
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()){
			count = rs.getInt(1);
		}
		return count > 0 ? true : false;
	}

	@Override
	public boolean isExistDetailByInfoIdInRange(int id, Date startDate, Date endDate) throws SQLException {
		int count = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("select count(id) from timetables_detail ")
		.append("WHERE timetable_id = ? AND (start_date < ? OR start_date > ?)");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		ps.setDate(i++, startDate);
		ps.setDate(i++, endDate);
		
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()){
			count = rs.getInt(1);
		}
		return count > 0? true: false;
	}
}
