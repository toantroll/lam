/**
 * Copyright(C) 2017 Luvina Software Company
 *	TimeTableDetailDao.java 2017-09-22, toanvv
 */
package manageuser.dao;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.TimeTableDetail;

/**
 * interface time table detail dao
 * @author LA-PM
 *
 */
public interface TimeTableDetailDao {
	
	/**
	 * insert to time table detail
	 * @param e entity
	 * @throws SQLException SQLException
	 */
	public void insertTimeTableDetail(TimeTableDetail e) throws SQLException;
	/**
	 * update time table detail
	 * @param e
	 * @throws SQLException
	 */
	public void updateTimeTableDetail(TimeTableDetail e) throws SQLException;
	/**
	 * delete by id
	 * @param id id
	 * @throws SQLExceptionSQLException
	 */
	public void deleteTimeTableDetail(int id) throws SQLException;
	/**
	 * delete a list detail by time table info id
	 * @param id id
	 * @throws SQLException SQLException
	 */
	public void deleteTimeTableDetailByTimeTableInfoId(int id) throws SQLException;
	/**
	 * get a detail
	 * @param id id
	 * @return a detail
	 * @throws SQLException
	 */
	public TimeTableDetail getTimeTableDetailById(int id) throws SQLException;
	/**
	 * get a list detail by time table info id
	 * @param id id
	 * @return list detail
	 * @throws SQLException SQLException
	 */
	public List<TimeTableDetail> getAllDetailByTimeTableInfoId(int id) throws SQLException;
}
