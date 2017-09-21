/**
 * 
 */
package manageuser.validates;

import java.util.HashMap;

import manageuser.entities.Register;
import manageuser.utils.Common;
import manageuser.utils.ErrorMessageProperties;

/**
 * @author LA-PM
 *
 */
public class Validate {
	public static HashMap<String, String> validateRegister(Register register){
		HashMap<String, String> listError = new HashMap<>();
		if(Common.checkEmpty(register.getFullName())){
			listError.put("full_name", ErrorMessageProperties.getErrorMessage("ERR_FULLNAME_EMPTY"));
		}
		return listError;
	}
	
}
