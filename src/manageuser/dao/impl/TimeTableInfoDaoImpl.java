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
	public void insertTimeTableInfo(TimeTableInfo e) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO `timetables_info`")
				.append("(`course_id`, `start_date`, `end_date`, `content`, `note`, `created_at`,")
				.append("`place`, `status`)").append("VALUES(?,?,?,?,?,now(),?,?)");

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, e.getCourseId());
		ps.setDate(i++, e.getStartDate());
		ps.setDate(i++, e.getEndDate());
		ps.setString(i++, e.getContent());
		ps.setString(i++, e.getNote());
		ps.setString(i++, e.getPlace());
		ps.setInt(i++, e.getStatus());

		ps.executeUpdate();
		ps.close();
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
				.append("`note` =?,	`updated_at` = now(),	`place` = ?").append("WHERE `id` = ?");

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
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
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
		.append("WHERE `status` = 1 ORDER BY ");

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
		sql.append("SELECT `timetables_info`.`id`,")
		.append("`timetables_info`.`start_date`,")
		.append("`timetables_info`.`end_date`,")
		.append("`timetables_info`.`course_id`,")
		.append("`timetables_info`.`content`,")
		.append("`timetables_info`.`note`,")
		.append("`timetables_info`.`created_at`,")
		.append(" `timetables_info`.`updated_at`,")
		.append("`timetables_info`.`deleted_at`,")
		.append("`timetables_info`.`status`,")
		.append("`timetables_info`.`place`")
		.append("FROM `timetables_info`")
		.append("WHERE `timetables_info`.`status` = 1 AND `timetables_info`.`id` = ?");

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

	public static void main(String[] args) {
		try {
			Date[] array = new TimeTableInfoDaoImpl().getStartDateAndEndDateTimeTableInfoById(11);
			LocalDate startDate = LocalDate.parse(array[0].toString());
			LocalDate endDate = LocalDate.parse(array[1].toString());
			List<TimeTableDetail> list = new ArrayList<TimeTableDetail>();
			List<TimeTableDetail> listDetail = new TimeTableDetailDaoImpl().getAllDetailByTimeTableInfoId(11);
			TimeTableDetail t;
			int size = listDetail.size();
			int i = 0;
			while(!startDate.isAfter(endDate)){
				t = listDetail.get(i);
				if(t.getStartDate().equals(Date.valueOf(startDate))){
					if(i < size-1){
						list.add(t);
						i++;
					}
				} else {
					t = new TimeTableDetail();
					t.setStartDate(Date.valueOf(startDate));
					list.add(t);
				}
				startDate = startDate.plusDays(1);
			}
			ResponseData data = new ResponseData();
			data.setCode(ResponseData.SUCCESS);
			data.setData(list);
			JSONObject jsonObject = new JSONObject(data);
			System.out.println(jsonObject.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
