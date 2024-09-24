package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.services.UserServices;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserServices services;
	
	@GetMapping()
	public String home()
	{
		return "hi";	
	}
	
	// all user 
	@GetMapping(value = "/showall")
	public List<User> getAllUsers(User user){
		
		return this.services.getAllusers(user);
		
	}
	
	
	// single 
	@GetMapping(value = "/userName")
	public User getuser(@PathVariable("userName") String userName) {
		
		return this.services.singleUser(userName);
	}
	
	@PostMapping(value = "/adduser")
	public User addusers(@RequestBody User user) {
		
		return this.services.addUser(user);
	}
			
	
}
