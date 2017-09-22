/**Copyright(C) 2017 Luvina
 * UsersLogic.java, Sep 22, 2017
 */
package manageuser.logic;

/**
 * @author LA-PM
 *
 */
public interface UsersLogic {
	/**
	 * kiểm tra thông tin đăng nhập
	 * @param user tên đăng nhập
	 * @param password mật khẩu
	 * @return trả về true nếu thông tin đăng nhập hợp lệ,ngược lại trả về true
	 */
	public boolean checkAccount(String user, String password) ;
}
