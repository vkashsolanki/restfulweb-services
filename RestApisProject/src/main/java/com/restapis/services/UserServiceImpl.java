package com.restapis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapis.entiry.User;
import com.restapis.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User userCreate(User user) {
		User save = repository.save(user);
		return save;
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = repository.findAll();
		return findAll;
	}

	@Override
	public User getById(int id) {
		Optional<User> findById = repository.findById(id);
		return findById.get();
	}

	@Override
	public User updateUser(User user) {
		User users = repository.findById(user.getId()).get();
		users.setName(user.getName());
		users.setEmail(user.getEmail());
		
		User save = repository.save(users);
		return save;
	}



	@Override
	public void deleteAllUser(User user) {
		repository.deleteAll();
		
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
		
	}


	
	

}
