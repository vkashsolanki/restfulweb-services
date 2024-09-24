package com.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entity.Person;
import com.restapi.repo.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person createPerson(Person person) {
		
		
		Person save = this.personRepository.save(person);
		return save;
	}

	
	@Override
	public List<Person> getAllPerson() {

			ArrayList<Person> arrayList = new ArrayList<Person>();
			return personRepository.findAll();
		
	}


	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}



}
