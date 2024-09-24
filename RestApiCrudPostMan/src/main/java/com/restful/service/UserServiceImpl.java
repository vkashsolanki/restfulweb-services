package com.restful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.model.User;
import com.restful.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User createUSer(User user) {
		User save = repository.save(user);
		return save;
	}

	@Override
	public User getbyId(long id) {
		Optional<User> findById = repository.findById(id);
		
		return findById.get();
	}

	@Override
	public List<User> getAllUser() {
		
		
		return repository.findAll();
	}

	@Override
	public User updateUser(User user) {
		User userid = repository.findById(user.getId()).get();
		userid.setFName(user.getFName());
		userid.setLName(user.getLName());
		userid.setEmail(user.getEmail());
		User save = repository.save(userid);
		return save;
	}

	@Override
	public void deleteUser(long id) {
		
		repository.deleteById(id);
		
	}
	
	
	
	
	

}
