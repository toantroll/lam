/**
 * 
 */
package manageuser.logic;

import java.util.ArrayList;

import manageuser.entities.StatusStudent;

/**
 * @author LA-PM
 *
 */
public interface StatusStudentLogic {
	/**
	 * lấy danh sách trạng thái hoạt động của sinh viên
	 * @return danh sách trạng thái 
	 */
	public ArrayList<StatusStudent> getStatus();
	/**
	 * kiểm tra trạng thái có còn tồn tại 
	 * @param statusID mã trạng thái 
	 * @return true còn tồn tại false không còn tồn tại 
	 */
	public boolean existStatus(int statusID);
}
