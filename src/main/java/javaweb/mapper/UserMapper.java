package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet resultSet) {
		User user = new User();
		try {
			user.setName(resultSet.getString("fullname"));
			user.setPasswork(resultSet.getString("passwork"));
			user.setPermissions(resultSet.getString("permission_id"));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
