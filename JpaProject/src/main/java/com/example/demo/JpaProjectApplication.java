package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@SpringBootApplication
public class JpaProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaProjectApplication.class, args);
		UserRepository ur = context.getBean(UserRepository.class);
		
		User user = new User();
		//Id autogenerate hoga
		//user.setId(100);
		user.setName("Radhika kainth");
		user.setEmail("Radhikakainth@gmail.com");
		user.setPassword("radhika123");
		
		// save user
		User save = ur.save(user);
		System.out.println("Console Base print "+save);
		
	}
	

}
