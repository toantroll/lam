/**Copyright(C) 2017 Luvina
 * UsersLogic.java, Sep 22, 2017
 */
package manageuser.logic.impl;

import manageuser.dao.impl.UserDaoImpl;
import manageuser.entities.Users;
import manageuser.logic.UsersLogic;
import manageuser.utils.Common;

/**
 * @author LA-PM
 *
 */
public class UsersLogicImpl implements UsersLogic {
	

	/* (non-Javadoc)
	 * @see manageuser.logic.UsersLogic#checkAccount(java.lang.String, java.lang.String)
	 */
	public boolean checkAccount(String user, String password) {
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		String passEncode = Common.encodeText(password);
		if (userDaoImpl.checkAccount(user, passEncode)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param userName
	 * @return
	 */
	public Users getUser(String userName) {
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		Users users=userDaoImpl.getUsers(userName);
		return users;
	}


}
