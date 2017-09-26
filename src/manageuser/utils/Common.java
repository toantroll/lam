/**
 * 
 */
package manageuser.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * @author LA-PM
 *
 */
public class Common {
	
	
	/**
	 * Mã hóa chuỗi theo sha1+base64
	 * @param text chuỗi muốn mã hóa
	 * @return chuỗi đã mã hóa theo sha1 + base64 trả về null nếu lỗi
	 */
	public static String encodeText(String text) {
	
		String passEncrypted = null;
		try {
			passEncrypted = encodeBase64(encodeSHA1(text));
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			System.out.println("lỗi hàm mã hóa");
		}	
		return passEncrypted;
	}
	
	/**
	 * Mã hóa SHA1
	 * @param text chuỗi cần  mã hóa
	 * @return chuỗi đã mã hóa SHA1
	 * @throws NoSuchAlgorithmException
	 */
	public static String encodeSHA1(String text) throws NoSuchAlgorithmException{
		String passEncrypted = "";
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] encryptText = md.digest(text.getBytes());
		BigInteger bigInt = new BigInteger(1,encryptText);
		passEncrypted = bigInt.toString(16);
		return passEncrypted;
	}
	/**
	 * Mã hóa Base64
	 * @param text chuỗi cần  mã hóa
	 * @return chuỗi đã mã hóa base64
	 * @throws NoSuchAlgorithmException
	 */
	public static String encodeBase64(String text) throws UnsupportedEncodingException{
		 byte[] bytes;
		 String passEncrypted="" ;
		 bytes = text.getBytes("UTF-8");
		 passEncrypted = Base64.getEncoder().encodeToString(bytes);
		 return passEncrypted;
	}
	
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
	public static boolean compareTwoDate(Date startDate, Date endDate){
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
	
	/**
	 * kiểm tra là số 
	 * @param num số cần kiểm tra số 
	 * @return true 
	 */
	public static boolean isNumBer(String num) {
		if(isNull(num)) {
			return false;
		}
		try{
			Integer.parseInt(num);
		} catch (NumberFormatException e) {
			return false;
		} 
		return true;
	}
	
	/**
	 * Thực hiện convert date string sang date sql
	 * @param date Ngày theo kiểu chuỗi
	 * @return trả về ngày dạng Date sql
	 */
	public static Date convertStringToDate(String date){
		java.sql.Date dateSQl = null; 
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date parsed;
			try {
				parsed = format.parse(date);
				dateSQl = new java.sql.Date(parsed.getTime());
			} catch (ParseException e) {
				System.out.println("Lỗi convert to Date");
				return null;
			}
	        
		return dateSQl;
		
	}
	/**
	 * Phương thức kiểm tra một chuỗi đầu vào có null hoặc rỗng không.
	 * 
	 * @param input
	 *            Chuỗi cần kiểm tra.
	 * @return true nếu chuỗi đầu vào null hoặc rỗng.<br />
	 *         false trong các trường hợp còn lại.
	 */
	public static boolean isNullOrEmpty(String input) {
		return (input == null || input.isEmpty());
	}

	/**
	 * Xử lí chuỗi ký tự nhập vào khi tìm kiếm để tránh lỗi SQL
	 * 
	 * @param input
	 *            chuỗi có ký tự đặc biệt cần xử lý
	 * @return input chuỗi được xử lý
	 */
	public static String escapeSQLSpecialChar(String input) {
		if (input != null) {
			input = input.replace("\\", "\\\\");
			input = input.replace("%", "\\%");
			input = input.replace("_", "\\_");
		}
		return input;
	}

	/**
	 * Tính tổng số trang
	 * 
	 * @param totalSubject
	 *            tổng số môn học
	 * @param limit
	 *            giới hạn số bản ghi trên 1 trang
	 * @return tổng số trang
	 */
	public static int getTotalPageSubject(int totalSubject, int limit) {
		if (totalSubject <= 0) {
			return 0;
		}
		return ((totalSubject - 1) / limit + 1);
	}

	/**
	 * Lấy offset
	 * 
	 * @param currentPage
	 *            trang hiện tại
	 * @param limit
	 *            giới hạn số trang
	 * @return offset của trang hiện tại
	 */
	public static int getOffsetSubject(int currentPage, int limit) {
		return (currentPage - 1) * limit;
	}

	/**
	 * Lấy mảng page
	 * 
	 * @param totalRecords
	 *            tổng số bản ghi
	 * @param limit
	 *            giới hạn số bản ghi trên 1 trang
	 * @param currentPage
	 *            trang hiện tại
	 * @return mảng các page
	 */
	public static List<Integer> getListPagingSubject(int totalRecords, int limit, int currentPage) {
		List<Integer> listPaging = new ArrayList<>();
		int totalPage = getTotalPageSubject(totalRecords, limit);
		if (totalPage == 0 || totalPage == 1) {
			return listPaging;
		}
		if (currentPage > totalPage || currentPage <= 0) {
			currentPage = 1;
		}
		int pageLimit = 3;
		int startPage = getStartPageSubject(currentPage, pageLimit);
		int endPage = getEndPageSubject(startPage, pageLimit, totalPage);
		for (int i = startPage; i <= endPage; i++) {
			listPaging.add(i);
		}
		return listPaging;
	}

	/**
	 * Lấy trang bắt đầu
	 * 
	 * @param currentPage
	 *            trang hiện tại
	 * @param pageLimit
	 *            giới hạn số trang được hiển thị
	 * @return trang bắt đầu
	 */
	public static int getStartPageSubject(int currentPage, int pageLimit) {
		int currentSegment = getCurrentSegmentSubject(currentPage, pageLimit);
		int startPage = (currentSegment - 1) * pageLimit + 1;
		return startPage;
	}

	/**
	 * Lấy trang kết thúc
	 * 
	 * @param startPage
	 *            trang bắt đầu
	 * @param pageLimit
	 *            giới hạn số trang được hiển thị
	 * @param totalPage
	 *            tổng số trang
	 * @return trang kết thúc
	 */
	public static int getEndPageSubject(int startPage, int pageLimit, int totalPage) {
		int endPage = pageLimit;
		if (startPage + pageLimit - 1 <= totalPage) {
			endPage = startPage + pageLimit - 1;
		} else {
			endPage = totalPage;
		}
		return endPage;
	}

	/**
	 * Lấy segment hiện tại
	 * 
	 * @param currentPage
	 *            trang hiện tại
	 * @param pageLimit
	 *            giới hạn số trang được hiển thị
	 * @return CurrentSegment
	 */
	public static int getCurrentSegmentSubject(int currentPage, int pageLimit) {
		return (currentPage - 1) / pageLimit + 1;
	}

	/**
	 * Kiểm tra điều kiện login
	 * 
	 * @param session
	 *            phiên làm việc
	 * @return success nếu login thành công, failure nếu login thất bại
	 */
	public static String checkLogin(HttpSession session) {
		if (session == null || session.getAttribute("loginName") == null) {
			return "failure";
		}
		return "success";
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean equalss(Date date1, Date date2){
		boolean flag = true;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString1 = sdf.format(date1);
		String dateString2 = sdf.format(date2);
		if(dateString1.equals(dateString2)){
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * check time
	 * @param time
	 * @return true if is time
	 */
	public static boolean isTime(String time){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		sdf.setLenient(false);
		try {
			sdf.parse(time);
		} catch (ParseException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * check date 
	 * @param date date
	 * @param regex format
	 * @return
	 */
	public static boolean isDate(String date, String regex){
		SimpleDateFormat sdf = new SimpleDateFormat(regex);
		sdf.setLenient(false);
		try {
			sdf.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}	
	
	/**
	 * check empty
	 * @param text
	 * @return
	 */
	public static boolean isEmpty(String text){
		if(isNull(text)){
			return false;
		}
		if("".equals(text)){
			return false;
		}
		return true;
	}
	
}
