/**
 * Copyright(C) 2017 Luvina
 * Constant.java, Jul 7, 2017 DinhVanHop
 */
package manageuser.utils;

/**
 * Khai báo các hằng
 * @author DinhHop
 *
 */
public class Constant {
	public static final String FILE_NAME_PROPERTIES = "database.properties";
	public static final String ERR_MESS_PROPERTIES = "error_message.properties";
	public static final int ROLE_UNACTIVE = 5;
	public static final int STATUS_DELETE = 0;
	public static final String REGEX_TEL="[0-9]{10,11}";
	public static final String REGEX_MAIL="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String REGEX_YEAR_GRADUATE="[0-9]{4}";
	public static final String SIGNUP = "WEB-INF/jsp/signup.jsp";
	public static final String SUCCESS = "WEB-INF/jsp/successRegister.jsp";
	public static final String USERNAME = "userName";
	public static final String EMAIL = "email";
	public static final String TEL = "tel";
	public static final String BIRTHDAY = "birthday";
	public static final String IDCARD = "idcard";
	public static final String FULLNAME = "fullName";
	public static final String ADDSTUDENT = "WEB-INF/jsp/AddStudent.jsp";
	public static final String PASSWORD = "password";
	public static final String COURSEID = "courseid";
	public static final String STATUS = "status";
	public static final String REGEX_IDCARD="[0-9]{9,15}";
}