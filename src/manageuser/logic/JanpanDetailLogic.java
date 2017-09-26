/**
 * Copyright(C) 2017 Luvina Software Company
 *
 * JanpanDetail.java,Sep 26, 2017 HoangThai
 */
package manageuser.logic;

import java.util.ArrayList;

import manageuser.entities.JapanDetail;

/**
 * @author LA-PM
 *
 */
public interface JanpanDetailLogic {
	/**
	 * lấy danh sách trình độ tiếng Nhật
	 * @return danh sách tiếng nhật. Nếu không có trình độ tiếng Nhật trả về danh sách có size = 0
	 */
	public ArrayList<JapanDetail> getListJapanDetail();
}
