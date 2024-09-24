package com.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restapi.entity.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	
	//if perosin already exit then false otherwise flase == where  s.personId =:personId also used
	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Person s WHERE s.personId = ?1")
	public boolean isPersonExitByid(Integer personId);

}
