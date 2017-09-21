/**
 * Copyright(C) 2017  Luvina
 * TeacherDao.java, Sep 20, 2017  TranTheHong
 */
package manageuser.dao;

import manageuser.entities.Teacher;

/**
 * @author HongTT
 *
 */
public interface TeacherDetailDao extends BaseDao {
	/**
	 * Thêm dữ liệu Teacher vào DB
	 * @param teacher đối tượng thông tin teacher
	 * @return true: insert thành công , false: insert không thành công.
	 */
	public boolean insertTeacher(Teacher teacher);
}
