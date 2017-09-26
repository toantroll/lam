package manageuser.logic;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.TimeTableDetail;

/**
 * interface time table detail logic
 * @author LA-PM
 *
 */
public interface TimeTableDetailLogic {
	/**
	 * insert to time table detail
	 * @param e entity
	 * @throws SQLException SQLException
	 */
	public boolean insertTimeTableDetail(TimeTableDetail e) throws SQLException;
	/**
	 * update time table detail
	 * @param e
	 * @throws SQLException
	 */
	public boolean updateTimeTableDetail(TimeTableDetail e) throws SQLException;
	/**
	 * delete by id
	 * @param id id
	 * @throws SQLExceptionSQLException
	 */
	public boolean deleteTimeTableDetail(int id) throws SQLException;
	/**
	 * delete a list detail by time table info id
	 * @param id id
	 * @throws SQLException SQLException
	 */
	public boolean deleteTimeTableDetailByTimeTableInfoId(int id) throws SQLException;
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
