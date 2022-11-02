package com.masai.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.masai.model.User;

import com.masai.Service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	

	@Autowired
	private UserServiceImpl userServiceImpl;

	

	// to register user
	@PostMapping("/")
	public  User  saveUser(@RequestBody User er) {
		User user= userServiceImpl.createUser(er);
		return user;
		
	}

	// to update user by passing key
	@PutMapping("/update")
	public User updateUser(@RequestBody User user, @RequestParam(required = false) String key) {

		return userServiceImpl.updateUser(user, key);
	}

	

}