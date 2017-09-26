/**
 * Copyright(C) 2017 luvina
 *	Validate.java, 22/9/2017 longvc
 */
package manageuser.validates;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import manageuser.entities.RegisterInfo;
import manageuser.entities.StudentDetail;
import manageuser.entities.TeacherDetail;
import manageuser.logic.impl.StatusStudentLogicImpl;
import manageuser.logic.impl.StudentDetailLogicImpl;
import manageuser.logic.impl.UsersLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.utils.ErrorMessageProperties;

/**
 * @author LA-PM
 *
 */
public class Validate {
	/**
	 * kiểm tra thông tin nhập
	 * 
	 * @param loginId tên đăng nhập
	 * @param password mật khẩu đăng nhập
	 * @return Danh sách lỗi ,nếu không có lỗi trả về mảng rỗng
	 */
	public List<String> validateLogin(String userName, String password) {
		List<String> messageError = new ArrayList<String>();
		if (Common.isEmpty(userName)) {
			messageError.add(ErrorMessageProperties.getErrorMessage("ERR01_USERNAME"));
		}
		if (Common.isEmpty(password)) {
			messageError.add(ErrorMessageProperties.getErrorMessage("ERR01_PASS"));
		}
		if (!Common.isEmpty(userName) && !Common.isEmpty(password)) {
			UsersLogicImpl usersLogicImpl = new UsersLogicImpl();
			if (!usersLogicImpl.checkAccount(userName, password)) {
				messageError.add(ErrorMessageProperties.getErrorMessage("ER16"));
			}
		}
		return messageError;
	}

