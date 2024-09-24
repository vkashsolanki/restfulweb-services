package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.Person;
import com.restapi.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/savedata")
	public ResponseEntity<?> saveStudent(@RequestBody Person person){
		
		return ResponseEntity.ok(this.personService.createPerson(person));
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllStdudent(){
		
		
		return ResponseEntity.ok(this.personService.getAllPerson());
	}
}
