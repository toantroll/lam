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
		.append("(`timetable_id`,`subject_id`,`teacher_id`,	`start_date`,`hours_per_day`,`status`)")
		.append("VALUES	(?,?,?,?,?,?)");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, e.getTimeTableInfoId());
		ps.setInt(i++, e.getSubjectId());
		ps.setInt(i++, e.getTeacherId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ps.setString(i++ ,sdf.format(e.getStartDate()));
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
		.append("`hours_per_day` = ?,")
		.append("WHERE `id` = ?");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, e.getSubjectId());
		ps.setInt(i++, e.getTeacherId());
		ps.setDate(i++, e.getStartDate());
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
		sql.append("SELECT `id`,  `timetable_id`, `subject_id`, `teacher_id`, `start_date`, `hours_per_day`, `status`")
		.append("FROM `timetables_detail`")
		.append("WHERE `id` = ?");
		
		PreparedStatement ps = getConnection().prepareStatement(sql.toString());
		int i = 1;
		ps.setInt(i++, id);
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()){
			i = 1;
			detail.setId(rs.getInt(i++));
			detail.setTimeTableInfoId(rs.getInt(i++));
			detail.setTeacherId(rs.getInt(i++));
			detail.setSubjectId(rs.getInt(i++));
			detail.setStartDate(rs.getDate(i++));
			detail.setId(rs.getInt(i++));
			detail.setStatus(rs.getInt(i++));
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
		sql.append("SELECT `id`,  `timetable_id`, `subject_id`, `teacher_id`, `start_date`, `hours_per_day`, `status`")
		.append("FROM `timetables_detail`")
		.append("WHERE `timetable_id` = ?");
		
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
				detail.setTeacherId(rs.getInt(i++));
				detail.setSubjectId(rs.getInt(i++));
				detail.setStartDate(rs.getDate(i++));
				detail.setId(rs.getInt(i++));
				detail.setStatus(rs.getInt(i++));
				listTimeTableDetail.add(detail);
			}
		}
		
		return listTimeTableDetail;
	}

	public static void main(String[] args) {
		TimeTableDetailDaoImpl t = new TimeTableDetailDaoImpl();
		TimeTableDetail d = new TimeTableDetail();
		
		d.setTeacherId(3);
		d.setSubjectId(9);
		d.setStatus(1);
		d.setHoursPerDay(4);
		d.setTimeTableInfoId(11);
		d.setStartDate(new Date(System.currentTimeMillis()));
		
		try {
			t.deleteTimeTableDetail(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
