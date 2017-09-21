/**
 * 
 */
package manageuser.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LA-PM
 *
 */
public class Common {
	public static boolean checkEmpty(String value){
		if("".equals(value)){
			return true;
		}
		return false;
	}
	
	/**
	 * check null
	 * @param o object
	 * @return true if not null
	 */
	public static boolean isNull(Object o){
		return o==null?true:false;
	}
	
	/**
	 * check date
	 * @param year year
	 * @param month month
	 * @param day day
	 * @return true if is date
	 */
	public static boolean isDate(int year, int month, int day){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		try {
			sdf.parse(year + "/" + month + "/" + day);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * compare 2 date
	 * @param startDate startDate
	 * @param endDate endDate
	 * @return true if start date < end date, false if date null or start date >= end date
	 */
	public static boolean conpareTwoDate(Date startDate, Date endDate){
		boolean flag = true;
		if(!isNull(startDate) && !isNull(endDate)){
			flag = startDate.compareTo(endDate) < 0? true: false;
		} else {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * check date in range
	 * @param currentDate currentDate
	 * @param startDate startDate
	 * @param endDate endDate
	 * @return true if date in range
	 */
	public static boolean isInRangeDate(Date currentDate, Date startDate, Date endDate){
		boolean flag = true;
		if(!isNull(currentDate) && !isNull(startDate) && !isNull(endDate)){
			flag = startDate.getTime() <= currentDate.getTime() && currentDate.getTime() <= endDate.getTime()?true: false;
		} else {
			flag = false;
		}
		return flag;
	}
}
