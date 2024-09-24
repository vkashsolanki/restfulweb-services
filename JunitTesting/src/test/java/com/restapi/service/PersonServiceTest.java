package com.restapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.restapi.repo.PersonRepository;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;

	private PersonServiceImpl personServiceimpl;

	// create mehtod for personService becose we dont using @autowired
	@BeforeEach
	void setUp() {
		this.personServiceimpl = new PersonServiceImpl(this.personRepository);
	}

	@Test
	void getAllPerson() {

		personServiceimpl.getAllPerson();

		verify(personRepository).findAll();

	}
}
