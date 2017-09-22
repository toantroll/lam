/**
 * 
 */
package manageuser.logic;

import manageuser.entities.Register;

/**
 * @author LA-PM
 *
 */
public interface RegisterLogic {
	/**
	 * Thực hiện thêm vào csdl
	 * @param register đối tượng Register
	 * @return trả về true đăng ký thành công
	 */
	public boolean addUserRegist(Register register);
}
