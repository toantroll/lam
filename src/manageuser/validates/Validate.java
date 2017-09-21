/**
 * 
 */
package manageuser.validates;

import java.util.HashMap;

import manageuser.entities.Register;
import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.utils.ErrorMessageProperties;

/**
 * @author LA-PM
 *
 */
public class Validate {
	public static HashMap<String, String> validateRegister(Register register){
		String tel=register.getTel();
		String email=register.getEmail();
		String yearGraduate=register.getGraduatedYear()+"";
		HashMap<String, String> listError = new HashMap<>();
		if(Common.checkEmpty(register.getFullName())){
			listError.put("full_name", ErrorMessageProperties.getErrorMessage("ERR01_FULLNAME"));
		}

		if(Common.checkEmpty(tel)){
			listError.put("tel", ErrorMessageProperties.getErrorMessage("ERR01_TEL"));
		}else if(checkFormat(tel,Constant.REGEX_TEL)){
			listError.put("tel", ErrorMessageProperties.getErrorMessage("ERR02_TEL"));
		}
		if(Common.checkEmpty(email)){
			listError.put("email", ErrorMessageProperties.getErrorMessage("ERR01_EMAIL"));
		}else if(checkFormat(email,Constant.REGEX_MAIL)){
			listError.put("email", ErrorMessageProperties.getErrorMessage("ERR02_EMAIL"));
		}
		if(Common.checkEmpty(register.getBirthday().toString())){
			listError.put("birthday", ErrorMessageProperties.getErrorMessage("ERR01_BIRTH"));
		}
		if(Common.checkEmpty(register.getStatus()+"")){
			listError.put("status", ErrorMessageProperties.getErrorMessage("ERR03_STATUS"));
		}
		if(Common.checkEmpty(register.getSchool())){
			listError.put("school", ErrorMessageProperties.getErrorMessage("ERR01_SCHOOL"));
		}
		if(Common.checkEmpty(register.getMajor())){
			listError.put("major", ErrorMessageProperties.getErrorMessage("ERR01_MAJOR"));
		}
		if(Common.checkEmpty(yearGraduate)){
			listError.put("year_graduate", ErrorMessageProperties.getErrorMessage("ERR01_YEAR"));
		}else if(checkFormat(yearGraduate,Constant.REGEX_YEAR_GRADUATE)){
			listError.put("year_graduate", ErrorMessageProperties.getErrorMessage("ERR02_YEAR"));
		}
		return listError;
	}
	public static boolean checkFormat(String value,String regex){
		if(value.matches(regex)){
			return true;
		}
		return false;
	}

	
}
