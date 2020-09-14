package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet resultSet) {
		try {
			Category category = new Category();
			category.setName(resultSet.getNString("name"));
			category.setCodeOfName(resultSet.getString("id"));
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
