package com.restapi.service;

import java.util.List;

import com.restapi.entity.Person;

public interface PersonService {
	
	public Person createPerson(Person person);
	public List<Person> getAllPerson();

	
	
}
