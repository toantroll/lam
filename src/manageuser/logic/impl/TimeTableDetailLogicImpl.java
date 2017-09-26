package manageuser.logic.impl;

import java.sql.SQLException;
import java.util.List;

import manageuser.dao.impl.TimeTableDetailDaoImpl;
import manageuser.entities.TimeTableDetail;
import manageuser.logic.TimeTableDetailLogic;

public class TimeTableDetailLogicImpl implements TimeTableDetailLogic{

	@Override
	public boolean insertTimeTableDetail(TimeTableDetail e) throws SQLException {
		TimeTableDetailDaoImpl detailDao = new TimeTableDetailDaoImpl();
		if(detailDao.isExistDetail(e.getTimeTableInfoId(), e.getStartDate())){
			return false;
		} else {
			detailDao.insertTimeTableDetail(e);
			return true;
		}
		
	}

	@Override
	public boolean updateTimeTableDetail(TimeTableDetail e) throws SQLException {
		TimeTableDetailDaoImpl detailDao = new TimeTableDetailDaoImpl();
		if(!detailDao.isExistDetail(e.getId())){
			return false;
		} else {
			detailDao.updateTimeTableDetail(e);
			return true;
		}
		
	}

	@Override
	public boolean deleteTimeTableDetail(int id) throws SQLException {
		new TimeTableDetailDaoImpl().deleteTimeTableDetail(id);
		return true;
	}

	@Override
	public boolean deleteTimeTableDetailByTimeTableInfoId(int id) throws SQLException {
		new TimeTableDetailDaoImpl().deleteTimeTableDetailByTimeTableInfoId(id);
		return true;
	}

	@Override
	public TimeTableDetail getTimeTableDetailById(int id) throws SQLException {
		return new TimeTableDetailDaoImpl().getTimeTableDetailById(id);
	}

	@Override
	public List<TimeTableDetail> getAllDetailByTimeTableInfoId(int id) throws SQLException {
		return new TimeTableDetailDaoImpl().getAllDetailByTimeTableInfoId(id);
	}

}
