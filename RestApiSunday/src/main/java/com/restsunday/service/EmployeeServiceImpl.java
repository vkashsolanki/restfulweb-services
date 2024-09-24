package com.restsunday.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restsunday.entity.Employee;
import com.restsunday.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		
		Employee save = employeeRepository.save(employee);
		
		return save;
	}

	@Override
	public List<Employee> findEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}

}
