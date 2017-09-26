package manageuser.logic.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.impl.TimeTableDetailDaoImpl;
import manageuser.dao.impl.TimeTableInfoDaoImpl;
import manageuser.entities.ResponseData;
import manageuser.entities.TimeTableDetail;
import manageuser.entities.TimeTableInfo;
import manageuser.logic.TimeTableInfoLogic;
import manageuser.utils.Common;

public class TimeTableInfoLogicImpl implements TimeTableInfoLogic {

	@Override
	public void insertTimeTableInfo(TimeTableInfo e) throws SQLException {
		new TimeTableInfoDaoImpl().insertTimeTableInfo(e);
	}

	@Override
	public void updateTimeTableInfo(TimeTableInfo e) throws SQLException {
		new TimeTableInfoDaoImpl().updateTimeTableInfo(e);

	}

	@Override
	public void deleteTimeTableInfo(int id) throws SQLException {
		new TimeTableInfoDaoImpl().deleteTimeTableInfo(id);

	}

	@Override
	public List<TimeTableInfo> getAllTimeTableInfo() throws SQLException {
		return new TimeTableInfoDaoImpl().getAllTimeTableInfo();
	}

	@Override
	public TimeTableInfo getTimeTableInfoById(int id) throws SQLException {
		return new TimeTableInfoDaoImpl().getTimeTableInfoById(id);
	}

	@Override
	public Date[] getStartDateAndEndDateTimeTableInfoById(int id) throws SQLException {
		return new TimeTableInfoDaoImpl().getStartDateAndEndDateTimeTableInfoById(id);
	}

	@Override
	public ResponseData getTimeTableById(int id) throws SQLException {
		TimeTableDetailDaoImpl detailDao = new TimeTableDetailDaoImpl();
		TimeTableInfoDaoImpl infoDao = new TimeTableInfoDaoImpl();
		ResponseData responseData = new ResponseData();
		responseData.setData(createListDetail(infoDao.getStartDateAndEndDateTimeTableInfoById(id),
				detailDao.getAllDetailByTimeTableInfoId(id)));
		return responseData;
	}

	/**
	 * tạo danh sách chi tiết thời khóa biểu theo ngày
	 * @param dateArray chứa ngày bắt đầu và ngày kết thúc
	 * @param listDetail dánh sách chi tiết thời khóa biểu theo ngày được lấy ra từ db
	 * @return danh sách chi khóa biểutiết thời
	 */
	private List<TimeTableDetail> createListDetail(Date[] dateArray, List<TimeTableDetail> listDetail) {
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
		// tạo một list lưu danh sách thời khóa biểu theo ngày và có độ dài tính
		// từ ngày bắt đầu đến ngày kết thúc
		while (!startDate.isAfter(endDate)) {
			if(startDate.getDayOfWeek().getValue() > 5){
				startDate = startDate.plusDays(1);
				continue;
			} 
			// lấy detail timetable
			t = listDetail.get(i);
			// nếu ngày đang được ánh xạ đến có trong db thì sẽ add detail trong
			// db vào
			// nếu không tồn tại trong đb thì sẽ add detail rỗng chỉ có ngày bắt
			// đầu
			if (t.getStartDate().equals(Date.valueOf(startDate))) {
				l.add(updateDetail(t));
				if (i < size -1) {
					i++;
				}
			} else {
				t = new TimeTableDetail();
				t.setStartDate(Date.valueOf(startDate));
				l.add(updateDetail(t));
			}
			
			startDate = startDate.plusDays(1);
		}
		return l;
	}
	
	private TimeTableDetail updateDetail(TimeTableDetail t){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(t.getStartDate().getTime());
		t.setStartDateString(sdf.format(date).trim());
		return t;
	}

}
