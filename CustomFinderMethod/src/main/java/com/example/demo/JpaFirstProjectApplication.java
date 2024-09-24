package com.example.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Employee;

@SpringBootApplication
public class JpaFirstProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaFirstProjectApplication.class, args);		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		//create object of employee
		
//		Employee employee = new Employee();
//		employee.setName("Komal");
//		employee.setEmail("Komal2015kumari@gmail.com");
//		System.out.println(employee);
//		userRepository.save(employee);
//		
//		Employee employee1 = new Employee();
//		employee1.setName("Rahul");
//		employee1.setEmail("rahul@gmail.com");
//		// list of method me sare object ko pass krke list type me hold kr diya 
//		List<Employee> listOfEmployee = List.of(employee, employee1);
//		//Iterable collection ka parent interface ha so jisme chile class List ko pass kr skte h jo ham saveall() me pass kiya h
//		Iterable<Employee> saveAll = userRepository.saveAll(listOfEmployee);
//		// bari bari se print krne ke liye foreach ko lambda expression ke use kiya h
//		saveAll.forEach(result ->{
//			System.out.println(result);
//			
//		});
		
		
		
		// update data
//		Optional<Employee> optional = userRepository.findById(4);
//		Employee employee = optional.get();
//		employee.setName("Dhoni");
//		// database me save krene ke liye save method pass kre object ko
//		userRepository.save(employee);
//		System.out.println(employee);
		
		
		// get data traditional way
		
//		Iterable<Employee> iterable = userRepository.findAll();
//		Iterator<Employee> iterator = iterable.iterator();
//		while (iterator.hasNext()) {
//			Employee employee = (Employee) iterator.next();
//			System.out.println(employee);
//			
//		}
		
		// get data modern way by labmda expression
		
//		Iterable<Employee> iterable = userRepository.findAll();
//		iterable.forEach(it->{
//			System.out.println(it);
//		});
//			
		
		// get data modern way by Consumer
		
//		Iterable<Employee> iterable = userRepository.findAll();
//		iterable.forEach(new Consumer<Employee>() {
//
//			@Override
//			public void accept(Employee t) {
//				
//				System.out.println(t);
//			}
//		});
		
		
		// delete data single data
		
	//	userRepository.deleteById(2);
		
		// delete data all users itreable ki help se lambda exp.
//		Iterable<Employee> iterable = userRepository.findAll();
//		iterable.forEach(result->{
//			System.out.println(result);
//		});
//		 
//		userRepository.deleteAll(iterable);
//		
//		
//		
//		
//		
		
		// create here Custom finder method/ derived method
		List<Employee> list = userRepository.findByName("Siyaram");
		list.forEach(jan->{
			System.out.println(jan);
		});
		
		
		
	}
		
	}


