/**
 * Copyright(C) 2017 Luvina
 * StudentDetailLogicImpl.java, Jul 10, 2017
 */
package manageuser.logic;

import manageuser.entities.StudentDetail;
import manageuser.entities.Users;
/**
 * xử lý các thao tác với sinh viên
 * @author LA-PM
 *
 */
public interface StudentDetailLogic {
/**
 * thêm sinh viên
 * @param student sinh viên cần thêm	
 * @return true thêm thành công false nếu thêm thất bại 
 */
public boolean createStudent(StudentDetail student);
/**
 * thay đổi mật khẩu 
 * @param user tài khoản mới 
 * @return true nếu cập nhật thành công false nếu cập nhaath thất bại 
 */
public boolean updatePass(Users user);
/**
 * cập nhật thông tin sinh viên 
 * @param studentDetail thông tin sinh viên cần cập nhật
 * @return true cập nhật thành công, false cập nhật không thành công
 */
public boolean updateUserInfor( StudentDetail studentDetail );
/**
 * xóa thông tin User
 * @param studentID mã sinh viên cần xóa 
 * @return true nếu xóa thành công, false xóa không thành công
 */
public boolean deleteUser(int studentID);
/**
 * hàm kiểm tra User đã tồn tại hay chưa 
 * @param userName tên đăng nhập cần kiểm tra 
 * @return chuỗi nếu user đã tồn tại, null nếu chưa tồn tại 
 */
public String existUser(String userName);
/**
 * kiểm tra email đã tồn tại hay chưa 
 * @param email email cần kiểm tra 
 * @return chuỗi email nếu đã tồn tại, null nếu chưa tồn tại 
 */
public String existEmail(String email);
}
