/**
 * 
 */
package manageuser.logic.impl;

import java.util.ArrayList;

import manageuser.dao.impl.StatusStudentDaoImpl;
import manageuser.entities.StatusStudent;
import manageuser.logic.StatusStudentLogic;

/**
 * @author LA-PM
 *
 */
public class StatusStudentLogicImpl implements StatusStudentLogic{

	/* (non-Javadoc)
	 * @see manageuser.logic.StatusStudentLogic#getStatus()
	 */
	@Override
	public ArrayList<StatusStudent> getStatus() {
		StatusStudentDaoImpl statusStudentLogicImpl = new StatusStudentDaoImpl();
		return statusStudentLogicImpl.getStatus();
	}
	
}
