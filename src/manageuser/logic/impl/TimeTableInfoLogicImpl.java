package manageuser.logic.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.impl.CourseDaoImpl;
import manageuser.dao.impl.TimeTableDetailDaoImpl;
import manageuser.dao.impl.TimeTableInfoDaoImpl;
import manageuser.entities.TimeTableDetail;
import manageuser.entities.TimeTableInfo;
import manageuser.logic.TimeTableInfoLogic;
import manageuser.utils.Common;

public class TimeTableInfoLogicImpl implements TimeTableInfoLogic {

	@Override
	public int insertTimeTableInfo(TimeTableInfo e) throws SQLException {
		int id = 0;
		TimeTableInfoDaoImpl infoDao = new TimeTableInfoDaoImpl();
		CourseDaoImpl courseDao = new CourseDaoImpl();
		if (!Common.compareTwoDate(e.getStartDate(), e.getEndDate()) || !courseDao.isExistCourseById(e.getCourseId())) {
			return 0;
		}
		 id = infoDao.insertTimeTableInfo(e);

		return id;
	}

	@Override
	public boolean updateTimeTableInfo(TimeTableInfo e) throws SQLException {
		TimeTableInfoDaoImpl infoDao = new TimeTableInfoDaoImpl();
		TimeTableDetailDaoImpl detailDao = new TimeTableDetailDaoImpl();
		CourseDaoImpl courseDao = new CourseDaoImpl();
		if (!Common.compareTwoDate(e.getStartDate(), e.getEndDate())
				|| detailDao.isExistDetailByInfoIdInRange(e.getId(), e.getStartDate(), e.getEndDate())
				|| !courseDao.isExistCourseById(e.getCourseId())) {
			return false;
		}
		
		infoDao.updateTimeTableInfo(e);
		return true;

	}

	@Override
	public boolean deleteTimeTableInfo(int id) throws SQLException {
		boolean flag = true;
		TimeTableInfoDaoImpl infoDao = new TimeTableInfoDaoImpl();
		TimeTableDetailDaoImpl detailDao = new TimeTableDetailDaoImpl();
		if (!infoDao.isExistsTimeTableInfoById(id)) {
			flag = false;
		} else {
			try {
				detailDao.deleteTimeTableDetailByTimeTableInfoId(id);
				infoDao.deleteTimeTableInfo(id);
				infoDao.commit();
				flag = true;
			} catch (SQLException e) {
				infoDao.rollbackTrasaction();
				flag = false;
				throw e;
			} finally {
				infoDao.closeConnectionTransaction();
			}
		}

		return flag;

	}

	@Override
	public List<TimeTableInfo> getAllTimeTableInfo() throws SQLException {
		return new TimeTableInfoDaoImpl().getAllTimeTableInfo();
	}

	@Override
	public TimeTableInfo getTimeTableInfoById(int id) throws SQLException {
		return updateInfo(new TimeTableInfoDaoImpl().getTimeTableInfoById(id));
	}

	@Override
	public Date[] getStartDateAndEndDateTimeTableInfoById(int id) throws SQLException {
		return new TimeTableInfoDaoImpl().getStartDateAndEndDateTimeTableInfoById(id);
	}

	@Override
	public List<TimeTableDetail> getTimeTableById(int id) throws SQLException {
		TimeTableDetailDaoImpl detailDao = new TimeTableDetailDaoImpl();
		TimeTableInfoDaoImpl infoDao = new TimeTableInfoDaoImpl();
		return createListDetail(infoDao.getStartDateAndEndDateTimeTableInfoById(id),
				detailDao.getAllDetailByTimeTableInfoId(id), id);

	}

	/**
	 * tạo danh sách chi tiết thời khóa biểu theo ngày
	 * 
	 * @param dateArray
	 *            chứa ngày bắt đầu và ngày kết thúc
	 * @param listDetail
	 *            dánh sách chi tiết thời khóa biểu theo ngày được lấy ra từ db
	 * @return danh sách chi khóa biểutiết thời
	 */
	private List<TimeTableDetail> createListDetail(Date[] dateArray, List<TimeTableDetail> listDetail, int id) {
		List<TimeTableDetail> l = new ArrayList<TimeTableDetail>();
		// lấy ngày bắt đầu và ngày kết thúc
		LocalDate startDate = LocalDate.parse(dateArray[0].toString());
		LocalDate endDate = LocalDate.parse(dateArray[1].toString());
		// model
		TimeTableDetail t;
		// size
		int size = listDetail.size();
		// index
		int i = 0;
		if (size > 0) {
			// tạo một list lưu danh sách thời khóa biểu theo ngày và có độ dài
			// tính
			// từ ngày bắt đầu đến ngày kết thúc
			while (!startDate.isAfter(endDate)) {
				if (startDate.getDayOfWeek().getValue() > 5) {
					startDate = startDate.plusDays(1);
					continue;
				}
				// lấy detail timetable
				t = listDetail.get(i);
				// nếu ngày đang được ánh xạ đến có trong db thì sẽ add detail
				// trong
				// db vào
				// nếu không tồn tại trong đb thì sẽ add detail rỗng chỉ có ngày
				// bắt
				// đầu
				if (t.getStartDate().equals(Date.valueOf(startDate))) {
					l.add(updateDetail(t));
					if (i < size - 1) {
						i++;
					}
				} else {
					t = new TimeTableDetail();
					t.setStartDate(Date.valueOf(startDate));
					t.setTimeTableInfoId(id);
					l.add(updateDetail(t));
				}

				startDate = startDate.plusDays(1);
			}
		} else {
			// tạo một list lưu danh sách thời khóa biểu theo ngày và có độ dài
			// tính
			// từ ngày bắt đầu đến ngày kết thúc
			while (!startDate.isAfter(endDate)) {
				if (startDate.getDayOfWeek().getValue() > 5) {
					startDate = startDate.plusDays(1);
					continue;
				}

				t = new TimeTableDetail();
				t.setStartDate(Date.valueOf(startDate));
				t.setTimeTableInfoId(id);
				l.add(updateDetail(t));

				startDate = startDate.plusDays(1);
			}
		}

		return l;
	}

	private TimeTableInfo updateInfo(TimeTableInfo t) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(t.getStartDate().getTime());
		t.setStartDateString((sdf.format(date).trim()));
		date = new Date(t.getEndDate().getTime());
		t.setEndDateString((sdf.format(date).trim()));
		return t;
	}

	private TimeTableDetail updateDetail(TimeTableDetail t) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(t.getStartDate().getTime());
		t.setStartDateString(sdf.format(date).trim());
		return t;
	}

	@Override
	public List<TimeTableInfo> getListTimeTableInfo(Date startDate, Date endDate, int offset, int limit)
			throws SQLException {
		return new TimeTableInfoDaoImpl().getListTimeTableInfo(startDate, endDate, offset, limit);
	}

	@Override
	public int getCount(Date startDate, Date endDate) throws SQLException {
		return new TimeTableInfoDaoImpl().getCount(startDate, endDate);
	}

}
