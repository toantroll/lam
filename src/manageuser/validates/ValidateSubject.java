package manageuser.validates;

import java.util.ArrayList;
import java.util.List;
import manageuser.dao.impl.SubjectDaoImpl;
import manageuser.entities.Subject;
import manageuser.utils.Common;

/**
 * Xác nhận tính hợp lệ của thông tin môn học
 * 
 * @author LA-PM
 *
 */
public class ValidateSubject {

	/**
	 * Xác nhận tính hợp lệ của thông tin môn học
	 * 
	 * @param subject
	 *            chứa thông tin cần kiểm tra
	 * @return danh sách lỗi nếu có
	 */
	public static List<String> validateSubject(Subject subject) {
		List<String> listError = new ArrayList<>();
		String error = null;
		if (subject.getFlag() == 0) {
			error = checkSubjectId(subject.getId());
			if (error != null) {
				listError.add(error);
			}
		}
		error = checkSubjectName(subject.getName());
		if (error != null) {
			listError.add(error);
		}
		error = checkSubjectContent(subject.getContent());
		if (error != null) {
			listError.add(error);
		}
		return listError;
	}

	/**
	 * Kiểm tra tên môn học
	 * 
	 * @param name
	 *            tên môn học
	 * @return lỗi đầu tiên gặp phải
	 */
	public static String checkSubjectName(String name) {
		String error = null;
		if (Common.isNullOrEmpty(name)) {
			error = "Hãy nhập tên môn học!";
		}
		return error;
	}

	/**
	 * Kiểm tra mã môn học
	 * 
	 * @param id
	 *            mã môn học
	 * @return lỗi đầu tiên gặp phải
	 */
	private static String checkSubjectId(String id) {
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		String error = null;
		if (Common.isNullOrEmpty(id)) {
			error = "Hãy nhập mã môn học!";
		} else if (subjectDaoImpl.getSubjectById(id) != null) {
			error = "Mã môn học đã tồn tại!";
		}
		return error;
	}

	/**
	 * Kiểm tra nội dung môn học
	 * 
	 * @param content
	 *            nội dung môn học
	 * @return lỗi đầu tiên gặp phải
	 */
	private static String checkSubjectContent(String content) {
		String error = null;
		if (Common.isNullOrEmpty(content)) {
			error = "Hãy nhập nội dung môn học!";
		}
		return error;
	}
}
