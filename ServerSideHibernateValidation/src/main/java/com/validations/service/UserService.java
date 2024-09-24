package com.validations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validations.model.User;
import com.validations.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	
	public User createUser(User user) {
		
		return repo.save(user);
	}
}
