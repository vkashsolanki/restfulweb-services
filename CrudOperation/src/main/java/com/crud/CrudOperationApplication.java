package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crud.entity.Employee;

@SpringBootApplication
public class CrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationApplication.class, args);
		
	
		Employee emp = new Employee();
		emp.setName("zraib");
		System.out.println(emp.getName());
	}

}
