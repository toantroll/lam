/**
 * 
 */
package manageuser.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
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
	
	/**
	 * kiểm tra là số 
	 * @param num số cần kiểm tra số 
	 * @return true 
	 */
	public static boolean isNumBer(String num) {
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
		java.sql.Date sql = null; 
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date parsed;
			try {
				parsed = format.parse(date);
				sql = new java.sql.Date(parsed.getTime());
			} catch (ParseException e) {
				System.out.println("Lỗi convert to Date");
			}
	        
		return sql;
		
	}
}
