package com.userapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.userapp.model.User;
import com.userapp.service.UsersService;


@RestController
@RequestMapping("/api/v1")

public class UsersController {
	
	@Autowired
    private UsersService usersService;

	 @GetMapping("/users")
	    public List<User> getAllUsers() {
	        return usersService.getAllUsers();
	    }
	 
	 
	 @PostMapping("/user")
	    public User createUser(@Validated @RequestBody User user) {
	        return usersService.createUser(user);
	    }
	
}
