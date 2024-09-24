package com.rest.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Course;
import com.rest.service.CourseService;

@RestController
public class HomeController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/home")
	public String home() {
		
		return "this is homepage";
	}
	
	// get the course 
	@GetMapping("/courses")
	public List<Course> getCourse(){
		
		return this.courseService.getCourses();
	}
	//get by id
	@GetMapping("/courses/{id}")
	public Course getById(@PathVariable String id) {
		return this.courseService.getCourses(Long.parseLong(id));
	}
	
	//save course
	@PostMapping("/courses")
	public Course addcourse(@RequestBody Course course) {
		
		return this.courseService.addCourses(course);
	}
	
	
	

}
