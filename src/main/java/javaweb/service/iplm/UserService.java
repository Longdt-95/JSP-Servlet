package javaweb.service.iplm;

import javax.inject.Inject;

import javaweb.DAO.IUserDAO;
import javaweb.model.User;
import javaweb.service.IUserService;

public class UserService implements IUserService {
	
	@Inject
	private IUserDAO iUserDAO;

	@Override
	public User findByUserNameAndPasswork(User user) {
		return iUserDAO.FindByfullNameAndPasswork(user);
	}
}
