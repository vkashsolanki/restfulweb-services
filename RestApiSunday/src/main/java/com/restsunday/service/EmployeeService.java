package com.restsunday.service;

import java.util.List;

import com.restsunday.entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	public List<Employee> findEmployee(); 

}