	/**
	 * validate thông tin đăng kí
	 * @param register đối tượng registẻ
	 * @return cặp list lỗi
	 */
	public static HashMap<String, String> validateRegister(RegisterInfo register){
		String tel= register.getTel();
		String email= register.getEmail();
		String yearGraduate=register.getGraduatedYear()+"";
		HashMap<String, String> listError = new HashMap<>();
		String errFullName = validateFullName(register.getFullName());
		if(errFullName != null) {
			listError.put("full_name", errFullName);
		}
		String errTel = validateTel(tel);
		if( errTel != null) {
			listError.put("tel", errTel);
		}
		String errEmail = validateEmail(email);
		if(errEmail != null) {
			listError.put("email", errEmail);
		}
		if(Common.isEmpty(register.getBirthday().toString())){
			listError.put("birthday", ErrorMessageProperties.getErrorMessage("ERR01_BIRTH"));
		}
		if(register.getStatus() == 0){
			listError.put("status", ErrorMessageProperties.getErrorMessage("ERR03_STATUS"));
		}
		if(Common.isEmpty(register.getSchool())){
			listError.put("school", ErrorMessageProperties.getErrorMessage("ERR01_SCHOOL"));
		}
		if(Common.isEmpty(register.getMajor())){
			listError.put("major", ErrorMessageProperties.getErrorMessage("ERR01_MAJOR"));
		}
		if(Common.isEmpty(yearGraduate)){
			listError.put("year_graduate", ErrorMessageProperties.getErrorMessage("ERR01_YEAR"));
		}else if(!checkFormat(yearGraduate,Constant.REGEX_YEAR_GRADUATE)){
			listError.put("year_graduate", ErrorMessageProperties.getErrorMessage("ERR02_YEAR"));
		}
		return listError;
	}
	/**
	 * 
	 * @param value
	 * @param regex
	 * @return
	 */
	public static boolean checkFormat(String value,String regex){
		if(value.matches(regex)){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param student
	 * @return
	 */
	public static HashMap<String,String> validateStudent(StudentDetail student) {
		HashMap<String, String> listErr = new HashMap<>();
		// kiểm tra user name
		String errUserName = validateUserName(student.getUserName());
		if(errUserName != null) {
			listErr.put(Constant.USERNAME, errUserName);
		}
		//Kiểm tra fullName
				String errFullName= validateFullName(student.getName());
				if(errFullName!=null){
					listErr.put(Constant.FULLNAME, errFullName);
				}		
		// kiển tra số điện thoại 
		String errTel = validateTel(student.getTel());
		if(errTel != null) {
			listErr.put(Constant.TEL, errTel);
		}
		// kiểm tra email
		String errEmail = validateEmail(student.getEmail());
		if(listErr != null) {
			listErr.put(Constant.EMAIL, errEmail);
		}
		// kiểm tra ngay sinh 
		String errDate = validateDate(student.getBirthday());
		if(errDate != null) {
			listErr.put(Constant.BIRTHDAY, errDate );
		}
		// kiểm tra số cmtnd
		String errIdCard = validateIdCard(student.getIdCard());
		if(errIdCard != null) {
			listErr.put(Constant.IDCARD, errIdCard);
		}
		return listErr;
	}
	public static HashMap<String,String> validateTeacherDetail(TeacherDetail teacher){
		HashMap<String, String> listErr = new HashMap<>();
		// kiểm tra user name
		String errUserName = validateUserName(teacher.getUserName());
		if(errUserName != null) {
			listErr.put(Constant.USERNAME, errUserName);
		}
		// kiển tra số điện thoại 
		String errTel = validateTel(teacher.getTel());
		if(errTel != null) {
			listErr.put(Constant.TEL, errTel);
		}
		// kiểm tra email
		String errEmail = validateEmail(teacher.getEmail());
		if(listErr != null) {
			listErr.put(Constant.EMAIL, errEmail);
		}
		//Kiểm tra fullName
		String errFullName= validateFullName(teacher.getFullName());
		if(errFullName!=null){
			listErr.put(Constant.FULLNAME, errFullName);
		}		
		return listErr;
	}
	/**
	 * validate số diện thoại
	 * @param tel số điện thoại cần  validate
	 * @return null nếu không có lỗi , chuỗi lỗi nếu có lỗi
	 */
	private static String validateTel(String tel){
		if(Common.isEmpty(tel)) {
			return ErrorMessageProperties.getErrorMessage("ERR01_TEL");
		} else if(!checkFormat(tel, Constant.REGEX_TEL)) {
			return(ErrorMessageProperties.getErrorMessage("ERR02_TEL"));
		}
		return null;
	}
	/**
	 * validate email
	 * @param email email cần validate 
	 * @return null nếu không có lỗi , chuỗi lỗi nếu có lỗi
	 */
	private static String validateEmail(String email) {
		if(Common.isEmpty(email)){
			return ErrorMessageProperties.getErrorMessage("ERR01_EMAIL");
		}else if(!checkFormat(email,Constant.REGEX_MAIL)){
			return ErrorMessageProperties.getErrorMessage("ERR02_EMAIL");
		}
		return null;
	}
	/**
	 * validate fullName
	 * @param fullName
	 * @return
	 */
	private static String validateFullName(String fullName) {
		if(Common.isEmpty(fullName)){
			return ErrorMessageProperties.getErrorMessage("ERR01_FULLNAME");
		}
		return null;
	}
	/**
	 * 
	 * @param userName
	 * @return
	 */
	private static String validateUserName(String userName){
		StudentDetailLogicImpl studentDetailLogicImpl = new StudentDetailLogicImpl();
		if( Common.isEmpty(userName)) {
			return ErrorMessageProperties.getErrorMessage("ERR01_USERNAME");
		} else if(userName.length() < 6 && userName.length() > 15 ) {
			return ErrorMessageProperties.getErrorMessage("ERR02_USERNAME");
		} else if(studentDetailLogicImpl.existUser(userName) != null) {
			return ErrorMessageProperties.getErrorMessage("ERR03_USERNAME");
		}
		return null;
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	private static String validateDate(Date date) {
		if(date == null) {
			return ErrorMessageProperties.getErrorMessage("ERR04_DATE");
		}
		return null;
	}
	/**
	 * 
	 * @param idcard
	 * @return
	 */
	private static String validateIdCard(String idcard){
		if( idcard != null && !checkFormat(idcard, Constant.REGEX_TEL)) {
			return ErrorMessageProperties.getErrorMessage("ERR02_IDCARD");
		}
		return null;
	}
}
