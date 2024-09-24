package com.restapis.controller;

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

import com.restapis.entiry.User;
import com.restapis.services.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping(value = "/save")
    public ResponseEntity<?>  saveUser(@RequestBody User user){
		
		User userCreate = service.userCreate(user);
		
		return new ResponseEntity(userCreate, HttpStatus.OK);
	}
	
	@PostMapping(value = "/getall")
	public ResponseEntity<List<User>> getAll(){
		
		List<User> allUser = service.getAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id, @RequestBody User user ){
		
		User byId = service.getById(id);
		
		return new ResponseEntity<>(byId, HttpStatus.OK);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id,  @RequestBody User user ){
		
		user.setId(id);
		User updateUser = service.updateUser(user);
		
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<?> deleteUser(@RequestBody User user){
		
		service.deleteAllUser(user);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<User> deleteById(@PathVariable("id")int id, @RequestBody User user){
		
		service.deleteById(id);
		
		return new ResponseEntity<User>(HttpStatus.OK);
		
		
	}
	
	
	
}
