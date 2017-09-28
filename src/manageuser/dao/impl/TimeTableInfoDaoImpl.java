/**
 * Copyright(C) 2017 Luvina Software Company
 *	TimeTableInfoDaoIml.java 2017-09-21, toanvv
 */
package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import manageuser.dao.TimeTableInfoDao;
import manageuser.entities.ResponseData;
import manageuser.entities.TimeTableDetail;
import manageuser.entities.TimeTableInfo;
import manageuser.utils.Constant;

/**
 * Time table logic
 * 
 * @author LA-PM
 *
 */
public class TimeTableInfoDaoImpl extends BaseDaoImpl implements TimeTableInfoDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableInfoDao#createTimeTableInfo()
	 */
	@Override
	public int insertTimeTableInfo(TimeTableInfo e) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO `timetables_info`")
				.append("(`course_id`, `start_date`, `end_date`, `created_at`,")
				.append("`status`)").append("VALUES(?,?,?,now(),1)");

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
		int i = 1;
		ps.setInt(i++, e.getCourseId());
		ps.setDate(i++, e.getStartDate());
		ps.setDate(i++, e.getEndDate());

		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		int id = 0;
		if(rs != null && rs.next()){
			id = rs.getInt(1);
		}
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableInfoDao#updateTimeTableInfo()
	 */
	@Override
	public void updateTimeTableInfo(TimeTableInfo e) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE `timetables_info`")
				.append("SET `start_date` = ?,`end_date` = ?, `course_id` = ?,`content` = ?,")
				.append("`note` =?,	`updated_at` = now(),	`place` = ?").append(" WHERE id = ?");

		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setDate(i++, e.getStartDate());
		ps.setDate(i++, e.getEndDate());
		ps.setInt(i++, e.getCourseId());
		ps.setString(i++, e.getContent());
		ps.setString(i++, e.getNote());
		ps.setString(i++, e.getPlace());
		ps.setInt(i++, e.getId());

		ps.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableInfoDao#deleteTimeTableInfo()
	 */
	@Override
	public void deleteTimeTableInfo(int id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE `timetables_info`")
				.append("SET `status` = ?, `deleted_at` = now()")
				.append("WHERE `id` = ?");
		
		PreparedStatement ps = getConnectionTransaction().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, Constant.STATUS_DELETE);
		ps.setInt(i++, id);
		
		ps.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableInfoDao#getAllTimeTableInfo()
	 */
	@Override
	public List<TimeTableInfo> getAllTimeTableInfo() throws SQLException {
		List<TimeTableInfo> listTimeTableInfo = new ArrayList<TimeTableInfo>();
		TimeTableInfo timeTableInfo;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT `id`,")
		.append("`start_date`,")
		.append("`end_date`,")
		.append("`course_id`,")
		.append("`content`,")
		.append("`note`,")
		.append("`created_at`,")
		.append("`updated_at`,")
		.append("`deleted_at`,")
		.append("`status`,")
		.append("`place`")
		.append("FROM `timetables_info`")
		.append("WHERE `status` = 1");

		PreparedStatement ps = getConnection().prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while (rs.next()) {
				int i = 1;
				timeTableInfo = new TimeTableInfo();
				timeTableInfo.setId(rs.getInt(i++));
				timeTableInfo.setStartDate(rs.getDate(i++));
				timeTableInfo.setEndDate(rs.getDate(i++));
				timeTableInfo.setCourseId(rs.getInt(i++));
				timeTableInfo.setContent(rs.getString(i++));
				timeTableInfo.setNote(rs.getString(i++));
				timeTableInfo.setCreateAt(rs.getDate(i++));
				timeTableInfo.setUpdatedAt(rs.getDate(i++));
				timeTableInfo.setDeletedAt(rs.getDate(i++));
				timeTableInfo.setStatus(rs.getInt(i++));
				timeTableInfo.setPlace(rs.getString(i++));
				listTimeTableInfo.add(timeTableInfo);
			}
		}
		
		return listTimeTableInfo;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.TimeTableInfoDao#getTimeTableInfoById()
	 */
	@Override
	public TimeTableInfo getTimeTableInfoById(int id) throws SQLException {
		TimeTableInfo timeTableInfo = new TimeTableInfo();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT `id`,")
		.append("`start_date`,")
		.append("`end_date`,")
		.append("`course_id`,")
		.append("`content`,")
		.append("`note`,")
		.append("`created_at`,")
		.append(" `updated_at`,")
		.append("`deleted_at`,")
		.append("`status`,")
		.append("`place`")
		.append("FROM `timetables_info`")
		.append("WHERE `status` = 1 AND `id` = ?");

		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);

		ResultSet rs = ps.executeQuery();
		
		if(rs != null && rs.next()){
			i = 1;
			timeTableInfo = new TimeTableInfo();
			timeTableInfo.setId(rs.getInt(i++));
			timeTableInfo.setStartDate(rs.getDate(i++));
			timeTableInfo.setEndDate(rs.getDate(i++));
			timeTableInfo.setCourseId(rs.getInt(i++));
			timeTableInfo.setContent(rs.getString(i++));
			timeTableInfo.setNote(rs.getString(i++));
			timeTableInfo.setCreateAt(rs.getDate(i++));
			timeTableInfo.setUpdatedAt(rs.getDate(i++));
			timeTableInfo.setDeletedAt(rs.getDate(i++));
			timeTableInfo.setStatus(rs.getInt(i++));
			timeTableInfo.setPlace(rs.getString(i++));
		}
		
		return timeTableInfo;

	}

	@Override
	public Date[] getStartDateAndEndDateTimeTableInfoById(int id) throws SQLException {
		Date[] array = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.start_date, t.end_date ")
		.append("FROM timetables_info t ")
		.append("WHERE t.id = ?");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()){
			i = 1;
			array = new Date[2];
			array[i-1] = rs.getDate(i++);
			array[i-1] = rs.getDate(i++);
		}
		
		return array;
	}


	@Override
	public List<TimeTableInfo> getListTimeTableInfo(Date startDate, Date endDate, int offset, int limit)
			throws SQLException {
		List<TimeTableInfo> list = new ArrayList<TimeTableInfo>();
		TimeTableInfo e;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id, c.course_name, t.start_date, t.end_date, t.place ")
		.append("FROM timetables_info t ")
		.append("INNER JOIN course c ")
		.append("ON c.id = t.course_id ");
		
		if(startDate != null){
			sql.append("WHERE t.start_date >= ? ");
		}
		sql.append("ORDER BY t.start_date ASC ");
		sql.append("LIMIT ?, ? ");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		if(startDate != null){
			ps.setDate(i++, startDate);
		}
		
		ps.setInt(i++, offset);
		ps.setInt(i++, limit);
		
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				i = 1;
				e = new TimeTableInfo();
				e.setId(rs.getInt(i++));
				e.setCourseName(rs.getString(i++));
				e.setStartDate(rs.getDate(i++));
				e.setEndDate(rs.getDate(i++));
				e.setPlace(rs.getString(i++));
				list.add(e);
			}
		}
		
		return list;
	}

	@Override
	public int getCount(Date startDate, Date endDate) throws SQLException {
		int count = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(id) FROM timetables_info ");
		if(startDate != null){
			sql.append("WHERE start_date > ? ");
		}
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		if(startDate != null){
			ps.setDate(i++, startDate);
		}
		
		
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()){
			count = rs.getInt(1);
		}
		
		return count;
	}

	@Override
	public boolean isExistsTimeTableInfoById(int id) throws SQLException {
		int count = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(id) FROM timetables_info WHERE id = ? AND status = 1");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()){
			count = rs.getInt(1);
		}
		return count > 0 ? true: false;
	}
}
