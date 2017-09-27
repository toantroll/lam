package manageuser.validates;

import java.util.HashMap;
import manageuser.dao.impl.SubjectDaoImpl;
import manageuser.entities.Subject;
import manageuser.logic.impl.TeacherDetailLogicImpl;
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
	public static HashMap<String, String> validateSubject(Subject subject) {
		HashMap<String, String> listError = new HashMap<String, String>();
		String error = null;
		if (subject.getFlag() == 0) {
			error = checkSubjectId(subject.getId());
			if (error != null) {
				listError.put("SUBJECT_ID", error);
			}
		}
		error = checkSubjectName(subject.getName());
		if (error != null) {
			listError.put("SUBJECT_NAME", error);
		}
		error = checkTeacher(subject.getGiaoVienId());
		if (error != null) {
			listError.put("SUBJECT_TEACHER", error);
		}
		error = checkSubjectContent(subject.getContent());
		if (error != null) {
			listError.put("SUBJECT_CONTENT", error);
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
		} else if (name.length() > 255) {
			error = "Tên môn học không vượt quá 255 kí tự!";
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
		} else if (id.length() > 20) {
			error = "Mã môn học không vượt quá 20 kí tự!";
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

	/**
	 * Kiểm tra giáo viên tồn tại
	 * 
	 * @param teacherId
	 *            mã giáo viên
	 * @return lỗi đầu tiên gặp phải
	 */
	private static String checkTeacher(int teacherId) {
		String error = null;
		TeacherDetailLogicImpl teacherDetailLogicImpl = new TeacherDetailLogicImpl();
		if (teacherId == 0) {
			error = "Hãy chọn giảng viên!";
		} else if (teacherDetailLogicImpl.getTeacherDetailById(teacherId) == null) {
			error = "Giảng viên không tồn tại!";
		}
		return error;
	}
}
