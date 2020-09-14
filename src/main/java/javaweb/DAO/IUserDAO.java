package javaweb.DAO;

import javaweb.model.User;

public interface IUserDAO extends GenericDAO<User> {
	User FindByfullNameAndPasswork(User user);
}
