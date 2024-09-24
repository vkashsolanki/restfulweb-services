package com.restapi.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restapi.entity.Person;


@SpringBootTest
class PersonrepoTest {
	
	@Autowired
	PersonRepository personRepository;
	

	@Test
	void isPersonExitByid(){
		Person person = new Person(10, "Vikash", "delhi");
		
		// save datea
		
		personRepository.save(person);
		
		boolean actualResult = personRepository.isPersonExitByid(10);
		
		assertThat(actualResult).isTrue();		
		
	}
	
//	@AfterEach
//	void tearDown()
//	{
//	System.out.println("After each method ");
//	personRepository.deleteAll();
//	}

	
	@BeforeEach
	void tearUp() {
		System.out.println("Seting up ");
	}
}
