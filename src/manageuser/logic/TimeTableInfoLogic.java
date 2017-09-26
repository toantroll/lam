package manageuser.logic;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.ResponseData;
import manageuser.entities.TimeTableInfo;

/**
 * interface time table info logic
 * @author LA-PM
 *
 */
public interface TimeTableInfoLogic {
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
	
	/**
	 * get start date and end date
	 * @param id time table id
	 * @return	array date
	 * @throws SQLException SQLException
	 */
	public Date[] getStartDateAndEndDateTimeTableInfoById(int id) throws SQLException;
	
	/**
	 * get all data detail of time table
	 * @return ResponseData
	 * @throws SQLException SQLException
	 */
	public ResponseData getTimeTableById(int id) throws SQLException;
}
