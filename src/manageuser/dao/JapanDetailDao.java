/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * JapanDetailDao.java,Sep 25, 2017 LA-PM
 */
package manageuser.dao;

import java.util.ArrayList;

import manageuser.entities.JapanDetail;

/**
 * @author LA-PM
 *
 */
public interface JapanDetailDao {
	/**
	 * lấy dnah sách trình độ tiếng nhât 
	 * @return danh sách trình độ tiếng nhật. trả về danh sách có size = 0 nếu không có trình độ tiếng nhật nào 
	 */
	public ArrayList<JapanDetail> getListJapanDetail();
	/**
	 * kiểm tra trình độ tiếng nhật có tồn tại hay không 
	 * @param japanlevel mã trình độ tiếng nhật cần kiểm tra 
	 * @return mã tiếng nhật nếu tồn tại và null nếu không tồn tại 
	 */
	public String existJapanLevel(String japanlevel);
}
