package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.News;

public class NewMapper implements RowMapper<News> {

	@Override
	public News mapRow(ResultSet resultSet) {
		try {
			News news = new News();
			news.setId(resultSet.getInt("id"));
			news.setTitle(resultSet.getNString("title"));
			news.setCode(resultSet.getString("code"));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
