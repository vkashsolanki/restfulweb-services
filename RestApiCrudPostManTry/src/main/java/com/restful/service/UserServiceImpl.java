package com.restful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.model.User;
import com.restful.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User createUser(User user) {
		User save = repository.save(user);
		return save;
	}

	@Override
	public User getById(long id) {
		Optional<User> findById = repository.findById(id);
		return findById.get();
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = repository.findAll();
		
		return findAll;
	}

	@Override
	public User updateUser(User user) {
		User userId = repository.findById(user.getId()).get();
		userId.setName(user.getName());
		userId.setEmail(user.getEmail());
		userId.setPassword(user.getPassword());
		
		User save = repository.save(userId);
		
		return save;
	}

	@Override
	public void deleteUser(long id) {
		repository.deleteById(id);
		
	}

}




















