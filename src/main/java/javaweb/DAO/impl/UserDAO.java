package javaweb.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import javaweb.DAO.IUserDAO;
import javaweb.mapper.UserMapper;
import javaweb.model.User;

public class UserDAO extends AbstrackDAO<User> implements IUserDAO{

	@Override
	public User FindByfullNameAndPasswork(User user) {
		String sql = "select * from users u join role_user r on u.id = r.users_id where u.fullname = ? and u.passwork = ?";
		List<User> listUser = new ArrayList<>();
		listUser = query(sql, new UserMapper(), user.getName(), user.getPasswork());
		return  listUser != null ? listUser.get(0): null;
	}

}
