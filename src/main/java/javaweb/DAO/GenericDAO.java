package javaweb.DAO;

import java.util.List;

import javaweb.mapper.RowMapper;

public interface GenericDAO<T> {
	@SuppressWarnings("hiding")
	<T> List<T> query(String sql, RowMapper<T> rp, Object ... paramater);
	void update(String sql, Object... parameter);
	Long insert(String sql, Object... paramater);
}
