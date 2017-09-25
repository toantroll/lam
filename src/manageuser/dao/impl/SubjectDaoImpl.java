package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manageuser.dao.SubjectDao;
import manageuser.entities.Subject;

public class SubjectDaoImpl extends BaseDaoImpl implements SubjectDao {
	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.SubjectDao#getSubjectById(java.lang.String)
	 */
	@Override
	public Subject getSubjectById(String id) {
		Connection connection = getConnection();
		String sql = "SELECT id, name, content, deleted_flag FROM subjects where id = ?";
		Subject subject = new Subject();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				subject.setId(rs.getString("id"));
				subject.setName(rs.getString("name"));
				subject.setContent(rs.getString("content"));
				subject.setFlag(rs.getInt("deleted_flag"));
			} else {
				subject = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return subject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.SubjectDao#insertSubject(manageuser.entities.Subject)
	 */
	@Override
	public boolean insertSubject(Subject subject) {
		Connection connection = getConnection();
		String sql = "INSERT INTO subjects ";
		boolean result = false;
		sql = sql.concat("(id, name, content, created_at, deleted_flag) VALUES ");
		sql = sql.concat("(?,?,?,now(),?)");
		int rowChange = -1, i = 0;
		try {
			PreparedStatement ptmt = connection.prepareStatement(sql);
			ptmt.setString(++i, subject.getId());
			ptmt.setString(++i, subject.getName());
			ptmt.setString(++i, subject.getContent());
			ptmt.setInt(++i, subject.getFlag());
			rowChange = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		if (rowChange > 0) {
			result = true;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.SubjectDao#deleteSubject(manageuser.entities.Subject)
	 */
	@Override
	public boolean deleteSubject(Subject subject) {
		Connection connection = getConnection();
		String sql = "UPDATE subjects SET deleted_at = now(), deleted_flag = ? WHERE id = ?";
		boolean result = false;
		int rowChange = -1, i = 0;
		try {
			PreparedStatement ptmt = connection.prepareStatement(sql);
			ptmt.setInt(++i, subject.getFlag());
			ptmt.setString(++i, subject.getId());
			rowChange = ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		if (rowChange > 0) {
			result = true;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.SubjectDao#editSubject(manageuser.entities.Subject,
	 * java.sql.Connection)
	 */
	@Override
	public boolean editSubject(Subject subject) {
		Connection connection = getConnection();
		String sql = "UPDATE subjects SET name = ?, content = ?, updated_at = now() WHERE id = ?";
		boolean result = false;
		int rowChange = -1, i = 0;
		try {
			PreparedStatement ptmt = connection.prepareStatement(sql);
			ptmt.setString(++i, subject.getName());
			ptmt.setString(++i, subject.getContent());
			ptmt.setString(++i, subject.getId());
			rowChange = ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		if (rowChange > 0) {
			result = true;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.SubjectDao#getTotalSubject(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int getTotalSubject(String id, String name) {
		int i = 0, total = 0;
		Connection connection = getConnection();
		String sql = ("SELECT COUNT(id) FROM subjects ");
		sql = sql.concat("WHERE deleted_flag = 1 ");
		if (!id.isEmpty()) {
			sql = sql.concat("AND id LIKE ? ");
		}
		if (!name.isEmpty()) {
			sql = sql.concat("AND name LIKE ? ");
		}
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			if (!id.isEmpty()) {
				preparedStatement.setString(++i, "%" + id + "%");
			}
			if (!name.isEmpty()) {
				preparedStatement.setString(++i, "%" + name + "%");
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				total = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see manageuser.dao.SubjectDao#getListSubject(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Subject> getListSubject(String id, String name, int offset, int limit) {
		Connection connection = getConnection();
		List<Subject> listSubject = new ArrayList<Subject>();
		int i = 0;
		String sql = "SELECT id, name, content FROM subjects ";
		sql = sql.concat("WHERE deleted_flag = 1 ");
		if (!id.isEmpty()) {
			sql = sql.concat("AND id LIKE ? ");
		}
		if (!name.isEmpty()) {
			sql = sql.concat("AND name LIKE ? ");
		}
		sql = sql.concat("LIMIT ? ");
		sql = sql.concat("OFFSET ? ");
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			if (!id.isEmpty()) {
				preparedStatement.setString(++i, "%" + id + "%");
			}
			if (!name.isEmpty()) {
				preparedStatement.setString(++i, "%" + name + "%");
			}
			preparedStatement.setInt(++i, limit);
			preparedStatement.setInt(++i, offset);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Subject subject = new Subject();
				subject.setId(resultSet.getString("id"));
				subject.setName(resultSet.getString("name"));
				subject.setContent(resultSet.getString("content"));
				listSubject.add(subject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return listSubject;
	}
}
