package com.restapis.services;

import java.util.List;

import com.restapis.entiry.User;

public interface UserService {
	
	public User userCreate(User user);
	public List<User> getAllUser();
	public User getById(int id);
	public User updateUser(User user);
	public void deleteAllUser(User user);
	public void deleteById(int id);
	

}
