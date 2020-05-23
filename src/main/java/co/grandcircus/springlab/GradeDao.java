package co.grandcircus.springlab;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GradeDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Grade> findAll() {
		String sql = "SELECT * FROM grades";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Grade.class));
	}
	
	public Optional<Grade> findById(Long id) {
		try {
			String sql = "SELECT * FROM grades WHERE id = ?";
			return Optional.of(jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Grade.class), id));
		} catch (EmptyResultDataAccessException exception) {
			return Optional.empty();
		}
	}
	
	public void create(Grade grade) {
		String sql = "INSERT INTO grades (name, type, score, total) VALUES (?, ?, ?, ?)";
		jdbc.update(sql, grade.getName(), grade.getType(),grade.getScore(), grade.getTotal());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM grades WHERE id = ?";
		jdbc.update(sql, id);
	}
}
