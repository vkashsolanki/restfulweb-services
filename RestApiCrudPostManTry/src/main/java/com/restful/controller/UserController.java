package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.model.User;
import com.restful.service.UserService;

@RestController
@RequestMapping(value = "/userapi")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<User> createUsers(@RequestBody User user){
		
		User createUser = service.createUser(user);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getById(@PathVariable("id") long id){
		User byId = service.getById(id);
		return new ResponseEntity<>(byId, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = service.getAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<User> updateUsers(@PathVariable("id") long id ,@RequestBody User user){
		//set id from user
		user.setId(id);
		User updateUser = service.updateUser(user);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		service.deleteUser(id);
		return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
	}
	
}
























