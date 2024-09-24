package com.rest.service;

import java.util.List;

import com.rest.model.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourses(long id);
	public Course addCourses(Course course);

}
