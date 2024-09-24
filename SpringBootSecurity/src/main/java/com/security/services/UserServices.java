package com.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.entity.User;


@Service
public class UserServices {
	
	
	List<User> list = new ArrayList<>();	
	
	
	public UserServices(List<User> users) {
		list.add(new User("abc", "abd123","ad@gmail.com"));
		list.add(new User("xyz", "zyx123","xyz@gmail.com"));
		
		
		
	}
	
	// get all user
	public List<User> getAllusers(User user)
	{
		return this.list;
	}

	// get single user
	
	public User singleUser(String userName) {
		
		return this.list.stream().filter((user) -> user.getUserName().equals(userName)).findAny().get();
		
	}
	
	//add user
	
	public User addUser(User user) {
		
		this.list.add(user);
		
		return user;
	}
	

}
