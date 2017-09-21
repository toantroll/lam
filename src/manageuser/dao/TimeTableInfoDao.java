/**
 * Copyright(C) 2017 Luvina Software Company
 *	TimeTableInfoDao.java 2017-09-21, toanvv
 */
package manageuser.dao;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.TimeTableInfo;

/**
 * interface time table info
 * @author LA-PM
 *
 */
public interface TimeTableInfoDao {
	/**
	 * insert time table
	 * @param e TimeTableInfo
	 * @throws SQLException SQLException
	 */
	public void insertTimeTableInfo(TimeTableInfo e) throws SQLException;
	/**
	 * update time table
	 * @param e TimeTableInfo
	 * @throws SQLException SQLException
	 */
	public void updateTimeTableInfo(TimeTableInfo e) throws SQLException;
	/**
	 * delete time table
	 * @param id time table id
	 * @throws SQLException SQLException
	 */
	public void deleteTimeTableInfo(int id) throws SQLException;
	/**
	 * get all data Time Table 
	 * @return list<TimeTableInfo>
	 * @throws SQLException SQLException
	 */
	public List<TimeTableInfo> getAllTimeTableInfo() throws SQLException;
	/**
	 * get a time table 
	 * @param id time table id
	 * @return  TimeTableInfo
	 * @throws SQLException SQLException
	 */
	public TimeTableInfo getTimeTableInfoById(int id) throws SQLException;
}
