/**
 * 
 */
package manageuser.logic.impl;

import manageuser.dao.impl.RegisterDaoImpl;
import manageuser.entities.Register;
import manageuser.logic.RegisterLogic;

/**
 * @author LA-PM
 *
 */
public class RegisterLogicImpl implements RegisterLogic {

	/* (non-Javadoc)
	 * @see manageuser.logic.RegisterLogic#addUserRegist(manageuser.entities.Register)
	 */
	@Override
	public boolean addUserRegist(Register register) {
		RegisterDaoImpl registerDaoImpl = new RegisterDaoImpl();
		return registerDaoImpl.addUserRegist(register);
	}

}
