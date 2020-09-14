package javaweb.service;

import javaweb.model.User;

public interface IUserService {
	User findByUserNameAndPasswork(User user);
}
