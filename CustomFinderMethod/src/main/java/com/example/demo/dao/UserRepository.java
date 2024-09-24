package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Employee;

public interface UserRepository extends CrudRepository<Employee, Integer>{
	
	public List<Employee>  findByName(String name);
	
	

}
