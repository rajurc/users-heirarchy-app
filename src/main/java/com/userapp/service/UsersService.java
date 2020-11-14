package com.userapp.service;

import java.util.List;
import com.userapp.model.User;

public interface UsersService {
	
	public List<User> getAllUsers();
	public User createUser(User user);
}
