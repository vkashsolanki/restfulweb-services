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
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<User> createusers(@RequestBody User user){
     User users =service.createUSer(user);
		
		return new ResponseEntity<>(users, HttpStatus.CREATED);
		
	}
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id){
		User findbyId = service.getbyId(id);
		return new ResponseEntity<>(findbyId, HttpStatus.OK);
		
		
	}
	@GetMapping
	public ResponseEntity<List<User>> getsAllUser(){
		List<User> list = service.getAllUser();
		//return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUsers(@PathVariable("id")long id, @RequestBody User user){
		
		user.setId(id);
		User updateUser = service.updateUser(user);
		
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
		
	}
	
    @DeleteMapping("{id}")
	public ResponseEntity<String> deleteUsers(@PathVariable("id") long id){
		service.deleteUser(id);
		
	   return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		
		
	}
	
	
	
	
}
