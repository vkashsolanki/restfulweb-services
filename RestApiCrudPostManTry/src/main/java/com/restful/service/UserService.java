package com.restful.service;

import java.util.List;

import com.restful.model.User;

public interface UserService {
	
	public User createUser(User user);
	public User getById(long id);
	public List<User> getAllUser();
	public User updateUser(User user);
	public void deleteUser(long id);
	

}
