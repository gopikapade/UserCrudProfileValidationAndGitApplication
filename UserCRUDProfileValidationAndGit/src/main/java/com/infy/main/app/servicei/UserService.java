package com.infy.main.app.servicei;

import java.util.List;

import com.infy.main.app.model.User;
import com.infy.main.app.serviceimpl.UserServiceImpl;

public interface UserService {

	public User addUser(User user);

	public List<User> getalluser();

	public User updateUser(int userid, User user);

	
	

}
