/**
 * Copyright(C) 2017 Luvina Software Company
 *	TimeTableDetailDaoImpl.java 2017-09-22, toanvv
 */
package manageuser.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import manageuser.dao.TimeTableDetailDao;
import manageuser.entities.TimeTableDetail;

/**
 * time table detail dao 
 * @author LA-PM
 *
 */
public class TimeTableDetailDaoImpl extends BaseDaoImpl implements TimeTableDetailDao {

	/* (non-Javadoc)
	 * @see manageuser.dao.TimeTableDetailDao#insertTimeTableDetail(manageuser.entities.TimeTableDetail)
	 */
	@Override
	public void insertTimeTableDetail(TimeTableDetail e) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO `timetables_detail`")
		.append("(`timetable_id`,`subject_id`,`teacher_id`,	`start_date`, `start_hours`, `hours_per_day`,`status`)")
		.append("VALUES	(?,?,?,?,?,?)");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, e.getTimeTableInfoId());
		ps.setInt(i++, e.getSubjectId());
		ps.setInt(i++, e.getTeacherId());
		ps.setDate(i++ ,e.getStartDate());
		ps.setString(i++ ,e.getStartHours());
		ps.setInt(i++, e.getHoursPerDay());
		ps.setInt(i++, 1);
		
		ps.executeUpdate();

	}

	/* (non-Javadoc)
	 * @see manageuser.dao.TimeTableDetailDao#updateTimeTableDetail(manageuser.entities.TimeTableDetail)
	 */
	@Override
	public void updateTimeTableDetail(TimeTableDetail e) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE `timetables_detail`")
		.append("SET")
		.append("`subject_id` = ?,")
		.append("`teacher_id` = ?,")
		.append("`start_date` = ?,")
		.append("`start_hours` = ?,")
		.append("`hours_per_day` = ?,")
		.append("WHERE `id` = ?");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, e.getSubjectId());
		ps.setInt(i++, e.getTeacherId());
		ps.setDate(i++, e.getStartDate());
		ps.setString(i++, e.getStartHours());
		ps.setInt(i++, e.getHoursPerDay());
		ps.setInt(i++, e.getId());

		ps.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.TimeTableDetailDao#deleteTimeTableDetail(int)
	 */
	@Override
	public void deleteTimeTableDetail(int id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM `timetables_detail`")
		.append("WHERE `id` = ?");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		
		ps.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.TimeTableDetailDao#deleteTimeTableDetailByTimeTableInfoId(int)
	 */
	@Override
	public void deleteTimeTableDetailByTimeTableInfoId(int id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM `timetables_detail`")
		.append("WHERE `timetable_id` = ?");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		
		ps.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.TimeTableDetailDao#getTimeTableDetailById(int)
	 */
	@Override
	public TimeTableDetail getTimeTableDetailById(int id) throws SQLException {
		TimeTableDetail detail = new TimeTableDetail();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id, t.timetable_id, s.id, s.name, t.subject_content, tc.teacher_id, tc.full_name, t.start_date, t.start_hours, t.hours_per_day ")
		.append("FROM timetables_detail t ")
		.append("INNER JOIN subjects s ")
		.append("ON s.id = t.subject_id ")
		.append("INNER JOIN teacher_detail tc ")
		.append("ON tc.teacher_id = t.teacher_id ")
		.append("WHERE t.id = ? ");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()){
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
		}
		
		return detail;
	}

	/* (non-Javadoc)
	 * @see manageuser.dao.TimeTableDetailDao#getAllDetailByTimeTableInfoId(int)
	 */
	@Override
	public List<TimeTableDetail> getAllDetailByTimeTableInfoId(int id) throws SQLException {
		List<TimeTableDetail> listTimeTableDetail = new ArrayList<TimeTableDetail>();
		TimeTableDetail detail;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id, t.timetable_id, s.id, s.name, t.subject_content, tc.teacher_id, tc.full_name, t.start_date, t.start_hours, t.hours_per_day ")
		.append("FROM timetables_detail t ")
		.append("INNER JOIN subjects s ")
		.append("ON s.id = t.subject_id ")
		.append("INNER JOIN teacher_detail tc ")
		.append("ON tc.teacher_id = t.teacher_id ")
		.append("WHERE t.timetable_id = ? ORDER BY t.start_date ASC");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
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
				listTimeTableDetail.add(detail);
			}
		}
		
		return listTimeTableDetail;
	}

	public static void main(String[] args) {
		TimeTableDetailDaoImpl t = new TimeTableDetailDaoImpl();
		TimeTableDetail d = new TimeTableDetail();

		
		try {
			JSONArray array = new JSONArray(t.getAllDetailByTimeTableInfoId(11));
			for(int i = 0; i< array.length(); i++){

				System.out.println(new JSONObject(array.get(i).toString()).getString("startDate"));
			}
			System.out.println(t.getAllDetailByTimeTableInfoId(11).get(0).getStartDate().toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
