package com.userapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userapp.model.User;
import com.userapp.repository.UsersRepository;

@Transactional
@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	public UsersRepository usersRepository;
	
	@Override
	public List<User> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return usersRepository.save(user);
	}

	
}
