package manageuser.logics.impl;

import java.util.List;

import manageuser.dao.impl.SubjectDaoImpl;
import manageuser.entities.Subject;
import manageuser.logics.SubjectLogic;
import manageuser.utils.Common;

public class SubjectLogicImpl implements SubjectLogic {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * manageuser.logics.SubjectLogic#insertSubject(manageuser.entities.Subject)
	 */
	@Override
	public boolean insertSubject(Subject subject) {
		boolean result = false;
		subject.setFlag(1);
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		if (subjectDaoImpl.insertSubject(subject)) {
			result = true;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * manageuser.logics.SubjectLogic#deleteSubject(manageuser.entities.Subject)
	 */
	@Override
	public boolean deleteSubject(Subject subject) {
		boolean result = false;
		subject.setFlag(0);
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		if (subjectDaoImpl.deleteSubject(subject)) {
			result = true;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.logics.SubjectLogic#editSubject(manageuser.entities.Subject)
	 */
	@Override
	public boolean editSubject(Subject subject) {
		boolean result = false;
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		if (subjectDaoImpl.editSubject(subject)) {
			result = true;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.logics.SubjectLogic#getTotalSubject(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int getTotalSubject(String id, String name) {
		int total = 0;
		id = Common.escapeSQLSpecialChar(id);
		name = Common.escapeSQLSpecialChar(name);
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		total = subjectDaoImpl.getTotalSubject(id, name);
		return total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.logics.SubjectLogic#getListSubject(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Subject> getListSubject(String id, String name, int offset, int limit) {
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		id = Common.escapeSQLSpecialChar(id);
		name = Common.escapeSQLSpecialChar(name);
		List<Subject> listSubject = null;
		listSubject = subjectDaoImpl.getListSubject(id, name, offset, limit);
		return listSubject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.logics.SubjectLogic#getSubjectById(java.lang.String)
	 */
	@Override
	public Subject getSubjectById(String id) {
		Subject subject = new Subject();
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		subject = subjectDaoImpl.getSubjectById(id);
		return subject;
	}
}
