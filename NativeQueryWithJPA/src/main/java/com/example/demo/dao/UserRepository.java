package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Ram;

public interface UserRepository extends CrudRepository<Ram, Integer>{
	
//	@Query("select i from Ram i")
//	public List<Ram>  getAllUSer();
	
	
	// jpql
	@Query("select u from Ram u where u.name =:s")
	public List<Ram> findByName(@Param("s")String name);
	
	//native query-simple
	@Query( value = "select * from Ram", nativeQuery = true)
	public List<Ram> getUserall();
	
	

}
